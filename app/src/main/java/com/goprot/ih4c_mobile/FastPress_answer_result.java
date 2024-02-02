package com.goprot.ih4c_mobile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FastPress_answer_result {

    public static List<Map<String, String>> getData() {

        String[] subject = {
                "国語",
                "国語",
                "国語",
                "算数",
                "数学",
                "理科",
                "理科",
                "社会",
                "社会",
                "社会",
        };

        String[] field = {
                "羅生門",
                "漢文",
                "古文",
                "掛け算",
                "連立方程式",
                "化学式",
                "種子の発芽条件",
                "飛鳥文化",
                "世界の地名",
                "戦国時代の武将",
        };

        List<Map<String, String>> list = new ArrayList<>();

        for(int i=0;i<subject.length;i++) {
            int n = i + 1;
            Map<String, String> data = new HashMap<>();
            data.put("question", "問" + n );
            data.put("subject", subject[i]);
            data.put("field", field[i]);
            if (n%3 == 0) {
                data.put("answer", "〇");
            }else if (n%3 == 1){
                data.put("answer", "✕");
            }else{
                data.put("answer", "―");
            }
            list.add(data);
        }

        return list;
    }
}