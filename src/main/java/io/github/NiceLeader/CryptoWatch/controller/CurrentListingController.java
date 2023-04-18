package io.github.NiceLeader.CryptoWatch.controller;

import io.github.NiceLeader.CryptoWatch.Service.CurrentListingService;
import io.github.NiceLeader.CryptoWatch.Service.LiveListingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CurrentListingController {
    public final CurrentListingService currentListingService;
    public final LiveListingService liveListingService;

    public CurrentListingController(CurrentListingService currentListingService, LiveListingService liveListingService) {
        this.currentListingService = currentListingService;
        this.liveListingService = liveListingService;
    }


    @GetMapping("/main-page")
    public String getCurrentListing(Model model) {
       if (true){
           model.addAttribute("currentListing",liveListingService.getLiveListing("Bitcoin", "USD"));
       }else {
           model.addAttribute("currentListing",currentListingService.getCurrentListing("Bitcoin", "USD"));
       }

        return "main-page";
    }
}
