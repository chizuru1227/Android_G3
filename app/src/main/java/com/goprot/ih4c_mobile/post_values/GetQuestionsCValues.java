package com.goprot.ih4c_mobile.post_values;

import org.json.JSONArray;

public class GetQuestionsCValues {
    public String getQuestionsC; // post結果
    public JSONArray CList;  //

    // コンストラクタ
    public GetQuestionsCValues(String getQuestionsC, JSONArray getQuestionsCList) {
        this.getQuestionsC = getQuestionsC;
        this.CList = getQuestionsCList;
    }
}