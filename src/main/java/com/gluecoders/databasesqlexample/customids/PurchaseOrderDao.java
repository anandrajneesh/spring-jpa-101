package com.gluecoders.databasesqlexample.customids;

import com.gluecoders.databasesqlexample.customids.PurchaseOrder;
import com.gluecoders.databasesqlexample.customids.PurchaseOrderId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderDao extends JpaRepository<PurchaseOrder, PurchaseOrderId> {


}
