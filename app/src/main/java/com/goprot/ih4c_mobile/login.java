package com.goprot.ih4c_mobile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.goprot.ih4c_mobile.DataBase.CreateDataBase;
import com.goprot.ih4c_mobile.post.UserLogin;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;


public class login extends AppCompatActivity {
    private Handler handler;
    private EditText login_name;
    private EditText login_password;
    private String postresult;
    private String SchoolID;
    private String IconId;
    private String result;
    private TextView test;
    SharedPreferences login_data;
    boolean hasLoggedIn ;
    String error;
    int errorcnt=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //reset login
//        login_data = getSharedPreferences("Login",MODE_PRIVATE);
//        SharedPreferences.Editor Ed=login_data.edit();
//        Ed.putString("username",null);
//        Ed.putString("password",null);
//        Ed.putInt("status",0);
//        Ed.commit();
        String dbStr = "data/data/" + getPackageName()+"/unit_db.db";
        CreateDataBase.CreateDB(dbStr);
        if (hasLoggedIn == true){
            test();
        }else{

            setContentView(R.layout.login);
        }
        View decor = getWindow().getDecorView();
        // hide navigation bar, hide status bar. don't show navigation when tapped.
        decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        login_name=findViewById(R.id.loginName);
        login_password=findViewById(R.id.loginPassword);
        test = findViewById(R.id.text1);
        handler = new Handler();


    }
    public void login(View view){
        //空白処理
        if (login_name.getText().toString().equals("")){
            error="名前が空白です";
            errorcnt++;
        }
        if(login_password.getText().toString().equals("")){
            error="パスワードが空白です";
            errorcnt++;
        }
        //エラー処理
       switch (errorcnt){
            //一か所だけならエラーメッセージを表示
           case 1:
               test.setText(error);
               break;
           //2か所なら下のエラーメッセージを表示
           case 2:
               test.setText("名前とパスワードが空白です");
               break;
           //エラーなかったらログイン処理を始める
           case 0:
               //Postクラスを開始
               Thread thread = new Thread(new Runnable() {
                   @Override
                   public void run() {
                       //Postクラスを呼び出し
                       postresult = UserLogin.LoginUser(login_name.getText().toString(),login_password.getText().toString());
                       //もらった返事を処理
                       handler.post(new Runnable() {
                           @Override
                           public void run() {
                               result= postresult;
                               JSONObject rootJSON = null;
                               try {
                                   rootJSON = new JSONObject(result);
                                   postresult= rootJSON.getString("status");
                                   if(postresult.equals("no")){
                                       postresult = rootJSON.getString("message");
                                   }
                                   SchoolID = rootJSON.getString("school_id");
                                   IconId = rootJSON.getString("student_icon");
                               } catch (JSONException e) {
                                   e.printStackTrace();
                               }
                               //返事OKの場合はそのままログイン
                               if (postresult.equals("ok")){
                                   //ログインデータをローカルで保存
                                   saveLoginStatus(login_name.getText().toString(),login_password.getText().toString(),SchoolID,IconId);
                                   //MainActivityを展開
                                   test();
                                   //ログインができたフラッグ
                                   hasLoggedIn = true;
                               }else{
                                   test.setText(postresult);
                               }
                           }
                       });
                   }
               });
               thread.start();
               break;
       }
        errorcnt=0;
    }
    //ローカルでログインデータを保存
    private void saveLoginStatus(String username,String pass,String school_id,String student_icon){
        login_data = getSharedPreferences("Login",MODE_PRIVATE);
        SharedPreferences.Editor Ed=login_data.edit();
        Ed.putString("username",username);
        Ed.putString("password",pass);
        Ed.putString("school_id",school_id);
        Ed.putString("usericon", student_icon);
        Ed.putInt("status",1);
        Ed.commit();
    }
    //MainActivityを展開
    private void test(){

            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
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


}
