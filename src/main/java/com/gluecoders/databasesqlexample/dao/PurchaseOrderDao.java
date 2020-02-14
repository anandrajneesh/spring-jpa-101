package com.gluecoders.databasesqlexample.dao;

import com.gluecoders.databasesqlexample.models.PurchaseOrder;
import com.gluecoders.databasesqlexample.models.PurchaseOrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderDao extends JpaRepository<PurchaseOrder, PurchaseOrderId> {


}
