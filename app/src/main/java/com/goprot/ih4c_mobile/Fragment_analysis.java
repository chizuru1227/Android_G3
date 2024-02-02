package com.goprot.ih4c_mobile;

import static com.github.mikephil.charting.utils.ColorTemplate.COLORFUL_COLORS;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_analysis#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_analysis extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // 選択肢
    private final String[] spinnerItems = {"Spinner", "Android", "Apple", "Windows"};

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_analysis() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_analysis.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_analysis newInstance(String param1, String param2) {
        Fragment_analysis fragment = new Fragment_analysis();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.analysis, container, false);
    }

    PieChart pieChart;
    LineChart lineChart;

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Spinner spin = (Spinner) view.findViewById(R.id.spinner);
        Spinner spin1 = (Spinner) view.findViewById(R.id.spinner1);
        Spinner spin2 = (Spinner) view.findViewById(R.id.spinner2);

        pieChart = view.findViewById(R.id.PieChart);
        lineChart = view.findViewById(R.id.linechart);
        loadPieChartData();
        loadLineChartData();


        // Spinnerのアイテムを選択時に行う処理
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // アイテムが選択された場合
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spin_p = (Spinner) parent;
                String item = (String) spin_p.getSelectedItem();
            }

            // 何も選択されなかった場合
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        // Spinnerのアイテムを選択時に行う処理
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // アイテムが選択された場合
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spin_p = (Spinner) parent;
                String item = (String) spin_p.getSelectedItem();
            }

            // 何も選択されなかった場合
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        // Spinnerのアイテムを選択時に行う処理
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // アイテムが選択された場合
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spin_p = (Spinner) parent;
                String item = (String) spin_p.getSelectedItem();
            }

            // 何も選択されなかった場合
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        //IDからオブジェクトを取得
        Button analysis_back_btn  = (Button) view.findViewById(R.id.analysis_back_btn);

        //問題を解くを押した場合
        analysis_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getFragmentManager();
                if(fragmentManager != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    fragmentTransaction.replace(R.id.fragmentContainerView, Fragment_home.class,null);
                    fragmentTransaction.commit();
                }
////        finish();
//        Intent intent = new Intent(getActivity(), MainActivity.class);
//        startActivity(intent);
//                    FragmentManager manager = getFragmentManager();
//                    FragmentTransaction transaction = manager.beginTransaction();
//                    transaction.addToBackStack("");
////        transaction.replace(R.id.container, Fragment_analysis.newInstance("myName"));
//                    transaction.commit();
            }
        });
    }
    private void loadPieChartData() {
        ArrayList<PieEntry> visitors = new ArrayList<>();
        visitors.add(new PieEntry(40, "正解"));
        visitors.add(new PieEntry(60, "不正解"));

        final int[] custom_color = {Color.rgb(0, 0, 255), Color.rgb(255, 0, 0)};
        ArrayList<Integer> Colors = new ArrayList<>();
        for (int c : custom_color) Colors.add(c);

        PieDataSet pieDataSet = new PieDataSet(visitors, "正答率");
        pieDataSet.setColors(Colors);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.getLegend().setEnabled(false);
        pieChart.animate();

    }

    private void loadLineChartData() {


        ArrayList<Entry> tensuu = new ArrayList<>();
//        Xは日付・時間 Yは点数
        tensuu.add(new Entry(0, 50));
        tensuu.add(new Entry(1, 30));
        tensuu.add(new Entry(2, 70));
        tensuu.add(new Entry(3, 40));
        tensuu.add(new Entry(4, 80));
        tensuu.add(new Entry(5, 10));
        LineDataSet set1 = new LineDataSet(tensuu, "点数");
//        set1.setDrawValues(false);
        set1.setValueTextSize(12f);
        set1.setFillAlpha(100);
//       右側のYを隠す
        YAxis rightYAxis = lineChart.getAxisRight();
        rightYAxis.setEnabled(false);
//      Yの最大数値設定
        YAxis yAxis = lineChart.getAxisLeft();
        yAxis.setAxisMaximum(100);
//      Xを下に移動
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//      Xの最大数値
        xAxis.setAxisMaximum(10);
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        LineData data = new LineData(dataSets);
//       説明off
        lineChart.getLegend().setEnabled(false);
        //zoom　off
        lineChart.setScaleEnabled(false);
//        詳細off
        lineChart.getDescription().setEnabled(false);
        lineChart.setData(data);
    }
}