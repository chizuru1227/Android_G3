package com.goprot.ih4c_mobile;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.SimpleAdapter;
import androidx.fragment.app.ListFragment;
import java.util.ArrayList;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

public class Test_result extends ListFragment {


    String[] subject = {
//            "国語",
//            "国語",
//            "国語",
//            "算数",
//            "数学",
//            "理科",
//            "理科",
//            "社会",
//            "社会",
//            "社会",
    };

    String[] field = {
//            "羅生門",
//            "漢文",
//            "古文",
//            "掛け算",
//            "連立方程式",
//            "化学式",
//            "種子の発芽条件",
//            "飛鳥文化",
//            "世界の地名",
//            "戦国時代の武将",
    };

    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String,String>>();
    SimpleAdapter adapter;

    String kamoku = "";
    String kamoku_name = "";
    String bunya = "";
    String ans = "";
    SQLiteDatabase db ;
    String ans_icon = "×";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle args = getArguments();
        if (args != null) {
//            problem_id = args.getString("problem_id");
            kamoku = args.getString("Ka");
            if (kamoku.equals("NL")) {kamoku_name = "国語";}
            else if (kamoku.equals("MT")) {kamoku_name = "数学";}
            else if (kamoku.equals("SS")) {kamoku_name = "社会";}
            else if (kamoku.equals("SE")) {kamoku_name = "理科";}
            else if (kamoku.equals("EL")) {kamoku_name = "英語";}
            bunya = args.getString("Bu");

            //データベースから分野取得
            String dbStr = "data/data/" + this.getActivity().getPackageName()+"/unit_db.db";
            db = SQLiteDatabase.openOrCreateDatabase(dbStr,null);

            //レコード検索(SELECT)
            //科目、学年
            String query_select = "SELECT * FROM UNIT_TBL where  unit_id = ?";
            //DB検索実行
            Cursor db_row = db.rawQuery(query_select,new String[]{bunya});
            //レコードを取り出しながらフィールドデータ取得
            while ( db_row.moveToNext()) {
                int unit_name_index = db_row.getColumnIndex("unit_name");
                bunya = db_row.getString(unit_name_index);
////                    ループ終了
            }

            ans = args.getString("An");
            if(ans == "1"){
                ans_icon = "〇";
            }
        }

        //MAP
        HashMap<String, String> map=new HashMap<String, String>();

        //string.xmlから文字列取得
        String incorrect_answer = getString(R.string.incorrect_answer);
        String correct_answer = getString(R.string.correct_answer);

        //FILL
//        for(int i=0;i<subject.length;i++) {
//            int n = i + 1;
            map = new HashMap<String, String>();
//            map.put("question", "第" + n + "問");
//            map.put("subject", subject[i]);
//            map.put("field", field[i]);
            map.put("question", "第" + 1 + "問");
            map.put("subject", kamoku_name);
            map.put("field", bunya);
//            if (n%2 == 0) {
//                map.put("answer", incorrect_answer);
//            }else {
//                map.put("answer", correct_answer);
//            }
                map.put("answer", ans_icon);
            data.add(map);
//        }

        //KEYS IN MAP
        String[] from={"question","subject","field","answer"};

        //IDS OF VIEWS
        int[] to={R.id.question_text,R.id.subject_text,R.id.field_text,R.id.answer_text};

        //ADAPTER
        adapter = new SimpleAdapter(getActivity(), data, R.layout.test_result, from, to);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}