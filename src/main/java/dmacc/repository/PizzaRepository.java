package dmacc.repository;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.model.Pizza;

@Repository
@Transactional
public interface PizzaRepository extends JpaRepository<Pizza , Long>
{

  
}
