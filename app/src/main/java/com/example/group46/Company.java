package com.example.group46;

public class Company {

    private int companyID;
    private String companyName;
    private int imageDrawableID;

    public Company(int companyID, String companyName, int imageDrawableID){
        this.companyID = companyID;
        this.companyName = companyName;
        this.imageDrawableID = imageDrawableID;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getImageDrawableID() {
        return imageDrawableID;
    }

    public void setImageDrawableID(int imageDrawableID) {
        this.imageDrawableID = imageDrawableID;
    }
}