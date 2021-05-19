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
    private Location location;
    private Users users;
    private Cat cat;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
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
