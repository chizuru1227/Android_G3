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

public class FastPress_answer extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // フラグメントのレイアウトをインフレート
        return inflater.inflate(R.layout.fastpress_answer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //IDからオブジェクトを取得
        Button answer  = (Button) view.findViewById(R.id.btn_answer);
        ImageView img_answer = (ImageView) view.findViewById(R.id.img_answer);
        TextView text_answer = (TextView) view.findViewById(R.id.text_answer);
        TextView text_answer1 = (TextView) view.findViewById(R.id.text_answer1);
        TextView text_answer2 = (TextView) view.findViewById(R.id.text_answer2);

        //string.xmlから文字列取得
        String incorrect_text = getString(R.string.incorrect_text);
        String correct_text = getString(R.string.correct_text);

        //FastPress_questionからの値の受け取り
        Integer test = getArguments().getInt("INT_ANSWER");

        if (test==0){
            img_answer.setImageResource(R.drawable.incorrect);
            text_answer.setText(incorrect_text);
            text_answer.setTextColor(Color.parseColor("#4682B4"));
            text_answer1.setText("次の問題まで");
            text_answer2.setText("〇秒");
        }else if (test==1){
            img_answer.setImageResource(R.drawable.correct);
            text_answer.setText(correct_text);
            text_answer.setTextColor(Color.parseColor("#B22222"));
            text_answer1.setText("正解者が出るまで");
            text_answer2.setText("待ってください");
        }

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