package com.goprot.ih4c_mobile.post;

import android.util.Log;

import com.goprot.ih4c_mobile.HttpRequest;
import com.goprot.ih4c_mobile.post_values.OcrValues;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ocr {
    private static String ocr = "";
    private static JSONArray ocrList = null;
    public static OcrValues PostOcr(String img_64) {
        Map<String, String> formdata = new HashMap<String, String>();
        formdata.put("act", "ocr");
        try {
            formdata.put("img_64", URLEncoder.encode(img_64,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Log.i("img_64", img_64);
        String response = "";
        try {
            response = HttpRequest.callPost(formdata);
            JSONObject rootJSON = new JSONObject(response);
            ocr = rootJSON.getString("status");
            ocrList = rootJSON.getJSONArray("data");
            if(ocr.equals("no")){
                ocr = rootJSON.getString("message");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // OcrValuesオブジェクトの生成
        OcrValues postResult = new OcrValues(ocr,ocrList);
        return postResult;
    }

}
