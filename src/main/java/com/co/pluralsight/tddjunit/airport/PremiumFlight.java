package com.co.pluralsight.tddjunit.airport;

public class PremiumFlight extends Flight {

    public PremiumFlight(String id) {
        super(id);
    }

    @Override
    public boolean addPassenger(Passenger passenger) {
        if (passenger.isVip()){
            return getPassengersSet().add(passenger);
        }
        return false;
    }

    @Override
    public boolean removePassenger(Passenger passenger) {
        if(passenger.isVip()){
            return getPassengersSet().remove(passenger);
        }
        return false;
    }
}
