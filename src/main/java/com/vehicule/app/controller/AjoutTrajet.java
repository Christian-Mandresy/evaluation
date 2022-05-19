package com.vehicule.app.controller;

import com.vehicule.app.model.Situation;
import com.vehicule.app.model.Trajet;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class AjoutTrajet {

    @Autowired
    private TrajetService service;

    @Autowired
    private VehiculeService vehiculeService;

    @RequestMapping(value = "/formAjout")
    public String FormAjout(Map<String, Object> modelMap)
    {
        modelMap.put("Trajet",new Trajet());
        modelMap.put("ListVehicule",vehiculeService.findall());
        return "FormTrajet";
    }

    @RequestMapping(value = "/AjoutTrajet")
    public String InsertVehicule(@ModelAttribute("Trajet") @Validated Trajet traje,
                                 BindingResult bindingResult, Model model, HttpServletRequest request) throws ParseException {
        if(bindingResult.hasErrors()){
            model.addAttribute("Trajet",new Trajet());
            model.addAttribute("ListVehicule",vehiculeService.findall());
            return "FormTrajet";
        }
        else
        {
            //HttpSession session =request.getSession();
            Trajet trajet=new Trajet();
            //trajet.setId_utilisateur((int)session.getAttribute("IdUtilisateur"));
            trajet.setId_utilisateur(1);
            trajet.setId_vehicule(Integer.parseInt(request.getParameter("id_vehicule")));
            trajet.setMotif(request.getParameter("motif"));
            trajet.setPrix_carburant(Float.parseFloat(request.getParameter("prix_carburant")));
            trajet.setQuantite_carburant(Float.parseFloat(request.getParameter("quantite_carburant")));
            Situation situation=new Situation();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            situation.setDate_heure(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
                    .parse(dtf.format(LocalDateTime.now())));
            situation.setKilometrage(Float.parseFloat(request.getParameter("kilometrage")));
            situation.setLieu(request.getParameter("lieu"));
            situation.setDepart(true);
            Set<Situation> situationList = new HashSet<Situation>();
            situationList.add(situation);
            trajet.setSituation(situationList);
            try {
                service.save(trajet);
                model.addAttribute("Trajet",new Trajet());
                model.addAttribute("ListVehicule",vehiculeService.findall());
                model.addAttribute("success","Trajet ajouter avec success");
                return "FormTrajet";
            }catch (Exception e)
            {
                e.printStackTrace();
                model.addAttribute("error","une erreur est survenue");
                model.addAttribute("Trajet",new Trajet());
                model.addAttribute("ListVehicule",vehiculeService.vehiculeDispo());
                return "FormTrajet";
            }
        }
    }
}
