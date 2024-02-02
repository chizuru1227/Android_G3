package com.goprot.ih4c_mobile;


import androidx.annotation.NonNull;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Fragment_home extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = (View) inflater.inflate(R.layout.home, container, false);

        // フラグメントのレイアウトをインフレート
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //IDからオブジェクトを取得
        LinearLayout lay_stamp  = (LinearLayout) view.findViewById(R.id.btn_stamp);
        LinearLayout lay_graph  = (LinearLayout) view.findViewById(R.id.btn_graph);
        LinearLayout lay_study  = (LinearLayout) view.findViewById(R.id.btn_study);
        LinearLayout lay_timer  = (LinearLayout) view.findViewById(R.id.btn_timer);

        //リスナーを登録
        //スタンプを押した場合
        lay_stamp.setOnClickListener(v -> {
            FragmentManager fragmentManager = getFragmentManager();
            if(fragmentManager != null) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.fragmentContainerView, Fragment_stamp.class,null);
                fragmentTransaction.commit();
            }
        });
        //分析を押した場合
//        lay_graph.setOnClickListener(v -> {
//            FragmentManager fragmentManager = getFragmentManager();
//            if(fragmentManager != null) {
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                fragmentTransaction.replace(R.id.fragmentContainerView, Fragment_analysis.class,null);
//                fragmentTransaction.commit();
//            }
//        });
        //問題を解くを押した場合
        lay_study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QuestionCreatePage.class);
                startActivity(intent);
//                Intent intent = new Intent(getActivity(), Test.class);
//                startActivity(intent);
            }
        });
//        //早押しを押した場合
//        lay_timer.setOnClickListener(v -> {
//            FragmentManager fragmentManager = getFragmentManager();
//            if(fragmentManager != null) {
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                fragmentTransaction.replace(R.id.fragmentContainerView, Fragment_match_menu.class,null);
//                fragmentTransaction.commit();
//        //早押し問題に遷移
//        //lay_timer.setOnClickListener(new View.OnClickListener() {
//        //  @Override
//        //  public void onClick(View v) {
//        //      Intent intent = new Intent(getActivity(), FastPress.class);
//        //      startActivity(intent);
//            }
//        });
    }
}