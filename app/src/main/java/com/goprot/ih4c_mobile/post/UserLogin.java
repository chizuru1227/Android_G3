package com.goprot.ih4c_mobile.post;



import com.goprot.ih4c_mobile.HttpRequest;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UserLogin {
    private static String login;
    public static String LoginUser(String user_id,String user_pass) {
        Map<String, String> formdata = new HashMap<String, String>();
        formdata.put("act", "loginUser");
        formdata.put("student_id", user_id);
        formdata.put("student_pass", user_pass);
        String response = "";
        try {
            response = HttpRequest.callPost(formdata);
            JSONObject rootJSON = new JSONObject(response);
            login = response;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return login;
    }

}
