package com.tuananhdo.repository;

import com.tuananhdo.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderProduct,Long> {

    @Query("SELECT p  FROM OrderProduct p WHERE concat(p.id, p.nameUserOrder, p.phoneNumber) like %?1%")
    List<OrderProduct> findAll(String search);

    @Query("SELECT p FROM OrderProduct p WHERE p.phoneNumber like %?1% ")
    List<OrderProduct> getOrderProductByPhoneNumber(String phone);

}
