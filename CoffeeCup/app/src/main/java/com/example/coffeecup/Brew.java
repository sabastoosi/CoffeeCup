package com.example.coffeecup;

public class Brew {
    private String mName;
    private String mDate;
    private int mWaterTemp;
    private int mWaterMass;
    private Bean mBeanType;
    private int mCoffeeMass;
    private int mGrindSize;
    private String mBrewer;
    private int mBrewTime;
    private int mWaterDilutionMass;
    private int mExtraction;
    private int mStrength;
    private int mRating;
    private String mNotes;
    private Boolean isFavorite = false;

    /**
     The constructor for Brew objects
     @param name - the name of the brew
     @param date - the date of the brew
     @param waterTemp - the temperature of the water
     @param waterMass - the mass of the water brewed
     @param beanType - the type of bean used
     @param coffeeMass - the mass of the coffee used
     @param grindSize - the size of the grind
     @param brewer - the type of brew (aeropress, french press etc.)
     @param brewTime - the time brewed
     @param waterDilutionMass - the water dilution mass
     */
    public Brew(String name, String date, int waterTemp, int waterMass, Bean beanType, int coffeeMass, int grindSize, String brewer, int brewTime, int waterDilutionMass) {
        mName = name;
        mDate = date;
        mWaterTemp = waterTemp;
        mWaterMass = waterMass;
        mBeanType = beanType;
        mCoffeeMass = coffeeMass;
        mGrindSize = grindSize;
        mBrewer = brewer;
        mBrewTime = brewTime;
        mWaterDilutionMass = waterDilutionMass;
    }

    /**
     This method returns the name of a given brew
     @return the string name of the brew
     */
    public String getmName() {
        return mName;
    }

    /**
     This method returns the date of a given brew
     @return the string date of the brew
     */
    public String getmDate() {
        return mDate;
    }

    /**
     This method returns the water temperature of a given brew
     @return the int water temperature of the brew
     */
    public int getmWaterTemp() {
        return mWaterTemp;
    }

    /**
     * This method returns the water mass of a given brew
     * @return the int water mass of the brew
     */
    public int getmWaterMass() {
        return mWaterMass;
    }

    /**
     This method returns the Bean type of a given brew
     @return the Bean object of the brew
     */
    public Bean getmBeanType() {
        return mBeanType;
    }

    /**
     This method returns the coffee mass of a given brew
     @return the int coffee mass of the brew
     */
    public int getmCoffeeMass() {
        return mCoffeeMass;
    }

    /**
     This method returns the grind size of a given brew
     @return the int grind size of the brew
     */
    public int getmGrindSize() {
        return mGrindSize;
    }

    /**
     This method returns the type of brew of a given brew
     @return the String brewer of the brew
     */
    public String getmBrewer() {
        return mBrewer;
    }

    /**
     This method returns the brew time of a given brew
     @return the int brew time of the brew in seconds
     */
    public int getmBrewTime() {
        return mBrewTime;
    }

    /**
     This method returns the water dilution mass of a given brew
     @return the int water dilution mass of the brew
     */
    public int getmWaterDilutionMass() {
        return mWaterDilutionMass;
    }

    /**
     This method returns the extraction of a given brew
     @return the int extraction of the brew (1-10)
     */
    public int getmExtraction() {
        return mExtraction;
    }

    /**
     This method returns the rating of a given brew
     @return the int rating of the brew (1-10)
     */
    public int getmRating() {
        return mRating;
    }

    /**
     This method returns the strength of a given brew
     @return the int strength of the brew (1-10)
     */
    public int getmStrength() {
        return mStrength;
    }

    /**
     This method returns the roast date of a given bean
     @return the date roasted
     */
    public String getmBeanRoastDate() {
        return mBeanType.getmRoastDate();
    }

    /**
     This method returns the darkness of a given bean
     @return the darkness strength of the bean
     */
    public String getmBeanDarkness() {
        return mBeanType.getmDarkness();
    }

    /**
     This method returns the bean name of a given bean
     @return the name of the bean
     */
    public String getmBeanName() {
        return mBeanType.getmName();
    }

    /**
     This method returns the notes for a given brew
     @return the notes of the brew
     */
    public String getmNotes() {
        return mNotes;
    }

    /**
     This method returns whether a brew is a favorite or not
     @return the favorite status of the brew
     */
    public Boolean getmFavoriteStatus() {
        return isFavorite;
    }

    /**
     This method sets the name of a given brew
     */
    public void setmName(String mName) {
        this.mName = mName;
    }

    /**
     This method sets the date of a given brew
     */
    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    /**
     This method sets the water temp of a given brew
     */
    public void setmWaterTemp(int mWaterTemp) {
        this.mWaterTemp = mWaterTemp;
    }

    /**
     This method sets the water temp of a given brew
     */
    public void setmWaterMass(int mWaterMass) {
        this.mWaterMass = mWaterMass;
    }

    /**
     This method sets the bean type of a given brew
     */
    public void setmBeanType(Bean mBeanType) {
        this.mBeanType = mBeanType;
    }

    /**
     This method sets the coffee mass of a given brew
     */
    public void setmCoffeeMass(int mCoffeeMass) {
        this.mCoffeeMass = mCoffeeMass;
    }

    /**
     This method sets the grind size of a given brew
     */
    public void setmGrindSize(int mGrindSize) {
        this.mGrindSize = mGrindSize;
    }

    /**
     This method sets the brewer of a given brew
     */
    public void setmBrewer(String mBrewer) {
        this.mBrewer = mBrewer;
    }

    /**
     This method sets the brew time of a given brew
     */
    public void setmBrewTime(int mBrewTime) {
        this.mBrewTime = mBrewTime;
    }

    /**
     This method sets the water dilution mass of a given brew
     */
    public void setmWaterDilutionMass(int mWaterDilutionMass) {
        this.mWaterDilutionMass = mWaterDilutionMass;
    }

    /**
     This method sets the extraction of a given brew
     */
    public void setmExtraction(int mExtraction) {
        this.mExtraction = mExtraction;
    }

    /**
     This method sets the strength of a given brew
     */
    public void setmStrength(int mStrength) {
        this.mStrength = mStrength;
    }

    /**
     This method sets the rating of a given brew
     */
    public void setmRating(int mRating) {
        this.mRating = mRating;
    }

    /**
     This method sets the bean name of a given bean
     */
    public void setmBeanName(String name) {this.mBeanType.setmName(name);}

    /**
     This method sets the darkness of a given bean
     */
    public void setmBeanDarkness(String darkness) {this.mBeanType.setmDarkness(darkness);}

    /**
     This method sets the roast date of a given bean
     */
    public void setmBeanRoastDate(String roastDate) {this.mBeanType.setmRoastDate(roastDate);}

    /**
     This method sets the notes of a given brew
     */
    public void setmNotes(String notes) {this.mNotes = notes;}

    /**
     This method sets the favorite status of a given brew
     */
    public void setIsFavorite(Boolean isFavorite) {this.isFavorite = isFavorite;}
}
