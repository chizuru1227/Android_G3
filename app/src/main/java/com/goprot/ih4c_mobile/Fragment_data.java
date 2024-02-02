package com.goprot.ih4c_mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Fragment_data extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.data, container, false);

        // フラグメントのレイアウトをインフレート
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //IDからオブジェクトを取得
        LinearLayout lay_stamp = (LinearLayout) view.findViewById(R.id.btn_stamp);
        LinearLayout lay_data = (LinearLayout) view.findViewById(R.id.btn_data);
        LinearLayout lay_history = (LinearLayout) view.findViewById(R.id.btn_history);

        //リスナーを登録
        //スタンプを押した場合
        lay_stamp.setOnClickListener(v -> {
            FragmentManager fragmentManager = getFragmentManager();
            if (fragmentManager != null) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.fragmentContainerView, Fragment_stamp.class, null);
                fragmentTransaction.commit();
            }
        });
//        //分析を押した場合
//        lay_data.setOnClickListener(v -> {
//            FragmentManager fragmentManager = getFragmentManager();
//            if (fragmentManager != null) {
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                fragmentTransaction.replace(R.id.fragmentContainerView, Fragment_analysis.class, null);
//                fragmentTransaction.commit();
//            }
//        });
//        //履歴を押した場合
//        lay_history.setOnClickListener(v -> {
//            FragmentManager fragmentManager = getFragmentManager();
//            if (fragmentManager != null) {
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                fragmentTransaction.replace(R.id.fragmentContainerView, HistoryMenu.class, null);
//                fragmentTransaction.commit();
//            }
//        });
    }
}
