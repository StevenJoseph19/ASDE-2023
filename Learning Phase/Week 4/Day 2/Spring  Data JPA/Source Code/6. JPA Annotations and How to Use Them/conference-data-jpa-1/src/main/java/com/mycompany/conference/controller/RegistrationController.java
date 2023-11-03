package com.mycompany.conference.controller;

import com.mycompany.conference.model.Registration;
import com.mycompany.conference.model.RegistrationReport;
import com.mycompany.conference.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @GetMapping("registration")
    public String getRegistration(@ModelAttribute ("registration")Registration registration) {

        return "registration";
    }

    @GetMapping("registrations")
    public @ResponseBody List<Registration> getRegistrations() {

        List<Registration> registrations = registrationService.findAll();

        return registrations;
    }

    @GetMapping("registration-reports")
    public @ResponseBody List<RegistrationReport> getRegistrationReports() {

        List<RegistrationReport> registrationReports = registrationService.findAllReports();

        return registrationReports;
    }

    @PostMapping("registration")
    public String addRegistration(@Valid @ModelAttribute ("registration")
                                              Registration registration,
                                  BindingResult result) {

        if(result.hasErrors()) {
            System.out.println("There were errors");
            return "registration";
        }
        else{
            registrationService.addRegistration(registration);
        }

        System.out.println("Registration: " + registration.getName());

        return "redirect:registration";
    }

}
