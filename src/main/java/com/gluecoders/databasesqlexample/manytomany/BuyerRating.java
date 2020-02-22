package com.gluecoders.databasesqlexample.manytomany;

import javax.persistence.*;

@Entity
public class BuyerRating {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buyer_fk")
    private Buyer buyer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_fk")
    private Product product;

    private int rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
