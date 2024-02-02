package com.goprot.ih4c_mobile;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.goprot.ih4c_mobile.post.UserIconChange;
import com.goprot.ih4c_mobile.post.UserLogin;
import com.goprot.ih4c_mobile.post_values.OcrValues;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Fragment_config extends Fragment {
    TextView username;
    TextView password;
    SharedPreferences data ;
    LinearLayout lay_photo;
    LinearLayout lay_pass;
    LinearLayout lay_logout;
    ImageView icon;
    String name;
    ContentResolver cr;
    private String postresult;
    private Handler handler;
    private String result;
    private String usericon;
    SharedPreferences.Editor Ed;
    String imgUrlencode = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         data = this.getActivity().getSharedPreferences("Login",Context.MODE_PRIVATE);
        // フラグメントのレイアウトをインフレート
        return inflater.inflate(R.layout.config, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //名前とパスワードを設定
        username=view.findViewById(R.id.username);
        password=view.findViewById(R.id.userpass);

        name=data.getString("username",null);
        String pass=data.getString("password",null);
        usericon = data.getString("usericon",null);
        username.setText("名前 :"+name);
        password.setText("パスワード :"+pass);
        //IDからオブジェクトを取得
        lay_photo  = (LinearLayout) view.findViewById(R.id.btn_photo);
        lay_pass  = (LinearLayout) view.findViewById(R.id.btn_pass);
        lay_logout  = (LinearLayout) view.findViewById(R.id.btn_logout);
        LinearLayout lay_pass  = (LinearLayout) view.findViewById(R.id.btn_pass);
        icon = view.findViewById(R.id.user_icon);
        //content resolver
        cr = view.getContext().getContentResolver();
        handler = new Handler();

        byte[] decodedString = Base64.decode(usericon, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        icon.setImageBitmap(decodedByte);


        //リスナーを登録
        //写真をアップロードを押した場合
        lay_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent getIcon = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(getIcon,3);
            }
        });

        //パスワードを変更を押した場合
        lay_pass.setOnClickListener(v -> {
            FragmentManager fragmentManager = getFragmentManager();
            if(fragmentManager != null) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainerView, Fragment_config_change.class,null);
                fragmentTransaction.commit();
            }
        });

        //ログアウトボタン
        lay_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reset login
                Ed=data.edit();
                Ed.putString("username",null);
                Ed.putString("password",null);
                Ed.putInt("status",0);
                Ed.commit();
                //ログインページに飛ぶ
                Intent loginpage = new Intent(getActivity(),login.class);
                startActivity(loginpage);

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (!data.equals(null)){
            Uri selectedImges = data.getData();
            InputStream inputStream = null;
            try {
                inputStream = cr.openInputStream(selectedImges);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            String encodedImage = encodeImage(bitmap);

            //Postクラスを開始
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //Postクラスを呼び出し
                    postresult =  UserIconChange.ChangeIcon(name,encodedImage);
                    //もらった返事を処理
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            result= postresult;
                            JSONObject rootJSON = null;
                            try {
                                rootJSON = new JSONObject(result);
                                result = rootJSON.getString("status");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            if(result.equals("ok")){
                                icon.setImageURI(selectedImges);
                                saveNewIcon(encodedImage);
                            }
                        }
                    });
                }
            });
            thread.start();
        }

    }

    private void saveNewIcon(String newicon){
        Ed=data.edit();
        Ed.putString("usericon",newicon);
        Ed.commit();
    }


    //クオリティを変えることしかできない
    private String encodeImage(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG,60,baos);
        byte[] b = baos.toByteArray();
        String encImage = Base64.encodeToString(b, Base64.DEFAULT);
        return encImage;
    }


}