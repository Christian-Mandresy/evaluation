package com.vehicule.app.controller;

import com.vehicule.app.service.TrajetService;
import com.vehicule.app.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
public class ExportPdf {

    @Autowired
    private VehiculeService vehiculeService;

    @Autowired
    private TrajetService trajetService;

    @RequestMapping(value = "/listeVoiture",method = RequestMethod.GET)
    public String ListeVoiture(Model model, HttpServletRequest request)
    {
        model.addAttribute("ListVehicule",vehiculeService.findall());
        return "ListeVehicule";
    }

    @RequestMapping(value = "/listeTrajet",method = RequestMethod.GET)
    public String ListeTrajet(Model model, HttpServletRequest request)
    {
        model.addAttribute("ListTrajet",trajetService.findById(Integer.parseInt(request.getParameter("id"))));
        return "TrajetVehicule";
    }
}
