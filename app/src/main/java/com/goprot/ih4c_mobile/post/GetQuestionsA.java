package com.goprot.ih4c_mobile.post;

import com.goprot.ih4c_mobile.HttpRequest;
import com.goprot.ih4c_mobile.post_values.GetQuestionsAValues;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class GetQuestionsA {
    private static String GetQuestionsA = "";
    private static JSONArray AList = null;

    public static GetQuestionsAValues GetQuestionsA(
            String check_type, String grade_id, String school_id
    ) {
        Map<String, String> formdata = new HashMap<String, String>();
        formdata.put("act", "getQuestions");
        formdata.put("check_type", check_type);
        formdata.put("grade_id", grade_id);
        formdata.put("school_id", school_id);

        String response = "";
        try {
            response = HttpRequest.callPost(formdata);
            JSONObject rootJSON = new JSONObject(response);
            GetQuestionsA = rootJSON.getString("status");
            AList = rootJSON.getJSONArray("data");
            if(GetQuestionsA.equals("no")){
                GetQuestionsA = rootJSON.getString("message");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // CreateChoicesValuesオブジェクトの生成
        GetQuestionsAValues postResult = new GetQuestionsAValues(GetQuestionsA, AList);
        return postResult;
    }

}
