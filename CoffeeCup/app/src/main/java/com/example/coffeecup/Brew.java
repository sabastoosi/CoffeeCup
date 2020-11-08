package com.example.coffeecup;

public class Brew {
    private String mName;
    private String mDate;
    private int mWaterTemp;
    private Bean mBeanType;
    private int mCoffeeMass;
    private int mGrindSize;
    private String mBrewer;
    private int mBrewTime;
    private int mWaterDilutionMass;
    private int mExtraction;
    private int mStrength;
    private int mRating;

    public Brew(String name, String date, int waterTemp, Bean beanType, int coffeeMass, int grindSize, String brewer, int brewTime, int waterDilutionMass) {
        mName = name;
        mDate = date;
        mWaterTemp = waterTemp;
        mBeanType = beanType;
        mCoffeeMass = coffeeMass;
        mGrindSize = grindSize;
        mBrewer = brewer;
        mBrewTime = brewTime;
        mWaterDilutionMass = waterDilutionMass;
    }

    public String getmName() {
        return mName;
    }

    public String getmDate() {
        return mDate;
    }

    public int getmWaterTemp() {
        return mWaterTemp;
    }

    public Bean getmBeanType() {
        return mBeanType;
    }

    public int getmCoffeeMass() {
        return mCoffeeMass;
    }

    public int getmGrindSize() {
        return mGrindSize;
    }

    public String getmBrewer() {
        return mBrewer;
    }

    public int getmBrewTime() {
        return mBrewTime;
    }

    public int getmWaterDilutionMass() {
        return mWaterDilutionMass;
    }

    public int getmExtraction() {
        return mExtraction;
    }

    public int getmRating() {
        return mRating;
    }

    public int getmStrength() {
        return mStrength;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public void setmWaterTemp(int mWaterTemp) {
        this.mWaterTemp = mWaterTemp;
    }

    public void setmBeanType(Bean mBeanType) {
        this.mBeanType = mBeanType;
    }

    public void setmCoffeeMass(int mCoffeeMass) {
        this.mCoffeeMass = mCoffeeMass;
    }

    public void setmGrindSize(int mGrindSize) {
        this.mGrindSize = mGrindSize;
    }

    public void setmBrewer(String mBrewer) {
        this.mBrewer = mBrewer;
    }

    public void setmBrewTime(int mBrewTime) {
        this.mBrewTime = mBrewTime;
    }

    public void setmWaterDilutionMass(int mWaterDilutionMass) {
        this.mWaterDilutionMass = mWaterDilutionMass;
    }

    public void setmExtraction(int mExtraction) {
        this.mExtraction = mExtraction;
    }

    public void setmStrength(int mStrength) {
        this.mStrength = mStrength;
    }

    public void setmRating(int mRating) {
        this.mRating = mRating;
    }
}
