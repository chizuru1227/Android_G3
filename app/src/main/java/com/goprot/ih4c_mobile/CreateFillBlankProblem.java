package com.goprot.ih4c_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.goprot.ih4c_mobile.post.Ocr;
import com.goprot.ih4c_mobile.post_values.OcrValues;

import org.json.JSONException;

public class CreateFillBlankProblem extends AppCompatActivity {
    private Handler handler;
    private String result;
    private String ocrResult = "";
    private EditText edit_f_question_front;
    private EditText edit_f_question_back;
    private EditText edit_f_answer;
    private TextView scan_text;
    String sub_id = "";
    String unit_id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String getImg = intent.getStringExtra("BASE64");
        Log.d("BASE64", getImg);
        sub_id = intent.getStringExtra("SUB");
        unit_id = intent.getStringExtra("UNIT");
        handler = new Handler();

        //Postクラスを開始
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Postクラスを呼び出し
                Ocr ocr = new Ocr();
                OcrValues postResult = ocr.PostOcr(getImg);
                //もらった返事を処理
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        result= postResult.ocr;
                        if (postResult.ocr.equals("ok")){
                            Log.d("OcrRunPostResult:", postResult.ocr);
                            for(int i = 0; i < postResult.ocrList.length(); i++){
                                try {
                                    String value = postResult.ocrList.get(i).toString();
                                    Log.d("value",value);
                                    ocrResult += value + "　";
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                scan_text.setText(ocrResult);
                                Log.i("OcrRunPostResult:List:", postResult.ocr);
                            }
                        }else{
                            Log.d("OcrRunPostResult:", postResult.ocr);
                        }
                    }
                });
            }
        });
        thread.start();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_fill_in_the_blank_question);
        scan_text=findViewById(R.id.scan_get_text);
        // Text Selection をenableにする
        scan_text.setTextIsSelectable(true);
        edit_f_question_front=findViewById(R.id.edit_f_question_front);
        edit_f_question_back=findViewById(R.id.edit_f_question_back);
        edit_f_answer=findViewById(R.id.edit_f_answer);
    }
    //    戻るボタン
    public void back_btnClick(View view){
        finish();
    }

    //    問題を解くボタン
    public void next_btnClick(View view){
        String edit_f_question_front_text = edit_f_question_front.getText().toString();
        String edit_f_question_back_text = edit_f_question_back.getText().toString();
        String edit_f_answer_text = edit_f_answer.getText().toString();
        Intent intent = new Intent(CreateFillBlankProblem.this, CheckFillBlankProblem.class);
        intent.putExtra("EDIT_Q_F", edit_f_question_front_text);
        intent.putExtra("EDIT_Q_B", edit_f_question_back_text);
        intent.putExtra("EDIT_A", edit_f_answer_text);
        intent.putExtra("SUB", sub_id);
        intent.putExtra("UNIT", unit_id);
        startActivity(intent);
    }

    //    問題文前にペースト
    public void question_paste_f(View view){
        int min = 0;
        int max = scan_text.getText().length();
        if (scan_text.isFocused()) {
            final int selStart = scan_text.getSelectionStart();
            final int selEnd = scan_text.getSelectionEnd();

            min = Math.max(0, Math.min(selStart, selEnd));
            max = Math.max(0, Math.max(selStart, selEnd));
        }

        final CharSequence selectedText = scan_text.getText()
                .subSequence(min, max);
        String text = selectedText.toString();

        edit_f_question_front.setText(text);
    }

    //    問題文後にペースト
    public void question_paste_b(View view){
        int min = 0;
        int max = scan_text.getText().length();
        if (scan_text.isFocused()) {
            final int selStart = scan_text.getSelectionStart();
            final int selEnd = scan_text.getSelectionEnd();

            min = Math.max(0, Math.min(selStart, selEnd));
            max = Math.max(0, Math.max(selStart, selEnd));
        }

        final CharSequence selectedText = scan_text.getText()
                .subSequence(min, max);
        String text = selectedText.toString();

        edit_f_question_back.setText(text);
    }

    //    答えにペースト
    public void answer_paste(View view){
        int min = 0;
        int max = scan_text.getText().length();
        if (scan_text.isFocused()) {
            final int selStart = scan_text.getSelectionStart();
            final int selEnd = scan_text.getSelectionEnd();

            min = Math.max(0, Math.min(selStart, selEnd));
            max = Math.max(0, Math.max(selStart, selEnd));
        }

        final CharSequence selectedText = scan_text.getText()
                .subSequence(min, max);
        String text = selectedText.toString();

        edit_f_answer.setText(text);
    }
    //    デモボタン
    public void demo_btnClick(View view){
        scan_text.setText("これはデモメッセージです");
    }
}
