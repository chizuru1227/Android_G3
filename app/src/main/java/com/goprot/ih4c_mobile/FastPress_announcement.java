package com.goprot.ih4c_mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FastPress_announcement extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // フラグメントのレイアウトをインフレート
        return inflater.inflate(R.layout.fastpress_announcement, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //IDからオブジェクトを取得
        ImageView img_1st = (ImageView) view.findViewById(R.id.img_1st);
        ImageView answerer_icon_1st = (ImageView) view.findViewById(R.id.answerer_icon_1st);
        TextView answerer_name_1st = (TextView) view.findViewById(R.id.answerer_name_1st);

        ImageView img_2nd = (ImageView) view.findViewById(R.id.img_2nd);
        ImageView answerer_icon_2nd = (ImageView) view.findViewById(R.id.answerer_icon_2nd);
        TextView answerer_name_2nd = (TextView) view.findViewById(R.id.answerer_name_2nd);

        ImageView img_3rd = (ImageView) view.findViewById(R.id.img_3rd);
        ImageView answerer_icon_3rd = (ImageView) view.findViewById(R.id.answerer_icon_3rd);
        TextView answerer_name_3rd = (TextView) view.findViewById(R.id.answerer_name_3rd);

        ImageView img_4th = (ImageView) view.findViewById(R.id.img_4th);
        ImageView answerer_icon_4th = (ImageView) view.findViewById(R.id.answerer_icon_4th);
        TextView answerer_name_4th = (TextView) view.findViewById(R.id.answerer_name_4th);

        ImageView img_5th = (ImageView) view.findViewById(R.id.img_5th);
        ImageView answerer_icon_5th = (ImageView) view.findViewById(R.id.answerer_icon_5th);
        TextView answerer_name_5th = (TextView) view.findViewById(R.id.answerer_name_5th);

        img_1st.setImageResource(R.drawable.rank1);
        answerer_icon_1st.setImageResource(R.drawable.icon_user);
        answerer_name_1st.setText("アカウント名");

        img_2nd.setImageResource(R.drawable.rank2);
        answerer_icon_2nd.setImageResource(R.drawable.icon_user);
        answerer_name_2nd.setText("アカウント名");

        img_3rd.setImageResource(R.drawable.rank3);
        answerer_icon_3rd.setImageResource(R.drawable.icon_user);
        answerer_name_3rd.setText("アカウント名");

        img_4th.setImageResource(R.drawable.rank4);
        answerer_icon_4th.setImageResource(R.drawable.icon_user);
        answerer_name_4th.setText("アカウント名");

        img_5th.setImageResource(R.drawable.rank5);
        answerer_icon_5th.setImageResource(R.drawable.icon_user);
        answerer_name_5th.setText("アカウント名");

    }
}