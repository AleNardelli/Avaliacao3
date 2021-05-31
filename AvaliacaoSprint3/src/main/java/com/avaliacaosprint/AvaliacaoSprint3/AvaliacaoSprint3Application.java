package com.avaliacaosprint.AvaliacaoSprint3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


import com.avaliacaosprint.AvaliacaoSprint3.Carro;
import com.avaliacaosprint.AvaliacaoSprint3.CarroRepository;


@ResponseBody
@SpringBootApplication
@RestController
@RequestMapping("/api")
public class AvaliacaoSprint3Application {
	
    @Autowired
    private CarroRepository _carroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoSprint3Application.class, args);
	}

    @ApiOperation(value = "Post um carro")
    @RequestMapping(value = "/cars", method =  RequestMethod.POST, produces="application/json", consumes="application/json")
    public Carro Post(@Valid @RequestBody Carro carro){
    	return _carroRepository.save(carro);
    }

    @ApiOperation(value = "Retorna uma lista de carros")
	@GetMapping("/cars")
	public List<Carro> cars(
			@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "marca", defaultValue = "") String marca,
			@RequestParam(value = "cor", defaultValue = "") String cor,
			@RequestParam(value = "caro", defaultValue = "") String caro,
			@RequestParam(value = "barato", defaultValue = "") String barato,
			@RequestParam(value = "orderbyNome", defaultValue = "") String orderbyNome,
			@RequestParam(value = "orderbyValor", defaultValue = "") String orderbyValor,
			@RequestParam(value = "orderbyAno", defaultValue = "") String orderbyAno
	) {
		if(!name.isEmpty()) {
			return _carroRepository.findByNome(name);
		}

		if(!marca.isEmpty()) {
			return _carroRepository.findByMarca(marca);
		}

		if(!cor.isEmpty()) {
			return _carroRepository.findByCor(cor);
		}

		if(!caro.isEmpty()) {
			return _carroRepository.findFirstByOrderByValorAsc();
		}

		if(!barato.isEmpty()) {
			return _carroRepository.findFirstByOrderByValorDesc();
		}

		if(!orderbyNome.isEmpty()) {
			return _carroRepository.findByOrderByNomeDesc();
		}

		if(!orderbyValor.isEmpty()) {
			return _carroRepository.findByOrderByValorDesc();
		}

		if(!orderbyAno.isEmpty()) {
			return _carroRepository.findByOrderByFabricacaoDesc();
		}
		return null;
	}
}
