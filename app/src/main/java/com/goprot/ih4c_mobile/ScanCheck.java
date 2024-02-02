package com.goprot.ih4c_mobile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

public class ScanCheck extends AppCompatActivity {
    String encoded = null;
    String sub_id = "";
    String unit_id = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        sub_id = intent.getStringExtra("SUB");
        unit_id = intent.getStringExtra("UNIT");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scan_check);

        Bitmap img = null;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             img = (Bitmap) extras.get("IMG");

//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            img.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
//            byte[] byteArray = byteArrayOutputStream .toByteArray();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            img.compress(Bitmap.CompressFormat.JPEG,100,baos);
            byte[] b = baos.toByteArray();
            encoded = Base64.encodeToString(b, Base64.DEFAULT);

//            encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
            Log.i("Base64Data",encoded);

        }

        ImageView imageView = findViewById(R.id.image_view);
        imageView.setImageBitmap(img);
    }


    //    再スキャンボタン
    public void back_btnClick(View view) {
//        Intent intent = new Intent(ScanCheck.this, ScanPage.class);
//        startActivity(intent);
        finish();
    }

    //    問題を作成するボタン
    public void next_btnClick(View view) {
        Intent intent = new Intent(ScanCheck.this, QuestionSelect.class);
        intent.putExtra("BASE64", encoded);
        intent.putExtra("SUB", sub_id);
        intent.putExtra("UNIT", unit_id);
        startActivity(intent);
    }

}
