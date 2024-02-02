package com.goprot.ih4c_mobile.post_values;

import org.json.JSONArray;

public class CreateChoicesValues {
    public String createChoices; // post結果
    public String choices_1;  //
    public String choices_2;  //
    public String choices_3;  //

    // コンストラクタ
    public CreateChoicesValues(String createChoices, String choices_1, String choices_2, String choices_3) {
        this.createChoices = createChoices;
        this.choices_1 = choices_1;
        this.choices_2 = choices_2;
        this.choices_3 = choices_3;
    }
}