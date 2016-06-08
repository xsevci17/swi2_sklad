package cz.mendelu.seminar.swi.mvc.controllers;


//import cz.fi.muni.pa165.seminar.pkmnleague.facade.BadgeFacade;
//import cz.fi.muni.pa165.seminar.pkmnleague.facade.TrainerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




/**
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
@Controller
@RequestMapping("/")
public class HomepageController {



    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        
        return "home";
    }

}
