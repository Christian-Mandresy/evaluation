package com.vehicule.app.controller;

import com.vehicule.app.model.User;
import com.vehicule.app.model.Vehicule;
import com.vehicule.app.service.TypeVehiculeService;
import com.vehicule.app.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class InsertionVoitureController {

    @Autowired
    private TypeVehiculeService typeVehiculeService;

    @Autowired
    private VehiculeService vehiculeService;

    @RequestMapping(value = "/formVehicule")
    public String FormLogin(Map<String, Object> modelMap)
    {
        modelMap.put("Vehicule",new Vehicule());
        modelMap.put("ListType",typeVehiculeService.findall());
        return "FormVehicule";
    }

    @RequestMapping(value = "/InsertVehicule")
    public String InsertVehicule(@ModelAttribute("Vehicule") @Validated Vehicule vehi,
                                 BindingResult bindingResult, Model model, HttpServletRequest request)
    {
        if(bindingResult.hasErrors()){
            model.addAttribute("Vehicule",new Vehicule());
            model.addAttribute("ListType",typeVehiculeService.findall());
            return "FormVehicule";
        }
        else
        {
            Vehicule vehicule=new Vehicule();
            vehicule.setMarque(request.getParameter("marque"));
            vehicule.setModel(request.getParameter("model"));
            vehicule.setNumero(request.getParameter("numero"));
            vehicule.setId_type(Integer.parseInt(request.getParameter("idTypeVehicule")));

            try {
                vehiculeService.save(vehicule);
                model.addAttribute("Vehicule",new Vehicule());
                model.addAttribute("success","vehicule ajouter avec success");
                model.addAttribute("ListType",typeVehiculeService.findall());
                return "FormVehicule";
            }catch (Exception e)
            {
                e.printStackTrace();
                model.addAttribute("error","une erreur est survenue");
                model.addAttribute("Vehicule",new Vehicule());
                model.addAttribute("ListType",typeVehiculeService.findall());
                return "FormVehicule";
            }
        }
    }

}
