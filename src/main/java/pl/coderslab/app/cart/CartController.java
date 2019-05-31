package pl.coderslab.app.cart;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@Transactional
@SessionAttributes("cart")
public class CartController {

    @GetMapping("/cart")
    public String cartHomepage(){
        return "cartShoop";

    }
}
