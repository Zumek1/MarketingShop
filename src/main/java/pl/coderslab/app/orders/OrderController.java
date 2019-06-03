package pl.coderslab.app.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.pm.PmService;
import pl.coderslab.app.pm.PrzedstawicielMedyczny;
import pl.coderslab.app.product.Product;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@Transactional
@SessionAttributes("cart")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    PmService pmService;

    @GetMapping("/ordersHistory")
    public String orders(Model model, HttpSession session){
        model.addAttribute("orders", orders(session));
        return "orders";
    }

    @PostMapping("/ordersHistory")

    public String addOrder(@ModelAttribute Order order, HttpSession session, Model model){
        List<OrderItem> orderItems = (List<OrderItem>) session.getAttribute("cart");
        List<Product> products = orderService.getFromOrderItem(orderItems);
        PrzedstawicielMedyczny przedstawicielMedyczny = (PrzedstawicielMedyczny) session.getAttribute("userSession");
        BigDecimal tempBudzet = przedstawicielMedyczny.getBudzet().subtract(order.getTotalAmount());
        order.setProducts(products);
        przedstawicielMedyczny.setBudzet(tempBudzet);
        order.setPrzedstawicielMedyczny(przedstawicielMedyczny);
        orderService.saveOrder(order);
        pmService.updetePM(przedstawicielMedyczny);
        orderItems.clear();
        session.setAttribute("cart", orderItems);
        model.addAttribute("orders", orders(session));
        return "orders";
    }

    @GetMapping("/{id}/orderDetails")
    public String orderDetails(@PathVariable("id") Long id, Model model){
        model.addAttribute("order", orderService.orderById(id));
        return "orderDetails";
    }

    @ModelAttribute
    public List<Order> orders ( HttpSession session){
        PrzedstawicielMedyczny przedstawicielMedyczny = (PrzedstawicielMedyczny) session.getAttribute("userSession");
        return orderService.orders(przedstawicielMedyczny.getId());
    }

}
