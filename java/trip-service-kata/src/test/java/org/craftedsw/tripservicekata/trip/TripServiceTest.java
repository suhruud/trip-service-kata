package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TripServiceTest {

    @Test
    public void shouldReturnTripsWhenUsersAreFriends() {
        User loggedUser = new User();
        User friendUser = new User();

        friendUser.addTrip(new Trip());
        friendUser.addFriend(loggedUser);

        TestableTripService tripService = new TestableTripService(loggedUser);

        List<Trip> trips = tripService.getTripsByUser(friendUser);

        Assertions.assertFalse(trips.isEmpty());
        Assertions.assertEquals(1, trips.size());
    }

    @Test
    public void shouldReturnEmptyListWhenUsersAreNotFriends() {
        User loggedUser = new User();
        User nonFriendUser = new User();

        nonFriendUser.addTrip(new Trip());

        TestableTripService tripService = new TestableTripService(loggedUser);

        List<Trip> trips = tripService.getTripsByUser(nonFriendUser);

        Assertions.assertTrue(trips.isEmpty());
        Assertions.assertEquals(0, trips.size());
    }

    @Test
    public void shouldThrowExceptionWhenUserIsNotLoggedIn() {
        User nonFriendUser = new User();
        nonFriendUser.addTrip(new Trip());

        TestableTripService tripService = new TestableTripService(null);

        Assertions.assertThrows(UserNotLoggedInException.class, () -> {
            tripService.getTripsByUser(nonFriendUser);
        });
    }
}
