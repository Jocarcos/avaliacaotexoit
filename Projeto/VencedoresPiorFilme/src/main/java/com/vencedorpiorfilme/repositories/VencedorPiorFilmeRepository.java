package com.vencedorpiorfilme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

import com.vencedorpiorfilme.entidades.VencedorPiorFilme;

public interface VencedorPiorFilmeRepository extends JpaRepository<VencedorPiorFilme, Integer>{
	
	public List<VencedorPiorFilme> findByYear(@Param("year") Integer year);	
   
	public List<VencedorPiorFilme> findByYearAndWinner( @Param("year") Integer year,  @Param("winner") String winner);  
	
	public List<VencedorPiorFilme> findByOrderByProducersAscYearAsc();
		
}
