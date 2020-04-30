
  package dmacc.repository;
  
  import org.springframework.data.jpa.repository.JpaRepository;
  
  import dmacc.beans.Orders;
  
  
  public interface OrdersRepository extends JpaRepository<Orders, Integer> {
  
  }
 