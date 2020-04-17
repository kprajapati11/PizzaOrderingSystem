package dmacc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Pizza;

public interface PizzaRepository  extends JpaRepository<Pizza, Integer>{

}
