package com.co.pluralsight.tddjunit.airport;

public class EconomyFlight extends Flight {

    public EconomyFlight(String id){super(id);}

    @Override
    public boolean addPassenger(Passenger passenger) {
        return getPassengersSet().add(passenger);
    }

    @Override
    public boolean removePassenger(Passenger passenger) {

        if (!passenger.isVip()){
            return getPassengersSet().remove(passenger);
        }

        return false;
    }
}
