package com.goprot.ih4c_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class QuestionSelect extends AppCompatActivity {
    String getImg = null;
    String sub_id = "";
    String unit_id = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        getImg = intent.getStringExtra("BASE64");
        sub_id = intent.getStringExtra("SUB");
        unit_id = intent.getStringExtra("UNIT");
        Log.i("Base64", getImg);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_select);
    }

    //    穴埋めボタン
    public void createFill(View view) {
        Intent receiveIntent = getIntent();
        getImg = receiveIntent.getStringExtra("BASE64");
        Intent sendIntent = new Intent(QuestionSelect.this, CreateFillBlankProblem.class);
        sendIntent.putExtra("BASE64", getImg);
        sendIntent.putExtra("SUB", sub_id);
        sendIntent.putExtra("UNIT", unit_id);
        Log.i("Base64", getImg);
        startActivity(sendIntent);
    }
    //    4択ボタン
    public void create4C(View view) {
        Intent receiveIntent = getIntent();
        getImg = receiveIntent.getStringExtra("BASE64");
        Intent sendIntent = new Intent(QuestionSelect.this, Create4Choices.class);
        sendIntent.putExtra("BASE64", getImg);
        sendIntent.putExtra("SUB", sub_id);
        sendIntent.putExtra("UNIT", unit_id);
        Log.i("Base64", getImg);
        startActivity(sendIntent);
    }
    //    並び替えボタン
    public void createSort(View view) {
        Intent intent = new Intent(QuestionSelect.this, CreateSentenceSorting.class);
        startActivity(intent);
    }
    //    ホームに戻るボタン
    public void back_btnClick(View view) {
        Intent intent = new Intent(QuestionSelect.this, MainActivity.class);
        intent.putExtra("LOGIN", 1);
        startActivity(intent);
    }
}
