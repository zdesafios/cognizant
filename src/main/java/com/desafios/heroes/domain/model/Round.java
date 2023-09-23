package com.desafios.heroes.domain.model;

import java.time.LocalTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Round {
	LocalTime startTime;
	Double speed;
	LocalTime time;
	Integer count;
}
