package com.goprot.ih4c_mobile.post;

import com.goprot.ih4c_mobile.HttpRequest;
import com.goprot.ih4c_mobile.post_values.CreateChoicesValues;
import com.goprot.ih4c_mobile.post_values.CreateQuestionFourValues;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CreateQuestionFour {
    private static String createQuestionFour = "";
    private static int problem_id = 0;

    public static CreateQuestionFourValues PostCreateQuestionFour(
            String problem_statement, String answer,String unit_id,String school_id,
            String choices_1, String choices_2,String choices_3,String student_id,String subject_id
    ) {
        Map<String, String> formdata = new HashMap<String, String>();
        formdata.put("student_id", student_id);
        formdata.put("subject_id", subject_id);
        formdata.put("problem_statement", problem_statement);
        formdata.put("answer", answer);
        formdata.put("unit_id", unit_id);
        formdata.put("school_id", school_id);
        formdata.put("choices_1", choices_1);
        formdata.put("choices_2", choices_2);
        formdata.put("choices_3", choices_3);
        formdata.put("act", "createQuestionFour");

        String response = "";
        try {
            response = HttpRequest.callPost(formdata);
            JSONObject rootJSON = new JSONObject(response);
            createQuestionFour = rootJSON.getString("status");
            problem_id = rootJSON.getInt("problem_id");
            if(createQuestionFour.equals("no")){
                createQuestionFour = rootJSON.getString("message");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // CreateChoicesValuesオブジェクトの生成
        CreateQuestionFourValues postResult = new CreateQuestionFourValues(createQuestionFour, problem_id);
        return postResult;
    }

}
