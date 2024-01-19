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
@RequestMapping("/api/cource/")  // Agregada barra al final
@CrossOrigin(origins = "http://34.30.217.33:4200")
public class CourceController {

    @Autowired
    private CourceService couService;

    @PostMapping("/save")
    public ResponseEntity<Cource> saveCource(@RequestBody Cource cou) {
        Cource savedCource = couService.create(cou);
        return ResponseEntity.ok(savedCource);
    }

    @DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCource(@PathVariable String id) {
		String result = couService.deleteCource(id);
		if (result.equals("Curso eliminado exitosamente")) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.badRequest().body(result);
		}
	}

	@GetMapping("/curso/{id}")
	public ResponseEntity<Optional<Cource>> getCourceById(@PathVariable String id) {
		return ResponseEntity.ok(couService.findById(id));
	}


    @GetMapping("/allList")
    public ResponseEntity<List<Cource>> getAllCources() {
        return ResponseEntity.ok(couService.listCource());
    }

}

