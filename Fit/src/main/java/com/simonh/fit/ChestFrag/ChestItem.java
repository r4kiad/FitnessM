package com.simonh.fit.ChestFrag;


import android.widget.Button;

public class ChestItem {
    private String workouName;
    private int weightNumber;
    private String lbLabel;
    //private Button plusBtn;
    //private Button minusBtn;
    private Button setBtn;

    ChestItem(String Wname, Button setBtn, int Wnumber, String lLabel){


        workouName = Wname;
        setBtn = this.setBtn;
        weightNumber = Wnumber;
        lbLabel = lLabel;

    }
    public String getWorkouName(){
        return workouName;
    }
    public Button getSetBtn(){return setBtn;}
    public int getWeightNumber(){
        return weightNumber;
    }
    public String getLbLabel(){
        return lbLabel;
    }
    public void setWeightNumber(int weightNumber) {
        this.weightNumber = weightNumber;
    }
}
