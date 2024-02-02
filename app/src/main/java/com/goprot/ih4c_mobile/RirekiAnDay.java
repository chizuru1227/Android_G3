package com.goprot.ih4c_mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//public class RirekiAnDay extends AppCompatActivity {
public class RirekiAnDay extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    List<RecycleDataDay> dataday = new ArrayList<RecycleDataDay>();

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.rirekianday);
//        fillData();
//
//        recyclerView = findViewById(R.id.recyclereview);
//        layoutManager=new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        mAdapter = new MyRecycleAdapterDay(dataday, RirekiAnDay.this);
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
        mAdapter = new MyRecycleAdapterDay(dataday,getContext());
        recyclerView.setAdapter(mAdapter);
    }

    private void fillData() {
        RecycleDataDay d1 = new RecycleDataDay(0, "20XX", "00問中00問正解");
        RecycleDataDay d2 = new RecycleDataDay(1, "20XX", "00問中00問正解");
        RecycleDataDay d3 = new RecycleDataDay(2, "20XX", "00問中00問正解");
        RecycleDataDay d4 = new RecycleDataDay(3, "20XX", "00問中00問正解");
        RecycleDataDay d5 = new RecycleDataDay(4, "20XX", "00問中00問正解");
        RecycleDataDay d6 = new RecycleDataDay(5, "20XX", "00問中00問正解");
        dataday.addAll(Arrays.asList(new RecycleDataDay[]{d1, d2, d3, d4, d5, d6}));
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
//public class RirekiAnDay extends AppCompatActivity {
//    private RecyclerView recyclerView;
//    private RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager layoutManager;
//    List<RecycleDataDay> dataday = new ArrayList<RecycleDataDay>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.rirekianday);
//        fillData();
//
//        recyclerView = findViewById(R.id.recyclereview);
//        layoutManager=new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        mAdapter = new MyRecycleAdapterDay(dataday, RirekiAnDay.this);
//        recyclerView.setAdapter(mAdapter);
//    }
//
//    private void fillData() {
//        RecycleDataDay d1 = new RecycleDataDay(0,"20XX","00問中00問正解");
//        RecycleDataDay d2 = new RecycleDataDay(1,"20XX","00問中00問正解");
//        RecycleDataDay d3 = new RecycleDataDay(2,"20XX","00問中00問正解");
//        RecycleDataDay d4 = new RecycleDataDay(3,"20XX","00問中00問正解");
//        RecycleDataDay d5 = new RecycleDataDay(4,"20XX","00問中00問正解");
//        RecycleDataDay d6 = new RecycleDataDay(5,"20XX","00問中00問正解");
//        dataday.addAll(Arrays.asList(new RecycleDataDay[]{d1,d2,d3,d4,d5,d6}));
//    }
//
}
