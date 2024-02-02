package com.goprot.ih4c_mobile;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.goprot.ih4c_mobile.post.PassChange;

public class Fragment_config_change extends Fragment {
    private String postresult;
    private String result;
    SharedPreferences data ;
    private  Handler handler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        data = this.getActivity().getSharedPreferences("Login", Context.MODE_PRIVATE);
        // フラグメントのレイアウトをインフレート
        return inflater.inflate(R.layout.config_change, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        handler = new Handler();


        //IDからオブジェクトを取得
        LinearLayout lay_change  = (LinearLayout) view.findViewById(R.id.btn_change);

        //リスナーを登録
        //パスワードを変更を押した場合
        lay_change.setOnClickListener(v -> {
            FragmentManager fragmentManager = getFragmentManager();
            if(fragmentManager != null) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //空白カウンター
                int errcnt =0;


                //IDからオブジェクトを取得
                EditText now_pass =  view.findViewById(R.id.now_password);
                EditText new_pass =  view.findViewById(R.id.new_password);
                EditText check_pass =  view.findViewById(R.id.check_password);
                TextView now_pass_err = view.findViewById(R.id.passtext);
                TextView new_pass_err = view.findViewById(R.id.newtext);
                TextView check_pass_err = view.findViewById(R.id.checktext);

                //エラー処理
                //現在パスワードが空白か現在のパスワードが同じか確認
                if (now_pass.getText().toString().equals("") ||!now_pass.getText().toString().equals(data.getString("password",null))){
                    now_pass_err.setTextColor(Color.parseColor("#FF0000"));
                    errcnt++;
                }else{
                    errcnt--;
                    now_pass_err.setTextColor(Color.parseColor("#000000"));
                }

                //新しいパスワード
                if (new_pass.getText().toString().equals("")){
                    new_pass_err.setTextColor(Color.parseColor("#FF0000"));
                    errcnt++;
                }else{
                    new_pass_err.setTextColor(Color.parseColor("#000000"));
                    errcnt--;
                }

                //確認パスワードが新しいパスワードと同じ
                if (!check_pass.getText().toString().equals(new_pass.getText().toString())||check_pass.getText().toString().equals("")){
                    check_pass_err.setTextColor(Color.parseColor("#FF0000"));
                    errcnt++;
                }else{
                    check_pass_err.setTextColor(Color.parseColor("#000000"));
                    errcnt--;
                }

                //エラーカウントが０の場合のみ送信しパスワードを変更する
                switch (errcnt){
                    case -3:
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //パスワードをサーバに反映する
                            postresult = PassChange.PassChange(data.getString("username",null),data.getString("password",null),new_pass.getText().toString());
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    result= postresult;
                                    if (postresult.equals("ok")){
                                        //エラーなければそのままローカルでアプデ
                                        updateLoginStatus(new_pass.getText().toString());
                                        //アカウント画面に戻る
                                        fragmentTransaction.replace(R.id.fragmentContainerView, Fragment_config.class,null);
                                        fragmentTransaction.commit();
                                    }
                                }
                            });
                        }
                    });
                    thread.start();
                        break;
                }
            }
        });
    }
    public void updateLoginStatus(String new_pass){
        SharedPreferences.Editor Ed=data.edit();
        Ed.putString("password",new_pass);
        Ed.commit();
    }
}