package com.gluecoders.databasesqlexample.runners;

import com.gluecoders.databasesqlexample.dao.CartDao;
import com.gluecoders.databasesqlexample.dao.ItemDao;
import com.gluecoders.databasesqlexample.models.Cart;
import com.gluecoders.databasesqlexample.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OneToManyExampleRunner implements CommandLineRunner {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ItemDao itemDao;

    @Override
    public void run(String... args) throws Exception {
        Cart cart = new Cart();
        Item item1 = new Item();
        item1.setCart(cart);
        Item item2 = new Item();
        item2.setCart(cart);

        cartDao.save(cart);
        itemDao.save(item1);
        itemDao.save(item2);
        System.out.println("Cart and items saved "+ cart.getId() + " item 1 "+ item1.getId()+ " item 2 "+item2.getId());

    }
}
