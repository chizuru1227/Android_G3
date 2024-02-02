package com.goprot.ih4c_mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.List;
import java.util.Map;

public class FastPress_result extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // フラグメントのレイアウトをインフレート
        return inflater.inflate(R.layout.fastpress_result, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Map<String, String>> androidVersionList = FastPress_answer_result.getData();

        SimpleAdapter answer_result = new SimpleAdapter(
                getActivity(),
                androidVersionList,
                R.layout.fastpress_answer_result,
                new String[]{"question","subject","field","answer"},
                new int[]{R.id.question_text,R.id.subject_text,R.id.field_text,R.id.answer_text}
        );

        ListView listView = (ListView) view.findViewById(R.id.fastpress_answer_result);

        listView.setAdapter(answer_result);

        //IDからオブジェクトを取得
        Button announcement  = (Button) view.findViewById(R.id.btn_announcement);

        //リスナーを登録
        //回答を押した場合
        announcement.setOnClickListener(v -> {
            FragmentManager fragmentManager = getFragmentManager();
            if(fragmentManager != null) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.fragmentContainerView4, FastPress_announcement.class,null);
                fragmentTransaction.commit();
            }
        });
    }
}