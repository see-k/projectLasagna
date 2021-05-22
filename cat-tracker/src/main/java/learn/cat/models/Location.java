package learn.cat.models;
import javax.validation.constraints.*;
import java.math.BigDecimal;

public class Location {
    private int locationId;
    @NotBlank(message = "Longitude coordinate is required!")
    @NotNull(message = "Longitude coordinate cannot be null!")
    private BigDecimal longitude;
    @NotBlank(message = "Latitude coordinate is required!")
    @NotNull(message = "Latitude coordinate cannot be null!")
    private BigDecimal latitude;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

}
