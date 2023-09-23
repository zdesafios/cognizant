package com.desafios.heroes.domain.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
public class Hero {
	private String id;
	private String name;
	
	@Setter(value = AccessLevel.NONE)
	private List<Round> rounds;

	public Hero() {
		rounds = new ArrayList<>();
	}
	
	@JsonProperty
	public Double bestRound() {
		return getSpeedsAsStream(rounds)
			.findFirst()
			.orElse(null);
	}
	
	@JsonProperty
	public Double totalAverageSpeed() {
		// TODO realizar todo o tratamento
		
		Double totalSpeed = getSpeedsAsStream(rounds)
				.reduce(Double.valueOf(0), Double::sum);
		
		Integer roundCount = rounds.size();
		Double totalAverageSpeed = totalSpeed / roundCount;
		return  totalAverageSpeed;
	}
	
	@JsonProperty
	public LocalTime totalTime() {
		return rounds.stream().map(round-> round.time).reduce((current, acc)-> acc
					.plusHours(current.getHour())
					.plusMinutes(current.getMinute())
					.plusSeconds(current.getSecond())
					.plusNanos(current.getNano())
		).orElse(null);
	}
	
	private Stream<Double> getSpeedsAsStream(List<Round> rounds) {
		return rounds.stream()
				.map(roud-> roud.speed)
				.filter(Objects::nonNull)
				.filter(speed-> speed > 0)
				.sorted(Comparator.naturalOrder());
	}
	
	
	
	public List<Round> getRounds() {
		return Collections.unmodifiableList(rounds);
	}

	public void addRound(Round round) {
		if(null != round) {
			rounds.add(round);
		}
	}
}
