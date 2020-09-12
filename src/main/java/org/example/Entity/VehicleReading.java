package org.example.Entity;

import io.swagger.annotations.Api;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Api(description = "Vehicle Reading related end points")
public class VehicleReading {

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(columnDefinition = "VARCHAR(17)")
    private String vin;

    @Column(columnDefinition = "DECIMAL(10,8)")
    private double latitude;

    @Column(columnDefinition = "DECIMAL(10,8)")
    private double longitude;

    @Column(columnDefinition = "DATETIME")
    @DateTimeFormat(pattern = "YYYY-MM-DDThh:mm:ss.sTZD")
    private Date timestamp;

    @Column(columnDefinition = "DECIMAL(3,1)")
    private double fuelVolume;

    @Column(columnDefinition ="INTEGER(4)")
    private int speed;

    @Column(columnDefinition ="INTEGER(4)")
    private int engineHp;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean checkEngineLightOn;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean engineCoolantLow;


    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean cruiseControlOn;

    @Column(columnDefinition ="VARCHAR(5)")
    private int engineRpm;

    @OneToOne(fetch= FetchType.EAGER,
            cascade =  CascadeType.ALL)
    private Tires tires;

    public VehicleReading()
    {
        this.id= UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(int engineHp) {
        this.engineHp = engineHp;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }

    public Tires getTires() {
        return tires;
    }

    @Override
    public String toString() {
        return "VehicleReading{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timestamp=" + timestamp +
                ", fuelVolume=" + fuelVolume +
                ", speed=" + speed +
                ", engineHp=" + engineHp +
                ", checkEngineLightOn=" + checkEngineLightOn +
                ", engineCoolantLow=" + engineCoolantLow +
                ", cruiseControlOn=" + cruiseControlOn +
                ", engineRpm=" + engineRpm +
                ", tires=" + tires +
                '}';
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }
}
