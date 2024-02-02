package com.goprot.ih4c_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MatchSelectQuestion extends AppCompatActivity {



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

    int kokugo_count = 0;
    int sugaku_count = 0;
    int shakai_count = 0;
    int rika_count = 0;
    int eigo_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_select_question);

        View decor = getWindow().getDecorView();
        // hide navigation bar, hide status bar. don't show navigation when tapped.
        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);


////                    チェックボックスをデータベースから作成
////                    データベースコードはここ
////                    データベースに存在するX分野の数だけループ
//        CheckBox cb = new CheckBox(this);
////                    setTextに分野の名前をセット
//        cb.setText("data");
//        bunya.addView(cb);
////                    ループ終了

        config=findViewById(R.id.config_text);


//        ボタン
        kokugo_button=(Button) findViewById(R.id.kokugo_button);
        sugaku_button = (Button)findViewById(R.id.suugaku_button);
        shakai_button = (Button)findViewById(R.id.shakai_button);
        rika_button = (Button)findViewById(R.id.rika_button);
        eigo_button = (Button)findViewById(R.id.eigo_button);
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
            kokugo_checkbox.setChecked(true);
            sugaku_checkbox.setChecked(true);
            shakai_checkbox.setChecked(true);
            rika_checkbox.setChecked(true);
            eigo_checkbox.setChecked(true);

//            本番環境ループ
//            分野の中のチェックボックス
            che_kok1.setChecked(true);
            che_kok2.setChecked(true);
            che_kok3.setChecked(true);
            che_kok4.setChecked(true);
            che_kok5.setChecked(true);
            che_kok6.setChecked(true);
            che_sug1.setChecked(true);
            che_sug2.setChecked(true);
            che_sug3.setChecked(true);
            che_sha1.setChecked(true);
            che_sha2.setChecked(true);
            che_sha3.setChecked(true);
            che_rik1.setChecked(true);
            che_rik2.setChecked(true);
            che_rik3.setChecked(true);
            che_eig1.setChecked(true);
            che_eig2.setChecked(true);
            che_eig3.setChecked(true);


        }else{
//            全てチェックを外す
            kokugo_checkbox.setChecked(false);
            sugaku_checkbox.setChecked(false);
            shakai_checkbox.setChecked(false);
            rika_checkbox.setChecked(false);
            eigo_checkbox.setChecked(false);

            //            本番環境ループ
//            分野の中のチェックボックスを外す
            che_kok1.setChecked(false);
            che_kok2.setChecked(false);
            che_kok3.setChecked(false);
            che_kok4.setChecked(false);
            che_kok5.setChecked(false);
            che_kok6.setChecked(false);
            che_sug1.setChecked(false);
            che_sug2.setChecked(false);
            che_sug3.setChecked(false);
            che_sha1.setChecked(false);
            che_sha2.setChecked(false);
            che_sha3.setChecked(false);
            che_rik1.setChecked(false);
            che_rik2.setChecked(false);
            che_rik3.setChecked(false);
            che_eig1.setChecked(false);
            che_eig2.setChecked(false);
            che_eig3.setChecked(false);

        }
    }
    @SuppressLint("ResourceType")
    public void checkgroup(View v){
        CheckBox checkbox = (CheckBox) v;
        if (checkbox.isChecked()){
            switch (v.getId()){
                case R.id.kokugo_checkbox:
                    LinearLayout kokugolay= (LinearLayout) findViewById(R.id.group_kokugo);
                    int count1 = kokugolay.getChildCount();
                    for (int i = 0;i<count1;i++){
                        View m = kokugolay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(true);
                    }
                    break;
                case R.id.suugaku_cehckbox:
                    LinearLayout sugakulay= (LinearLayout) findViewById(R.id.group_sugaku);
                    int count2 = sugakulay.getChildCount();
                    for (int i = 0;i<count2;i++){
                        View m = sugakulay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(true);
                    }
                    break;
                case R.id.shakai_checkbox:
                    LinearLayout shakailay= (LinearLayout) findViewById(R.id.group_shakai);
                    int count3 = shakailay.getChildCount();
                    for (int i = 0;i<count3;i++){
                        View m = shakailay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(true);
                    }
                    break;
                case R.id.rika_checkbox:
                    LinearLayout rikalay= (LinearLayout) findViewById(R.id.group_rika);
                    int count4 = rikalay.getChildCount();
                    for (int i = 0;i<count4;i++){
                        View m = rikalay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(true);
                    }
                    break;
                case R.id.eigo_checkbox:
                    LinearLayout eigolay= (LinearLayout) findViewById(R.id.group_eigo);
                    int count5 = eigolay.getChildCount();
                    for (int i = 0;i<count5;i++){
                        View m = eigolay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(true);
                    }
                    break;
            }
        }else{
            switch (v.getId()){
                case R.id.kokugo_checkbox:
                    LinearLayout kokugolay= (LinearLayout) findViewById(R.id.group_kokugo);
                    int count1 = kokugolay.getChildCount();
                    for (int i = 0;i<count1;i++){
                        View m = kokugolay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(false);
                    }
                    break;
                case R.id.suugaku_cehckbox:
                    LinearLayout sugakulay= (LinearLayout) findViewById(R.id.group_sugaku);
                    int count2 = sugakulay.getChildCount();
                    for (int i = 0;i<count2;i++){
                        View m = sugakulay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(false);
                    }
                    break;
                case R.id.shakai_checkbox:
                    LinearLayout shakailay= (LinearLayout) findViewById(R.id.group_shakai);
                    int count3 = shakailay.getChildCount();
                    for (int i = 0;i<count3;i++){
                        View m = shakailay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(false);
                    }
                    break;
                case R.id.rika_checkbox:
                    LinearLayout rikalay= (LinearLayout) findViewById(R.id.group_rika);
                    int count4 = rikalay.getChildCount();
                    for (int i = 0;i<count4;i++){
                        View m = rikalay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(false);
                    }
                    break;
                case R.id.eigo_checkbox:
                    LinearLayout eigolay= (LinearLayout) findViewById(R.id.group_eigo);
                    int count5 = eigolay.getChildCount();
                    for (int i = 0;i<count5;i++){
                        View m = eigolay.getChildAt(i);
                        CheckBox c =(CheckBox) findViewById(m.getId());
                        c.setChecked(false);
                    }
                    break;
            }
        }
    }

    public void uncheck1(View v){
        CheckBox checkbox = (CheckBox) v;
        if (checkbox.isChecked()){
            kokugo_count=kokugo_count+1;
        }else{
            kokugo_count=kokugo_count-1;
        }
        if(kokugo_count == 0){

            kokugo_checkbox.setChecked(true);
        }else{
            kokugo_checkbox.setChecked(false);
        }
    }
    public void uncheck2(View v){
        CheckBox checkbox = (CheckBox) v;
        if (checkbox.isChecked()){
            sugaku_count=sugaku_count+1;
        }else{
            sugaku_count=sugaku_count-1;
        }
        if(sugaku_count == 0){

            sugaku_checkbox.setChecked(true);
        }else{
            sugaku_checkbox.setChecked(false);
        }
    }
    public void uncheck3(View v){
        CheckBox checkbox = (CheckBox) v;
        if (checkbox.isChecked()){
            shakai_count=shakai_count+1;
        }else{
            shakai_count=shakai_count-1;
        }
        if(shakai_count == 0){

            shakai_checkbox.setChecked(true);
        }else{
            shakai_checkbox.setChecked(false);
        }
    }
    public void uncheck4(View v){
        CheckBox checkbox = (CheckBox) v;
        if (checkbox.isChecked()){
            rika_count=rika_count+1;
        }else{
            rika_count=rika_count-1;
        }
        if(rika_count == 0){

            rika_checkbox.setChecked(true);
        }else{
            rika_checkbox.setChecked(false);
        }
    }    public void uncheck5(View v){
        CheckBox checkbox = (CheckBox) v;
        if (checkbox.isChecked()){
            eigo_count=eigo_count+1;
        }else{
            eigo_count=eigo_count-1;
        }
        if(eigo_count == 0){

            eigo_checkbox.setChecked(true);
        }else{
            eigo_checkbox.setChecked(false);
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


    //    問題を解くボタン
    public void next_btnClick(View view){
        Intent intent = new Intent(MatchSelectQuestion.this, FastPress.class);
        startActivity(intent);
    }

    //    問題を解くボタン
    public void back_btnClick(View view){
        Intent intent = new Intent(MatchSelectQuestion.this, MainActivity.class);
        intent.putExtra("LOGIN", 1);
        startActivity(intent);
    }
}