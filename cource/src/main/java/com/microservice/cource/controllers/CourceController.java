package com.microservice.cource.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.cource.models.Cource;
import com.microservice.cource.service.CourceService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;



@RestController
@RequestMapping("api/cource/")
@CrossOrigin(origins = "http://localhost:4200")
public class CourceController {

	@Autowired
	public CourceService couService;

	@PostMapping("/save")
	private ResponseEntity<Cource> save(@RequestBody Cource cou) {
		Cource temporal = couService.create(cou);

		return ResponseEntity.ok(temporal);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, String>> deleteCource(@PathVariable("id") Long id) {
		Map<String, String> result = couService.deleteCource(id);
		if (result.containsKey("Mensaje") && result.get("Mensaje").equals("Curso eliminado exitosamente")) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.badRequest().body(result);
		}
	}

	@GetMapping("/allList")
	private ResponseEntity<List<Cource>> allList() {
		return ResponseEntity.ok(couService.listCource());
	}

	@GetMapping("curso/{id}")
	private ResponseEntity<Optional<Cource>> user(@PathVariable("id") Long id) {
		return ResponseEntity.ok(couService.findById(id));
	}
}
