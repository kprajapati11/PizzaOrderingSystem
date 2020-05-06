package dmacc.repository;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.model.Topping;

@Repository
@Transactional
public interface ToppingRepository extends JpaRepository<Topping, Long>
{
  
}
