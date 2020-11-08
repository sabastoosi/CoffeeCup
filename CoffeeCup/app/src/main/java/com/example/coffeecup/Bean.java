package com.example.coffeecup;

public class Bean {

    private String mDarkness;
    private String mName;
    private String mRoastDate;

    /**
     The constructor for Brew objects
     @param name - the name of the bean
     @param darkness - the darkness of the bean
     @param roastDate - the roast date of the bean
     */
    public Bean(String name, String darkness, String roastDate) {
        mName = name;
        mDarkness = darkness;
        mRoastDate = roastDate;
    }

    /**
     This method returns the darkness of a given bean
     @return the string darkness of the bean
     */
    public String getmDarkness() {
        return mDarkness;
    }

    /**
     This method returns the name of a given bean
     @return the string name of the bean
     */
    public String getmName() {
        return mName;
    }

    /**
     This method returns the roast date of a given bean
     @return the string roast date of the bean
     */
    public String getmRoastDate() {
        return mRoastDate;
    }

    /**
     This method sets the darkness of a given bean
     */
    public void setmDarkness(String mDarkness) {
        this.mDarkness = mDarkness;
    }

    /**
     This method sets the name of a given bean
     */
    public void setmName(String mName) {
        this.mName = mName;
    }

    /**
     This method sets the roast date of a given bean
     */
    public void setmRoastDate(String mRoastDate) {
        this.mRoastDate = mRoastDate;
    }
}
