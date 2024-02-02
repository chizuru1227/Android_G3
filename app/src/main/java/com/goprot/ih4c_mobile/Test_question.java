package com.goprot.ih4c_mobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.goprot.ih4c_mobile.post.CreateQuestionFour;
import com.goprot.ih4c_mobile.post.GetQuestionsA;
import com.goprot.ih4c_mobile.post.GetQuestionsB;
import com.goprot.ih4c_mobile.post.GetQuestionsC;
import com.goprot.ih4c_mobile.post.RegistAnswer;
import com.goprot.ih4c_mobile.post_values.CreateQuestionFourValues;
import com.goprot.ih4c_mobile.post_values.GetQuestionsAValues;
import com.goprot.ih4c_mobile.post_values.GetQuestionsBValues;
import com.goprot.ih4c_mobile.post_values.GetQuestionsCValues;
import com.goprot.ih4c_mobile.post_values.RegistAnswerValues;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Test_question extends Fragment {

    String sentaku_f = "";
    String grade = "";
    String sentaku_data = "";
    SharedPreferences data ;

    Handler handler;
    final JSONArray[] q = {new JSONArray()};
    final String[] problem_id = {""};
    final int[] format_id = {0};
    final String[] answer = {""};
    final String[] problem_statement = {""};
    final String[] choices_1 = {""};
    final String[] choices_2 = {""};
    final String[] choices_3 = {""};
    final String[] kamoku = {""};
    final int[] bunya = {0};

    Button incorrect;
    Button correct;
    Button answer_b;
    LinearLayout lay_answer;
    ImageView img_answer;
    TextView text_answer;
    TextView set_f_question;
    TextView set_4_answer;
    TextView set_4_answer_1;
    TextView set_4_answer_2;
    TextView set_4_answer_3;

    String ans = "0";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // フラグメントのレイアウトをインフレート
        return inflater.inflate(R.layout.test_question, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        data = this.getActivity().getSharedPreferences("Login", Context.MODE_PRIVATE);
//        String problem_id = "";
//        String answer_t = "";
//        String problem_statement = "";
//        String choices_1 = "";
//        String choices_2 = "";
//        String choices_3 = "";

        Bundle args = getArguments();
        if (args != null) {
//            problem_id = args.getString("problem_id");
            sentaku_f = args.getString("ChooseFlag");
            grade = args.getString("grade");
            sentaku_data = args.getString("ChooseData");
        }

        //全科目の場合
        //->A
        if (sentaku_f.equals("A")) {
            handler = new Handler();
//            //Postクラスを開始
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //Postクラスを呼び出し
                    GetQuestionsA getQuestionsA = new GetQuestionsA();
                    GetQuestionsAValues postResult = getQuestionsA.GetQuestionsA(
                            "A", grade, data.getString("school_id", null)
                    );
                    //もらった返事を処理
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (postResult.getQuestionsA.equals("ok")) {
                                Log.d("CreateChoicesResult:", postResult.getQuestionsA);
//                                    dataList = postResult.AList;
//        for(int i = 0; i < dataList.length(); i++) {
                                try {
                                    JSONObject json = postResult.AList.getJSONObject(0);
                                    problem_id[0] = json.getString("problem_id");
                                    format_id[0] = json.getInt("format_id");
                                    q[0] = json.getJSONArray("q");
                                    kamoku[0] = json.getString("subject_id");
                                    bunya[0] = json.getInt("unit_id");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
//        }
                                if(format_id[0] == 1) {
                                    try {
                                        JSONObject json = q[0].getJSONObject(0);
                                        answer[0] = json.getString("answer");
                                        problem_statement[0] = json.getString("problem_statement_F");
                                        problem_statement[0] += "　(　?　)　";
                                        problem_statement[0] += json.getString("problem_statement_E");
                                        choices_1[0] = json.getString("choices_1");
                                        choices_2[0] = json.getString("choices_2");
                                        choices_3[0] = json.getString("choices_3");


                                        set_f_question.setText(problem_statement[0]);
                                        set_4_answer.setText(answer[0]);
                                        set_4_answer_1.setText(choices_1[0]);
                                        set_4_answer_2.setText(choices_2[0]);
                                        set_4_answer_3.setText(choices_3[0]);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }else if(format_id[0] == 2){
                                    try {
                                        JSONObject json = q[0].getJSONObject(0);
                                        answer[0] = json.getString("answer");
                                        problem_statement[0] = json.getString("problem_statement");
                                        choices_1[0] = json.getString("choices_1");
                                        choices_2[0] = json.getString("choices_2");
                                        choices_3[0] = json.getString("choices_3");

                                        set_f_question.setText(problem_statement[0]);
                                        set_4_answer.setText(answer[0]);
                                        set_4_answer_1.setText(choices_1[0]);
                                        set_4_answer_2.setText(choices_2[0]);
                                        set_4_answer_3.setText(choices_3[0]);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                            } else {
                                Log.d("CreateChoicesResult:", postResult.getQuestionsA);
                            }
                        }
                    });
                }
            });
            thread.start();
        }
        //一科目の場合
        //->B
        else if (sentaku_f.equals("B")) {
            handler = new Handler();
            //Postクラスを開始
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //Postクラスを呼び出し
                    GetQuestionsB getQuestionsB = new GetQuestionsB();
                    GetQuestionsBValues postResult = getQuestionsB.GetQuestionsB(
                            "B", grade, data.getString("school_id", null),
                            sentaku_data
                    );
                    //もらった返事を処理
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (postResult.getQuestionsB.equals("ok")) {
                                Log.d("CreateChoicesResult:", postResult.getQuestionsB);
                                try {
                                    JSONObject json = postResult.BList.getJSONObject(0);
                                    problem_id[0] = json.getString("problem_id");
                                    format_id[0] = json.getInt("format_id");
                                    kamoku[0] =json.getString("subject_id");
                                    bunya[0] = json.getInt("unit_id");
                                    q[0] = json.getJSONArray("q");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
//        }
                                if(format_id[0] == 1) {
                                    try {
                                        JSONObject json = q[0].getJSONObject(0);
                                        answer[0] = json.getString("answer");
                                        problem_statement[0] = json.getString("problem_statement_F");
                                        problem_statement[0] += "　(　?　)　";
                                        problem_statement[0] += json.getString("problem_statement_E");
                                        choices_1[0] = json.getString("choices_1");
                                        choices_2[0] = json.getString("choices_2");
                                        choices_3[0] = json.getString("choices_3");
                                        set_f_question.setText(problem_statement[0]);
                                        set_4_answer.setText(answer[0]);
                                        set_4_answer_1.setText(choices_1[0]);
                                        set_4_answer_2.setText(choices_2[0]);
                                        set_4_answer_3.setText(choices_3[0]);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }else if(format_id[0] == 2){
                                    try {
                                        JSONObject json = q[0].getJSONObject(0);
                                        answer[0] = json.getString("answer");
                                        problem_statement[0] = json.getString("problem_statement");
                                        choices_1[0] = json.getString("choices_1");
                                        choices_2[0] = json.getString("choices_2");
                                        choices_3[0] = json.getString("choices_3");
                                        set_f_question.setText(problem_statement[0]);
                                        set_4_answer.setText(answer[0]);
                                        set_4_answer_1.setText(choices_1[0]);
                                        set_4_answer_2.setText(choices_2[0]);
                                        set_4_answer_3.setText(choices_3[0]);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                            } else {
                                Log.d("CreateChoicesResult:", postResult.getQuestionsB);
                            }
                        }
                    });
                }
            });
            thread.start();
        }
        //分野選択の場合
        //->C
        else if (sentaku_f.equals("C")) {
            handler = new Handler();
            //Postクラスを開始
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    //Postクラスを呼び出し
                    GetQuestionsC getQuestionsC = new GetQuestionsC();
                    GetQuestionsCValues postResult = getQuestionsC.GetQuestionsC(
                            "C", data.getString("school_id", null), sentaku_data
                    );
                    //もらった返事を処理
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (postResult.getQuestionsC.equals("ok")) {
                                Log.d("CreateChoicesResult:", postResult.getQuestionsC);
                                try {
                                    JSONObject json = postResult.CList.getJSONObject(0);
                                    problem_id[0] = json.getString("problem_id");
                                    format_id[0] = json.getInt("format_id");
                                    kamoku[0] = json.getString("subject_id");
                                    bunya[0] = json.getInt("unit_id");
                                    q[0] = json.getJSONArray("q");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
//        }
                                if(format_id[0] == 1) {
                                    try {
                                        JSONObject json = q[0].getJSONObject(0);
                                        answer[0] = json.getString("answer");
                                        problem_statement[0] = json.getString("problem_statement_F");
                                        problem_statement[0] += "　(　?　)　";
                                        problem_statement[0] += json.getString("problem_statement_E");
                                        choices_1[0] = json.getString("choices_1");
                                        choices_2[0] = json.getString("choices_2");
                                        choices_3[0] = json.getString("choices_3");
                                        set_f_question.setText(problem_statement[0]);
                                        set_4_answer.setText(answer[0]);
                                        set_4_answer_1.setText(choices_1[0]);
                                        set_4_answer_2.setText(choices_2[0]);
                                        set_4_answer_3.setText(choices_3[0]);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }else if(format_id[0] == 2){
                                    try {
                                        JSONObject json = q[0].getJSONObject(0);
                                        answer[0] = json.getString("answer");
                                        problem_statement[0] = json.getString("problem_statement");
                                        choices_1[0] = json.getString("choices_1");
                                        choices_2[0] = json.getString("choices_2");
                                        choices_3[0] = json.getString("choices_3");
                                        set_f_question.setText(problem_statement[0]);
                                        set_4_answer.setText(answer[0]);
                                        set_4_answer_1.setText(choices_1[0]);
                                        set_4_answer_2.setText(choices_2[0]);
                                        set_4_answer_3.setText(choices_3[0]);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else {
                                Log.d("CreateChoicesResult:", postResult.getQuestionsC);
                            }
                        }
                    });
                }
            });
            thread.start();

        }


        //IDからオブジェクトを取得
        incorrect  = (Button) view.findViewById(R.id.btn_incorrect);
        correct  = (Button) view.findViewById(R.id.btn_correct);
        answer_b  = (Button) view.findViewById(R.id.btn_answer);
        lay_answer  = (LinearLayout) view.findViewById(R.id.view_answer);
        img_answer = (ImageView) view.findViewById(R.id.img_answer);
        text_answer = (TextView) view.findViewById(R.id.text_answer);

        set_f_question = (TextView) view.findViewById(R.id.set_f_question);
        set_4_answer = (TextView) view.findViewById(R.id.set_4_answer);
        set_4_answer_1 = (TextView) view.findViewById(R.id.set_4_answer_1);
        set_4_answer_2 = (TextView) view.findViewById(R.id.set_4_answer_2);
        set_4_answer_3 = (TextView) view.findViewById(R.id.set_4_answer_3);
        set_f_question.setText(problem_statement[0]);
        set_4_answer.setText(answer[0]);
        set_4_answer.setClickable(true);
        set_4_answer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            img_answer.setImageResource(R.drawable.correct);
            text_answer.setText("正解");
            text_answer.setTextColor(Color.parseColor("#B22222"));
            lay_answer.setVisibility(View.VISIBLE);
            //ボタンを無効にする処理
//            incorrect.setEnabled(false);
//            correct.setEnabled(false);
            //ボタンを有効にする処理
//            answer.setEnabled(true);
                set_4_answer.setClickable(false);
                set_4_answer_1.setClickable(false);
                set_4_answer_2.setClickable(false);
                set_4_answer_3.setClickable(false);
                answer_b.setText("次へ");
                ans = "1";
            }
        });

        set_4_answer_1.setText(choices_1[0]);
        set_4_answer_1.setClickable(true);
        set_4_answer_1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            img_answer.setImageResource(R.drawable.incorrect);
            text_answer.setText("不正解");
            text_answer.setTextColor(Color.parseColor("#4682B4"));
            lay_answer.setVisibility(View.VISIBLE);
            //ボタンを無効にする処理
//            incorrect.setEnabled(false);
//            correct.setEnabled(false);
            //ボタンを有効にする処理
//            answer.setEnabled(true);
                set_4_answer.setClickable(false);
                set_4_answer_1.setClickable(false);
                set_4_answer_2.setClickable(false);
                set_4_answer_3.setClickable(false);
                answer_b.setText("次へ");
            }
        });

        set_4_answer_2.setText(choices_2[0]);

        set_4_answer_2.setClickable(true);
        set_4_answer_2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                img_answer.setImageResource(R.drawable.incorrect);
                text_answer.setText("不正解");
                text_answer.setTextColor(Color.parseColor("#4682B4"));
                lay_answer.setVisibility(View.VISIBLE);
                //ボタンを無効にする処理
//                incorrect.setEnabled(false);
//                correct.setEnabled(false);
                //ボタンを有効にする処理
//            answer.setEnabled(true);
                set_4_answer.setClickable(false);
                set_4_answer_1.setClickable(false);
                set_4_answer_2.setClickable(false);
                set_4_answer_3.setClickable(false);
                answer_b.setText("次へ");
            }
        });

        set_4_answer_3.setText(choices_3[0]);
        set_4_answer_3.setClickable(true);
        set_4_answer_3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                img_answer.setImageResource(R.drawable.incorrect);
                text_answer.setText("不正解");
                text_answer.setTextColor(Color.parseColor("#4682B4"));
                lay_answer.setVisibility(View.VISIBLE);
                //ボタンを無効にする処理
//                incorrect.setEnabled(false);
//                correct.setEnabled(false);
                //ボタンを有効にする処理
//            answer.setEnabled(true);
                set_4_answer.setClickable(false);
                set_4_answer_1.setClickable(false);
                set_4_answer_2.setClickable(false);
                set_4_answer_3.setClickable(false);
                answer_b.setText("次へ");
            }
        });

        //string.xmlから文字列取得
        String incorrect_text = getString(R.string.incorrect_text);
        String correct_text = getString(R.string.correct_text);

        //ボタンを有効にする処理
        answer_b.setEnabled(true);

        //リスナーを登録
        //不正解を押した場合
//        incorrect.setOnClickListener(v -> {
//            img_answer.setImageResource(R.drawable.incorrect);
//            text_answer.setText(incorrect_text);
//            text_answer.setTextColor(Color.parseColor("#4682B4"));
//            lay_answer.setVisibility(View.VISIBLE);
//            //ボタンを無効にする処理
//            incorrect.setEnabled(false);
//            correct.setEnabled(false);
//            //ボタンを有効にする処理
//            answer.setEnabled(true);
//        });
        //正解を押した場合
//        correct.setOnClickListener(v -> {
//            img_answer.setImageResource(R.drawable.correct);
//            text_answer.setText(correct_text);
//            text_answer.setTextColor(Color.parseColor("#B22222"));
//            lay_answer.setVisibility(View.VISIBLE);
//            //ボタンを無効にする処理
//            incorrect.setEnabled(false);
//            correct.setEnabled(false);
//            //ボタンを有効にする処理
//            answer.setEnabled(true);
//        });
        //回答を押した場合
        answer_b.setOnClickListener(v -> {
            FragmentManager fragmentManager = getFragmentManager();
            if(fragmentManager != null) {

//                回答結果送信
                handler = new Handler();

                //Postクラスを開始
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //Postクラスを呼び出し
                        RegistAnswer registAnswer = new RegistAnswer();
                        RegistAnswerValues postResult = registAnswer.PostRegistAnswer(
                                data.getString("username", null), String.valueOf(bunya[0]), ans
                        );
                        //もらった返事を処理
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                String result= postResult.registAnswer;
                                if (postResult.registAnswer.equals("ok")){
                                    Log.d("CreateChoicesResult:", postResult.registAnswer);                          Log.d("CreateChoicesResult:", postResult.registAnswer);
                                    Log.d("message:", postResult.message);

                                }else{
                                    Log.d("CreateChoicesResult:", postResult.registAnswer);
                                }
                            }
                        });
                    }
                });
                thread.start();


                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Test_result fragment = new Test_result();
                Bundle bundle = new Bundle();

                bundle.putString("Ka", kamoku[0]);
                bundle.putString("Bu", String.valueOf(bunya[0]));
                bundle.putString("An", ans);

                //値を書き込む
                fragment.setArguments(bundle);
                ft.replace(R.id.fragmentContainerView2, fragment).commit();

//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                fragmentTransaction.replace(R.id.fragmentContainerView2, Test_result.class,null);
//                fragmentTransaction.commit();
            }
        });
    }

}