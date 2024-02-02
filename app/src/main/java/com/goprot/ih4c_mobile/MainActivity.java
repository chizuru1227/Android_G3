package com.goprot.ih4c_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView icon;
    private Intent intent;
    private String iconString;
    int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences login_status = this.getSharedPreferences("Login",MODE_PRIVATE);
        iconString =login_status.getString("usericon",null);

        //reset log in
       int LOGIN =login_status.getInt("status",0);

//        int LOGIN = 0;

        if (LOGIN != 0) {
            icon();
            n = LOGIN;
        }

        if (n == 0) {
            Intent intent = new Intent(MainActivity.this, login.class);
            startActivity(intent);
        }
//        else {
//            setContentView(R.layout.activity_main);
//        }


        //ナビゲーションバー非表示＆フリックで表示(時間制限あり)
        View decor = getWindow().getDecorView();
        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //MainActivityが強制終了された時は、savedInstanceStateにFragmentの情報が入ってonCreateが呼び出される
        //最初の1回だけフラグメントを作成するため、nullで条件分岐
        if (savedInstanceState == null) {
            //FragmentManagerのインスタンス取得、FragmentTransaction開始
            getSupportFragmentManager().beginTransaction()
                    //トランザクションに関与するフラグメントの状態変更を最適化
                    .setReorderingAllowed(true)
                    //フラグメント追加指示。第3引数はデータを受け渡す場合に使用
                    .add(R.id.fragmentContainerView, Fragment_home.class, null)
                    //上記のトランザクションに設定した内容を実行
                    .commit();
        }

        //レイアウトからボタンオブジェクトをそれぞれ取得
        ImageView user_icon = findViewById(R.id.user_icon);
        ImageView button1 = findViewById(R.id.home);
        ImageView button2 = findViewById(R.id.scan);
        ImageView button3 = findViewById(R.id.study);
        ImageView button4 = findViewById(R.id.data);
        ImageView button5 = findViewById(R.id.config);

        //ボタンオブジェクトににリスナをそれぞれ設定
        user_icon.setOnClickListener(new ButtonClickListener());
        button1.setOnClickListener(new ButtonClickListener());
        button2.setOnClickListener(new ButtonClickListener());
        button3.setOnClickListener(new ButtonClickListener());
        button4.setOnClickListener(new ButtonClickListener());
        button5.setOnClickListener(new ButtonClickListener());

    }
    private void icon(){
        byte[] decodedString = Base64.decode(iconString, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        icon= findViewById(R.id.user_icon);
        icon.setImageBitmap(decodedByte);
    }

    //ボタンを押したときの動作を定義するリスナクラス
    private class ButtonClickListener implements View.OnClickListener {
        //ボタンを押したときの動作定義
        @Override
        public void onClick(View view) {
            //ボタンのIDによって条件分岐
            switch (view.getId()) {
                //ボタン1が押された場合
                case R.id.home:
                    //FragmentManagerのインスタンス取得、FragmentTransaction開始
                    getSupportFragmentManager().beginTransaction()
                            //トランザクションに関与するフラグメントの状態変更を最適化
                            .setReorderingAllowed(true)
                            //Fragment_homeに入れ替え指示。第3引数はデータを受け渡す場合に使用
                            .replace(R.id.fragmentContainerView, Fragment_home.class, null)
                            //上記のトランザクションに設定した内容を実行
                            .commit();
                    break;

                //ボタン2が押された場合
                case R.id.scan:
//                    //FragmentManagerのインスタンス取得、FragmentTransaction開始
//                    getSupportFragmentManager().beginTransaction()
//                            //トランザクションに関与するフラグメントの状態変更を最適化
//                            .setReorderingAllowed(true)
//                            //Fragment_scanに入れ替え指示。第3引数はデータを受け渡す場合に使用
//                            .replace(R.id.fragmentContainerView, Fragment_scan.class, null)
//                            //上記のトランザクションに設定した内容を実行
//                            .commit();
                    intent = new Intent(MainActivity.this, ScanPage.class);
                    startActivity(intent);
                    break;

                //ボタン3が押された場合
                case R.id.study:
                    //FragmentManagerのインスタンス取得、FragmentTransaction開始
//                    getSupportFragmentManager().beginTransaction()
//                            //トランザクションに関与するフラグメントの状態変更を最適化
//                            .setReorderingAllowed(true)
//                            //Fragment_studyに入れ替え指示。第3引数はデータを受け渡す場合に使用
//                            .replace(R.id.fragmentContainerView, Fragment_study.class, null)
//                            //上記のトランザクションに設定した内容を実行
//                            .commit();
                    intent = new Intent(MainActivity.this, QuestionCreatePage.class);
                    startActivity(intent);
                    break;

                //ボタン4が押された場合
                case R.id.data:
                    //FragmentManagerのインスタンス取得、FragmentTransaction開始
                    getSupportFragmentManager().beginTransaction()
                            //トランザクションに関与するフラグメントの状態変更を最適化
                            .setReorderingAllowed(true)
                            //Fragment_dataに入れ替え指示。第3引数はデータを受け渡す場合に使用
                            .replace(R.id.fragmentContainerView, Fragment_data.class, null)
                            //上記のトランザクションに設定した内容を実行
                            .commit();
                    break;

                //ボタン5が押された場合
                //user_iconが押された場合
                case R.id.config:
                case R.id.user_icon:
                    //FragmentManagerのインスタンス取得、FragmentTransaction開始
                    getSupportFragmentManager().beginTransaction()
                            //トランザクションに関与するフラグメントの状態変更を最適化
                            .setReorderingAllowed(true)
                            //Fragment_configに入れ替え指示。第3引数はデータを受け渡す場合に使用
                            .replace(R.id.fragmentContainerView, Fragment_config.class, null)
                            //上記のトランザクションに設定した内容を実行
                            .commit();
                    break;

                default:
                    break;
            }
        }
    }

    @Override
    //Activity再起動しても画面維持
    protected void onResume() {
        super.onResume();
        SetView();
    }

    private void SetView() {
        View decor = getWindow().getDecorView();
        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
}