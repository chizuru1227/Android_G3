package com.goprot.ih4c_mobile.post;

import android.util.Log;

import com.goprot.ih4c_mobile.HttpRequest;
import com.goprot.ih4c_mobile.post_values.CreateChoicesValues;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CreateChoices {
    private static String createChoices = "";
    private static String choices_1 = "";
    private static String choices_2 = "";
    private static String choices_3 = "";
    public static CreateChoicesValues PostCreateChoices(String answer) {
        Map<String, String> formdata = new HashMap<String, String>();
        formdata.put("act", "createChoices");
        formdata.put("answer", answer);
//        formdata.put("answer", "新宿");
        String response = "";
        try {
            response = HttpRequest.callPost(formdata);
            JSONObject rootJSON = new JSONObject(response);
//            createChoices = rootJSON.getString("status");
            choices_1 = rootJSON.getString("choices_1");
            choices_2 = rootJSON.getString("choices_2");
            choices_3 = rootJSON.getString("choices_3");
            if(createChoices.equals("no")){
                createChoices = rootJSON.getString("message");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // CreateChoicesValuesオブジェクトの生成
        CreateChoicesValues postResult = new CreateChoicesValues(createChoices,choices_1,choices_2,choices_3);
        return postResult;
    }

}
