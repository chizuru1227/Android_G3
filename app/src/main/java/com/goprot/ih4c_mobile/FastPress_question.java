package com.goprot.ih4c_mobile;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FastPress_question extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // フラグメントのレイアウトをインフレート
        return inflater.inflate(R.layout.fastpress_question, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //IDからオブジェクトを取得
        LinearLayout lay_statement  = (LinearLayout) view.findViewById(R.id.statement);
        Button incorrect  = (Button) view.findViewById(R.id.btn_incorrect);
        Button correct  = (Button) view.findViewById(R.id.btn_correct);
        Button pass  = (Button) view.findViewById(R.id.btn_pass);
        Button answer  = (Button) view.findViewById(R.id.btn_answer);

        //リスナーを登録
        //不正解を押した場合
        incorrect.setOnClickListener(v -> {
            FragmentManager fragmentManager = getFragmentManager();
            if(fragmentManager != null) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Bundle bundle = new Bundle();
                bundle.putInt("INT_ANSWER", 0);

                fragmentTransaction.replace(R.id.fragmentContainerView3, FastPress_answer.class,bundle);
                fragmentTransaction.commit();
            }
        });
        //正解を押した場合
        correct.setOnClickListener(v -> {
            FragmentManager fragmentManager = getFragmentManager();
            if(fragmentManager != null) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Bundle bundle = new Bundle();
                bundle.putInt("INT_ANSWER", 1);

                fragmentTransaction.replace(R.id.fragmentContainerView3, FastPress_answer.class,bundle);
                fragmentTransaction.commit();
            }
        });
        //パスを押した場合
        pass.setOnClickListener(v -> {
            FragmentManager fragmentManager = getFragmentManager();
            if(fragmentManager != null) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.fragmentContainerView3, FastPress_pass.class,null);
                fragmentTransaction.commit();
            }
        });
        //回答を押した場合
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FastPress2_result.class);
                startActivity(intent);
            }
        });
    }
}