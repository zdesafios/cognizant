package com.desafios.bitmap.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class BitmapSearcher {

	public Map<Integer, Integer> seach(int[][] bitmap, int... pixelsForSearchAsArray) {
		Assert.notNull(bitmap, "bitmap nao pode ser nulo");
		Assert.notNull(pixelsForSearchAsArray, "pixelsForSearchAsArray nao pode ser nulo");
		
		Map<Integer, Integer> pixelsCount = initPixelsCount(pixelsForSearchAsArray);
		for(int[] currentPixelsAsRow: bitmap) {
			for (int pixelValue : currentPixelsAsRow) {
				pixelsCount.computeIfPresent(pixelValue, (key, pixelCount)-> ++pixelCount);
			}
		}
		return pixelsCount;
	}
	
	public String seachAsString(int[][] bitmap, int... pixelsForSearchAsArray) {
		Map<Integer, Integer> pixelsCountAsMap = seach(bitmap, pixelsForSearchAsArray);
		return pixelsCountAsMap.toString();
	}

	private Map<Integer, Integer> initPixelsCount(int... pixelsForSearchAsArray) {
		Map<Integer, Integer> pixelsCount = new HashMap<>();
		for (int pixelSearch : pixelsForSearchAsArray) {
			pixelsCount.put(pixelSearch, 0);
		}
		return pixelsCount;
	}

}