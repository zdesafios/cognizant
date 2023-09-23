package com.desafios.heroes.service.provider;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class HerosEmptyLineArgumentsProvider implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return Stream.of(
			Arguments.of(withEmptyLine, 1, 2),
			Arguments.of(withEmptyLine1, 2, 1),
			Arguments.of(withEmptyLine2, 2, 1),
			Arguments.of(withEmptyLine3, 2, 1)
		);
	}
	
	private static String withEmptyLine = "Hora;Super-Heroi;Nº Volta;Tempo Volta;Velocidade média da volta\n"
			+ "23:49:08.277;038–Superman;1;1:02.852;44,275\n"
			+"\n"
			+ "23:49:08.277;038–Superman;1;1:02.852;44,275\n";
	
	private static String withEmptyLine1 = "Hora;Super-Heroi;Nº Volta;Tempo Volta;Velocidade média da volta\n"
			+ "23:49:08.277;038–Superman;1;1:02.852;44,275\n"
			+"\n"
			+ "23:49:12.667;023–Sonic;1;1:04.414;43,202\n";
	
	private static String withEmptyLine2 = "Hora;Super-Heroi;Nº Volta;Tempo Volta;Velocidade média da volta\n"
			+ "23:49:08.277;038–Superman;1;1:02.852;44,275\n"
			+"\n"
			+ "23:49:12.667;023–Sonic;1;1:04.414;43,202\n"
			+ "\n";
	
	private static String withEmptyLine3 = "\n"
			+ "23:49:08.277;038–Superman;1;1:02.852;44,275\n"
			+"\n"
			+ "23:49:12.667;023–Sonic;1;1:04.414;43,202\n"
			+ "\n";
	

}
