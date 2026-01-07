package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.Trip;

import java.util.List;


public class TestableTripService extends TripService {


    private final User loggedUser;

    public TestableTripService(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    static List<Trip> getByUser(User user) {
        return user.trips();
    }


    @Override
    User getLoggedUser() {
        return loggedUser;
    }

}
