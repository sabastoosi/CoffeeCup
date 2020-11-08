package com.example.coffeecup;

public class Bean {

    private String mDarkness;
    private String mName;
    private String mRoastDate;

    public Bean(String name, String darkness, String roastDate) {
        mName = name;
        mDarkness = darkness;
        mRoastDate = roastDate;
    }

    public String getmDarkness() {
        return mDarkness;
    }

    public String getmName() {
        return mName;
    }

    public String getmRoastDate() {
        return mRoastDate;
    }

    public void setmDarkness(String mDarkness) {
        this.mDarkness = mDarkness;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmRoastDate(String mRoastDate) {
        this.mRoastDate = mRoastDate;
    }
}
