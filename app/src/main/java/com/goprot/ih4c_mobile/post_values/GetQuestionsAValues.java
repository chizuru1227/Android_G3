package com.goprot.ih4c_mobile.post_values;

import org.json.JSONArray;

public class GetQuestionsAValues {
    public String getQuestionsA; // post結果
    public JSONArray AList;  //

    // コンストラクタ
    public GetQuestionsAValues(String getQuestionsA, JSONArray getQuestionsAList) {
        this.getQuestionsA = getQuestionsA;
        this.AList = getQuestionsAList;
    }
}