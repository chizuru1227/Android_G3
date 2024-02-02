package com.goprot.ih4c_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.goprot.ih4c_mobile.post.CreateChoices;
import com.goprot.ih4c_mobile.post_values.CreateChoicesValues;

import org.json.JSONException;

public class Check4Choices extends AppCompatActivity {

    private Handler handler;
    private String result;
    private TextView set_4_question;
    private EditText set_4_answer;
    private EditText set_4_answer_1;
    private EditText set_4_answer_2;
    private EditText set_4_answer_3;

    private String question = "";
    private String answer = "";
    private String answer_1 = "";
    private String answer_2 = "";
    private String answer_3 = "";
    String sub_id = "";
    String unit_id = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        question = intent.getStringExtra("EDIT_Q");
        answer = intent.getStringExtra("EDIT_A");
        sub_id = intent.getStringExtra("SUB");
        unit_id = intent.getStringExtra("UNIT");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_4choice_question);

        set_4_question=findViewById(R.id.set_4_question);
        set_4_answer=findViewById(R.id.set_4_answer);
        set_4_answer_1=findViewById(R.id.set_4_answer_1);
        set_4_answer_2=findViewById(R.id.set_4_answer_2);
        set_4_answer_3=findViewById(R.id.set_4_answer_3);


        handler = new Handler();

        //Postクラスを開始
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Postクラスを呼び出し
                CreateChoices createChoices = new CreateChoices();
                CreateChoicesValues postResult = createChoices.PostCreateChoices(answer);
                //もらった返事を処理
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        result = "ok";
                        result= postResult.createChoices;
                        if (!(postResult.createChoices.equals("no"))){
//                            Log.d("CreateChoicesResult:", postResult.createChoices);
                            answer_1 = postResult.choices_1;
                            answer_2 = postResult.choices_2;
                            answer_3 = postResult.choices_3;

                            set_4_answer_1.setText(answer_1);
                            set_4_answer_2.setText(answer_2);
                            set_4_answer_3.setText(answer_3);
                        }else{
                            Log.d("CreateChoicesResult:", postResult.createChoices);
                        }
                    }
                });
            }
        });
        thread.start();

        set_4_question.setText(question);
        set_4_answer.setText(answer);
        set_4_answer_1.setText(answer_1);
        set_4_answer_2.setText(answer_2);
        set_4_answer_3.setText(answer_3);
    }

    //    戻るボタン
    public void back_btnClick(View view){
        finish();
    }

    //    問題を作成するボタン
    public void next_btnClick(View view){
        answer_1 = set_4_answer_1.getText().toString();
        answer_2 = set_4_answer_2.getText().toString();
        answer_3 = set_4_answer_3.getText().toString();

        Intent intent = new Intent(Check4Choices.this, loading.class);
        intent.putExtra("INI_KEY", 333);
        intent.putExtra("FORMAT_KEY", 1);
        intent.putExtra("QUESTION", question);
        intent.putExtra("ANSWER", answer);
        intent.putExtra("ANSWER1", answer_1);
        intent.putExtra("ANSWER2", answer_2);
        intent.putExtra("ANSWER3", answer_3);
        intent.putExtra("SUB", sub_id);
        intent.putExtra("UNIT", unit_id);
        startActivity(intent);
    }

    //    リトライボタン
    public void retry_btnClick(View view){

        String set_answer =  set_4_answer.getText().toString();
        Log.i("set_answer::",set_answer);
        handler = new Handler();

        //Postクラスを開始
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Postクラスを呼び出し
                CreateChoices createChoices = new CreateChoices();
                CreateChoicesValues postResult = createChoices.PostCreateChoices(set_answer);
                //もらった返事を処理
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        result= postResult.createChoices;
                        if (postResult.createChoices.equals("ok")){
                            Log.d("CreateChoicesResult:", postResult.createChoices);
                            answer_1 = postResult.choices_1;
                            answer_2 = postResult.choices_2;
                            answer_3 = postResult.choices_3;

                        }else{
                            Log.d("CreateChoicesResult:", postResult.createChoices);
                        }
                    }
                });
            }
        });
        thread.start();
        set_4_answer_1.setText(answer_1);
        set_4_answer_2.setText(answer_2);
        set_4_answer_3.setText(answer_3);
    }
}
