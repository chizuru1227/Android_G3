package com.goprot.ih4c_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CheckSentenceSorting extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_sentence_sorting);
    }

    //    戻るボタン
    public void back_btnClick(View view){
        finish();
    }

    //    問題を解くボタン
    public void next_btnClick(View view){
        Intent intent = new Intent(CheckSentenceSorting.this, loading.class);
        intent.putExtra("INI_KEY", 333);
        startActivity(intent);
    }
}
