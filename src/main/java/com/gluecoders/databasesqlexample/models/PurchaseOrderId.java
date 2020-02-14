package com.gluecoders.databasesqlexample.models;


import java.io.Serializable;

public class PurchaseOrderId implements Serializable {

    private String clientId;
    private String orderId;


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
