package org.craftedsw.tripservicekata.user;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.trip.Trip;
import org.craftedsw.tripservicekata.trip.TripDAO;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        List<Trip> tripList = new ArrayList<Trip>();
        User loggedUser = getLoggedUser();


        if ( loggedUser != null) {
            if (isFriend(user, loggedUser)) {
                tripList = getByUser(user);
            }
            return tripList;
        } else {
            throw new UserNotLoggedInException();
        }
    }

     User getLoggedUser() {
        return UserSession.getInstance().getLoggedUser();
    }

    private boolean isFriend(User user, User loggedUser) {
        return user.isFriend(loggedUser);
    }


     static List<Trip> getByUser(User user) {
        return TripDAO.findTripsByUser(user);
    }

}
