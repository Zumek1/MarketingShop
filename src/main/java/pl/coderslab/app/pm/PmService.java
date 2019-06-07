package pl.coderslab.app.pm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import pl.coderslab.app.orders.Order;
import pl.coderslab.app.orders.OrderItem;
import pl.coderslab.app.product.Product;
import pl.coderslab.app.rkp.Regionalny;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
@SessionAttributes
public class PmService {
    @Autowired
    PmRepo pmRepo;

    public HttpSession session() {
        ServletRequestAttributes attributes = (ServletRequestAttributes)
                RequestContextHolder.currentRequestAttributes();
        return attributes.getRequest().getSession();
    }

    public void updetePM(PrzedstawicielMedyczny przedstawicielMedyczny) {
        pmRepo.save(przedstawicielMedyczny);
    }

    public int budzetVScartItem(HttpSession session, OrderItem orderItem) {
        PrzedstawicielMedyczny przedstawicielMedyczny = (PrzedstawicielMedyczny) session.getAttribute("userSession");
        int result = przedstawicielMedyczny.getBudzet().compareTo(orderItem.getAmount());
        return result;
    }

    public boolean veryfiCartQuantity(List<OrderItem> orderItems, OrderItem orderItem) {
        int tempQuantity = 0;
        for (int i = 0; i < orderItems.size(); i++) {
            tempQuantity = tempQuantity + orderItems.get(i).getQuantity();
        }
        tempQuantity = tempQuantity + orderItem.getQuantity();
        if (tempQuantity > orderItem.getProduct().getMagQuantity()) {
            return false;
        } else {
            return true;
        }
    }

    public boolean veryfiAmount(List<OrderItem> orderItems, OrderItem orderItem, HttpSession session) {
        PrzedstawicielMedyczny przedstawicielMedyczny = (PrzedstawicielMedyczny)session.getAttribute("userSession");
        BigDecimal temp = BigDecimal.valueOf(0);
        for (int i = 0; i < orderItems.size(); i++) {
            temp = temp.add(orderItems.get(i).getAmount());
        }
        temp = temp.add(orderItem.getAmount());
        int index = temp.compareTo(przedstawicielMedyczny.getBudzet());
        if(index==-1){
            return true;
        }
        else{
            return false;
        }
    }

    public List<PrzedstawicielMedyczny> findByRkp(HttpSession session){
        List<PrzedstawicielMedyczny> przedstawicielMedycznyList =
                pmRepo.findByRegionalny((Regionalny)session.getAttribute("userSession"));
        return przedstawicielMedycznyList;
    }

    public void setBudzetCancelOrder (Order order){

            PrzedstawicielMedyczny przedstawicielMedyczny = pmRepo.findOne(order.getPrzedstawicielMedyczny().getId());
            przedstawicielMedyczny.setBudzet(przedstawicielMedyczny.getBudzet().add(order.getTotalAmount()));
            pmRepo.save(przedstawicielMedyczny);

    }

}
