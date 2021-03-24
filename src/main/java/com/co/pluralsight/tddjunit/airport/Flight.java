package com.co.pluralsight.tddjunit.airport;

import java.util.HashSet;
import java.util.Set;

public abstract class Flight {

    private String id;
    private int distance;
    private Set<Passenger> passengersSet = new HashSet<>();

    public Flight(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Set<Passenger> getPassengersSet() {
        return passengersSet;
    }


    public abstract boolean addPassenger(Passenger passenger);

    public abstract boolean removePassenger(Passenger passenger);
}
