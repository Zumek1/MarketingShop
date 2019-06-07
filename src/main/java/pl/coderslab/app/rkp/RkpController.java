package pl.coderslab.app.rkp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.orders.Order;
import pl.coderslab.app.orders.OrderItem;
import pl.coderslab.app.orders.OrderService;
import pl.coderslab.app.pm.PmService;
import pl.coderslab.app.pm.PrzedstawicielMedyczny;
import pl.coderslab.app.product.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Transactional
@RequestMapping("/rkp")
@SessionAttributes("userSession")
public class RkpController {
    @Autowired
    PmService pmService;
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;


    @GetMapping("/home")
    public String homePage(HttpSession session, Model model) {
        List<PrzedstawicielMedyczny> pms = pmService.findByRkp(session);
        model.addAttribute("pms",pms);
        model.addAttribute("orders",orderService.findAll());
        return "rkpPage";
    }
    @GetMapping("/{id}/orderList")
    public String orderList(@PathVariable("id") Long id, Model model){
        model.addAttribute("orders", orderService.orders(id));
        model.addAttribute("order", new Order());
        return "ordersRKP";
    }

    @PostMapping("/{id}/orderList")
    public String orderSetStatus(HttpServletRequest request, @ModelAttribute Order order){
        String action = request.getParameter("action");
        order=orderService.orderById(order.getId());

        if("Akcept".equals(action) && order.getStatus().equals("New order")){
            order.setStatus("Zaakceptowane");
            orderService.saveOrder(order);
        }
        else if("Odrzuć".equals(action) && order.getStatus().equals("New order")){
            order.setStatus("Odrzucone");
            productService.setMagCancelOrder(order);
            pmService.setBudzetCancelOrder(order);
            orderService.saveOrder(order);
        }
        return "redirect:orderList";
    }


    @GetMapping("/{pm}/{orderID}/orderDetails")
    public String orderDetails(@PathVariable("orderID") Long id, Model model){
        model.addAttribute("order", orderService.orderById(id));
        return "orderDetailsRKP";
    }
    @GetMapping("/ims")
    public String ims(){
        return "rkpIMS";
    }
}

