package cn.alandelip.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author Alan on 2017/3/25
 */
@Entity
@Table(name = "point")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private double x;

    @NotNull
    private double y;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
