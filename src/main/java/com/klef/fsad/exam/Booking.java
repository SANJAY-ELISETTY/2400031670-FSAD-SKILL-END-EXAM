package com.klef.fsad.exam;

import javax.persistence.*;

@Entity
@Table(name="booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String date;
    private String status;
    private double amount;

    public Booking() {}

    public Booking(String name, String date, String status, double amount) {
        this.name = name;
        this.date = date;
        this.status = status;
        this.amount = amount;
    }

    public String toString() {
        return id + " " + name + " " + date + " " + status + " " + amount;
    }
}