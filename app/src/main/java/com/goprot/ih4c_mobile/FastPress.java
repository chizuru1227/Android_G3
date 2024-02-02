package com.goprot.ih4c_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FastPress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fastpress);

        //ナビゲーションバー非表示＆フリックで表示(時間制限あり)
        View decor = getWindow().getDecorView();
        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        Intent intent = getIntent();

        //MainActivityが強制終了された時は、savedInstanceStateにFragmentの情報が入ってonCreateが呼び出される
        //最初の1回だけフラグメントを作成するため、nullで条件分岐
        if (savedInstanceState == null) {
            //FragmentManagerのインスタンス取得、FragmentTransaction開始
            getSupportFragmentManager().beginTransaction()
                    //トランザクションに関与するフラグメントの状態変更を最適化
                    .setReorderingAllowed(true)
                    //フラグメント追加指示。第3引数はデータを受け渡す場合に使用
                    .add(R.id.fragmentContainerView3, FastPress_question.class, null)
                    //上記のトランザクションに設定した内容を実行
                    .commit();
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