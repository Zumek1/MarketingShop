package pl.coderslab.app.pm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.app.orders.Order;
import pl.coderslab.app.orders.OrderItem;
import pl.coderslab.app.orders.OrderService;
import pl.coderslab.app.product.Product;
import pl.coderslab.app.product.ProductService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/pm")
@SessionAttributes("cart")
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class PmController {
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;
    @Autowired
    PmService pmService;

    @GetMapping("/home")
    public String homePage(Model model){
        model.addAttribute("products", products());
        model.addAttribute("orderItem", new OrderItem());
        return "pmPage";
    }

    @PostMapping("/home")
    public String cartAdd(@ModelAttribute OrderItem orderItem, Model model, HttpSession session){
        orderItem.setProduct(productService.findById(orderItem.getProduct().getId()));
        orderItem.setAmount(orderItem.getQuantity()*orderItem.getProduct().getPrice());

        if(session.getAttribute("cart")==null){
            List<OrderItem> orderItems = new ArrayList<>();
            orderItems.add(orderItem);
            session.setAttribute("cart", orderItems);
        }
        else {
            List<OrderItem> orderItems = (List<OrderItem>) session.getAttribute("cart");
            orderItems.add(orderItem);
            session.setAttribute("cart",orderItems);
        };

       return "cartShoop";
    }

    @ModelAttribute("orders")
    public List<Order> orders() {
        System.out.println(orderService.findAll().toString());
        return orderService.findAll();

    }

    @ModelAttribute("products")
    public List<Product> products(){
        return productService.findAll();
    }

}
