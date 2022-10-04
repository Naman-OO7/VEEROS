package com.example.signup;

public class ModelClass {
    private int imageview1;
    private String textview1;
    private String textview2;
    private String textview3;
    private String dash;

    ModelClass(int imageview1,String textview1, String textview2, String textview3, String dash){
        this.imageview1 = imageview1;
        this.textview1 = textview1;
        this.textview2 = textview2;
        this.textview3 = textview3;
        this.dash = dash;
    }


    public int getImageview1() {
        return imageview1;
    }

    public String getTextview1() {
        return textview1;
    }

    public String getTextview2() {
        return textview2;
    }

    public String getTextview3() {
        return textview3;
    }

    public String getDash() {
        return dash;
    }
}
