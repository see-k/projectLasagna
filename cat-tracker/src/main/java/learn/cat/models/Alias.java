package learn.cat.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Alias {

    private int aliasId;

    @NotBlank(message = "Alias name is required.")
    @Size(max = 50, message = "Alias name cannot be greater than 50 characters.")
    private String aliasName;

    @Positive(message = "Alias must have be associated with a cat.")
    private int catId;

    public int getAliasId() {
        return aliasId;
    }

    public void setAliasId(int aliasId) {
        this.aliasId = aliasId;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }
}
