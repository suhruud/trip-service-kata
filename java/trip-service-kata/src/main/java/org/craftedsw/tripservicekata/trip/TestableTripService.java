package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;

import java.util.List;


public class TestableTripService extends TripService {


    private final User loggedUser;

    public TestableTripService(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Override
    List<Trip> getByUser(User user) {
        return user.trips();
    }


    @Override
    User getLoggedUser() {
        return loggedUser;
    }

}
