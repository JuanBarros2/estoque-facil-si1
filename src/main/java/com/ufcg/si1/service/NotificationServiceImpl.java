package com.ufcg.si1.service;


import com.ufcg.si1.model.Lot;
import com.ufcg.si1.model.Notification;
import com.ufcg.si1.model.ProductLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Autowired
    private ProductLotService productLotService;

    @Override
    public List<Notification> findAll() {
        List<Notification> notifications = new ArrayList<>();
        List<ProductLot> productLots = productLotService.findAll();
        String today = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        productLots.forEach(productLot -> {
            List<Lot> lots = productLot.getLots();
            for (Lot lot: lots) {
                if(lot.getItensAmount() <= 15){
                    notifications.add(new Notification(productLot.getProduct() + " está com estoque baixo"));
                    break;
                } else if(lot.getExpirationDate().compareTo(today) < 0){
                    notifications.add(new Notification(productLot.getProduct() + " tem lote vencido"));
                    break;
                }
            }
        });
        return notifications;
    }
}
