package com.simonh.fit.ChestFrag;


import android.widget.Button;

public class ChestItem {
    private String workouName;
    private int weightNumber;
    private String lbLabel;
    private Button plusBtn;
    private Button minusBtn;

    ChestItem(String Wname, Button mBtn, int Wnumber, String lLabel, Button pBtn){


        workouName = Wname;
        minusBtn = mBtn;
        weightNumber = Wnumber;
        lbLabel = lLabel;
        plusBtn = pBtn;
    }
    public String getWorkouName(){
        return workouName;
    }
    public Button getMinusBtn(){
        return minusBtn;
    }
    public int getWeightNumber(){
        return weightNumber;
    }
    public String getLbLabel(){
        return lbLabel;
    }
    public Button getPlusBtn(){
        return plusBtn;
    }
    public void setWeightNumber(int weightNumber) {
        this.weightNumber = weightNumber;
    }
}
