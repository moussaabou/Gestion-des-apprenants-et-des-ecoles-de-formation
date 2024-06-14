package Controlle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import DAO.Apprenant;
import DAO.Etablissement;
import DAO.Formateur;
import DAO.Formation;
import DAO.Offre_de_emploi;
import DAO.personne;
import Metier.EspaceApprenant;
import Metier.EspaceEtablissement;
import Metier.EspaceFormateur;

@Controller
public class Controlle {
	private List<Formation> msgs = new ArrayList<Formation>();

		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/").setViewName("index");
			registry.addViewController("/AdminGere").setViewName("AdminGere");
			
		}
		@RequestMapping(value = "/inscrire", method = RequestMethod.GET)
	    public ModelAndView showForm() {
	        return new ModelAndView("inscription", "user", new personne ());
	    }
	    @RequestMapping(value = "/inscriptionApp", method = RequestMethod.POST)
	    public String submita(@ModelAttribute("user") personne  user, Model model) 	{
	     if(user.getPass().equals(user.getPassconf())) {
	    	 EspaceApprenant a = new EspaceApprenant();
	    		if(a.addUser (user)) {
	    			model.addAttribute("nom",user.getNom());
	  	    	  model.addAttribute("prenom", user.getPrenom());
	    		    return "views" ;} }
	    	return "inscription";}
	    
	    @RequestMapping(value = "/inscriptionEtab", method = RequestMethod.POST)
	    public String submite(@ModelAttribute("user") Etablissement user, Model model) 	{
		     if(user.getPass().equals(user.getPassconf())) {
		    	 EspaceEtablissement e = new EspaceEtablissement();
		    		if(e.addUser(user)) {
		    			model.addAttribute("nom",user.getNom());
			  	    	  model.addAttribute("prenom", user.getPrenom());
		    		    return "views" ;}}
		    	return "inscription";}
	    @RequestMapping(value = "/inscriptionFor", method = RequestMethod.POST)
	    public String submitf(@ModelAttribute("user") Formateur user, Model model) 	{
		     if(user.getPass().equals(user.getPassconf())) {
		    	 EspaceFormateur f = new EspaceFormateur();
		    		if(f.addUser(user)) {
		    			model.addAttribute("nom",user.getNom());
			  	    	model.addAttribute("prenom", user.getPrenom());
		    		    return "views" ;}}
		    	return "inscription";}
	    
	    @GetMapping(value ="/info")
		public String option(Model model) {
	    	EspaceApprenant a = new EspaceApprenant();
            model.addAttribute("id",a.option("idFormation"));
            model.addAttribute("NomFormatio",a.option("NomFormatio"));
            model.addAttribute("Niveaux",a.option("Niveaux"));
            model.addAttribute("idFormateur",a.option("idFormateur"));
            model.addAttribute("Prix",a.option("Prix"));
            model.addAttribute("date_fin",a.option("date_fin"));
            model.addAttribute("date_debut",a.option("date_debut"));

	    	return "info";
	    }
	    @GetMapping(value ="/infoemploi")
		public String optionemploi(Model model) {
	    	EspaceApprenant a = new EspaceApprenant();
            model.addAttribute("id",a.optionemploi("idoffre_de_emploi"));
            model.addAttribute("Nom_emploi",a.optionemploi("Nom_emploi"));
            model.addAttribute("Niveaux",a.optionemploi("Niveaux"));
            model.addAttribute("abbr",a.optionemploi("abbr"));

	    	return "infoemploi";
	    }
	    @RequestMapping(value = "/OffreDeEtab", method = RequestMethod.GET)
		public ModelAndView option1(Model model) {
	    	EspaceApprenant a = new EspaceApprenant();
            model.addAttribute("id",a.optionEtab("idEtablissement"));
            model.addAttribute("Nom",a.optionEtab("Nom"));
            model.addAttribute("prenom",a.optionEtab("prenom"));
            model.addAttribute("n_tel",a.optionEtab("n_tel"));
            model.addAttribute("email",a.optionEtab("email"));
            model.addAttribute("ville",a.optionEtab("ville"));
            model.addAttribute("filieres",a.optionEtab("filieres"));
            model.addAttribute("region",a.optionEtab("region"));
            model.addAttribute("Niveaux",a.optionEtab("Niveaux"));
            model.addAttribute("diplomes",a.optionEtab("diplomes"));
            return new ModelAndView("OffreDeEtab", "user", new personne());	    }
	    @RequestMapping(value = "/OffreDeEtabR", method = RequestMethod.POST)
	    public String OffreDeEtab(@ModelAttribute("user") personne user, Model model) 	{
	    	EspaceApprenant a = new EspaceApprenant();
	    	if(user.getRegion().equals("0") && user.getDiplomes().equals("0")) {
	    		model.addAttribute("id",a.optionEtabV("idEtablissement" ,user.getVille()));
	            model.addAttribute("Nom",a.optionEtabV("Nom", user.getVille()));
	            model.addAttribute("prenom",a.optionEtabV("prenom", user.getVille()));
	            model.addAttribute("n_tel",a.optionEtabV("n_tel", user.getVille()));
	            model.addAttribute("email",a.optionEtabV("email", user.getVille()));
	            model.addAttribute("ville",a.optionEtabV("ville", user.getVille()));
	            model.addAttribute("filieres",a.optionEtabV("filieres",user.getVille()));
	            model.addAttribute("region",a.optionEtabV("region", user.getVille()));
	            model.addAttribute("Niveaux",a.optionEtabV("Niveaux",user.getVille()));
	            model.addAttribute("diplomes",a.optionEtabV("diplomes",user.getVille()));
	            return "OffreDeEtab";
	    	}
	    	 if(user.getVille().equals("0") && user.getDiplomes().equals("0")) 
	    	{model.addAttribute("id",a.optionEtabR("idEtablissement" , user.getRegion()));
            model.addAttribute("Nom",a.optionEtabV("Nom", user.getRegion()));
            model.addAttribute("prenom",a.optionEtabR("prenom", user.getRegion()));
            model.addAttribute("n_tel",a.optionEtabR("n_tel", user.getRegion()));
            model.addAttribute("email",a.optionEtabR("email", user.getRegion()));
            model.addAttribute("ville",a.optionEtabR("ville", user.getRegion()));
            model.addAttribute("filieres",a.optionEtabR("filieres", user.getRegion()));
            model.addAttribute("region",a.optionEtabR("region", user.getRegion()));
            model.addAttribute("Niveaux",a.optionEtabR("Niveaux", user.getRegion()));
            model.addAttribute("diplomes",a.optionEtabR("diplomes", user.getRegion()));
            return "OffreDeEtab";}
	    	if (user.getDiplomes().equals("0")) 
	    	{ model.addAttribute("id",a.optionEtabVR("idEtablissement" , user.getRegion() ,user.getVille()));
            model.addAttribute("Nom",a.optionEtabVR("Nom", user.getRegion() ,user.getVille()));
            model.addAttribute("prenom",a.optionEtabVR("prenom", user.getRegion() ,user.getVille()));
            model.addAttribute("n_tel",a.optionEtabVR("n_tel", user.getRegion() ,user.getVille()));
            model.addAttribute("email",a.optionEtabVR("email", user.getRegion() ,user.getVille()));
            model.addAttribute("ville",a.optionEtabVR("ville", user.getRegion() ,user.getVille()));
            model.addAttribute("filieres",a.optionEtabVR("filieres", user.getRegion() ,user.getVille()));
            model.addAttribute("region",a.optionEtabVR("region", user.getRegion() ,user.getVille()));
            model.addAttribute("Niveaux",a.optionEtabVR("Niveaux", user.getRegion() ,user.getVille()));
            model.addAttribute("diplomes",a.optionEtabVR("diplomes", user.getRegion() ,user.getVille()));
            return "OffreDeEtab";}
	    	if (user.getVille().equals("0") && user.getRegion().equals("0"))
	    	{ model.addAttribute("id",a.optionEtabD("idEtablissement" , user.getDiplomes()));
            model.addAttribute("Nom",a.optionEtabD("Nom",user.getDiplomes()));
            model.addAttribute("prenom",a.optionEtabD("prenom", user.getDiplomes()));
            model.addAttribute("n_tel",a.optionEtabD("n_tel",user.getDiplomes()));
            model.addAttribute("email",a.optionEtabD("email",user.getDiplomes()));
            model.addAttribute("ville",a.optionEtabD("ville", user.getDiplomes()));
            model.addAttribute("filieres",a.optionEtabD("filieres", user.getDiplomes()));
            model.addAttribute("region",a.optionEtabD("region",user.getDiplomes()));
            model.addAttribute("Niveaux",a.optionEtabD("Niveaux", user.getDiplomes()));
            model.addAttribute("diplomes",a.optionEtabD("diplomes", user.getDiplomes()));
	    	return "OffreDeEtab";}
/* --------------------------------- All -----------------------------*/
	    	if(user.getVille().equals("0") && user.getRegion().equals("0") && user.getDiplomes().equals("0"))
	    			{ model.addAttribute("id",a.optionEtab("idEtablissement"));
	                model.addAttribute("Nom",a.optionEtab("Nom"));
	                model.addAttribute("prenom",a.optionEtab("prenom"));
	                model.addAttribute("n_tel",a.optionEtab("n_tel"));
	                model.addAttribute("email",a.optionEtab("email"));
	                model.addAttribute("ville",a.optionEtab("ville"));
	                model.addAttribute("filieres",a.optionEtab("filieres"));
	                model.addAttribute("region",a.optionEtab("region"));
	                model.addAttribute("Niveaux",a.optionEtab("Niveaux"));
	                model.addAttribute("diplomes",a.optionEtab("diplomes"));
	            return "OffreDeEtab";}
	    	return "OffreDeEtab";
	    }
	    }
