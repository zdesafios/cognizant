package com.desafios.heroes.web.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.desafios.heroes.domain.model.Hero;
import com.desafios.heroes.service.HeroLoader;


@RestController
@RequestMapping("/hero")
public class HeroController {
	
	@Autowired
	private HeroLoader heroLoader;
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> loadFromFile(@RequestParam("file") MultipartFile file) throws IOException {
		var heros = heroLoader.load(new String(file.getBytes(), StandardCharsets.UTF_8));
		var bestHero = heros.stream().sorted(Comparator.comparing(Hero::totalAverageSpeed)).findFirst().orElse(null);
		
		return ResponseEntity.ok(Map.of("heros", heros, "bestHero", bestHero));
		
	}
}
