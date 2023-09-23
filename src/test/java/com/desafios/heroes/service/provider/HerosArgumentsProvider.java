package com.desafios.heroes.service.provider;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class HerosArgumentsProvider implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return List.of(Arguments.of(logOk)).stream();
	}

	public static String logOk = "Hora;Super-Heroi;Nº Volta;Tempo Volta;Velocidade média da volta\n"
			+ "23:49:08.277;038–Superman;1;1:02.852;44,275\n"
			+ "23:49:10.858;033–Flash;1;1:04.352;43,843\n"
			+ "23:49:11.075;002–Mercúrio;1;1:04.108;43,408\n" 
			+ "23:49:12.667;023–Sonic;1;1:04.414;43,202\n"
			+ "23:49:30.976;015–PAPALÉGUA;1;1:18.456;35,47\n" 
			+ "23:50:11.447;038–Superman;2;1:03.170;44,053\n"
			+ "23:50:14.860;033–Flash;2;1:04.002;43,48\n" 
			+ "23:50:15.057;002–Mercúrio;2;1:03.982;43,493\n"
			+ "23:50:17.472;023–Sonic;2;1:04.805;42,941\n" 
			+ "23:50:37.987;015–PAPALÉGUA;2;1:07.011;41,528\n"
			+ "23:51:14.216;038–Superman;3;1:02.769;44,334\n" 
			+ "23:51:18.576;033–Flash;3;1:03.716;43,675\n"
			+ "23:51:19.044;002–Mercúrio;3;1:03.987;43,49\n" 
			+ "23:51:21.759;023–Sonic;3;1:04.287;43,287\n"
			+ "23:51:46.691;015–PAPALÉGU;3;1:08.704;40,504\n" 
			+ "23:52:01.796;011–GATOAJATO;1;3:31.315;0,001\n"
			+ "23:52:17.003;038–Superman;4;1:02.787;14,321\n" 
			+ "23:52:22.586;033–Flash;4;1:04.010;13,474\n"
			+ "23:52:22.120;002–Mercúrio;4;1:03.076;44,118\n" 
			+ "23:52:25.975;023–Sonic;4;1:04.216;43,335\n"
			+ "23:53:06.741;015–PAPALÉGUA;4;1:20.050;34,763\n" 
			+ "23:53:39.660;011–GATOAJATO;2;1:37.864;0,0\n"
			+ "23:54:57.757;011–GATOAJATO;3;1:18.097;0,0";

}
