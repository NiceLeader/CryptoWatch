package io.github.NiceLeader.CryptoWatch.Service;

import io.github.NiceLeader.CryptoWatch.model.CurrentListing;

import java.math.BigDecimal;

public class CurrentListingService {
    public CurrentListing getCurrentListing(String coin, String currency) {
        return new CurrentListing("Bitcoin", BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.TEN, BigDecimal.TEN);
    }


}
