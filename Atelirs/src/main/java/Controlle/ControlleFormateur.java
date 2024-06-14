package Controlle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import DAO.Formateur;
import Metier.EspaceFormateur;
@Controller
public class ControlleFormateur {
	Formateur form = new Formateur();
	@RequestMapping(value = "/Loginformateur", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("loginform", "user", new Formateur());
    }
    @RequestMapping(value = "/Formateur", method = RequestMethod.POST)
    public String submit(@ModelAttribute("user") Formateur  user, Model model) 	{
    	EspaceFormateur a = new EspaceFormateur();
    	form = user ;
    	if(a.authentify(user)) 
       	  {return "index";	}
       	else {return "loginform";}
    }
}
