package com.xyz.training.legacy;

import org.junit.Test;

import static org.junit.Assert.*;

public class TripServiceTest {

    public static final User GUEST = null;

    @Test(expected = AuthenticationException.class)
    public void shouldThrowAuthenticationExceptionIfUserIsNotLoggedIn() throws Exception {
        TripService tripService = new TestableTripService();
        tripService.getTripsForUser(GUEST);
    }

    private class TestableTripService extends TripService {
        @Override
        User getLoggedInUser() {
            return null;
        }
    }
}