package learn.cat.models;

import java.math.BigDecimal;
import javax.validation.constraints.*;

public class Location {
    private int locationId;

    @NotBlank(message = "location coordinates required")
    private BigDecimal longitude;

    @NotBlank(message = "location coordinates required")
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
