package io.github.NiceLeader.CryptoWatch.model;


import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
public class CurrentListing implements Serializable {
    private String coin;
    private BigDecimal price;
    private BigDecimal volume;
    private BigDecimal change;
    private BigDecimal marketCap;


    public CurrentListing(String coin, BigDecimal price, BigDecimal volume, BigDecimal change, BigDecimal marketCap) {
        this.coin = coin;
        this.price = price;
        this.volume = volume;
        this.change = change;
        this.marketCap = marketCap;
    }
}
