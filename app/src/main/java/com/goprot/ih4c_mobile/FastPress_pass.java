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

public class FastPress_pass extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // フラグメントのレイアウトをインフレート
        return inflater.inflate(R.layout.fastpress_pass, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //IDからオブジェクトを取得
        Button answer  = (Button) view.findViewById(R.id.btn_answer);;
        ImageView answerer_icon = (ImageView) view.findViewById(R.id.answerer_icon);
        TextView answerer_name = (TextView) view.findViewById(R.id.answerer_name);
        TextView next_quiz = (TextView) view.findViewById(R.id.next_quiz);

        answerer_icon.setImageResource(R.drawable.icon_user);
        answerer_name.setText("アカウント名");
        next_quiz.setText("〇秒");

        //リスナーを登録
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