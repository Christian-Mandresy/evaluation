package com.vehicule.app.controller;

import com.vehicule.app.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ListVoitureDispo {

    @Autowired
    VehiculeService vehiculeService;

    @RequestMapping(value = "/voituredispo",method = RequestMethod.GET)
    public String VoitureDispo(Model model, HttpServletRequest request)
    {
        model.addAttribute("ListVehicule",vehiculeService.vehiculeDispo());
        int i=0;
        return "VoitureDispo";
    }
}
