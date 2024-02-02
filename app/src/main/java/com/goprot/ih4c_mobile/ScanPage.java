package com.goprot.ih4c_mobile;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class ScanPage extends AppCompatActivity {
    //Scroll

    ScrollView sscroll;
    ScrollView skokugo;
    ScrollView ssugaku;
    ScrollView sshakai;
    ScrollView srika;
    ScrollView seigo;
    String kamoku="";
    String namebunya="";


    Dialog popup;
    SQLiteDatabase db ;
    String unit_btn_text = "";
    String subject_btn_text = "";

    String kamoku_id = "";
    String unit_id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_page);

        //データベースから分野取得
        String dbStr = "data/data/" + getPackageName()+"/unit_db.db";
        db = SQLiteDatabase.openOrCreateDatabase(dbStr,null);

        //      ポップアップ画面
        popup = new Dialog(this);
        popup.setContentView(R.layout.scanpagepopup);




    }

    private void readAllBunya( String bunya, String idname ,int Layout) {
        //入れるレイアウト
        LinearLayout row = findViewById(Layout);
        //レコード検索(SELECT)
        String query_select = "SELECT * FROM UNIT_TBL where subject_id = ?";
        //DB検索実行
        Cursor db_row = db.rawQuery(query_select,new String[]{bunya});
        //レコードを取り出しながらフィールドデータ取得
        int id =0;
        while ( db_row.moveToNext()) {
            int unit_name_index = db_row.getColumnIndex("unit_name");
            int unit_kamoku_index = db_row.getColumnIndex("subject_id");
            int unit_id_index = db_row.getColumnIndex("unit_id");
            String unit_name= db_row.getString(unit_name_index);
            String kamoku_name= db_row.getString(unit_kamoku_index);
            String unit_id1= db_row.getString(unit_id_index);
            kamoku_id= kamoku_name;
            switch (kamoku_name){
                case "NL":
                    kamoku_name="国語";
                    break;
                case "MT":
                    kamoku_name="数学";
                    break;
                case "SS":
                    kamoku_name="社会";
                    break;
                case "SE":
                    kamoku_name="科学";
                    break;
                case "EL":
                    kamoku_name="英語";
                    break;
            }
            kamoku=kamoku_name;
            Button btnTag = new Button(this);
            btnTag.setText(unit_name);
            btnTag.setId(id);
            btnTag.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    namebunya = unit_name;
                    popup(v,kamoku,namebunya,unit_id1);
                }
            });
            row.addView(btnTag);


        }
    }

    //分析ボタンクリックしたら詳細分析表示
    public void scanbuttongroup(View view){
        skokugo = findViewById(R.id.scan_kokugo);
        ssugaku = findViewById(R.id.scan_sugaku);
        sshakai = findViewById(R.id.scan_shakai);
        srika = findViewById(R.id.scan_rika);
        seigo = findViewById(R.id.scan_eigo);
        switch (view.getId()){
            case R.id.scan_kokugo_button:
                subject_btn_text = "国語";
                sscroll = findViewById(R.id.scan_kokugo);
                if (sscroll.getVisibility() == View.VISIBLE){
//                    元の位置に戻る
                    sscroll.setVisibility(View.GONE);
                }else {
                    readAllBunya("NL","kokugo",R.id.scangroup_kokugo);
                    sscroll.setVisibility(View.VISIBLE);
                    ssugaku.setVisibility(View.GONE);
                    sshakai.setVisibility(View.GONE);
                    srika.setVisibility(View.GONE);
                    seigo.setVisibility(View.GONE);
                }
                break;

            case R.id.scan_sugaku_button:
                subject_btn_text = "数学";
                sscroll = findViewById(R.id.scan_sugaku);
                if (sscroll.getVisibility() == View.VISIBLE){
//                    元の位置に戻る
                    sscroll.setVisibility(View.GONE);
                }else {
                    readAllBunya("MT","sugaku",R.id.scangroup_sugaku);
                    sscroll.setVisibility(View.VISIBLE);
                    skokugo.setVisibility(View.GONE);
                    sshakai.setVisibility(View.GONE);
                    srika.setVisibility(View.GONE);
                    seigo.setVisibility(View.GONE);
                }
                break;

            case R.id.scan_shakai_button:
                subject_btn_text = "社会";
                sscroll = findViewById(R.id.scan_shakai);
                if (sscroll.getVisibility() == View.VISIBLE){
//                    元の位置に戻る
                    sscroll.setVisibility(View.GONE);
                }else {
                    readAllBunya("SS","shakai",R.id.scangroup_shakai);
                    sscroll.setVisibility(View.VISIBLE);
                    skokugo.setVisibility(View.GONE);
                    ssugaku.setVisibility(View.GONE);
                    srika.setVisibility(View.GONE);
                    seigo.setVisibility(View.GONE);
                }
                break;

            case R.id.scan_rika_button:
                subject_btn_text = "理科";
                sscroll= findViewById(R.id.scan_rika);
                if (sscroll.getVisibility() == View.VISIBLE){
//                    元の位置に戻る
                    sscroll.setVisibility(View.GONE);
                }else {
                    readAllBunya("SE","rika",R.id.scangroup_rika);
                    sscroll.setVisibility(View.VISIBLE);
                    skokugo.setVisibility(View.GONE);
                    ssugaku.setVisibility(View.GONE);
                    sshakai.setVisibility(View.GONE);
                    seigo.setVisibility(View.GONE);
                }
                break;

            case R.id.scan_eigo_button:
                subject_btn_text = "英語";
                sscroll = findViewById(R.id.scan_eigo);
                if (sscroll.getVisibility() == View.VISIBLE){
//                    元の位置に戻る
                    sscroll.setVisibility(View.GONE);
                }else {
                    readAllBunya("EL","eigo",R.id.scangroup_eigo);
                    sscroll.setVisibility(View.VISIBLE);
                    skokugo.setVisibility(View.GONE);
                    ssugaku.setVisibility(View.GONE);
                    sshakai.setVisibility(View.GONE);
                    srika.setVisibility(View.GONE);
                }
                break;
        }
    }
    public void popup(View v,String kamokuName,String bunyaName, String bunya_id){
        Button b = (Button)v;
        unit_btn_text = b.getText().toString();
        popup.show();
        //        科目名、分野を表示させたい
        TextView popup_kamoku = popup.findViewById(R.id.popup_kamoku);
        TextView popup_bunya = popup.findViewById(R.id.popup_bunya);
        unit_id = bunya_id;
        popup_kamoku.setText(kamokuName);
        popup_bunya.setText(bunyaName);



        ImageButton close_popup = findViewById(R.id.closepopup);
//                close_popup.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        popup.cancel();
//                    }
//                });
    }

    //    xボタン
    public void cancel_btnClick(View view){
        popup.cancel();
    }

    ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {

                    Intent data  = result.getData();
                    if(data != null) {
                        Bitmap bitmap;
                        // cancelしたケースも含む
                        if (data.getExtras() == null) {

                            Log.d("debug", "cancel ?");
                            return;
                        } else {
                            bitmap = (Bitmap) data.getExtras().get("data");
                            if (bitmap != null) {
                                // 画像サイズを計測
                                int bmpWidth = bitmap.getWidth();
                                int bmpHeight = bitmap.getHeight();
                                Log.d("debug", String.format("w= %d", bmpWidth));
                                Log.d("debug", String.format("h= %d", bmpHeight));
                            }
                        }

                        //遷移
                        Intent intent = new Intent(ScanPage.this, ScanCheck.class);
                        intent.putExtra("IMG",bitmap);
                        //            科目ID、分野ID送信
                        intent.putExtra("SUB", kamoku_id);
                        intent.putExtra("UNIT", unit_id);
                        startActivity(intent);
//                        imageView.setImageBitmap(bitmap);
                    }

                }
            });

    //    スキャンするボタン
    public void scan_btnClick(View view){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            resultLauncher.launch(intent);
    }


    //    戻るボタン
    public void back_btnClick(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}
