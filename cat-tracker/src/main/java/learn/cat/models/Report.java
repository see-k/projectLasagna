package learn.cat.models;

import javax.validation.constraints.Size;

public class Report {

    private int reportId;

    @Size(max = 300, message = "Report description cannot exceed 300 characters.")
    private String reportDescription;

    private int catId;
    private int usersId;
    private int sightingId;

    public Report() {
    }

    public Report(int reportId, String reportDescription, int catId, int userId, int sightingId) {
        this.reportId = reportId;
        this.reportDescription = reportDescription;
        this.catId = catId;
        this.usersId = userId;
        this.sightingId = sightingId;
    }


    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getUsersId() {
        return usersId;
    }

    public void setUsersId(int usersId) {
        this.usersId = usersId;
    }

    public int getSightingId() {
        return sightingId;
    }

    public void setSightingId(int sightingId) {
        this.sightingId = sightingId;
    }
}
