package org.example.Entity;

import io.swagger.annotations.Api;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Api(description = "Tires related end points")
public class Tires {


    @Id
    @Column(columnDefinition = "VARCHAR(10)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(columnDefinition = "VARCHAR(3)")
    private int frontLeft;

    @Column(columnDefinition = "VARCHAR(3)")
       private int frontRight;

    @Column(columnDefinition = "VARCHAR(3)")
       private int rearLeft;
    @Column(columnDefinition = "VARCHAR(3)")
       private int rearRight;


    public Tires(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }

    @Override
    public String toString() {
        return "Tires{" +
                "id=" + id +
                ", frontLeft=" + frontLeft +
                ", frontRight=" + frontRight +
                ", rearLeft=" + rearLeft +
                ", rearRight=" + rearRight +
                '}';
    }

    public int getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }

    public int getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(int rearLeft) {
        this.rearLeft = rearLeft;
    }

    public int getRearRight() {
        return rearRight;
    }

    public void setRearRight(int rearRight) {
        this.rearRight = rearRight;
    }
}
