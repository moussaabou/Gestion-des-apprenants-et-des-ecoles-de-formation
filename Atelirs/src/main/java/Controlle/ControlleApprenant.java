package Controlle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import DAO.Apprenant;
import DAO.personne;
import Metier.EspaceApprenant;
@Controller
public class ControlleApprenant {
	Apprenant app = new Apprenant();
	@RequestMapping(value = "/Loginapprenant", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("loginapper", "user", new Apprenant());
    }
    @RequestMapping(value = "/Apprenant", method = RequestMethod.POST)
    public String submit(@ModelAttribute("user") Apprenant  user, Model model) 	{
    	EspaceApprenant a = new EspaceApprenant();
    	app = user ;
    	if(a.authentify(user)) 
    	{ return "index";	}
       	else {return "loginapper";}
    }
}
