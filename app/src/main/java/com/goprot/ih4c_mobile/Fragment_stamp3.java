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

public class Fragment_stamp3 extends Fragment {
    //レイアウトからボタンオブジェクトをそれぞれ取得
    ImageView stamp13;
    ImageView stamp14;
    ImageView stamp15;
    ImageView left;
    ImageView right;

    int flag01=0;
    int flag02=0;
    int flag03=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // フラグメントのレイアウトをインフレート
        return inflater.inflate(R.layout.stamp3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//レイアウトからボタンオブジェクトをそれぞれ取得
        stamp13 = view.findViewById(R.id.stamp13);
        stamp14 = view.findViewById(R.id.stamp14);
        stamp15 = view.findViewById(R.id.stamp15);
        left = view.findViewById(R.id.left_stamp);
        right = view.findViewById(R.id.right_stamp);

        //ボタンオブジェクトににリスナをそれぞれ設定
        stamp13.setOnClickListener(new Fragment_stamp3.ButtonClickListener());
        stamp14.setOnClickListener(new Fragment_stamp3.ButtonClickListener());
        stamp15.setOnClickListener(new Fragment_stamp3.ButtonClickListener());
        left.setOnClickListener( new Fragment_stamp3.ButtonClickListener());
        right.setOnClickListener( new Fragment_stamp3.ButtonClickListener());
    }



    //ボタンを押したときの動作を定義するリスナクラス
    private class ButtonClickListener implements View.OnClickListener {
        //ボタンを押したときの動作定義
        @Override
        public void onClick(View view) {
            //ボタンのIDによって条件分岐
            switch (view.getId()) {
                case R.id.stamp13:
                    if(flag01==0){
                        Drawable stamp_click= ResourcesCompat.getDrawable(getResources(), R.drawable.stamp_border, null);
                        stamp13.setBackground(stamp_click);
                        Drawable stamp = getResources().getDrawable(R.drawable.questioncreate1);
                        stamp13.setImageDrawable(stamp);
                        flag01 = 1;
                    }else {
                        Drawable stamp = getResources().getDrawable(R.drawable.stamp_borderoff);
                        stamp13.setImageDrawable(stamp);
                        flag01 = 0;
                    }

                    break;
                case R.id.stamp14:
                    if(flag02==0){
                        Drawable stamp_click= ResourcesCompat.getDrawable(getResources(), R.drawable.stamp_border, null);
                        stamp14.setBackground(stamp_click);
                        Drawable stamp = getResources().getDrawable(R.drawable.questioncreate10);
                        stamp14.setImageDrawable(stamp);
                        flag02 = 1;
                    }else {
                        Drawable stamp = getResources().getDrawable(R.drawable.stamp_borderoff);
                        stamp14.setImageDrawable(stamp);
                        flag02 = 0;
                    }
                    break;
                case R.id.stamp15:
                    if(flag03==0){
                        Drawable stamp_click= ResourcesCompat.getDrawable(getResources(), R.drawable.stamp_border, null);
                        stamp15.setBackground(stamp_click);
                        Drawable stamp = getResources().getDrawable(R.drawable.questioncreate50);
                        stamp15.setImageDrawable(stamp);
                        flag03 = 1;
                    }else {
                        Drawable stamp = getResources().getDrawable(R.drawable.stamp_borderoff);
                        stamp15.setImageDrawable(stamp);
                        flag03 = 0;
                    }
                    break;

                case R.id.left_stamp:
                    FragmentManager fragmentManager = getFragmentManager();
                    if(fragmentManager != null) {
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        fragmentTransaction.replace(R.id.fragmentContainerView, Fragment_stamp2.class,null);
                        fragmentTransaction.commit();
                    }

                    break;
                case R.id.right_stamp:
                    FragmentManager fragmentManager2 = getFragmentManager();
                    if(fragmentManager2 != null) {
                        FragmentTransaction fragmentTransaction = fragmentManager2.beginTransaction();

                        fragmentTransaction.replace(R.id.fragmentContainerView, Fragment_stamp.class,null);
                        fragmentTransaction.commit();
                    }

                    break;


                default:
                    break;
            }
        }
    }
}