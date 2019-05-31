package pl.coderslab.app.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pl.coderslab.app.orders.Order;
import pl.coderslab.app.orders.OrderItem;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Transactional
@SessionAttributes("cart")
public class CartController {
    @Autowired
    CartItemService cartItemService;

    @GetMapping("/cart")
    public String cartHomepage(Model model){
        model.addAttribute("order", new Order());
        model.addAttribute("orderItem", new OrderItem());
        return "cartShoop";

    }

    @PostMapping("/cart")
    public String deleteItem(@ModelAttribute OrderItem orderItem, HttpSession session){
        List<OrderItem> orderItems = (List<OrderItem>) session.getAttribute("cart");
        Long id = orderItem.getProduct().getId();
        int index = cartItemService.isExisting(id,orderItems);
        if(index>-1){
            orderItems.remove(index);
            session.setAttribute("cart",orderItems);
        }
        return "redirect:cart";
    }

}
