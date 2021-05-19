package learn.cat.models;

import java.util.ArrayList;
import java.util.List;

public class Cat {

    private int catId;
    private String name;
    private String desc;
    private String picture;
    private User user;
    private boolean isDisabled;
    private List<Alias> aliases = new ArrayList<>();

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    public List<Alias> getAliases() {
        return new ArrayList<>(aliases);
    }

    public void setAliases(List<Alias> aliases) {
        this.aliases = aliases;
    }
}
