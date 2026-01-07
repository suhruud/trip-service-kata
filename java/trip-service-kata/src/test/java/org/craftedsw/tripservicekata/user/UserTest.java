package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.Trip;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void isFriendWith_ShouldReturnFalse_WhenUsersAreNotFriends() {
        User user1 = new User();
        User user2 = new User();

        Assertions.assertFalse(
                user1.isFriend(user2));
    }

    @Test
    public void isFriendWith_ShouldReturnTrue_WhenUsersAreFriends() {
        User user1 = new User();
        User user2 = new User();

        user1.addFriend(user2);
        Assertions.assertTrue(user1.isFriend(user2));

    }

    @Test
    public void trips_ShouldReturnAddedTrips() {
        User user = new User();
        Trip trip1 = new Trip();
        Trip trip2 = new Trip();

        user.addTrip(trip1);
        user.addTrip(trip2);

        Assertions.assertFalse(user.trips().isEmpty());
    }

    @Test
    public void trips_ShouldReturnEmptyList_WhenNoTripsAdded() {
        User user = new User();
        Assertions.assertTrue(user.trips().isEmpty());
    }

}
