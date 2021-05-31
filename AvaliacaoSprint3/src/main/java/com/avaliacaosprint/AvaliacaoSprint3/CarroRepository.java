package com.avaliacaosprint.AvaliacaoSprint3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avaliacaosprint.AvaliacaoSprint3.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
	List<Carro> findByOrderByNomeAsc();
	List<Carro> findByOrderByNomeDesc();
	
	List<Carro> findByOrderByValorAsc();
	List<Carro> findByOrderByValorDesc();

	List<Carro> findFirstByOrderByValorAsc();
	List<Carro> findFirstByOrderByValorDesc();
	
	List<Carro> findByOrderByFabricacaoAsc();
	List<Carro> findByOrderByFabricacaoDesc();
	
	List<Carro> findByNome(String nome);
	List<Carro> findByMarca(String marca);
	List<Carro> findByCor(String cor);
}