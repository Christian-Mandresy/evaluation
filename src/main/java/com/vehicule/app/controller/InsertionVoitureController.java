package com.vehicule.app.controller;

import com.vehicule.app.model.User;
import com.vehicule.app.model.Vehicule;
import com.vehicule.app.service.TypeVehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class InsertionVoitureController {

    @Autowired
    private TypeVehiculeService typeVehiculeService;

    @RequestMapping(value = "/formVehicule")
    public String FormLogin(Map<String, Object> modelMap)
    {
        modelMap.put("Vehicule",new Vehicule());
        modelMap.put("ListType",typeVehiculeService.findall());
        return "FormVehicule";
    }

}
