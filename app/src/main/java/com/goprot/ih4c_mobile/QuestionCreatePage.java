package com.goprot.ih4c_mobile;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.goprot.ih4c_mobile.DataBase.CreateDataBase;
import com.goprot.ih4c_mobile.post.CreateQuestionFour;
import com.goprot.ih4c_mobile.post.GetQuestionsA;
import com.goprot.ih4c_mobile.post.GetQuestionsB;
import com.goprot.ih4c_mobile.post.GetQuestionsC;
import com.goprot.ih4c_mobile.post_values.CreateQuestionFourValues;
import com.goprot.ih4c_mobile.post_values.GetQuestionsAValues;
import com.goprot.ih4c_mobile.post_values.GetQuestionsBValues;
import com.goprot.ih4c_mobile.post_values.GetQuestionsCValues;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class QuestionCreatePage extends AppCompatActivity {

    TextView config;

//  分野ボタン
    Button kokugo_button;
    Button sugaku_button;
    Button shakai_button;
    Button rika_button;
    Button eigo_button;
//分野チェックボックス
    CheckBox kokugo_checkbox;
    CheckBox sugaku_checkbox;
    CheckBox shakai_checkbox;
    CheckBox rika_checkbox;
    CheckBox eigo_checkbox;
//分野の分野チェックボックス
    CheckBox che_kok1;
    CheckBox che_kok2;
    CheckBox che_kok3;
    CheckBox che_kok4;
    CheckBox che_kok5;
    CheckBox che_kok6;
    CheckBox che_sug1;
    CheckBox che_sug2;
    CheckBox che_sug3;
    CheckBox che_sha1;
    CheckBox che_sha2;
    CheckBox che_sha3;
    CheckBox che_rik1;
    CheckBox che_rik2;
    CheckBox che_rik3;
    CheckBox che_eig1;
    CheckBox che_eig2;
    CheckBox che_eig3;

//Scroll
    ScrollView sscroll;
    ScrollView skokugo;
    ScrollView ssugaku;
    ScrollView sshakai;
    ScrollView srika;
    ScrollView seigo;
//count変数
    int kokugo_count = 0;
    int sugaku_count = 0;
    int shakai_count = 0;
    int rika_count = 0;
    int eigo_count = 0;
    int count1;
    int count2;
    int count3;
    int count4;
    int count5;

//
    LinearLayout kokugolay;
    LinearLayout sugakulay;
    LinearLayout shakailay;
    LinearLayout rikalay;
    LinearLayout eigolay;


    SQLiteDatabase db ;
    String grade = "1";


    int all_c = 0;
    private boolean flag = false;
    int ch_c = 0;

    String sentaku_f = "O";
    String sentaku_data = "";
    String sentaku_data_b = "";
    String sentaku_data_c = "";

    SharedPreferences data ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_create_page);

        View decor = getWindow().getDecorView();
        // hide navigation bar, hide status bar. don't show navigation when tapped.
        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        kokugolay= (LinearLayout) findViewById(R.id.group_kokugo);
        sugakulay= (LinearLayout) findViewById(R.id.group_sugaku);
        shakailay= (LinearLayout) findViewById(R.id.group_shakai);
        rikalay= (LinearLayout) findViewById(R.id.group_rika);
        eigolay= (LinearLayout) findViewById(R.id.group_eigo);

        data = this.getSharedPreferences("Login", Context.MODE_PRIVATE);
        setCheckBox(grade);

//        ボタン
        kokugo_button=(Button) findViewById(R.id.kokugo_button);
        sugaku_button = (Button)findViewById(R.id.suugaku_button);
        shakai_button = (Button)findViewById(R.id.shakai_button);
        rika_button = (Button)findViewById(R.id.rika_button);
        eigo_button = (Button)findViewById(R.id.eigo_button);
        Button grade_1 = (Button)findViewById(R.id.grade_1);
        Button grade_2 = (Button)findViewById(R.id.grade_2);
        Button grade_3 = (Button)findViewById(R.id.grade_3);
//        分野チェックボックス
        kokugo_checkbox = (CheckBox) findViewById(R.id.kokugo_checkbox);
        sugaku_checkbox = (CheckBox) findViewById(R.id.suugaku_cehckbox);
        shakai_checkbox = (CheckBox) findViewById(R.id.shakai_checkbox);
        rika_checkbox = (CheckBox) findViewById(R.id.rika_checkbox);
        eigo_checkbox = (CheckBox) findViewById(R.id.eigo_checkbox);


//        分野の分野のチェックボックス (ここはデータベースのデータあったら消える部分

        che_kok1 = (CheckBox) findViewById(R.id.kokugo1);
        che_kok2 = (CheckBox) findViewById(R.id.kokugo2);
        che_kok3 = (CheckBox) findViewById(R.id.kokugo3);
        che_kok4 = (CheckBox) findViewById(R.id.kokugo4);
        che_kok5 = (CheckBox) findViewById(R.id.kokugo5);
        che_kok6 = (CheckBox) findViewById(R.id.kokugo6);
        che_sug1 = (CheckBox) findViewById(R.id.sugaku1);
        che_sug2 = (CheckBox) findViewById(R.id.sugaku2);
        che_sug3 = (CheckBox) findViewById(R.id.sugaku3);
        che_sha1 = (CheckBox) findViewById(R.id.shakai1);
        che_sha2 = (CheckBox) findViewById(R.id.shakai2);
        che_sha3 = (CheckBox) findViewById(R.id.shakai3);
        che_rik1 = (CheckBox) findViewById(R.id.rika1);
        che_rik2 = (CheckBox) findViewById(R.id.rika2);
        che_rik3 = (CheckBox) findViewById(R.id.rika3);
        che_eig1 = (CheckBox) findViewById(R.id.eigo1);
        che_eig2 = (CheckBox) findViewById(R.id.eigo2);
        che_eig3 = (CheckBox) findViewById(R.id.eigo3);

        grade_1.setBackgroundColor(Color.rgb(102, 51, 0));

        //学年ボタンクリック
        grade_1.setOnClickListener(v -> {
            kokugolay.removeAllViews();
            sugakulay.removeAllViews();
            shakailay.removeAllViews();
            rikalay.removeAllViews();
            eigolay.removeAllViews();
            grade = "1";
            grade_1.setBackgroundColor(Color.rgb(102, 51, 0));
            grade_2.setBackgroundColor(Color.rgb(202, 174, 135));
            grade_3.setBackgroundColor(Color.rgb(202, 174, 135));
            setCheckBox(grade);
        });
        grade_2.setOnClickListener(v -> {
            kokugolay.removeAllViews();
            sugakulay.removeAllViews();
            shakailay.removeAllViews();
            rikalay.removeAllViews();
            eigolay.removeAllViews();
            grade = "2";
            grade_1.setBackgroundColor(Color.rgb(202, 174, 135));
            grade_2.setBackgroundColor(Color.rgb(102, 51, 0));
            grade_3.setBackgroundColor(Color.rgb(202, 174, 135));
            setCheckBox(grade);
        });
        grade_3.setOnClickListener(v -> {
            kokugolay.removeAllViews();
            sugakulay.removeAllViews();
            shakailay.removeAllViews();
            rikalay.removeAllViews();
            eigolay.removeAllViews();
            grade = "3";
            grade_1.setBackgroundColor(Color.rgb(202, 174, 135));
            grade_2.setBackgroundColor(Color.rgb(202, 174, 135));
            grade_3.setBackgroundColor(Color.rgb(102, 51, 0));
            setCheckBox(grade);
        });

    }
//分析ボタンクリックしたら詳細分析表示
    public void buttongroup(View view){
        skokugo = findViewById(R.id.scroll_kokugo);
        ssugaku = findViewById(R.id.scroll_sugaku);
        sshakai = findViewById(R.id.scroll_shakai);
        srika = findViewById(R.id.scroll_rika);
        seigo = findViewById(R.id.scroll_eigo);
        switch (view.getId()){
            case R.id.kokugo_button:
                sscroll = findViewById(R.id.scroll_kokugo);
                if (sscroll.getVisibility() == View.VISIBLE){
//                    元の位置に戻る
                   sscroll.setVisibility(View.GONE);
                }else {
                    sscroll.setVisibility(View.VISIBLE);
                    ssugaku.setVisibility(View.GONE);
                    sshakai.setVisibility(View.GONE);
                    srika.setVisibility(View.GONE);
                    seigo.setVisibility(View.GONE);
                }
                    break;

            case R.id.suugaku_button:
                sscroll = findViewById(R.id.scroll_sugaku);
                if (sscroll.getVisibility() == View.VISIBLE){
//                    元の位置に戻る
                    sscroll.setVisibility(View.GONE);
                }else {
                    sscroll.setVisibility(View.VISIBLE);
                    skokugo.setVisibility(View.GONE);
                    sshakai.setVisibility(View.GONE);
                    srika.setVisibility(View.GONE);
                    seigo.setVisibility(View.GONE);
                }
                break;

            case R.id.shakai_button:
                sscroll = findViewById(R.id.scroll_shakai);
                if (sscroll.getVisibility() == View.VISIBLE){
//                    元の位置に戻る
                    sscroll.setVisibility(View.GONE);
                }else {
                    sscroll.setVisibility(View.VISIBLE);
                    skokugo.setVisibility(View.GONE);
                    ssugaku.setVisibility(View.GONE);
                    srika.setVisibility(View.GONE);
                    seigo.setVisibility(View.GONE);
                }
                break;

            case R.id.rika_button:
                sscroll= findViewById(R.id.scroll_rika);
                if (sscroll.getVisibility() == View.VISIBLE){
//                    元の位置に戻る
                    sscroll.setVisibility(View.GONE);
                }else {
                    sscroll.setVisibility(View.VISIBLE);
                    skokugo.setVisibility(View.GONE);
                    ssugaku.setVisibility(View.GONE);
                    sshakai.setVisibility(View.GONE);
                    seigo.setVisibility(View.GONE);
                }
                break;

            case R.id.eigo_button:
                sscroll = findViewById(R.id.scroll_eigo);
                if (sscroll.getVisibility() == View.VISIBLE){
//                    元の位置に戻る
                    sscroll.setVisibility(View.GONE);
                }else {

                    sscroll.setVisibility(View.VISIBLE);
                    skokugo.setVisibility(View.GONE);
                    ssugaku.setVisibility(View.GONE);
                    sshakai.setVisibility(View.GONE);
                    srika.setVisibility(View.GONE);
                }
                break;
        }
    }
    public void checkall(View v){
        CheckBox checkbox = (CheckBox) v;
        if(checkbox.isChecked()){
//            全てチェック
            sentaku_f = "A";
            kokugo_checkbox.setChecked(true);
            sugaku_checkbox.setChecked(true);
            shakai_checkbox.setChecked(true);
            rika_checkbox.setChecked(true);
            eigo_checkbox.setChecked(true);
            kokugo_checkbox.setEnabled(false);
            sugaku_checkbox.setEnabled(false);
            shakai_checkbox.setEnabled(false);
            rika_checkbox.setEnabled(false);
            eigo_checkbox.setEnabled(false);

//            本番環境ループ
//            分野の中のチェックボックス
//            che_kok1.setChecked(true);
            for(int i = 1; i < all_c ;i++){
                CheckBox c =(CheckBox) findViewById(i);
                c.setChecked(true);
            }
            for(int i = 1; i < all_c ;i++){
                CheckBox c =(CheckBox) findViewById(i);
                c.setEnabled(false);
            }


        }else{
//            全てチェックを外す
            sentaku_f = "O";
            kokugo_checkbox.setChecked(false);
            sugaku_checkbox.setChecked(false);
            shakai_checkbox.setChecked(false);
            rika_checkbox.setChecked(false);
            eigo_checkbox.setChecked(false);
            kokugo_checkbox.setEnabled(true);
            sugaku_checkbox.setEnabled(true);
            shakai_checkbox.setEnabled(true);
            rika_checkbox.setEnabled(true);
            eigo_checkbox.setEnabled(true);

            //            本番環境ループ
//            分野の中のチェックボックスを外す
            for(int i = 1; i < all_c ;i++){
                CheckBox c =(CheckBox) findViewById(i);
                c.setChecked(false);
            }
            for(int i = 1; i < all_c ;i++){
                CheckBox c =(CheckBox) findViewById(i);
                c.setEnabled(true);
            }

        }
    }
    @SuppressLint("ResourceType")
//    グループの中だけチェック
    public void checkgroup(View v){
        CheckBox checkbox = (CheckBox) v;

        if (checkbox.isChecked()){
            switch (v.getId()){
                case R.id.kokugo_checkbox:
                    sentaku_f = "B";
                    sentaku_data_b = "NL";
//                    LinearLayout kokugolay= (LinearLayout) findViewById(R.id.group_kokugo);
                    count1 = kokugolay.getChildCount();
                    sugaku_checkbox.setEnabled(false);
                    shakai_checkbox.setEnabled(false);
                    rika_checkbox.setEnabled(false);
                    eigo_checkbox.setEnabled(false);

                    for (int i = 0;i<count1;i++){
                        View m = kokugolay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(true);
                    }
                    for(int i = 1; i < all_c ;i++){
                        CheckBox c =(CheckBox) findViewById(i);
                        c.setEnabled(false);
                    }
                    break;
                case R.id.suugaku_cehckbox:
                    sentaku_f = "B";
                    sentaku_data_b = "MT";
//                    LinearLayout sugakulay= (LinearLayout) findViewById(R.id.group_sugaku);
                    count2 = sugakulay.getChildCount();
                    kokugo_checkbox.setEnabled(false);
                    shakai_checkbox.setEnabled(false);
                    rika_checkbox.setEnabled(false);
                    eigo_checkbox.setEnabled(false);
                    for (int i = 0;i<count2;i++){
                        View m = sugakulay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(true);
                    }
                    for(int i = 1; i < all_c ;i++){
                        CheckBox c =(CheckBox) findViewById(i);
                        c.setEnabled(false);
                    }
                    break;
                case R.id.shakai_checkbox:
                    sentaku_f = "B";
                    sentaku_data_b = "SS";
//                    LinearLayout shakailay= (LinearLayout) findViewById(R.id.group_shakai);
                    count3 = shakailay.getChildCount();
                    kokugo_checkbox.setEnabled(false);
                    sugaku_checkbox.setEnabled(false);
                    rika_checkbox.setEnabled(false);
                    eigo_checkbox.setEnabled(false);
                    for (int i = 0;i<count3;i++){
                        View m = shakailay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(true);
                    }
                    for(int i = 1; i < all_c ;i++){
                        CheckBox c =(CheckBox) findViewById(i);
                        c.setEnabled(false);
                    }
                    break;
                case R.id.rika_checkbox:
                    sentaku_f = "B";
                    sentaku_data_b = "SE";
//                    LinearLayout rikalay= (LinearLayout) findViewById(R.id.group_rika);
                    count4 = rikalay.getChildCount();
                    kokugo_checkbox.setEnabled(false);
                    sugaku_checkbox.setEnabled(false);
                    shakai_checkbox.setEnabled(false);
                    eigo_checkbox.setEnabled(false);
                    for (int i = 0;i<count4;i++){
                        View m = rikalay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(true);
                    }
                    for(int i = 1; i < all_c ;i++){
                        CheckBox c =(CheckBox) findViewById(i);
                        c.setEnabled(false);
                    }
                    break;
                case R.id.eigo_checkbox:
                    sentaku_f = "B";
                    sentaku_data_b = "EL";
//                    LinearLayout eigolay= (LinearLayout) findViewById(R.id.group_eigo);
                    count5 = eigolay.getChildCount();
                    kokugo_checkbox.setEnabled(false);
                    sugaku_checkbox.setEnabled(false);
                    shakai_checkbox.setEnabled(false);
                    rika_checkbox.setEnabled(false);
                    for (int i = 0;i<count5;i++){
                        View m = eigolay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(true);
                    }
                    for(int i = 1; i < all_c ;i++){
                        CheckBox c =(CheckBox) findViewById(i);
                        c.setEnabled(false);
                    }
                    break;
            }
        }else{
            switch (v.getId()){
                case R.id.kokugo_checkbox:
                    sentaku_f = "O";
                    sentaku_data_b = "";
//                    LinearLayout kokugolay= (LinearLayout) findViewById(R.id.group_kokugo);
                    count1 = kokugolay.getChildCount();
                    kokugo_checkbox.setEnabled(true);
                    sugaku_checkbox.setEnabled(true);
                    shakai_checkbox.setEnabled(true);
                    rika_checkbox.setEnabled(true);
                    eigo_checkbox.setEnabled(true);
                    for (int i = 0;i<count1;i++){
                        View m = kokugolay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(false);
                    }
                    for(int i = 1; i < all_c ;i++){
                        CheckBox c =(CheckBox) findViewById(i);
                        c.setEnabled(true);
                    }
                    break;
                case R.id.suugaku_cehckbox:
                    sentaku_f = "O";
                    sentaku_data_b = "";
//                    LinearLayout sugakulay= (LinearLayout) findViewById(R.id.group_sugaku);
                    count2 = sugakulay.getChildCount();
                    kokugo_checkbox.setEnabled(true);
                    sugaku_checkbox.setEnabled(true);
                    shakai_checkbox.setEnabled(true);
                    rika_checkbox.setEnabled(true);
                    eigo_checkbox.setEnabled(true);
                    for (int i = 0;i<count2;i++){
                        View m = sugakulay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(false);
                    }
                    for(int i = 1; i < all_c ;i++){
                        CheckBox c =(CheckBox) findViewById(i);
                        c.setEnabled(true);
                    }
                    break;
                case R.id.shakai_checkbox:
                    sentaku_f = "O";
                    sentaku_data_b = "";
//                    LinearLayout shakailay= (LinearLayout) findViewById(R.id.group_shakai);
                    count3 = shakailay.getChildCount();
                    kokugo_checkbox.setEnabled(true);
                    sugaku_checkbox.setEnabled(true);
                    shakai_checkbox.setEnabled(true);
                    rika_checkbox.setEnabled(true);
                    eigo_checkbox.setEnabled(true);
                    for (int i = 0;i<count3;i++){
                        View m = shakailay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(false);
                    }
                    for(int i = 1; i < all_c ;i++){
                        CheckBox c =(CheckBox) findViewById(i);
                        c.setEnabled(true);
                    }
                    break;
                case R.id.rika_checkbox:
                    sentaku_f = "O";
                    sentaku_data_b = "";
//                    LinearLayout rikalay= (LinearLayout) findViewById(R.id.group_rika);
                    count4 = rikalay.getChildCount();
                    kokugo_checkbox.setEnabled(true);
                    sugaku_checkbox.setEnabled(true);
                    shakai_checkbox.setEnabled(true);
                    rika_checkbox.setEnabled(true);
                    eigo_checkbox.setEnabled(true);
                    for (int i = 0;i<count4;i++){
                        View m = rikalay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(false);
                    }
                    for(int i = 1; i < all_c ;i++){
                        CheckBox c =(CheckBox) findViewById(i);
                        c.setEnabled(true);
                    }
                    break;
                case R.id.eigo_checkbox:
                    sentaku_f = "O";
                    sentaku_data_b = "";
//                    LinearLayout eigolay= (LinearLayout) findViewById(R.id.group_eigo);
                    count5 = eigolay.getChildCount();
                    kokugo_checkbox.setEnabled(true);
                    sugaku_checkbox.setEnabled(true);
                    shakai_checkbox.setEnabled(true);
                    rika_checkbox.setEnabled(true);
                    eigo_checkbox.setEnabled(true);
                    for (int i = 0;i<count5;i++){
                        View m = eigolay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(false);
                    }
                    for(int i = 1; i < all_c ;i++){
                        CheckBox c =(CheckBox) findViewById(i);
                        c.setEnabled(true);
                    }
                    break;
            }
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        SetView();
    }
    private void SetView(){
        View decor = getWindow().getDecorView();
        // hide navigation bar, hide status bar. don't show navigation when tapped.
        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }


    //    戻るボタン
    public void back_btnClick(View view){
        finish();
    }

    //    問題を解くボタン
    public void next_btnClick(View view){

        //設定されていない場合
        //->エラーメッセージ

        if (sentaku_f != "O") {

//            Handler handler;
//            handler = new Handler();
//            final JSONArray[] q = {new JSONArray()};
//            final String[] problem_id = {""};
//            final int[] format_id = {0};
//            final String[] answer = {""};
//            final String[] problem_statement = {""};
//            final String[] choices_1 = {""};
//            final String[] choices_2 = {""};
//            final String[] choices_3 = {""};
//            //全科目の場合
//            //->A
//            if (sentaku_f == "A") {
//                //Postクラスを開始
//                Thread thread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        //Postクラスを呼び出し
//                        GetQuestionsA getQuestionsA = new GetQuestionsA();
//                        GetQuestionsAValues postResult = getQuestionsA.GetQuestionsA(
//                                "A", Integer.valueOf(grade).toString(), data.getString("school_id", null)
//                        );
//                        //もらった返事を処理
//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                if (postResult.getQuestionsA.equals("ok")) {
//                                    Log.d("CreateChoicesResult:", postResult.getQuestionsA);
////                                    dataList = postResult.AList;
////        for(int i = 0; i < dataList.length(); i++) {
//                                    try {
//                                        JSONObject json = postResult.AList.getJSONObject(0);
//                                        problem_id[0] = json.getString("problem_id");
//                                        format_id[0] = json.getInt("format_id");
//                                        q[0] = json.getJSONArray("q");
//                                    } catch (JSONException e) {
//                                        e.printStackTrace();
//                                    }
////        }
//                                    if(format_id[0] == 1) {
//                                        try {
//                                            JSONObject json = q[0].getJSONObject(0);
//                                            answer[0] = json.getString("answer");
//                                            problem_statement[0] = json.getString("problem_statement_F");
//                                            problem_statement[0] += "　(　?　)　";
//                                            problem_statement[0] += json.getString("problem_statement_E");
//                                            choices_1[0] = json.getString("choices_1");
//                                            choices_2[0] = json.getString("choices_2");
//                                            choices_3[0] = json.getString("choices_3");
//                                        } catch (JSONException e) {
//                                            e.printStackTrace();
//                                        }
//                                    }else if(format_id[0] == 2){
//                                        try {
//                                            JSONObject json = q[0].getJSONObject(0);
//                                            answer[0] = json.getString("answer");
//                                            problem_statement[0] = json.getString("problem_statement");
//                                            choices_1[0] = json.getString("choices_1");
//                                            choices_2[0] = json.getString("choices_2");
//                                            choices_3[0] = json.getString("choices_3");
//                                        } catch (JSONException e) {
//                                            e.printStackTrace();
//                                        }
//                                    }
//
//                                } else {
//                                    Log.d("CreateChoicesResult:", postResult.getQuestionsA);
//                                }
//                            }
//                        });
//                    }
//                });
//                thread.start();
//            }
//            //一科目の場合
//            //->B
//            else if (sentaku_f == "B") {
//                //Postクラスを開始
//                Thread thread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        //Postクラスを呼び出し
//                        GetQuestionsB getQuestionsB = new GetQuestionsB();
//                        GetQuestionsBValues postResult = getQuestionsB.GetQuestionsB(
//                                "B", Integer.valueOf(grade).toString(), data.getString("school_id", null),
//                                sentaku_data
//                        );
//                        //もらった返事を処理
//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                if (postResult.getQuestionsB.equals("ok")) {
//                                    Log.d("CreateChoicesResult:", postResult.getQuestionsB);
//                                    try {
//                                        JSONObject json = postResult.BList.getJSONObject(0);
//                                        problem_id[0] = json.getString("problem_id");
//                                        format_id[0] = json.getInt("format_id");
//                                        q[0] = json.getJSONArray("q");
//                                    } catch (JSONException e) {
//                                        e.printStackTrace();
//                                    }
////        }
//                                    if(format_id[0] == 1) {
//                                        try {
//                                            JSONObject json = q[0].getJSONObject(0);
//                                            answer[0] = json.getString("answer");
//                                            problem_statement[0] = json.getString("problem_statement_F");
//                                            problem_statement[0] += "　(　?　)　";
//                                            problem_statement[0] += json.getString("problem_statement_E");
//                                            choices_1[0] = json.getString("choices_1");
//                                            choices_2[0] = json.getString("choices_2");
//                                            choices_3[0] = json.getString("choices_3");
//                                        } catch (JSONException e) {
//                                            e.printStackTrace();
//                                        }
//                                    }else if(format_id[0] == 2){
//                                        try {
//                                            JSONObject json = q[0].getJSONObject(0);
//                                            answer[0] = json.getString("answer");
//                                            problem_statement[0] = json.getString("problem_statement");
//                                            choices_1[0] = json.getString("choices_1");
//                                            choices_2[0] = json.getString("choices_2");
//                                            choices_3[0] = json.getString("choices_3");
//                                        } catch (JSONException e) {
//                                            e.printStackTrace();
//                                        }
//                                    }
//
//                                } else {
//                                    Log.d("CreateChoicesResult:", postResult.getQuestionsB);
//                                }
//                            }
//                        });
//                    }
//                });
//                thread.start();
//            }
//            //分野選択の場合
//            //->C
//            else if (sentaku_f == "C") {
//                //Postクラスを開始
//                Thread thread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        //Postクラスを呼び出し
//                        GetQuestionsC getQuestionsC = new GetQuestionsC();
//                        GetQuestionsCValues postResult = getQuestionsC.GetQuestionsC(
//                                "C", data.getString("school_id", null), sentaku_data
//                        );
//                        //もらった返事を処理
//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                if (postResult.getQuestionsC.equals("ok")) {
//                                    Log.d("CreateChoicesResult:", postResult.getQuestionsC);
//                                    try {
//                                        JSONObject json = postResult.CList.getJSONObject(0);
//                                        problem_id[0] = json.getString("problem_id");
//                                        format_id[0] = json.getInt("format_id");
//                                        q[0] = json.getJSONArray("q");
//                                    } catch (JSONException e) {
//                                        e.printStackTrace();
//                                    }
////        }
//                                    if(format_id[0] == 1) {
//                                        try {
//                                            JSONObject json = q[0].getJSONObject(0);
//                                            answer[0] = json.getString("answer");
//                                            problem_statement[0] = json.getString("problem_statement_F");
//                                            problem_statement[0] += "　(　?　)　";
//                                            problem_statement[0] += json.getString("problem_statement_E");
//                                            choices_1[0] = json.getString("choices_1");
//                                            choices_2[0] = json.getString("choices_2");
//                                            choices_3[0] = json.getString("choices_3");
//                                        } catch (JSONException e) {
//                                            e.printStackTrace();
//                                        }
//                                    }else if(format_id[0] == 2){
//                                        try {
//                                            JSONObject json = q[0].getJSONObject(0);
//                                            answer[0] = json.getString("answer");
//                                            problem_statement[0] = json.getString("problem_statement");
//                                            choices_1[0] = json.getString("choices_1");
//                                            choices_2[0] = json.getString("choices_2");
//                                            choices_3[0] = json.getString("choices_3");
//                                        } catch (JSONException e) {
//                                            e.printStackTrace();
//                                        }
//                                    }
//                                } else {
//                                    Log.d("CreateChoicesResult:", postResult.getQuestionsC);
//                                }
//                            }
//                        });
//                    }
//                });
//                thread.start();
//
//            }

//            //分野選択の場合
//            //->B
            if (sentaku_f == "B") {sentaku_data = sentaku_data_b;}
//            //分野選択の場合
//            //->C
            else if (sentaku_f == "C") {sentaku_data = sentaku_data_c;}
            Intent intent = new Intent(QuestionCreatePage.this, Test.class);
//            intent.putExtra("dataList", dataList);
            intent.putExtra("ChooseFlag", sentaku_f );
            intent.putExtra("grade", Integer.valueOf(grade).toString());
            intent.putExtra("ChooseData", sentaku_data);
            startActivity(intent);
        }
    }

    private void setCheckBox(String grade_id){
////                    チェックボックスをデータベースから作成
////                    データベースコードはここ
        //データベースから分野取得
        String dbStr = "data/data/" + getPackageName()+"/unit_db.db";
        db = SQLiteDatabase.openOrCreateDatabase(dbStr,null);

        //レコード検索(SELECT)
        //科目、学年
        String query_select = "SELECT * FROM UNIT_TBL where  grade_id = ?";
        //DB検索実行
        Cursor db_row = db.rawQuery(query_select,new String[]{grade_id});
        //レコードを取り出しながらフィールドデータ取得
        int id =1;
        int tagId =1;
        while ( db_row.moveToNext()) {
            int unit_name_index = db_row.getColumnIndex("unit_name");
            int unit_id_index = db_row.getColumnIndex("unit_id");
            int subject_id_index = db_row.getColumnIndex("subject_id");
            String unit_name= db_row.getString(unit_name_index);
            String subject_id= db_row.getString(subject_id_index);
            String unit_id= db_row.getString(unit_id_index);
////                    データベースに存在するX分野の数だけループ
            CheckBox cb = new CheckBox(this);
////                    setTextに分野の名前をセット
//            cb.setText("data");
            cb.setText(unit_name);
            cb.setId(id);
            cb.setTag(unit_id_index);

            // リスナーをボタンに登録
            // lambda式
            cb.setOnClickListener( v-> {
                // flagがtrueの時
                if (cb.isChecked() == true) {
                    ch_c++;
                    //分野1までチェック可能
                    if(ch_c == 1){
                        sentaku_f = "C";
                        sentaku_data_c = unit_id;
                        for(int i = 1; i < all_c ;i++){
                            CheckBox c =(CheckBox) findViewById(i);
                            c.setEnabled(false);
                        }
                        v.setEnabled(true);
                    }
                    flag = false;
                }
                // flagがfalseの時
                else {
                    sentaku_f = "O";
                    sentaku_data_c = "";
                    ch_c--;
                    for(int i = 1; i < all_c ;i++){
                        CheckBox c =(CheckBox) findViewById(i);
                        c.setEnabled(true);
                    }
                    flag = true;
                }
            });

//        bunya.addView(cb);
            switch (subject_id){
                case "NL":
                    kokugolay.addView(cb);
                    break;
                case "MT":
                    cb.setTag("che_sug"+tagId);
                    sugakulay.addView(cb);
                    break;
                case "SS":
                    cb.setTag("che_sha"+tagId);
                    shakailay.addView(cb);
                    break;
                case "SE":
                    cb.setTag("che_rik"+tagId);
                    rikalay.addView(cb);
                    break;
                case "EL":
                    cb.setTag("che_eig"+tagId);
                    eigolay.addView(cb);
                    break;
            }
            id++;
////                    ループ終了
        }
        all_c = id;

        config=findViewById(R.id.config_text);
    }
}
