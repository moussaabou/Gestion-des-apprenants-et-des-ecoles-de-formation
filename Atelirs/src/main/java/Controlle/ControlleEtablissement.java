package Controlle;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DAO.Apprenant;
import DAO.Etablissement;
import DAO.Formation;
import DAO.Offre_de_emploi;
import DAO.personne;
import Metier.EspaceApprenant;
import Metier.EspaceEtablissement;
@Controller
public class ControlleEtablissement {
	ArrayList<String> cars = new ArrayList<String>() ;
	
	Etablissement etab = new Etablissement();
	@RequestMapping(value = "/Loginetablissement", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("loginetabl", "user", new Etablissement());
    }
    @RequestMapping(value = "/Etablissement", method = RequestMethod.POST)
    public String submit(@ModelAttribute("user") Etablissement  user, Model model) 	{
    	EspaceEtablissement a = new EspaceEtablissement();
    	etab = user ;
    	if(a.authentify(user))
    	{  cars = a.formationEtablissement(user);
    	etab.setIdEtablissement(Integer.valueOf(cars.get(0)));;
    	etab.setNom(cars.get(1));
    	etab.setPrenom(cars.get(2));
    	etab.setEmail(cars.get(3));
    	etab.setPass(cars.get(4));
    	etab.setN_Telephone(cars.get(6));
    	model.addAttribute("nom", etab.getNom());
    	model.addAttribute("prenom", etab.getPrenom());
    	 model.addAttribute("id",a.option("idFormation", cars.get(0)));
         model.addAttribute("NomFormatio",a.option("NomFormatio", cars.get(0)));
         model.addAttribute("Niveaux",a.option("Niveaux" ,cars.get(0)));
         model.addAttribute("idFormateur",a.option("idFormateur" ,cars.get(0)));
         model.addAttribute("Prix",a.option("Prix" ,cars.get(0)));
         model.addAttribute("date_fin",a.option("date_fin", cars.get(0)));
         model.addAttribute("date_debut",a.option("date_debut" ,cars.get(0)));
    	
    		return "Etablissement";	}
       	else {return "loginetabl";}
    }
	@RequestMapping(value = "/Offer_emploi", method = RequestMethod.GET)
    public ModelAndView emploi1(Model model) {
		model.addAttribute("nom", etab.getNom());
    	model.addAttribute("prenom", etab.getPrenom());
        return new ModelAndView("Addemploi", "user", new Offre_de_emploi());
    }
    @RequestMapping(value = "/addemploi", method = RequestMethod.POST)
    public String emploi(@ModelAttribute("user") Offre_de_emploi  user, Model model) 	{
    	model.addAttribute("nom", etab.getNom());
    	model.addAttribute("prenom", etab.getPrenom());
    	EspaceEtablissement a = new EspaceEtablissement();
    	if(a.addEmploie(user , etab)) 
    	{ return "Addemploi";	}
       	else {
    		model.addAttribute("a","Erreur");
       		return "Addemploi";}
    }
    @RequestMapping(value = "/EtabComp", method = RequestMethod.GET)
    public ModelAndView EtabComp(Model model) {
		model.addAttribute("nom", etab.getNom());
    	model.addAttribute("prenom", etab.getPrenom());
    	model.addAttribute("a",cars );
    	/*--------------------------------------------*/
        return new ModelAndView("EtabComp", "user", new Etablissement());
    }
    @RequestMapping(value = "/EtabModComp", method = RequestMethod.POST)
    public String EtabModComp(@ModelAttribute("user") Etablissement user, Model model) 	{
    	model.addAttribute("nom", etab.getNom());
    	model.addAttribute("prenom", etab.getPrenom());
    	EspaceEtablissement a = new EspaceEtablissement();
    	if(a.ModifEtab(user)) {
    	 return "EtabComp";	}
    	else {model.addAttribute("Errure", "Errure");
    		return "EtabComp";}
    }
    @RequestMapping(value = "/EtabAddf", method = RequestMethod.GET)
    public ModelAndView AddFormation(Model model) {
		model.addAttribute("nom", etab.getNom());
    	model.addAttribute("prenom", etab.getPrenom());
        return new ModelAndView("EtabAddf", "user",new Formation  ());
        }
    @RequestMapping(value = "/EtabAddform", method = RequestMethod.POST)
    public String EtabAddForm(@ModelAttribute("user") Formation user, Model model) 	{
    	model.addAttribute("nom", etab.getNom());
    	model.addAttribute("prenom", etab.getPrenom());
    	EspaceEtablissement a = new EspaceEtablissement();
    	a.addFormation(user, cars.get(0));
    	 return "EtabAddf";	    	
    }
    @RequestMapping(value = "/EtabGere", method = RequestMethod.GET)
    public ModelAndView EtabGere(Model model) {
    	EspaceEtablissement a = new EspaceEtablissement();
		model.addAttribute("nom", etab.getNom());
    	model.addAttribute("prenom", etab.getPrenom());
    	 model.addAttribute("id",a.option("idFormation", cars.get(0)));
         model.addAttribute("NomFormatio",a.option("NomFormatio", cars.get(0)));
         model.addAttribute("Niveaux",a.option("Niveaux" ,cars.get(0)));
         model.addAttribute("idFormateur",a.option("idFormateur" ,cars.get(0)));
         model.addAttribute("Prix",a.option("Prix" ,cars.get(0)));
         model.addAttribute("date_fin",a.option("date_fin", cars.get(0)));
         model.addAttribute("date_debut",a.option("date_debut" ,cars.get(0)));
        return new ModelAndView("EtabGere", "user", new Formation());
        }
    @RequestMapping(value = "/EtabformModf", method = RequestMethod.POST)
    public String EtabformModf(@ModelAttribute("user") Formation user, Model model) 	{
    	EspaceEtablissement a = new EspaceEtablissement();
    	a.ModifEtabForm(user);
    	model.addAttribute("nom", etab.getNom());
    	model.addAttribute("prenom", etab.getPrenom());
    	 model.addAttribute("id",a.option("idFormation", cars.get(0)));
         model.addAttribute("NomFormatio",a.option("NomFormatio", cars.get(0)));
         model.addAttribute("Niveaux",a.option("Niveaux" ,cars.get(0)));
         model.addAttribute("idFormateur",a.option("idFormateur" ,cars.get(0)));
         model.addAttribute("Prix",a.option("Prix" ,cars.get(0)));
         model.addAttribute("date_fin",a.option("date_fin", cars.get(0)));
         model.addAttribute("date_debut",a.option("date_debut" ,cars.get(0)));
    	return "EtabGere";
    }
    @RequestMapping(value = "/EtabformSupp", method = RequestMethod.POST)
    public String EtabformSupp(@ModelAttribute("user") Formation user, Model model) 	{
    	EspaceEtablissement a = new EspaceEtablissement();      	 
    	/*-------------------------------------------------------------------------------*/
    	a.suppFormation(user.getId());
    	model.addAttribute("nom", etab.getNom());
    	model.addAttribute("prenom", etab.getPrenom());
    	 model.addAttribute("id",a.option("idFormation", cars.get(0)));
         model.addAttribute("NomFormatio",a.option("NomFormatio", cars.get(0)));
         model.addAttribute("Niveaux",a.option("Niveaux" ,cars.get(0)));
         model.addAttribute("idFormateur",a.option("idFormateur" ,cars.get(0)));
         model.addAttribute("Prix",a.option("Prix" ,cars.get(0)));
         model.addAttribute("date_fin",a.option("date_fin", cars.get(0)));
         model.addAttribute("date_debut",a.option("date_debut" ,cars.get(0)));
      	 /*-------------------------------------------------------------------------------*/
                     return "EtabGere";
    }
}



