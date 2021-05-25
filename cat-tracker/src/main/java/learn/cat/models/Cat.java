package learn.cat.models;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;

public class Cat {

    private int catId;

    @NotNull(message = "Cat name is required.")
    @Size(max = 50, message = "Cat name cannot be greater than 50 characters.")
    private String name;

    @Size(max = 300, message = "Cat description cannot be greater than 300 characters.")
    private String desc;

    @Size(max = 100, message = "Image path cannot be greater than 100 characters.")
    private String picture;

    @NotNull(message = "User Id is required.")
    private int usersId;
    private boolean isDisabled;

    private List<Alias> aliases = new ArrayList<>();

    public Cat() {
    }

    public Cat(int catId, String name, String desc, String picture, int usersId, boolean isDisabled, List<Alias> aliases) {
        this.catId = catId;
        this.name = name;
        this.desc = desc;
        this.picture = picture;
        this.usersId = usersId;
        this.isDisabled = isDisabled;
        this.aliases = aliases;
    }

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

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
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
