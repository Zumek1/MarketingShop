package pl.coderslab.app;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.pm.PmRepo;
import pl.coderslab.app.pm.PrzedstawicielMedyczny;
import pl.coderslab.app.rkp.Regionalny;
import pl.coderslab.app.rkp.RegionalnyRepo;
import pl.coderslab.app.storehouse.Storekeeper;
import pl.coderslab.app.storehouse.StorekeeperRepo;


import java.awt.print.Book;

@Controller
@SessionAttributes("userSession")
public class LoginController {
    @Autowired
    PmRepo pmRepo;
    @Autowired
    RegionalnyRepo regionalnyRepo;
    @Autowired
    StorekeeperRepo storekeeperRepo;

    @GetMapping("/{typ}/login")
    public String pobieranie(@PathVariable("typ") String typ) {
        return "login";
    }

    @PostMapping("/{typ}/login")
    public String login(@PathVariable("typ") String typ, @RequestParam String email, @RequestParam String password, Model model) {
        if (typ.equals("pm")) {
            PrzedstawicielMedyczny przedstawicielMedyczny = pmRepo.findByEmail(email);
            model.addAttribute("isLogged", false);
            if (przedstawicielMedyczny == null) {
                return "login";
            }
//            if (BCrypt.checkpw(password, przedstawicielMedyczny.getPassword())) {
            //todo dorobić rejestrację i hasłowanie,ewentualnie zmianę hasła dla hasła startowego
            if(przedstawicielMedyczny.getPassword().equals(password)){
                model.addAttribute("userSession", przedstawicielMedyczny);
//                model.addAttribute("przedstawicielMedyczny",przedstawicielMedyczny);
                model.addAttribute("isLogged", true);
                return "redirect:/pm/home";
            }
        }
        else if(typ.equals("rkp")){
            Regionalny regionalny = regionalnyRepo.findByEmail(email);
            model.addAttribute("isLogged", false);
            if(regionalny==null){
                return "login";
            }
            if(regionalny.getPassword().equals(password)){
                model.addAttribute("userSession", regionalny);
                model.addAttribute("isLogged", true);
                return "rkpPage";
            }
        }
        else if(typ.equals("mag")){
            Storekeeper storekeeper = storekeeperRepo.findByEmail(email);
            model.addAttribute("isLogged", false);
            if(storekeeper==null){
                return "login";
            }
            if(storekeeper.getPassword().equals(password)){
                model.addAttribute("userSession", storekeeper);
                model.addAttribute("isLogged", true);
                return "magPage";
            }

        }
        return "login";
    }
}

