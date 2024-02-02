package com.goprot.ih4c_mobile;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_match_input#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_match_input extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int si = 0;

    public Fragment_match_input() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_match_input.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_match_input newInstance(String param1, String param2) {
        Fragment_match_input fragment = new Fragment_match_input();
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

        si = getArguments().getInt("INT_KEY");
        Log.i("MyFragment : ", "渡された値 = " + Integer.toString(si));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.match_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (si == 111) {
            ((Button)getView().findViewById(R.id.btn_loading)).setText("作成");
        } else if (si == 222) {
            ((Button)getView().findViewById(R.id.btn_loading)).setText("参加");
        }

        //IDからオブジェクトを取得
        ImageButton btn_back = (ImageButton) view.findViewById(R.id.btn_back);
        Button btn_loading = (Button) view.findViewById(R.id.btn_loading);

        //リスナーを登録
        btn_back.setOnClickListener(v -> {
            FragmentManager fragmentManager = getFragmentManager();
            if(fragmentManager != null) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.fragmentContainerView, Fragment_match_menu.class,null);
                fragmentTransaction.commit();
            }
        });

        btn_loading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), loading.class);
                intent.putExtra("INI_KEY", si);
                startActivity(intent);
            }
        });
    }
}