package com.goprot.ih4c_mobile.post;

import com.goprot.ih4c_mobile.HttpRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class UserIconChange {
    private static String icon;
    public static String ChangeIcon(String user_id, String user_icon) {
        Map<String, String> formdata = new HashMap<String, String>();
        formdata.put("act", "s_changeIcon");
        formdata.put("student_id", user_id);

        try {
            formdata.put("icon_64", URLEncoder.encode(user_icon, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String response = "";
        try {
            response = HttpRequest.callPost(formdata);
            JSONObject rootJSON = new JSONObject(response);
            icon = rootJSON.getString("status");
            if(icon.equals("no")){
                icon = rootJSON.getString("message");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return response;
    }

}
