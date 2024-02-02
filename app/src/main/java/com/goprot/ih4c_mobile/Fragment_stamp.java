package com.goprot.ih4c_mobile;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Fragment_stamp extends Fragment {
    //レイアウトからボタンオブジェクトをそれぞれ取得
    ImageView stamp01;
    ImageView stamp02;
    ImageView stamp03;
    ImageView stamp04;
    ImageView stamp05;
    ImageView stamp06;
    ImageView left;
    ImageView right;

    int flag01=0;
    int flag02=0;
    int flag03=0;
    int flag04=0;
    int flag05=0;
    int flag06=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // フラグメントのレイアウトをインフレート
        return inflater.inflate(R.layout.stamp, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//レイアウトからボタンオブジェクトをそれぞれ取得
        stamp01 = view.findViewById(R.id.stamp01);
        stamp02 = view.findViewById(R.id.stamp02);
        stamp03 = view.findViewById(R.id.stamp03);
        stamp04 = view.findViewById(R.id.stamp04);
        stamp05 = view.findViewById(R.id.stamp05);
        stamp06 = view.findViewById(R.id.stamp06);
        left = view.findViewById(R.id.left_stamp);
        right = view.findViewById(R.id.right_stamp);

        //ボタンオブジェクトににリスナをそれぞれ設定
        stamp01.setOnClickListener(new Fragment_stamp.ButtonClickListener());
        stamp02.setOnClickListener(new Fragment_stamp.ButtonClickListener());
        stamp03.setOnClickListener(new Fragment_stamp.ButtonClickListener());
        stamp04.setOnClickListener(new Fragment_stamp.ButtonClickListener());
        stamp05.setOnClickListener(new Fragment_stamp.ButtonClickListener());
        stamp06.setOnClickListener(new Fragment_stamp.ButtonClickListener());
        left.setOnClickListener( new Fragment_stamp.ButtonClickListener());
        right.setOnClickListener( new Fragment_stamp.ButtonClickListener());
    }



    //ボタンを押したときの動作を定義するリスナクラス
    private class ButtonClickListener implements View.OnClickListener {
        //ボタンを押したときの動作定義
        @Override
        public void onClick(View view) {
            //ボタンのIDによって条件分岐
            switch (view.getId()) {
                case R.id.stamp01:
                    if(flag01==0){
                        Drawable stamp_click= ResourcesCompat.getDrawable(getResources(), R.drawable.stamp_border, null);
                        stamp01.setBackground(stamp_click);
                        Drawable stamp = getResources().getDrawable(R.drawable.questioncreate1);
                        stamp01.setImageDrawable(stamp);
                        flag01 = 1;
                    }else {
                        Drawable stamp = getResources().getDrawable(R.drawable.stamp_borderoff);
                        stamp01.setImageDrawable(stamp);
                        flag01 = 0;
                    }

                    break;
                case R.id.stamp02:
                    if(flag02==0){
                        Drawable stamp_click= ResourcesCompat.getDrawable(getResources(), R.drawable.stamp_border, null);
                        stamp02.setBackground(stamp_click);
                        Drawable stamp = getResources().getDrawable(R.drawable.questioncreate10);
                        stamp02.setImageDrawable(stamp);
                        flag02 = 1;
                    }else {
                        Drawable stamp = getResources().getDrawable(R.drawable.stamp_borderoff);
                        stamp02.setImageDrawable(stamp);
                        flag02 = 0;
                    }
                    break;
                case R.id.stamp03:
                    if(flag03==0){
                        Drawable stamp_click= ResourcesCompat.getDrawable(getResources(), R.drawable.stamp_border, null);
                        stamp03.setBackground(stamp_click);
                        Drawable stamp = getResources().getDrawable(R.drawable.questioncreate50);
                        stamp03.setImageDrawable(stamp);
                        flag03 = 1;
                    }else {
                        Drawable stamp = getResources().getDrawable(R.drawable.stamp_borderoff);
                        stamp03.setImageDrawable(stamp);
                        flag03 = 0;
                    }
                    break;
                case R.id.stamp04:
                    if(flag04==0){
                        Drawable stamp_click= ResourcesCompat.getDrawable(getResources(), R.drawable.stamp_border, null);
                        stamp04.setBackground(stamp_click);
                        Drawable stamp = getResources().getDrawable(R.drawable.clear50);
                        stamp04.setImageDrawable(stamp);
                        flag04 = 1;
                    }else {
                        Drawable stamp = getResources().getDrawable(R.drawable.stamp_borderoff);
                        stamp04.setImageDrawable(stamp);
                        flag04 = 0;
                    }
                    break;
                case R.id.stamp05:
                    if(flag05==0){
                        Drawable stamp_click= ResourcesCompat.getDrawable(getResources(), R.drawable.stamp_border, null);
                        stamp05.setBackground(stamp_click);
                        Drawable stamp = getResources().getDrawable(R.drawable.clear100);
                        stamp05.setImageDrawable(stamp);
                        flag05 = 1;
                    }else {
                        Drawable stamp = getResources().getDrawable(R.drawable.stamp_borderoff);
                        stamp05.setImageDrawable(stamp);
                        flag05 = 0;
                    }
                    break;
                case R.id.stamp06:
                    if(flag06==0){
                        Drawable stamp_click= ResourcesCompat.getDrawable(getResources(), R.drawable.stamp_border, null);
                        stamp06.setBackground(stamp_click);
                        Drawable stamp = getResources().getDrawable(R.drawable.clear500);
                        stamp06.setImageDrawable(stamp);
                        flag06 = 1;
                    }else {
                        Drawable stamp = getResources().getDrawable(R.drawable.stamp_borderoff);
                        stamp06.setImageDrawable(stamp);
                        flag06 = 0;
                    }
                    break;
                case R.id.left_stamp:
                    FragmentManager fragmentManager = getFragmentManager();
                    if(fragmentManager != null) {
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        fragmentTransaction.replace(R.id.fragmentContainerView, Fragment_stamp3.class,null);
                        fragmentTransaction.commit();
                    }

                    break;
                case R.id.right_stamp:
                    FragmentManager fragmentManager2 = getFragmentManager();
                    if(fragmentManager2 != null) {
                        FragmentTransaction fragmentTransaction = fragmentManager2.beginTransaction();

                        fragmentTransaction.replace(R.id.fragmentContainerView, Fragment_stamp2.class,null);
                        fragmentTransaction.commit();
                    }

                    break;


                default:
                    break;
            }
        }
    }
}