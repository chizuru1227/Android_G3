package com.goprot.ih4c_mobile;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Fragment_stamp2 extends Fragment {
    //レイアウトからボタンオブジェクトをそれぞれ取得
    ImageView stamp07;
    ImageView stamp08;
    ImageView stamp09;
    ImageView stamp10;
    ImageView stamp11;
    ImageView stamp12;
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
        return inflater.inflate(R.layout.stamp2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//レイアウトからボタンオブジェクトをそれぞれ取得
        stamp07 = view.findViewById(R.id.stamp07);
        stamp08 = view.findViewById(R.id.stamp08);
        stamp09 = view.findViewById(R.id.stamp09);
        stamp10 = view.findViewById(R.id.stamp10);
        stamp11 = view.findViewById(R.id.stamp11);
        stamp12 = view.findViewById(R.id.stamp12);
        left = view.findViewById(R.id.left_stamp);
        right = view.findViewById(R.id.right_stamp);

        //ボタンオブジェクトににリスナをそれぞれ設定
        stamp07.setOnClickListener(new Fragment_stamp2.ButtonClickListener());
        stamp08.setOnClickListener(new Fragment_stamp2.ButtonClickListener());
        stamp09.setOnClickListener(new Fragment_stamp2.ButtonClickListener());
        stamp10.setOnClickListener(new Fragment_stamp2.ButtonClickListener());
        stamp11.setOnClickListener(new Fragment_stamp2.ButtonClickListener());
        stamp12.setOnClickListener(new Fragment_stamp2.ButtonClickListener());
        left.setOnClickListener( new Fragment_stamp2.ButtonClickListener());
        right.setOnClickListener( new Fragment_stamp2.ButtonClickListener());
    }



    //ボタンを押したときの動作を定義するリスナクラス
    private class ButtonClickListener implements View.OnClickListener {
        //ボタンを押したときの動作定義
        @Override
        public void onClick(View view) {
            //ボタンのIDによって条件分岐
            switch (view.getId()) {
                case R.id.stamp07:
                    if(flag01==0){
                        Drawable stamp_click= ResourcesCompat.getDrawable(getResources(), R.drawable.stamp_border, null);
                        stamp07.setBackground(stamp_click);
                        Drawable stamp = getResources().getDrawable(R.drawable.questioncreate1);
                        stamp07.setImageDrawable(stamp);
                        flag01 = 1;
                    }else {
                        Drawable stamp = getResources().getDrawable(R.drawable.stamp_borderoff);
                        stamp07.setImageDrawable(stamp);
                        flag01 = 0;
                    }

                    break;
                case R.id.stamp08:
                    if(flag02==0){
                        Drawable stamp_click= ResourcesCompat.getDrawable(getResources(), R.drawable.stamp_border, null);
                        stamp08.setBackground(stamp_click);
                        Drawable stamp = getResources().getDrawable(R.drawable.questioncreate10);
                        stamp08.setImageDrawable(stamp);
                        flag02 = 1;
                    }else {
                        Drawable stamp = getResources().getDrawable(R.drawable.stamp_borderoff);
                        stamp08.setImageDrawable(stamp);
                        flag02 = 0;
                    }
                    break;
                case R.id.stamp09:
                    if(flag03==0){
                        Drawable stamp_click= ResourcesCompat.getDrawable(getResources(), R.drawable.stamp_border, null);
                        stamp09.setBackground(stamp_click);
                        Drawable stamp = getResources().getDrawable(R.drawable.questioncreate50);
                        stamp09.setImageDrawable(stamp);
                        flag03 = 1;
                    }else {
                        Drawable stamp = getResources().getDrawable(R.drawable.stamp_borderoff);
                        stamp09.setImageDrawable(stamp);
                        flag03 = 0;
                    }
                    break;
                case R.id.stamp10:
                    if(flag04==0){
                        Drawable stamp_click= ResourcesCompat.getDrawable(getResources(), R.drawable.stamp_border, null);
                        stamp10.setBackground(stamp_click);
                        Drawable stamp = getResources().getDrawable(R.drawable.clear50);
                        stamp10.setImageDrawable(stamp);
                        flag04 = 1;
                    }else {
                        Drawable stamp = getResources().getDrawable(R.drawable.stamp_borderoff);
                        stamp10.setImageDrawable(stamp);
                        flag04 = 0;
                    }
                    break;
                case R.id.stamp11:
                    if(flag05==0){
                        Drawable stamp_click= ResourcesCompat.getDrawable(getResources(), R.drawable.stamp_border, null);
                        stamp11.setBackground(stamp_click);
                        Drawable stamp = getResources().getDrawable(R.drawable.clear100);
                        stamp11.setImageDrawable(stamp);
                        flag05 = 1;
                    }else {
                        Drawable stamp = getResources().getDrawable(R.drawable.stamp_borderoff);
                        stamp11.setImageDrawable(stamp);
                        flag05 = 0;
                    }
                    break;
                case R.id.stamp12:
                    if(flag06==0){
                        Drawable stamp_click= ResourcesCompat.getDrawable(getResources(), R.drawable.stamp_border, null);
                        stamp12.setBackground(stamp_click);
                        Drawable stamp = getResources().getDrawable(R.drawable.clear500);
                        stamp12.setImageDrawable(stamp);
                        flag06 = 1;
                    }else {
                        Drawable stamp = getResources().getDrawable(R.drawable.stamp_borderoff);
                        stamp12.setImageDrawable(stamp);
                        flag06 = 0;
                    }
                    break;
                case R.id.left_stamp:
                    FragmentManager fragmentManager = getFragmentManager();
                    if(fragmentManager != null) {
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        fragmentTransaction.replace(R.id.fragmentContainerView, Fragment_stamp.class,null);
                        fragmentTransaction.commit();
                    }

                    break;
                case R.id.right_stamp:
                    FragmentManager fragmentManager2 = getFragmentManager();
                    if(fragmentManager2 != null) {
                        FragmentTransaction fragmentTransaction = fragmentManager2.beginTransaction();

                        fragmentTransaction.replace(R.id.fragmentContainerView, Fragment_stamp3.class,null);
                        fragmentTransaction.commit();
                    }

                    break;


                default:
                    break;
            }
        }
    }
}