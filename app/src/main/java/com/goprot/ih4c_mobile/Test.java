package com.goprot.ih4c_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Test extends AppCompatActivity {

    JSONArray dataList = new JSONArray();
    String sentaku_f = "";
    String grade = "";
    String sentaku_data = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        Intent intent1 = getIntent();
//        problem_id = String.valueOf(intent1.putExtra("problem_id", ""));
        sentaku_f = intent1.getStringExtra("ChooseFlag");
        grade = intent1.getStringExtra("grade");
        sentaku_data = intent1.getStringExtra("ChooseData");



        //ナビゲーションバー非表示＆フリックで表示(時間制限あり)
        View decor = getWindow().getDecorView();
        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


        //MainActivityが強制終了された時は、savedInstanceStateにFragmentの情報が入ってonCreateが呼び出される
        //最初の1回だけフラグメントを作成するため、nullで条件分岐
        if (savedInstanceState == null) {// Fragment側に渡す変数を用意します。

        Bundle args = new Bundle();
            args.putString("ChooseFlag", sentaku_f );
            args.putString("grade", grade);
            args.putString("ChooseData", sentaku_data);

        // FragmentTransactionを生成。
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // TestFragmentを生成。
        Test_question fragment = new Test_question();
        //Fragmetnに渡す変数をセット
        fragment.setArguments(args);
        // FragmentTransactionに、TestFragmentをセット
//        transaction.add(R.id.fragmentContainerView2, fragment);
            getSupportFragmentManager()
                    .beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragmentContainerView2, fragment)
                    .commit();
//            //MainActivityが強制終了された時は、savedInstanceStateにFragmentの情報が入ってonCreateが呼び出される
//            //最初の1回だけフラグメントを作成するため、nullで条件分岐
//            if (savedInstanceState == null) {
//                //FragmentManagerのインスタンス取得、FragmentTransaction開始
//                getSupportFragmentManager().beginTransaction()
//                        //トランザクションに関与するフラグメントの状態変更を最適化
//                        .setReorderingAllowed(true)
//                        //フラグメント追加指示。第3引数はデータを受け渡す場合に使用
//                        .add(R.id.fragmentContainerView2, Test_question.class, null)
//                        //上記のトランザクションに設定した内容を実行
//                        .commit();
        }

        //レイアウトからボタンオブジェクトをそれぞれ取得
        ImageView button1 = findViewById(R.id.btn_out);

        //ボタンオブジェクトににリスナをそれぞれ設定
        button1.setOnClickListener(new ButtonClickListener());

    }

    //ボタンを押したときの動作を定義するリスナクラス
    private class ButtonClickListener implements View.OnClickListener {
        //ボタンを押したときの動作定義
        @Override
        public void onClick(View view) {
            //ボタンのIDによって条件分岐
            switch (view.getId()) {
                //ボタン1が押された場合
                case R.id.btn_out:
                    Intent intent = new Intent(getApplication(), MainActivity.class);
                    intent.putExtra("LOGIN", 1);
                    startActivity(intent);
                    break;

                default:
                    break;
            }
        }
    }

    @Override
    //Activity再起動しても画面維持
    protected void onResume(){
        super.onResume();
        SetView();
    }
    private void SetView(){
        View decor = getWindow().getDecorView();
        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
}