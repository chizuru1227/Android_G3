package com.goprot.ih4c_mobile;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.goprot.ih4c_mobile.post.CreateChoices;
import com.goprot.ih4c_mobile.post.CreateQuestionBlank;
import com.goprot.ih4c_mobile.post.CreateQuestionFour;
import com.goprot.ih4c_mobile.post_values.CreateChoicesValues;
import com.goprot.ih4c_mobile.post_values.CreateQuestionBlankValues;
import com.goprot.ih4c_mobile.post_values.CreateQuestionFourValues;

public class loading extends AppCompatActivity {

    TextView loading_message;
    Button loading_next_btn;
    Button loading_back_btn;
    Dialog popup;

    private Handler handler;
    private String result;
    private String question = "";
    private String question_f = "";
    private String question_b = "";
    private String answer = "";
    private String answer_1 = "";
    private String answer_2 = "";
    private String answer_3 = "";
    String sub_id = "";
    String unit_id = "";


    SharedPreferences data ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);
        data = this.getSharedPreferences("Login", Context.MODE_PRIVATE);

        Intent intent = getIntent();
        int key = intent.getIntExtra("INI_KEY", 10);
        Log.i("MyFragment : ", "渡された値 = " + Integer.toString(key));

        if (key == 111) {
            makeMatch();
        } else if (key == 222) {
            joinMatch();
        } else if (key == 333) {
            int format_key = intent.getIntExtra("FORMAT_KEY", 10);
            answer = intent.getStringExtra("ANSWER");
            answer_1 = intent.getStringExtra("ANSWER1");
            answer_2 = intent.getStringExtra("ANSWER2");
            answer_3 = intent.getStringExtra("ANSWER3");
            sub_id = intent.getStringExtra("SUB");
            unit_id = intent.getStringExtra("UNIT");
            Log.i("ID表示.......", sub_id+unit_id);
            if (format_key == 1){
                Log.i("key","４たく");
                question = intent.getStringExtra("QUESTION");
                createFour();
            }else if(format_key == 2){
                Log.i("key","あなうめ");
                question_f = intent.getStringExtra("QUESTION_F");
                question_b = intent.getStringExtra("QUESTION_B");
                createBlank();
            }
            questionLoading();
            popup = new Dialog(this);
        }
    }

    //    早押しルームマスター(参加者を待っています)
    private void makeMatch() {
        loading_message = (TextView) findViewById(R.id.loading_message);
        loading_next_btn = (Button) findViewById(R.id.loading_next_btn);
        loading_back_btn = (Button) findViewById(R.id.loading_back_btn);

        loading_message.setText("参加者を待っています…");
        loading_next_btn.setText("開始する");
        loading_back_btn.setText("ルームを閉じる");
    }

    //    早押しルーム参加者(開始までしばらくお待ちください)
    private void joinMatch() {
        loading_message = (TextView) findViewById(R.id.loading_message);
        loading_next_btn = (Button) findViewById(R.id.loading_next_btn);
        loading_back_btn = (Button) findViewById(R.id.loading_back_btn);

        loading_message.setText("開始までしばらくお待ちください…");
        loading_next_btn.setVisibility(View.INVISIBLE);
        loading_next_btn.setVisibility(View.GONE);
        loading_back_btn.setText("ルームから退出する");
    }

    //    問題作成中
    private void questionLoading() {
        loading_message = (TextView) findViewById(R.id.loading_message);
        loading_next_btn = (Button) findViewById(R.id.loading_next_btn);
        loading_back_btn = (Button) findViewById(R.id.loading_back_btn);

        loading_message.setText("問題を作成中です…");
        loading_back_btn.setVisibility(View.INVISIBLE);
        loading_back_btn.setVisibility(View.GONE);
        loading_next_btn.setVisibility(View.INVISIBLE);
        loading_next_btn.setVisibility(View.GONE);

        //スレッドを生成して起動します。
        MyThread thread = new MyThread();
        thread.start();
        popup();
    }


    //    戻るボタン
    public void back_btnClick(View view) {
        finish();
    }

    //  ポップアップ
    public void popup() {
        Dialog popup = new Dialog(this);
        popup.setContentView(R.layout.scan_finish_popup);
        popup.show();
    }


    //    開始するボタン
    public void next_btnClick(View view) {
//        Intent intent = new Intent(loading.this, FastPress.class);
//        startActivity(intent);

        Intent intent = new Intent(loading.this, MatchSelectQuestion.class);
        startActivity(intent);
    }


    //    開始するボタン
    public void scan_btnClick(View view) {
        Intent intent = new Intent(loading.this, ScanPage.class);
        startActivity(intent);
    }
    //    開始するボタン
    public void home_btnClick(View view) {
        Intent intent = new Intent(loading.this, MainActivity.class);
        intent.putExtra("LOGIN", 1);
        startActivity(intent);
    }

//    四択
    public void createFour(){
        handler = new Handler();

        //Postクラスを開始
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Postクラスを呼び出し
                    CreateQuestionFour createQuestionFour = new CreateQuestionFour();
                    CreateQuestionFourValues postResult = createQuestionFour.PostCreateQuestionFour(
                            question, answer, unit_id, data.getString("school_id", null), answer_1, answer_2, answer_3, data.getString("username", null), sub_id
                    );
                //もらった返事を処理
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        result= postResult.createQuestionFour;
                        if (postResult.createQuestionFour.equals("ok")){
                            Log.d("CreateChoicesResult:", postResult.createQuestionFour);
                            int problem_id = postResult.problem_id;     //問題番号

                        }else{
                            Log.d("CreateChoicesResult:", postResult.createQuestionFour);
                        }
                    }
                });
            }
        });
        thread.start();

    }
//    穴埋め
    public void createBlank(){
        handler = new Handler();

        //Postクラスを開始
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                //Postクラスを呼び出し
                CreateQuestionBlank createQuestionBlank = new CreateQuestionBlank();
                CreateQuestionBlankValues postResult = createQuestionBlank.PostCreateQuestionBlank(
                        question_f, question_b, answer, unit_id, data.getString("school_id", null), answer_1, answer_2, answer_3, data.getString("username", null), sub_id
                );
                //もらった返事を処理
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        result= postResult.createQuestionBlank;
                        if (postResult.createQuestionBlank.equals("ok")){
                            Log.d("CreateChoicesResult:", postResult.createQuestionBlank);
                            int problem_id = postResult.problem_id;     //問題番号

                        }else{
                            Log.d("CreateChoicesResult:", postResult.createQuestionBlank);
                        }
                    }
                });
            }
        });
        thread.start();

    }

    class MyThread extends Thread {
        public void run() {
            //時間のかかる処理実行します。今回は仮で10秒停止させています。
            try {
                //10秒停止します。
                Thread.sleep(0);
            } catch (InterruptedException e) {
            }
        }
    }
}