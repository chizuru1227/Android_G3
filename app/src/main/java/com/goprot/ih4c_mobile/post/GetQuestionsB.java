package com.goprot.ih4c_mobile.post;

import com.goprot.ih4c_mobile.HttpRequest;
import com.goprot.ih4c_mobile.post_values.GetQuestionsBValues;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class GetQuestionsB {
    private static String GetQuestionsB = "";
    private static JSONArray BList = null;

    public static GetQuestionsBValues GetQuestionsB(
            String check_type, String grade_id, String school_id,
            String subject_id
    ) {
        Map<String, String> formdata = new HashMap<String, String>();
        formdata.put("act", "getQuestions");
        formdata.put("check_type", check_type);
        formdata.put("grade_id", grade_id);
        formdata.put("school_id", school_id);
        formdata.put("subject_id", subject_id);

        String response = "";
        try {
            response = HttpRequest.callPost(formdata);
            JSONObject rootJSON = new JSONObject(response);
            GetQuestionsB = rootJSON.getString("status");
            BList = rootJSON.getJSONArray("data");
            if(GetQuestionsB.equals("no")){
                GetQuestionsB = rootJSON.getString("message");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // CreateChoicesValuesオブジェクトの生成
        GetQuestionsBValues postResult = new GetQuestionsBValues(GetQuestionsB, BList);
        return postResult;
    }

}
