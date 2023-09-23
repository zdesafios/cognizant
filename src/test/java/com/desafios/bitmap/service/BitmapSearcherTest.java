package com.desafios.bitmap.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BitmapSearcherTest {

	
	@DisplayName("Deve retornar uma string quando chamar o método 'seachAsString'")
	@Test
	void seach() {
		BitmapSearcher bitmapSearcher = new BitmapSearcher();
		BitmapService bitmapService = new BitmapService();
		int[] pixelsForSearchAsArray = {1,2, 21, 100};
		String resultAsString = bitmapSearcher.seachAsString(bitmapService.image1, pixelsForSearchAsArray);
		assertEquals("{1=39, 2=33, 100=0, 21=1}", resultAsString);
	}
	
	@DisplayName("Deve retornar uma map com 4 elementos quando passar {1,2, 21, 100}")
	@Test
	void seachString() {
		BitmapSearcher bitmapSearcher = new BitmapSearcher();
		BitmapService bitmapService = new BitmapService();
		int[] pixelsForSearchAsArray = {1,2, 21, 100};
		Map<Integer, Integer> result = bitmapSearcher.seach(bitmapService.image1, pixelsForSearchAsArray);
		assertEquals(39, result.get(1));
		assertEquals(33, result.get(2));
		assertEquals(1, result.get(21));
		assertEquals(0, result.get(100));
	}
	
	@DisplayName("Deve levantar exceção quando for passado um valor nulo para o bitmap")
	@Test
	void seachs() {
		BitmapSearcher bitmapSearcher = new BitmapSearcher();
		BitmapService bitmapService = new BitmapService();
		int[] pixelsForSearchAsArray = {1,2};
		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			int[][] bitmapNull = null;
			bitmapSearcher.seach(bitmapNull, pixelsForSearchAsArray);
        });
		assertEquals("bitmap nao pode ser nulo", exception.getMessage());
		
	}
	
	@DisplayName("Deve levantar exceção quando for passado um valor nulo para o array de busca")
	@Test
	void seachss() {
		BitmapSearcher bitmapSearcher = new BitmapSearcher();
		BitmapService bitmapService = new BitmapService();
		int[] pixelsForSearchAsArrayNull = null;
		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			bitmapSearcher.seach(bitmapService.image1, pixelsForSearchAsArrayNull);
        });
		assertEquals("pixelsForSearchAsArray nao pode ser nulo", exception.getMessage());
		
	}
	
}
