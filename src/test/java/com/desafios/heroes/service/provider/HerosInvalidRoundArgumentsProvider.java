package com.desafios.heroes.service.provider;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class HerosInvalidRoundArgumentsProvider implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return Stream.of(
			Arguments.of(startTimeEmpty, "startTimeAsString não pode ser vazio"),
			Arguments.of(countEmpty, "countAsString não pode ser vazio"),
			Arguments.of(speedEmpty, "speedAsString não pode ser vazio"),
			Arguments.of(timeEmpty, "timeAsString não pode ser vazio"),
			Arguments.of(startTimeEmptySpace, "startTimeAsString não pode ser vazio"),
			Arguments.of(countEmptySpace, "countAsString não pode ser vazio"),
			Arguments.of(speedEmptySpace, "speedAsString não pode ser vazio"),
			Arguments.of(timeEmptySpace, "timeAsString não pode ser vazio")
		);
	}

	//String startTimeAsString, String countAsString, String speedAsString, String timeAsString
	private static String defaults = "Hora;Super-Heroi;Nº Volta;Tempo Volta;Velocidade média da volta\n"
			+ "23:49:08.277;038–Superman;1;1:02.852;44,275\n";
	
	private static String startTimeEmpty = "Hora;Super-Heroi;Nº Volta;Tempo Volta;Velocidade média da volta\n"
			+ ";038–Superman;1;1:02.852;44,275\n";
	
	private static String countEmpty = "Hora;Super-Heroi;Nº Volta;Tempo Volta;Velocidade média da volta\n"
			+ "23:49:08.277;038–Superman;;1:02.852;44,275\n";
	
	private static String speedEmpty = "Hora;Super-Heroi;Nº Volta;Tempo Volta;Velocidade média da volta\n"
			+ "23:49:08.277;038–Superman;1;1:02.852; \n";
	
	private static String timeEmpty = "Hora;Super-Heroi;Nº Volta;Tempo Volta;Velocidade média da volta\n"
			+ "23:49:08.277;038–Superman;1;;44,275\n";
	
	private static String startTimeEmptySpace = "Hora;Super-Heroi;Nº Volta;Tempo Volta;Velocidade média da volta\n"
			+ " ;038–Superman;1;1:02.852;44,275\n";
	
	private static String countEmptySpace = "Hora;Super-Heroi;Nº Volta;Tempo Volta;Velocidade média da volta\n"
			+ "23:49:08.277;038–Superman; ;1:02.852;44,275\n";
	
	private static String speedEmptySpace = "Hora;Super-Heroi;Nº Volta;Tempo Volta;Velocidade média da volta\n"
			+ "23:49:08.277;038–Superman;1;1:02.852; \n";
	
	private static String timeEmptySpace = "Hora;Super-Heroi;Nº Volta;Tempo Volta;Velocidade média da volta\n"
			+ "23:49:08.277;038–Superman;1; ;44,275\n";
}
