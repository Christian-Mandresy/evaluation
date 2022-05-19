package com.vehicule.app.controller;

import com.vehicule.app.model.Trajet;
import com.vehicule.app.model.Vehicule;
import com.vehicule.app.service.TrajetService;
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
public class AjoutTrajet {

    @Autowired
    private TrajetService service;

    @Autowired
    private VehiculeService vehiculeService;

    @RequestMapping(value = "/formAjout")
    public String FormAjout(Map<String, Object> modelMap)
    {
        modelMap.put("Vehicule",new Trajet());
        modelMap.put("ListType",vehiculeService.findall());
        return "FormTrajet";
    }

    @RequestMapping(value = "/InsertVehicule")
    public String InsertVehicule(@ModelAttribute("Trajet") @Validated Trajet traje,
                                 BindingResult bindingResult, Model model, HttpServletRequest request)
    {
        if(bindingResult.hasErrors()){
            model.addAttribute("Vehicule",new Trajet());
            model.addAttribute("ListType",vehiculeService.findall());
            return "FormTrajet";
        }
        else
        {
            HttpSession session =request.getSession();
            Trajet trajet=new Trajet();
            trajet.setId_utilisateur((int)session.getAttribute("IdUtilisateur"));
            trajet.setId_vehicule(Integer.parseInt(request.getParameter("id_vehicule")));
            trajet.setMotif(request.getParameter("motif"));
            trajet.setPrix_carburant(Float.parseFloat(request.getParameter("prix_carburant")));
            trajet.setQuantite_carburant(Float.parseFloat(request.getParameter("quantite_carburant")));

            try {
                service.save(trajet);
                model.addAttribute("Vehicule",new Trajet());
                model.addAttribute("ListType",vehiculeService.findall());
                model.addAttribute("success","Trajet ajouter avec success");
                return "FormTrajet";
            }catch (Exception e)
            {
                e.printStackTrace();
                model.addAttribute("error","une erreur est survenue");
                model.addAttribute("Vehicule",new Trajet());
                model.addAttribute("ListType",vehiculeService.findall());
                return "FormTrajet";
            }
        }
    }
}
