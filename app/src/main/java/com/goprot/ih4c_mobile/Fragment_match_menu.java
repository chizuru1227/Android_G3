package com.goprot.ih4c_mobile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_match_menu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_match_menu extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_match_menu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_match_menu.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_match_menu newInstance(String param1, String param2) {
        Fragment_match_menu fragment = new Fragment_match_menu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.match_menu, container, false);
        // Inflate the layout for this fragment
        // フラグメントのレイアウトをインフレート
        return inflater.inflate(R.layout.match_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //IDからオブジェクトを取得
        LinearLayout lay_match_make  = (LinearLayout) view.findViewById(R.id.btn_match_make);
        LinearLayout lay_match_join  = (LinearLayout) view.findViewById(R.id.btn_match_join);

        //リスナーを登録
        //ルームを作成する
        lay_match_make.setOnClickListener(v -> {
            FragmentManager fragmentManager = getFragmentManager();
            if(fragmentManager != null) {
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                fragmentTransaction.replace(R.id.fragmentContainerView, Fragment_match_input.class,null);
//                fragmentTransaction.commit();

                FragmentTransaction ft = fragmentManager.beginTransaction();
                Fragment_match_input fragment = new Fragment_match_input();
                Bundle bundle = new Bundle();
                bundle.putInt("INT_KEY", 111);
                //値を書き込む
                fragment.setArguments(bundle);
                ft.replace(R.id.fragmentContainerView, fragment).commit();
            }
        });

        //ルームに参加する
        lay_match_join.setOnClickListener(v -> {
            FragmentManager fragmentManager = getFragmentManager();
            if(fragmentManager != null) {
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                fragmentTransaction.replace(R.id.fragmentContainerView, Fragment_match_input.class,null);
//                fragmentTransaction.commit();

                FragmentTransaction ft = fragmentManager.beginTransaction();
                Fragment_match_input fragment = new Fragment_match_input();
                Bundle bundle = new Bundle();
                bundle.putInt("INT_KEY", 222);
                //値を書き込む
                fragment.setArguments(bundle);
                ft.replace(R.id.fragmentContainerView, fragment).commit();
            }
        });

    }
}