package learn.cat.models;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Sighting {

    private int sightingId;
    private Date sightingDate;
    private Time sightingTime;
    private String catDescription;
    private String sightingDescription;
    private int locationId;
    private int usersId;
    private int catId;
    private boolean isDisabled;
    private List<String> pictures;

    public Sighting() {
    }

    public int getSightingId() {
        return sightingId;
    }

    public void setSightingId(int sightingId) {
        this.sightingId = sightingId;
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

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    public List<String> getPictures() {
        return new ArrayList<>(pictures);
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

}
