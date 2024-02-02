package com.goprot.ih4c_mobile.post;

import com.goprot.ih4c_mobile.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PassChange {
    private static String passchange;
    public static String PassChange(String user_id,String user_pass,String new_pass) {
        Map<String, String> formdata = new HashMap<String, String>();
        formdata.put("act", "s_changePassword");
        formdata.put("student_id", user_id);
        formdata.put("student_pass", user_pass);
        formdata.put("new_pass",new_pass);
        String response = "";
        try {
            response = HttpRequest.callPost(formdata);
            JSONObject rootJSON = new JSONObject(response);
            passchange = rootJSON.getString("status");
            if(passchange.equals("no")){
                passchange = rootJSON.getString("message");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return passchange;
    }

}
