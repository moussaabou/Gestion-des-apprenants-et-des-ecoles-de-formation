package Controlle;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DAO.Administrateur;
import DAO.personne;
import Metier.EspaceAdmin;

@Controller
public class ControlleAdministrateur {
	Administrateur admin = new Administrateur();
	@RequestMapping(value = "/Loginadmin", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("loginadmin", "user", new Administrateur ());
    }
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String submit(@ModelAttribute("user") Administrateur  user, Model model) 	{
    	EspaceAdmin a = new EspaceAdmin();
    	admin = user ;
    	if(a.authentify(user) == true)
    	      { 
    		ArrayList<String> cars = new ArrayList<String>() ;
            cars = a.formationadmin(admin);
            admin.setIdAdmin(Integer.valueOf(cars.get(0)));
            admin.setNom(cars.get(1));
            admin.setPrenom(cars.get(2));
            admin.setN_Telephone(cars.get(6));
            /* user == admin*/
    		model.addAttribute("nom", admin.getNom());
    		model.addAttribute("prenom", admin.getPrenom());
    		model.addAttribute("formature",a.option("formateur"));
    		model.addAttribute("apprenant",a.option("apprenant"));
    		model.addAttribute("etablissement",a.option("etablissement"));
    		model.addAttribute("offre_de_emploi",a.option("offre_de_emploi"));
    		model.addAttribute("formation",a.option("formation"));
/*     ----------------------------------------------------------------------------------------- */
              return "Admin";	}
    	else { model.addAttribute("a", "ERREUR");
    		return "loginadmin";}
    }
    @RequestMapping(value = "/Compteadmin", method = RequestMethod.GET)
    public ModelAndView compte(Model model) {
    	EspaceAdmin a = new EspaceAdmin();
    	model.addAttribute("nom", admin.getNom());
		model.addAttribute("prenom", admin.getPrenom());
		model.addAttribute("a", a.formationadmin(admin));
		
        return new ModelAndView("compteAdmin", "user", new Administrateur ());
    }
    @RequestMapping(value = "/Modiferadmin", method = RequestMethod.POST)
    public String Modiferadmin(@ModelAttribute("user") Administrateur  user, Model model) 	{
    	EspaceAdmin a = new EspaceAdmin();
    	model.addAttribute("nom", admin.getNom());
		model.addAttribute("prenom", admin.getPrenom());
    	admin = user ;
    	if(a.modifer(user)) { return "compteAdmin";	}
    	else { model.addAttribute("Eruure", "ERREUR");
    		return "compteAdmin";}
    }
    @RequestMapping(value = "/AdminGere", method = RequestMethod.GET)
    public ModelAndView option(Model model) {
    	model.addAttribute("nnom", admin.getNom());
		model.addAttribute("pprenom", admin.getPrenom());
    	EspaceAdmin a = new EspaceAdmin();
    	 model.addAttribute("id",a.GereApp("apprenant", "idApprenant"));
    	 model.addAttribute("nom",a.GereApp("apprenant", "Nom"));
    	 model.addAttribute("prenom",a.GereApp("apprenant", "prenom"));
    	 model.addAttribute("email",a.GereApp("apprenant", "Email"));
    	 model.addAttribute("n_tel",a.GereApp("apprenant", "N_Telephone"));
    	 model.addAttribute("pass",a.GereApp("apprenant", "pass"));
/*-------------------------------------------------------------------------------*/
    	 model.addAttribute("idF",a.GereApp("formateur", "idFormateur"));
    	 model.addAttribute("nomF",a.GereApp("formateur", "Nom"));
    	 model.addAttribute("prenomF",a.GereApp("formateur", "prenom"));
    	 model.addAttribute("emailF",a.GereApp("formateur", "Email"));
    	 model.addAttribute("n_telF",a.GereApp("formateur", "N_Telephone"));
    	 model.addAttribute("passF",a.GereApp("formateur", "pass"));
    	 /*-------------------------------------------------------------------------------*/
    	 model.addAttribute("idE",a.GereApp("etablissement", "idEtablissement"));
    	 model.addAttribute("nomE",a.GereApp("etablissement", "Nom"));
    	 model.addAttribute("prenomE",a.GereApp("etablissement", "prenom"));
    	 model.addAttribute("emailE",a.GereApp("etablissement", "Email"));
    	 model.addAttribute("n_telE",a.GereApp("etablissement", "N_Telephone"));
    	 model.addAttribute("passE",a.GereApp("etablissement", "pass"));
    	 model.addAttribute("diplomes",a.GereApp("etablissement", "diplomes"));
    	 model.addAttribute("Niveaux",a.GereApp("etablissement", "Niveaux"));
    	 model.addAttribute("region",a.GereApp("etablissement", "region"));
    	 model.addAttribute("filieres",a.GereApp("etablissement", "filieres"));
    	 model.addAttribute("ville",a.GereApp("etablissement", "ville"));
    	 /*-------------------------------------------------------------------------------*/
    	 return new ModelAndView("AdminGere", "user", new personne ());}
    @RequestMapping(value = "/AdminGereApp", method = RequestMethod.POST)
    public String AdminGereApp(@ModelAttribute("user") personne  user, Model model) 	{
    	EspaceAdmin a = new EspaceAdmin();
    	model.addAttribute("nnom", admin.getNom());
		model.addAttribute("pprenom", admin.getPrenom());
    	a.AjoutApp(user);
      	 /*-------------------------------------------------------------------------------*/
   	 model.addAttribute("id",a.GereApp("apprenant", "idApprenant"));
   	 model.addAttribute("nom",a.GereApp("apprenant", "Nom"));
   	 model.addAttribute("prenom",a.GereApp("apprenant", "prenom"));
   	 model.addAttribute("email",a.GereApp("apprenant", "Email"));
   	 model.addAttribute("n_tel",a.GereApp("apprenant", "N_Telephone"));
   	 model.addAttribute("pass",a.GereApp("apprenant", "pass"));    
   	/*-------------------------------------------------------------------------------*/
	 model.addAttribute("idF",a.GereApp("formateur", "idFormateur"));
	 model.addAttribute("nomF",a.GereApp("formateur", "Nom"));
	 model.addAttribute("prenomF",a.GereApp("formateur", "prenom"));
	 model.addAttribute("emailF",a.GereApp("formateur", "Email"));
	 model.addAttribute("n_telF",a.GereApp("formateur", "N_Telephone"));
	 model.addAttribute("passF",a.GereApp("formateur", "pass"));
	 /*-------------------------------------------------------------------------------*/
	 model.addAttribute("idE",a.GereApp("etablissement", "idEtablissement"));
	 model.addAttribute("nomE",a.GereApp("etablissement", "Nom"));
	 model.addAttribute("prenomE",a.GereApp("etablissement", "prenom"));
	 model.addAttribute("emailE",a.GereApp("etablissement", "Email"));
	 model.addAttribute("n_telE",a.GereApp("etablissement", "N_Telephone"));
	 model.addAttribute("passE",a.GereApp("etablissement", "pass"));
	 model.addAttribute("diplomes",a.GereApp("etablissement", "diplomes"));
	 model.addAttribute("Niveaux",a.GereApp("etablissement", "Niveaux"));
	 model.addAttribute("region",a.GereApp("etablissement", "region"));
	 model.addAttribute("filieres",a.GereApp("etablissement", "filieres"));
	 model.addAttribute("ville",a.GereApp("etablissement", "ville"));
	 /*-------------------------------------------------------------------------------*/
    	return "AdminGere"; }
    @RequestMapping(value = "/AdminGereAppSupp", method = RequestMethod.POST)
    public String AdminGereAppSupp(@ModelAttribute("user") personne  user, Model model) 	{
    	EspaceAdmin a = new EspaceAdmin();
    	model.addAttribute("nom", admin.getNom());
		model.addAttribute("prenom", admin.getPrenom());
    	a.suppApp(user);
      	 /*-------------------------------------------------------------------------------*/
   	 model.addAttribute("id",a.GereApp("apprenant", "idApprenant"));
   	 model.addAttribute("nom",a.GereApp("apprenant", "Nom"));
   	 model.addAttribute("prenom",a.GereApp("apprenant", "prenom"));
   	 model.addAttribute("email",a.GereApp("apprenant", "Email"));
   	 model.addAttribute("n_tel",a.GereApp("apprenant", "N_Telephone"));
   	 model.addAttribute("pass",a.GereApp("apprenant", "pass"));    
   	/*-------------------------------------------------------------------------------*/
	 model.addAttribute("idF",a.GereApp("formateur", "idFormateur"));
	 model.addAttribute("nomF",a.GereApp("formateur", "Nom"));
	 model.addAttribute("prenomF",a.GereApp("formateur", "prenom"));
	 model.addAttribute("emailF",a.GereApp("formateur", "Email"));
	 model.addAttribute("n_telF",a.GereApp("formateur", "N_Telephone"));
	 model.addAttribute("passF",a.GereApp("formateur", "pass"));
	 /*-------------------------------------------------------------------------------*/
	 model.addAttribute("idE",a.GereApp("etablissement", "idEtablissement"));
	 model.addAttribute("nomE",a.GereApp("etablissement", "Nom"));
	 model.addAttribute("prenomE",a.GereApp("etablissement", "prenom"));
	 model.addAttribute("emailE",a.GereApp("etablissement", "Email"));
	 model.addAttribute("n_telE",a.GereApp("etablissement", "N_Telephone"));
	 model.addAttribute("passE",a.GereApp("etablissement", "pass"));
	 model.addAttribute("diplomes",a.GereApp("etablissement", "diplomes"));
	 model.addAttribute("Niveaux",a.GereApp("etablissement", "Niveaux"));
	 model.addAttribute("region",a.GereApp("etablissement", "region"));
	 model.addAttribute("filieres",a.GereApp("etablissement", "filieres"));
	 model.addAttribute("ville",a.GereApp("etablissement", "ville"));
	 /*-------------------------------------------------------------------------------*/
    	return "AdminGere"; }
    @RequestMapping(value = "/AdminGereEtab", method = RequestMethod.POST)
    public String AdminGereEtab(@ModelAttribute("user") personne  user, Model model) 	{
    	EspaceAdmin a = new EspaceAdmin();
    	model.addAttribute("nom", admin.getNom());
		model.addAttribute("prenom", admin.getPrenom());
    	a.AjoutEtab(user);
    	/*-------------------------------------------------------------------------------*/
   	 model.addAttribute("idF",a.GereApp("formateur", "idFormateur"));
   	 model.addAttribute("nomF",a.GereApp("formateur", "Nom"));
   	 model.addAttribute("prenomF",a.GereApp("formateur", "prenom"));
   	 model.addAttribute("emailF",a.GereApp("formateur", "Email"));
   	 model.addAttribute("n_telF",a.GereApp("formateur", "N_Telephone"));
   	 model.addAttribute("passF",a.GereApp("formateur", "pass"));
   	 /*-------------------------------------------------------------------------------*/
   	 model.addAttribute("idE",a.GereApp("etablissement", "idEtablissement"));
   	 model.addAttribute("nomE",a.GereApp("etablissement", "Nom"));
   	 model.addAttribute("prenomE",a.GereApp("etablissement", "prenom"));
   	 model.addAttribute("emailE",a.GereApp("etablissement", "Email"));
   	 model.addAttribute("n_telE",a.GereApp("etablissement", "N_Telephone"));
   	 model.addAttribute("passE",a.GereApp("etablissement", "pass"));
   	 model.addAttribute("diplomes",a.GereApp("etablissement", "diplomes"));
   	 model.addAttribute("Niveaux",a.GereApp("etablissement", "Niveaux"));
   	 model.addAttribute("region",a.GereApp("etablissement", "region"));
   	 model.addAttribute("filieres",a.GereApp("etablissement", "filieres"));
   	 model.addAttribute("ville",a.GereApp("etablissement", "ville"));
   	 /*-------------------------------------------------------------------------------*/
   	 model.addAttribute("id",a.GereApp("apprenant", "idApprenant"));
   	 model.addAttribute("nom",a.GereApp("apprenant", "Nom"));
   	 model.addAttribute("prenom",a.GereApp("apprenant", "prenom"));
   	 model.addAttribute("email",a.GereApp("apprenant", "Email"));
   	 model.addAttribute("n_tel",a.GereApp("apprenant", "N_Telephone"));
   	 model.addAttribute("pass",a.GereApp("apprenant", "pass")); 
   	 /*-------------------------------------------------------------------------------*/
      return "AdminGere"; }
   
    	 @RequestMapping(value = "/AdminGereEtabSupp", method = RequestMethod.POST)
    	    public String AdminGereEtabSupp(@ModelAttribute("user") personne  user, Model model) 	{
    	    	EspaceAdmin a = new EspaceAdmin();
    	    	model.addAttribute("nom", admin.getNom());
        		model.addAttribute("prenom", admin.getPrenom());
    	    	 a.suppEtab(user);
    	    	/*-------------------------------------------------------------------------------*/
    	   	 model.addAttribute("idF",a.GereApp("formateur", "idFormateur"));
    	   	 model.addAttribute("nomF",a.GereApp("formateur", "Nom"));
    	   	 model.addAttribute("prenomF",a.GereApp("formateur", "prenom"));
    	   	 model.addAttribute("emailF",a.GereApp("formateur", "Email"));
    	   	 model.addAttribute("n_telF",a.GereApp("formateur", "N_Telephone"));
    	   	 model.addAttribute("passF",a.GereApp("formateur", "pass"));
    	   	 /*-------------------------------------------------------------------------------*/
    	   	 model.addAttribute("idE",a.GereApp("etablissement", "idEtablissement"));
    	   	 model.addAttribute("nomE",a.GereApp("etablissement", "Nom"));
    	   	 model.addAttribute("prenomE",a.GereApp("etablissement", "prenom"));
    	   	 model.addAttribute("emailE",a.GereApp("etablissement", "Email"));
    	   	 model.addAttribute("n_telE",a.GereApp("etablissement", "N_Telephone"));
    	   	 model.addAttribute("passE",a.GereApp("etablissement", "pass"));
    	   	 model.addAttribute("diplomes",a.GereApp("etablissement", "diplomes"));
    	   	 model.addAttribute("Niveaux",a.GereApp("etablissement", "Niveaux"));
    	   	 model.addAttribute("region",a.GereApp("etablissement", "region"));
    	   	 model.addAttribute("filieres",a.GereApp("etablissement", "filieres"));
    	   	 model.addAttribute("ville",a.GereApp("etablissement", "ville"));
    	   	 /*-------------------------------------------------------------------------------*/
    	   	 model.addAttribute("id",a.GereApp("apprenant", "idApprenant"));
    	   	 model.addAttribute("nom",a.GereApp("apprenant", "Nom"));
    	   	 model.addAttribute("prenom",a.GereApp("apprenant", "prenom"));
    	   	 model.addAttribute("email",a.GereApp("apprenant", "Email"));
    	   	 model.addAttribute("n_tel",a.GereApp("apprenant", "N_Telephone"));
    	   	 model.addAttribute("pass",a.GereApp("apprenant", "pass"));    
    	   	 /*-------------------------------------------------------------------------------*/
    	    	return "AdminGere";}
    @RequestMapping(value = "/AdminGereForm", method = RequestMethod.POST)
    public String AdminGereFrom(@ModelAttribute("user") personne  user, Model model) 	{
    	EspaceAdmin a = new EspaceAdmin();
    	model.addAttribute("nom", admin.getNom());
		model.addAttribute("prenom", admin.getPrenom());
    	a.AjoutFrom(user);
    	/*-------------------------------------------------------------------------------*/
   	 model.addAttribute("idF",a.GereApp("formateur", "idFormateur"));
   	 model.addAttribute("nomF",a.GereApp("formateur", "Nom"));
   	 model.addAttribute("prenomF",a.GereApp("formateur", "prenom"));
   	 model.addAttribute("emailF",a.GereApp("formateur", "Email"));
   	 model.addAttribute("n_telF",a.GereApp("formateur", "N_Telephone"));
   	 model.addAttribute("passF",a.GereApp("formateur", "pass"));
   	 /*-------------------------------------------------------------------------------*/
   	 model.addAttribute("idE",a.GereApp("etablissement", "idEtablissement"));
   	 model.addAttribute("nomE",a.GereApp("etablissement", "Nom"));
   	 model.addAttribute("prenomE",a.GereApp("etablissement", "prenom"));
   	 model.addAttribute("emailE",a.GereApp("etablissement", "Email"));
   	 model.addAttribute("n_telE",a.GereApp("etablissement", "N_Telephone"));
   	 model.addAttribute("passE",a.GereApp("etablissement", "pass"));
   	 model.addAttribute("diplomes",a.GereApp("etablissement", "diplomes"));
   	 model.addAttribute("Niveaux",a.GereApp("etablissement", "Niveaux"));
   	 model.addAttribute("region",a.GereApp("etablissement", "region"));
   	 model.addAttribute("filieres",a.GereApp("etablissement", "filieres"));
   	 model.addAttribute("ville",a.GereApp("etablissement", "ville"));
   	 /*-------------------------------------------------------------------------------*/
   	 model.addAttribute("id",a.GereApp("apprenant", "idApprenant"));
   	 model.addAttribute("nom",a.GereApp("apprenant", "Nom"));
   	 model.addAttribute("prenom",a.GereApp("apprenant", "prenom"));
   	 model.addAttribute("email",a.GereApp("apprenant", "Email"));
   	 model.addAttribute("n_tel",a.GereApp("apprenant", "N_Telephone"));
   	 model.addAttribute("pass",a.GereApp("apprenant", "pass"));    
   	 /*-------------------------------------------------------------------------------*/
    	return "AdminGere";}
    	 @RequestMapping(value = "/AdminGereFormSupp", method = RequestMethod.POST)
    	    public String AdminGereFromSupp(@ModelAttribute("user") personne  user, Model model) 	{
    	    	EspaceAdmin a = new EspaceAdmin();
    	    	model.addAttribute("nom", admin.getNom());
        		model.addAttribute("prenom", admin.getPrenom());
    	    	 a.suppFrom(user);
    	    	/*-------------------------------------------------------------------------------*/
    	   	 model.addAttribute("idF",a.GereApp("formateur", "idFormateur"));
    	   	 model.addAttribute("nomF",a.GereApp("formateur", "Nom"));
    	   	 model.addAttribute("prenomF",a.GereApp("formateur", "prenom"));
    	   	 model.addAttribute("emailF",a.GereApp("formateur", "Email"));
    	   	 model.addAttribute("n_telF",a.GereApp("formateur", "N_Telephone"));
    	   	 model.addAttribute("passF",a.GereApp("formateur", "pass"));
    	   	 /*-------------------------------------------------------------------------------*/
    	   	 model.addAttribute("idE",a.GereApp("etablissement", "idEtablissement"));
    	   	 model.addAttribute("nomE",a.GereApp("etablissement", "Nom"));
    	   	 model.addAttribute("prenomE",a.GereApp("etablissement", "prenom"));
    	   	 model.addAttribute("emailE",a.GereApp("etablissement", "Email"));
    	   	 model.addAttribute("n_telE",a.GereApp("etablissement", "N_Telephone"));
    	   	 model.addAttribute("passE",a.GereApp("etablissement", "pass"));
    	   	 model.addAttribute("diplomes",a.GereApp("etablissement", "diplomes"));
    	   	 model.addAttribute("Niveaux",a.GereApp("etablissement", "Niveaux"));
    	   	 model.addAttribute("region",a.GereApp("etablissement", "region"));
    	   	 model.addAttribute("filieres",a.GereApp("etablissement", "filieres"));
    	   	 model.addAttribute("ville",a.GereApp("etablissement", "ville"));
    	   	 /*-------------------------------------------------------------------------------*/
    	   	 model.addAttribute("id",a.GereApp("apprenant", "idApprenant"));
    	   	 model.addAttribute("nom",a.GereApp("apprenant", "Nom"));
    	   	 model.addAttribute("prenom",a.GereApp("apprenant", "prenom"));
    	   	 model.addAttribute("email",a.GereApp("apprenant", "Email"));
    	   	 model.addAttribute("n_tel",a.GereApp("apprenant", "N_Telephone"));
    	   	 model.addAttribute("pass",a.GereApp("apprenant", "pass"));    
    	   	 /*-------------------------------------------------------------------------------*/
    	    	return "AdminGere";}
    	 @RequestMapping(value = "/AdminStat", method = RequestMethod.GET)
    	    public ModelAndView adminStat(Model model) {
    		 EspaceAdmin a = new EspaceAdmin();
    	    	model.addAttribute("nom", admin.getNom());
    			model.addAttribute("prenom", admin.getPrenom());
    	        return new ModelAndView("AdminStat", "user", new Administrateur ());
    	    }
}

