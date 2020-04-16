package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dmacc.beans.orders;

public interface Repository extends JpaRepository<orders, Long>{


}
