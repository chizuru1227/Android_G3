package com.goprot.ih4c_mobile.post;

import com.goprot.ih4c_mobile.HttpRequest;
import com.goprot.ih4c_mobile.post_values.CreateQuestionBlankValues;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CreateQuestionBlank {
    private static String createQuestionBlank = "";
    private static int problem_id = 0;

    public static CreateQuestionBlankValues PostCreateQuestionBlank(
            String problem_statement_f, String problem_statement_b,String answer,String unit_id,String school_id,
            String choices_1, String choices_2,String choices_3,String student_id,String subject_id
    ) {
        Map<String, String> formdata = new HashMap<String, String>();
        formdata.put("act", "createQuestionBlank");
        formdata.put("problem_statement_F", problem_statement_f);
        formdata.put("problem_statement_E", problem_statement_b);
        formdata.put("answer", answer);
        formdata.put("unit_id", unit_id);
        formdata.put("school_id", school_id);
        formdata.put("choices_1", choices_1);
        formdata.put("choices_2", choices_2);
        formdata.put("choices_3", choices_3);
        formdata.put("student_id", student_id);
        formdata.put("subject_id", subject_id);
        String response = "";
        try {
            response = HttpRequest.callPost(formdata);
            JSONObject rootJSON = new JSONObject(response);
            createQuestionBlank = rootJSON.getString("status");
            problem_id = rootJSON.getInt("problem_id");
            if(createQuestionBlank.equals("no")){
                createQuestionBlank = rootJSON.getString("message");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // CreateChoicesValuesオブジェクトの生成
        CreateQuestionBlankValues postResult = new CreateQuestionBlankValues(createQuestionBlank, problem_id);
        return postResult;
    }

}
