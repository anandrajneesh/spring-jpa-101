package com.gluecoders.databasesqlexample.customids;

import com.gluecoders.databasesqlexample.customids.PurchaseOrderDao;
import com.gluecoders.databasesqlexample.customids.PurchaseOrder;
import com.gluecoders.databasesqlexample.customids.PurchaseOrderId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IDClassExampleRunner implements CommandLineRunner {

    @Autowired
    private PurchaseOrderDao purchaseOrderDao;

    @Override
    public void run(String... args) throws Exception {
        PurchaseOrder order = new PurchaseOrder();
        order.setClientId("xx-44531");
        order.setOrderId("ord-1234");
        order.setProduct("shampoo");

        purchaseOrderDao.save(order);

        System.out.println("Purchase Order saved");

        PurchaseOrderId id = new PurchaseOrderId();
        id.setClientId("xx-44531");
        id.setOrderId("ord-1234");

        Optional<PurchaseOrder> result = purchaseOrderDao.findById(id);
        if(result.isPresent()){
            System.out.println("Fetched purchase order for product "+ result.get().getProduct());
        }else{
            System.out.println("Order not found for id");
        }

        purchaseOrderDao.deleteById(id);
        result = purchaseOrderDao.findById(id);
        if(result.isPresent()){
            System.out.println("Error: should have been deleted "+ result.get().getProduct());
            throw new IllegalStateException();
        }else{
            System.out.println("Successfully deleted");
        }
    }
}
