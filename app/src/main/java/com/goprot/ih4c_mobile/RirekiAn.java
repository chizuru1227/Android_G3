package com.goprot.ih4c_mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//public class RirekiAn extends AppCompatActivity {
    public class RirekiAn extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<RecycleData> data = new ArrayList<RecycleData>();
//    MyRecycleAdapter.OnItemClickListener listener;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.rirekian);
//        fillData();
//
//        recyclerView = findViewById(R.id.recyclereview);
//        layoutManager=new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        mAdapter = new MyRecycleAdapter(data,RirekiAn.this);
//        recyclerView.setAdapter(mAdapter);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.rirekian, container, false);

        // フラグメントのレイアウトをインフレート
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fillData();

        recyclerView = view.findViewById(R.id.recyclereview);
        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MyRecycleAdapter(data,getContext());
        recyclerView.setAdapter(mAdapter);
    }

    private void fillData() {
        RecycleData d1 = new RecycleData(0,"学科1","分野1");
        RecycleData d2 = new RecycleData(1,"学科2","分野2");
        RecycleData d3 = new RecycleData(2,"学科3","分野3");
        RecycleData d4 = new RecycleData(3,"学科4","分野4");
        RecycleData d5 = new RecycleData(4,"学科5","分野5");
        RecycleData d6 = new RecycleData(5,"学科6","分野6");
        data.addAll(Arrays.asList(new RecycleData[]{d1,d2,d3,d4,d5,d6}));
    }

    private void datalist() {
    }
}
