package com.gluecoders.databasesqlexample.manytomany;

import java.util.Set;

public interface BuyerProjection {

    String getName();
    Set<BuyerRatingSummary> getRatings();

    interface BuyerRatingSummary{
        int getRating();
        ProductSummary getProduct();
    }

    interface ProductSummary{
        String getName();
    }
}
