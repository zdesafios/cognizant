package com.desafios.bitmap.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafios.bitmap.service.BitmapSearcher;
import com.desafios.bitmap.service.BitmapService;


@RestController
@RequestMapping("/bitmap")
public class BitmapController {
	
	@Autowired
	private BitmapSearcher bitmapSearcher;
	
	@Autowired
	private BitmapService bitmapService;

	@GetMapping("/{bitmapId}")
	public ResponseEntity<Map<Integer, Integer>> search(@PathVariable("bitmapId") String bitmapId, @RequestParam("q") int[] pixelsValueForSearch) {
		Map<Integer, Integer> pixelsCount = bitmapSearcher.seach(bitmapService.loadBitmapById(bitmapId), pixelsValueForSearch);
		return ResponseEntity.ok(pixelsCount);
	}
	
}
