package ar.edu.unlam.pb2.creaturas;

import static org.junit.Assert.*;

import org.junit.Test;

public class CriaturaTest {

	@Test
	public void queSePuedaCrearUnaCriatura() {
		Criatura cria = new Criatura("Michi", "Agua", 100);
		
		assertNotNull(cria);
	}

	@Test 
	public void queSePuedaCrearUnaCriaturaDomesticada() {
		Criatura cria = new Domesticada("Michi", "Agua", 100);
		
		assertNotNull(cria);
	}
	
}
