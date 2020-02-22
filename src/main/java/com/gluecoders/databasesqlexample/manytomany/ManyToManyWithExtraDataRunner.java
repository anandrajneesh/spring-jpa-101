package com.gluecoders.databasesqlexample.manytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Component
public class ManyToManyWithExtraDataRunner implements CommandLineRunner {

    @Autowired
    private BuyerDao buyerDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private BuyerRatingDao buyerRatingDao;

    @Override
    public void run(String... args) throws Exception {
        Buyer b1 = new Buyer();
        b1.setName("xx");
        Buyer b2 = new Buyer();
        b2.setName("yy");
        buyerDao.save(b1);
        buyerDao.save(b2);
        Product p1 = new Product();
        p1.setName("p1");
        Product p2 = new Product();
        p2.setName("p2");
        Product p3 = new Product();
        p3.setName("p3");
        productDao.save(p1);
        productDao.save(p2);
        productDao.save(p3);
        BuyerRating r1 = new BuyerRating();
        r1.setBuyer(b1);
        r1.setProduct(p1);
        r1.setRating(3);
        BuyerRating r2 = new BuyerRating();
        r2.setProduct(p1);
        r2.setBuyer(b2);
        r2.setRating(4);
        BuyerRating r3 = new BuyerRating();
        r3.setProduct(p2);
        r3.setBuyer(b1);
        r3.setRating(1);
        BuyerRating r4 = new BuyerRating();
        r4.setRating(4);
        r4.setProduct(p3);
        r4.setBuyer(b2);
        buyerRatingDao.save(r1);
        buyerRatingDao.save(r2);
        buyerRatingDao.save(r3);
        buyerRatingDao.save(r4);

        List<Product> products = productDao.findAll();
        for(Product product : products){
            for(BuyerRating rating : product.getRatings()){
                System.out.println("Product id "+ product.getId() + " product name "+ product.getName() + " rating id "+ rating.getId());
            }
        }
        Collection<BuyerProjection> buyerProjections = buyerDao.findByName(b1.getName());
        for(BuyerProjection projection : buyerProjections){
            for(BuyerProjection.BuyerRatingSummary buyerRatingSummary : projection.getRatings()){
                System.out.println(projection.getName() + "gave rating "+ buyerRatingSummary.getRating() + " for product "+ buyerRatingSummary.getProduct().getName());
            }
        }
    }
}
