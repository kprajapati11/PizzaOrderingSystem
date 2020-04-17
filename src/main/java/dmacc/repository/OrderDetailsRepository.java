package dmacc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

}
