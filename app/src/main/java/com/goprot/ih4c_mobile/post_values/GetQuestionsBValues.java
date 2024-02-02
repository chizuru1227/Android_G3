package com.goprot.ih4c_mobile.post_values;

import org.json.JSONArray;

public class GetQuestionsBValues {
    public String getQuestionsB; // post結果
    public JSONArray BList;  //

    // コンストラクタ
    public GetQuestionsBValues(String getQuestionsB, JSONArray getQuestionsBList) {
        this.getQuestionsB = getQuestionsB;
        this.BList = getQuestionsBList;
    }
}