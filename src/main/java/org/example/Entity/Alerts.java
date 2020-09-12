package org.example.Entity;

import io.swagger.annotations.Api;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity

public class Alerts {


    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(columnDefinition = "VARCHAR(10)")
    private String priority;

    @Column(columnDefinition = "VARCHAR(17)")
    private String vin;


    @Column(columnDefinition = "VARCHAR(100)")
    private String description;

    @Column(columnDefinition = "DATETIME")
    @DateTimeFormat(pattern = "YYYY-MM-DDThh:mm:ss.sTZD")
    private Date timestamp;

    @Column(columnDefinition = "DECIMAL(10,8)")
    private double latitude;

    @Column(columnDefinition = "DECIMAL(11,8)")
    private double longitude;


    public Alerts()
    {
        this.id= UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Alerts{" +
                "id='" + id + '\'' +
                ", priority='" + priority + '\'' +
                ", vin='" + vin + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
