package learn.cat.models;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class Sighting {

    private int sightingId;
    private String picture;
    private String catDescription;
    private String sightingDescription;
    private Date sightingDate;
    private Time sightingTime;
    private boolean isDisabled;
    private int usersId;
    private int locationId;
    private int catId;

    public Sighting() {
    }

    public int getSightingId() {
        return sightingId;
    }

    public void setSightingId(int sightingId) {
        this.sightingId = sightingId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getSightingDate() {
        return sightingDate;
    }

    public void setSightingDate(Date sightingDate) {
        this.sightingDate = sightingDate;
    }

    public Time getSightingTime() {
        return sightingTime;
    }

    public void setSightingTime(Time sightingTime) {
        this.sightingTime = sightingTime;
    }

    public String getCatDescription() {
        return catDescription;
    }

    public void setCatDescription(String catDescription) {
        this.catDescription = catDescription;
    }

    public String getSightingDescription() {
        return sightingDescription;
    }

    public void setSightingDescription(String sightingDescription) {
        this.sightingDescription = sightingDescription;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }
}
