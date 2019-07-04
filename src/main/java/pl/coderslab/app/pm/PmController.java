package pl.coderslab.app.pm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import pl.coderslab.app.cart.CartItemService;
import pl.coderslab.app.orders.OrderItem;
import pl.coderslab.app.orders.OrderService;
import pl.coderslab.app.product.Product;
import pl.coderslab.app.product.ProductService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/pm")
@SessionAttributes("cart")
@Scope(value = WebApplicationContext.SCOPE_SESSION)//co z proxy mode?
public class PmController {
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;
    @Autowired
    PmService pmService;
    @Autowired
    CartItemService cartItemService;

    @GetMapping("/home")
    public String homePage(Model model){
        model.addAttribute("products", products());
        model.addAttribute("orderItem", new OrderItem());
        return "pmPage";
    }

    @PostMapping("/home")
    public String cartAdd(@ModelAttribute @Valid OrderItem orderItem, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            model.addAttribute("orderItem", new OrderItem());
            return "pmPage";
        }
        orderItem.setProduct(productService.findById(orderItem.getProduct().getId()));
        orderItem.setAmount(BigDecimal.valueOf(orderItem.getQuantity()*orderItem.getProduct().getPrice()).setScale(2, RoundingMode.FLOOR));

        if(session.getAttribute("cart")==null){
            if(orderItem.getQuantity()>orderItem.getProduct().getMagQuantity()||pmService.budzetVScartItem(session,orderItem)==-1){
                return "error";
            }
            else {
                List<OrderItem> orderItems = new ArrayList<>();
                orderItems.add(orderItem);
                session.setAttribute("cart", orderItems);
            }
        }
        else {
            List<OrderItem> orderItems = (List<OrderItem>) session.getAttribute("cart");

            if(pmService.veryfiCartQuantity(orderItems,orderItem)==false||pmService.veryfiAmount(orderItems,orderItem,session)==false){
                return "error";
            }
            else {
                int index = cartItemService.isExisting(orderItem.getProduct().getId(), orderItems);
                if (index == -1) {
                    orderItems.add(orderItem);
                    session.setAttribute("cart", orderItems);
                } else {
                    BigDecimal tempAmount = orderItem.getAmount().add(orderItems.get(index).getAmount());
                    int tempQuantity = orderItem.getQuantity() + orderItems.get(index).getQuantity();
                    orderItems.get(index).setAmount(tempAmount);
                    orderItems.get(index).setQuantity(tempQuantity);
                }
                session.setAttribute("cart", orderItems);
            }
        };
        model.addAttribute("orderItem", new OrderItem());
        return "pmPage";
    }

    @GetMapping("/ims")
    public String ims(){
        return "pmIMS";
    }

    @GetMapping("/akademia")
    public String akademia(){return "akademia";}

    @ModelAttribute("products")
    public List<Product> products(){
        return productService.findAll();
    }

}
