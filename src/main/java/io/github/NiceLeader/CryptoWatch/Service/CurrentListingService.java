package io.github.NiceLeader.CryptoWatch.Service;

import io.github.NiceLeader.CryptoWatch.model.CurrentListing;

import java.math.BigDecimal;

public class CurrentListingService {
    public CurrentListing getCurrentWeather(String city, String country) {
        return new CurrentListing("Bitcoin", BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.TEN);
    }
}
