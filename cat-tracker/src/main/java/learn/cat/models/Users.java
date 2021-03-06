package learn.cat.models;
import javax.validation.constraints.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Users {
    private int usersId;
    @NotBlank(message = "Username is required!")
    @Size(max= 50, message = "Username cannot be greater than 50")
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    @NotNull(message = "disabled cannot be null")
    private Boolean disabled;
    private List<Cat> cats = new ArrayList<>();

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public List<Cat> getCats() {
        return new ArrayList<>(cats);
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }
}
