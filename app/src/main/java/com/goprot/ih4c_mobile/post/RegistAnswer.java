package com.goprot.ih4c_mobile.post;

import com.goprot.ih4c_mobile.HttpRequest;
import com.goprot.ih4c_mobile.post_values.CreateQuestionFourValues;
import com.goprot.ih4c_mobile.post_values.RegistAnswerValues;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegistAnswer {
    private static String registAnswer = "";
    private static String message = "";

    public static RegistAnswerValues PostRegistAnswer(
            String student_id, String problem_id_1, String ans_flg_1
    ) {
        Map<String, String> formdata = new HashMap<String, String>();
        formdata.put("act", "registAnswer");
        formdata.put("student_id", student_id);
        formdata.put("problem_id_1", problem_id_1);
        formdata.put("ans_flg_1", ans_flg_1);

        String response = "";
        try {
            response = HttpRequest.callPost(formdata);
            JSONObject rootJSON = new JSONObject(response);
            registAnswer = rootJSON.getString("status");
            message = rootJSON.getString("message");
            if(registAnswer.equals("no")){
                registAnswer = rootJSON.getString("message");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // CreateChoicesValuesオブジェクトの生成
        RegistAnswerValues postResult = new RegistAnswerValues(registAnswer, message);
        return postResult;
    }

}
