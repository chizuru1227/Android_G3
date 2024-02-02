package com.goprot.ih4c_mobile.post_values;

import org.json.JSONArray;

public class OcrValues {
    public String ocr; // post結果
    public JSONArray ocrList;  //

    // コンストラクタ
    public OcrValues(String ocr, JSONArray ocrList) {
        this.ocr = ocr;
        this.ocrList = ocrList;
    }
}