package com.xyz.training.legacy;

import java.util.List;

public class TripDao {
    public static List<Trip> findTripsByUser(User user) {
        throw new DependentClassInvokedException();
    }
}
