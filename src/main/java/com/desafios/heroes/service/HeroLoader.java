package com.desafios.heroes.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.desafios.heroes.domain.model.Hero;
import com.desafios.heroes.domain.model.Round;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class HeroLoader {
	public static final int ROUND_START_TIME_POSITION = 0;
	public static final int HERO_ID_AND_NAME_POSITION = 1;
	public static final int ROUND_COUNT_POSITION = 2;
	public static final int ROUND_TIME_POSITION = 3;
	public static final int ROUND_SPEED_POSITION = 4;

	public static final int HERO_ID_POSITION = 0;
	public static final int HERO_NAME_POSITION = 1;

	private static final DateTimeFormatter DEFAULT_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:m:ss.SSS");

	public List<Hero> load(String content) {
		Assert.hasText(content, "Content não pode ser vazio");

		var heroes = new HashMap<String, Hero>();

		List<String> lines = getLinesWithoutHeader(content);
		lines.stream().map(this::loadHeroFromLine).forEach(heroWithRound -> {
			if (heroes.containsKey(heroWithRound.getId())) {
				Round currentRound = heroWithRound.getRounds().stream().findFirst().orElse(null);
				heroes.get(heroWithRound.getId()).addRound(currentRound);
			} else {
				heroes.put(heroWithRound.getId(), heroWithRound);
			}
		});

		heroes.values().stream().forEach(h->{
			
			
		});
		
		return heroes.values().stream().toList();
	}

	private List<String> getLinesWithoutHeader(String content) {
		List<String> lines = getLines(content);
		if(!lines.isEmpty())
			lines.remove(0);
		
		return lines.stream()
			.filter(line-> !line.trim().isEmpty())
			.toList();
	}
	
	private List<String> getLines(String content) {
		List<String> lines = new ArrayList<>();
		var scanner = new Scanner(content);
		while (scanner.hasNext()) {
			lines.add(scanner.nextLine());
		}
		scanner.close();
		return lines;
	}

	private Hero loadHeroFromLine(String line) {
		Assert.hasText(line, "Line não pode ser vazio");

		String[] datas = line.split(";");
		if (datas.length != 5) {
			throw new IllegalArgumentException("Erro na estrutura do log");
		}

		Round round = createRound(
			datas[ROUND_START_TIME_POSITION],
			datas[ROUND_COUNT_POSITION],
			datas[ROUND_SPEED_POSITION],
			datas[ROUND_TIME_POSITION]
		);

		return createHero(datas[HERO_ID_AND_NAME_POSITION], round);
	}

	private Hero createHero(String heroIdAndName, Round round) {
		Assert.hasText(heroIdAndName, "heroIdAndName não pode ser vazio");

		String[] heroParts = heroIdAndName.split("–");
		if (heroParts.length < 2) {
			throw new IllegalArgumentException("Erro na estrutura do log [id–name]");
		}

		String heroId = heroParts[HERO_ID_POSITION];
		String heroName = heroParts[HERO_NAME_POSITION];

		var hero = new Hero();
		hero.setId(heroId);
		hero.setName(heroName);
		hero.addRound(round);

		return hero;
	}

	private Round createRound(String startTimeAsString, String countAsString, String speedAsString, String timeAsString) {
		Assert.hasText(startTimeAsString, "startTimeAsString não pode ser vazio");
		Assert.hasText(countAsString, "countAsString não pode ser vazio");
		Assert.hasText(speedAsString, "speedAsString não pode ser vazio");
		Assert.hasText(timeAsString, "timeAsString não pode ser vazio");

		try {
			Integer count = Integer.parseInt(countAsString);
			LocalTime startTime = LocalTime.parse(startTimeAsString);
			LocalTime time = LocalTime.parse(String.format("00:0%s", timeAsString), DEFAULT_TIME_FORMATTER);
			Double speed = Double.valueOf(speedAsString.replace(",", "."));

			return Round.builder().count(count).startTime(startTime).time(time).speed(speed).build();

		} catch (Exception e) {
			throw new IllegalArgumentException("Erro converter Round");
		}
	}

}
