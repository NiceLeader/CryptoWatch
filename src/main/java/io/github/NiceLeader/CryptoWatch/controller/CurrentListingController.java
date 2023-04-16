package io.github.NiceLeader.CryptoWatch.controller;

import io.github.NiceLeader.CryptoWatch.model.CurrentListing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
public final CurrentListingService currentListingService;
public final LiveListingService liveListingService;
@Controller
public class CurrentListingController {


    @GetMapping("/main-page")
    public String getCurrentListing(Model model) {
        CurrentListing currentListing = new CurrentListing("Bitcoin", new BigDecimal("10000"), new BigDecimal("100000"), new BigDecimal("100"), new BigDecimal("1000000"));
        model.addAttribute("currentListing", currentListing);

        return "main-page";
    }
}
