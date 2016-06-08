package cz.mendelu.seminar.swi.sampledata;

import cz.mendelu.seminar.swi.domain.*;
import cz.mendelu.seminar.swi.service.AddressService;
import cz.mendelu.seminar.swi.service.CustomerService;
/*
import cz.mendelu.seminar.swi.service.GymService;
import cz.mendelu.seminar.swi.service.PokemonService;
import cz.mendelu.seminar.swi.service.TrainerService;
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Pavel Kouřil <pk@pavelkouril.cz>
 */
@Component
@Transactional
public class SampleData {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    /*
    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private GymService gymService;

    @Autowired
    private BadgeService badgeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    */
    
    public void loadData() {
        customer("Vit", "Sevcik", new Date(), 585858, address("Brno", "Jostova", 589));
        customer("Martyn", "Zaboy", new Date(), 969696, address("Praha", "Kernerova", 458));
        /*
        Trainer red = trainer("Red", "red@example.com", "heslo", new Date(90, 8, 24));
        Trainer blue = trainer("Blue", "blue@example.com", "heslo", new Date(96, 9, 1));
        Trainer brock = trainer("Brock", "brock@example.com", "heslo", new Date(99, 12, 12));
        Trainer misty = trainer("Misty", "misty@example.com", "heslo", new Date(101, 5, 26));

        pokemon(red, 25, "Pikachu", PokemonType.ELECTRIC, 88);
        pokemon(red, 131, "Lapras", PokemonType.WATER, PokemonType.ICE, 80);
        pokemon(red, 143, "Snorlax", PokemonType.NORMAL, 88);
        pokemon(red, 3, "Venusaur", PokemonType.GRASS, PokemonType.POISON, 84);
        pokemon(red, 6, "Charizard", PokemonType.FIRE, PokemonType.FLYING, 84);
        pokemon(red, 9, "Blastoise", PokemonType.WATER, 84);

        pokemon(blue, 103, "Exeggutor", PokemonType.GRASS, PokemonType.PSYCHIC, 55);
        pokemon(blue, 59, "Arcaine", PokemonType.FIRE, 58);
        pokemon(blue, 130, "Gyarados", PokemonType.WATER, PokemonType.FLYING, 52);

        pokemon(brock, 74, "Geodude", PokemonType.ROCK, PokemonType.GROUND, 12);
        pokemon(brock, 95, "Onyx", PokemonType.ROCK, PokemonType.GROUND, 14);

        pokemon(misty, 120, "Staryu", PokemonType.WATER, 18);
        pokemon(misty, 121, "Starmie", PokemonType.WATER, PokemonType.PSYCHIC, 21);

        Gym viridianGym = gym("Viridian City", PokemonType.GROUND, blue);
        Gym pewterGym = gym("Pewter City", PokemonType.ROCK, brock);
        Gym ceruleanGym = gym("Cerulean City", PokemonType.WATER, misty);

        badge(viridianGym, red);
        badge(pewterGym, red);
        badge(ceruleanGym, blue);
        */
    }

    private CustomerEntity customer(String aName, String aSurName, Date aDate, int aIco, AddressEntity aAddress) {
        //AddressEntity tmpAdr = new AddressEntity("mesto", "street", 589);               
        CustomerEntity p = new CustomerEntity(aAddress, aName, aSurName, aDate, aIco);
        customerService.save(p);
        return p;
    }

    private AddressEntity address(String aCity, String aStreet, int aHouseNumber) {
        AddressEntity tmpAdr = new AddressEntity(aCity, aStreet, aHouseNumber);
        addressService.save(tmpAdr);
        return tmpAdr;
    }
    
    /*
    private Trainer trainer(String fullName, String email, String password, Date dateOfBirth) {
        Trainer t = new Trainer(fullName, email, passwordEncoder.encode(password), dateOfBirth);
        trainerService.create(t);
        return t;
    }

    private Pokemon pokemon(Trainer trainer, int speciesId, String speciesName, PokemonType primaryType, int level) {
        Pokemon p = new Pokemon(trainer, speciesId, speciesName, primaryType, level);
        pokemonService.create(p);
        return p;
    }

    private Pokemon pokemon(Trainer trainer, int speciesId, String speciesName, PokemonType primaryType, PokemonType secondaryType, int level) {
        Pokemon p = new Pokemon(trainer, speciesId, speciesName, primaryType, secondaryType, level);
        pokemonService.create(p);
        return p;
    }

    private Gym gym(String city, PokemonType type, Trainer trainer) {
        Gym g = new Gym(city, type, trainer);
        gymService.create(g);
        return g;
    }

    private Badge badge(Gym gym, Trainer trainer) {
        Badge b = new Badge(trainer, gym);
        badgeService.createBadge(b);
        return b;
    }
    */

}
