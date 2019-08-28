package com.xyz.training.legacy;

import java.util.ArrayList;
import java.util.List;

public class TripService {

    public List<Trip> getTripsForUser(User user) throws AuthenticationException {
        List<Trip> tripsList = new ArrayList<>();
        User loggedInUser = getLoggedInUser();
        boolean isFriend = false;
        if (loggedInUser != null) {
            for (User friend : user.getFriends()) {
                if (friend.equals(loggedInUser)) {
                    isFriend = true;
                    break;
                }
            }
            if (isFriend) {
                tripsList = TripDao.findTripsByUser(user);
            }
            return tripsList;
        } else {
            throw new AuthenticationException();
        }
    }

    User getLoggedInUser() {
        return UserSession.getInstance().getLoggedInUser();
    }

}
