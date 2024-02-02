package com.goprot.ih4c_mobile.post;

import com.goprot.ih4c_mobile.HttpRequest;
import com.goprot.ih4c_mobile.post_values.GetQuestionsCValues;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class GetQuestionsC {
    private static String GetQuestionsC = "";
    private static JSONArray CList = null;

    public static GetQuestionsCValues GetQuestionsC(
            String check_type, String school_id, String unit_id_1) {
        Map<String, String> formdata = new HashMap<String, String>();
        formdata.put("act", "getQuestions");
        formdata.put("check_type", check_type);
        formdata.put("school_id", school_id);
        formdata.put("unit_id_1", unit_id_1);

        String response = "";
        try {
            response = HttpRequest.callPost(formdata);
            JSONObject rootJSON = new JSONObject(response);
            GetQuestionsC = rootJSON.getString("status");
            CList = rootJSON.getJSONArray("data");
            if(GetQuestionsC.equals("no")){
                GetQuestionsC = rootJSON.getString("message");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // CreateChoicesValuesオブジェクトの生成
        GetQuestionsCValues postResult = new GetQuestionsCValues(GetQuestionsC,CList);
        return postResult;
    }

}
