package com.example.delivery.repository;

import com.example.delivery.entity.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Deliveryrepository extends JpaRepository<DeliveryEntity,Integer> {
//    @Query("select c from DeliveryEntity c where c.id=:id and c.orderstatus='Available'")
//    public int id(@Param("id")int id);

    @Query("select c from DeliveryEntity c where c.userEntity.id=:id and c.messagestatus='messagenotsent'")
    public DeliveryEntity findid(@Param("id")int id);

    @Query("select c from DeliveryEntity c where c.id=:orderid and c.orderstatus='Available'")
    public DeliveryEntity bookorder(@Param("orderid")int orderid);

    @Query("select c from DeliveryEntity c where c.id=:id")
    public DeliveryEntity findusergmail(@Param("id")int id);

    @Query("select c from DeliveryEntity c where c.id=:id and c.orderstatus='Picked'")
    public DeliveryEntity deliverorder(@Param("id")int id);
}
