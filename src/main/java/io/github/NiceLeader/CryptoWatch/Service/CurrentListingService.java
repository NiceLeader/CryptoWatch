package io.github.NiceLeader.CryptoWatch.Service;

import io.github.NiceLeader.CryptoWatch.model.CurrentListing;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class CurrentListingService {
    public CurrentListing getCurrentListing(String coin, String fiat) {
        return new CurrentListing("Bitcoin", BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.TEN, BigDecimal.TEN);
    }





}
