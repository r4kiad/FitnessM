package com.simonh.fit.WorkoutFrag;


public class ExampleItem {
    private int mImageResource;
    private String mText1;
    private String mText2;
    private int mdragImage;

    public ExampleItem(/*int imageResource,*/ String text1, String text2, int dragImage){
        //mImageResource =imageResource;
        mText1 = text1;
        mText2 = text2;
        mdragImage = dragImage;
    }
    public int getmImageResource(){
        return mImageResource;
    }
    public int getmdragImage(){
        return mdragImage;
    }
    public String getText1(){
        return mText1;
    }
    public String getText2(){
        return mText2;
    }
}
