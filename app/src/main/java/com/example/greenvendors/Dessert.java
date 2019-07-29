package com.example.greenvendors;

class Dessert {


    // Name of the desert
    private String mDessertName;

    // Number of desserts
    private int mDessertNumber;

    // Drawable resource ID
    private int mImageResourceId;

    /*
     * Create a new dessert object.
     *
     * @param vName is the name of the dessert
     * @param vNumber is the corresponding number of desserts
     * @param image is drawable reference ID that corresponds to the dessert
     * */
    public Dessert(String vName)

    {
        mDessertName = vName;

    }

    /**
     * Get the name of the dessert
     */
    public String getDessertName() {
        return mDessertName;
    }

    /**
     * Get the  number of desserts
     */
    public int getDessertNumber() {
        return mDessertNumber;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }
}
