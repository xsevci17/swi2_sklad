/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.mendelu.seminar.swi.mvc.controllers;

import cz.mendelu.seminar.swi.domain.CustomerEntity;
import cz.mendelu.seminar.swi.sampledata.SampleDataConfig;
import cz.mendelu.seminar.swi.service.CustomerService;
import cz.mendelu.seminar.swi.service.config.ServiceConfiguration;

import java.security.Principal;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 *
 * @author admin
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {
    
    //final static Logger log = LoggerFactory.getLogger(CustomerController.class);
    
    @Autowired
    CustomerService customerService;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String customers(Model model, Principal principal) {
        /*log.info("Pokemons = {}", pokemonFacade.getAllPokemons());

        String trainerName = principal.getName();

        List<PokemonDTO> pokemonDTOs = pokemonFacade.getAllPokemons();
        List<PokemonDTO> result = new ArrayList<>();
        for (PokemonDTO p : pokemonDTOs) {
            if (p.getTrainer().getEmail().equals(trainerName)) {
                result.add(p);
            }
        }*/

        List<CustomerEntity> result = customerService.findAll();
        model.addAttribute("customers", result);
        return "customer/list";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable int id){
        //log.debug("Edit existing pokemon");
        /*
        PokemonEditDTO pok=new PokemonEditDTO();
        
        PokemonDTO existPok=pokemonFacade.getPokemonWithId(id);
        pok.setId(id);
        pok.setNickname(existPok.getNickname());
        */
        
        CustomerEntity tmpCust = customerService.findById(id);       
        model.addAttribute("editCustomer", tmpCust);
        return "customer/edit";
    }
    
}
