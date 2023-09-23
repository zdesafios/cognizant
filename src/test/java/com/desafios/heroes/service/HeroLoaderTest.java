package com.desafios.heroes.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import com.desafios.heroes.domain.model.Hero;
import com.desafios.heroes.service.provider.HerosArgumentsProvider;
import com.desafios.heroes.service.provider.HerosEmptyLineArgumentsProvider;
import com.desafios.heroes.service.provider.HerosInvalidColumnsArgumentsProvider;
import com.desafios.heroes.service.provider.HerosInvalidIdAndNameArgumentsProvider;
import com.desafios.heroes.service.provider.HerosInvalidRoundArgumentsProvider;

class HeroLoaderTest {
	
	private static final int FIRST_ELEMENT = 0;

	@DisplayName("Deve carregar 'heros' quando o log tiver linhas em branco")
	@ParameterizedTest
	@ArgumentsSource(HerosEmptyLineArgumentsProvider.class)
	void testComEmptyLine(String content, int herosSize, int roundSize) {
		var heroLoader = new HeroLoader();
		List<Hero> heros = heroLoader.load(content);
		assertEquals(herosSize, heros.size());
		assertEquals(roundSize, heros.get(FIRST_ELEMENT).getRounds().size());
	}
	
	@DisplayName("Deve carregar os 'hero' corretamente")
	@ParameterizedTest
	@ArgumentsSource(HerosArgumentsProvider.class)
	void ok(String content) {
		var heroLoader = new HeroLoader();
		List<Hero> heros = heroLoader.load(content);
		assertEquals(6, heros.size());
		assertEquals("Flash", heros.get(FIRST_ELEMENT).getName());
		assertEquals(13.474, heros.get(FIRST_ELEMENT).bestRound());
		assertEquals(4, heros.get(FIRST_ELEMENT).getRounds().size());
		assertEquals(36.117999999999995, heros.get(FIRST_ELEMENT).totalAverageSpeed().doubleValue());
	}
	
	@DisplayName("Deve levantar exceção quando a estrutura do log for diferente da definida")
	@ParameterizedTest
	@ArgumentsSource(HerosInvalidColumnsArgumentsProvider.class)
	void testComColunasInvalidas(String content) {
		var heroLoader = new HeroLoader();
		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			heroLoader.load(content);
        });
		assertEquals("Erro na estrutura do log", exception.getMessage());
	}
	
	@DisplayName("Deve levantar exceção quando o campo do 'hero' for diferente do definido")
	@ParameterizedTest
	@ArgumentsSource(HerosInvalidIdAndNameArgumentsProvider.class)
	void testComFormatoErradoHerroIdENome(String content) {
		var heroLoader = new HeroLoader();
		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			heroLoader.load(content);
        });
		assertEquals("Erro na estrutura do log [id–name]", exception.getMessage());
	}
	
	@DisplayName("Deve levantar exceção quando os campos das 'voltas' forem inválidos")
	@ParameterizedTest
	@ArgumentsSource(HerosInvalidRoundArgumentsProvider.class)
	void testComCamposRoundsVazios(String content, String msg) {
		var heroLoader = new HeroLoader();
		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			heroLoader.load(content);
        });
		assertEquals(msg, exception.getMessage());
	}
	
}
