package com.desafios.heroes.service.provider;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class HerosInvalidColumnsArgumentsProvider implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return Stream.of(Arguments.of(moreCells), Arguments.of(lessCells));
	}

	private static String moreCells = "Hora;Super-Heroi;Nº Volta;Tempo Volta;Velocidade média da volta;coluna-a-mais\n"
			+ "23:49:08.277;038–Superman;1;1:02.852;44,275;valor-coluna-a-mais\n";


	private static String lessCells = "Hora;Super-Heroi;Nº Volta;Tempo Volta\n"
			+ "23:49:08.277;038–Superman;1;1:02.852;\n";

			

}
