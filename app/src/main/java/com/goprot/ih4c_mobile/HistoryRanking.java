package com.goprot.ih4c_mobile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryRanking#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class HistoryRanking extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryRanking.
     */


    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<RecycleHistory> rank = new ArrayList<RecycleHistory>();

    // TODO: Rename and change types and number of parameters
    public static HistoryRanking newInstance(String param1, String param2) {
        HistoryRanking fragment = new HistoryRanking();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public HistoryRanking() {
        // Required empty public constructor
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.history_ranking, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fillData();

//        fillData();
//
        recyclerView = view.findViewById(R.id.recycleRank);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyRecycleAdapterRanking(rank, getContext());
        recyclerView.setAdapter(mAdapter);
    }

//package com.goprot.ih4c_mobile;
//
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class HistoryRanking extends AppCompatActivity {
//    private RecyclerView recyclerView;
//    private RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager layoutManager;
//    List<RecycleHistory> rank = new ArrayList<RecycleHistory>();
////    MyRecycleAdapter.OnItemClickListener listener;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.history_ranking);
//        fillData();
//
//        recyclerView = findViewById(R.id.recycleRank);
//        layoutManager=new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        mAdapter = new MyRecycleAdapterRanking(rank, HistoryRanking.this);
//        recyclerView.setAdapter(mAdapter);
//    }
//
    private void fillData() {
        RecycleHistory d1 = new RecycleHistory(0,"00","00",R.drawable.ranking_1);
        RecycleHistory d2 = new RecycleHistory(1,"10","00",R.drawable.ranking_2);
        RecycleHistory d3 = new RecycleHistory(2,"00","00",R.drawable.ranking_3);
        RecycleHistory d4 = new RecycleHistory(3,"00","00",R.drawable.ranking_4);
        RecycleHistory d5 = new RecycleHistory(4,"00","00",R.drawable.ranking_4);
        RecycleHistory d6 = new RecycleHistory(5,"00","00",R.drawable.ranking_4);
        rank.addAll(Arrays.asList(new RecycleHistory[]{d1,d2,d3,d4,d5,d6}));
    }

    private void datalist() {
    }
}