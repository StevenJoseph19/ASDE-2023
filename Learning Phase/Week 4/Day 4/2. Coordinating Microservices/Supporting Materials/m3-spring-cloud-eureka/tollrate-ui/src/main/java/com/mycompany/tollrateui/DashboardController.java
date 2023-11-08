package com.mycompany.tollrateui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class DashboardController {

  

    @RequestMapping("/dashboard")
    public String GetTollRate(@RequestParam(defaultValue = "1000") Integer stationId, Model m) {

        WebClient client = WebClient.create();

        TollRate rate = client.get()
                .uri("http://localhost:8082/tollrate/" + stationId)
                .retrieve()
                .bodyToMono(TollRate.class)
                .block();

        System.out.println("stationId: " + stationId);
        m.addAttribute("rate", rate);
        return "dashboard";
    }

}
