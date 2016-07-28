
package com.example.jakub.zadanie4;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("location")
    @Expose
    private Location location;

    @SerializedName("picture")
    @Expose
    private Picture picture;



    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    public Picture getPicture() {
        return picture;
    }

    /**
     * 
     * @param picture
     *     The picture
     */
    public void setPicture(Picture picture) {
        this.picture = picture;
    }


}
