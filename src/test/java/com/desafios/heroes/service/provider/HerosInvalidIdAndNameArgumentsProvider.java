package com.desafios.heroes.service.provider;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class HerosInvalidIdAndNameArgumentsProvider implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return Stream.of(
			Arguments.of(withHifen),
			Arguments.of(withoutChar),
			Arguments.of(withSpace),
			Arguments.of(withUnderline)
		);
	}

	private static String withHifen = "Hora;Super-Heroi;Nº Volta;Tempo Volta;Velocidade média da volta\n"
			+ "23:49:08.277;038-Superman;1;1:02.852;44,275\n";


	private static String withoutChar = "Hora;Super-Heroi;Nº Volta;Tempo Volta;Velocidade média da volta\n"
			+ "23:49:08.277;038Superman;1;1:02.852;44,275\n";
	
	private static String withSpace = "Hora;Super-Heroi;Nº Volta;Tempo Volta;Velocidade média da volta\n"
			+ "23:49:08.277;038 Superman;1;1:02.852;44,275\n";
	
	private static String withUnderline = "Hora;Super-Heroi;Nº Volta;Tempo Volta;Velocidade média da volta\n"
			+ "23:49:08.277;038_Superman;1;1:02.852;44,275\n";

			

}
