package ar.edu.unlam.pb2.maestro;

import static org.junit.Assert.*;
import org.junit.Test;

import ar.edu.unlam.pb2.creaturas.Afinidad;
import ar.edu.unlam.pb2.creaturas.*;
import ar.edu.unlam.pb2.creaturas.Domesticada;


public class MaestroElementalTest {

	@Test
	public void queSePuedaCrearUnMaestroConSusAtributos() {
		Maestro pablo= new Maestro("Pablo", 15, Afinidad.FUEGO);
		
		assertNotNull(pablo);
		assertEquals("Pablo", pablo.getNombre());
		assertEquals(15, pablo.getNivelDeMaestria(),0.01);
		assertEquals(Afinidad.FUEGO, pablo.getAfinidad());
	}
	
	@Test
	public void queSePuedaAgregarUnaCriaturaAlMaestro() {
		Maestro pablo= new Maestro("Pablo", 15, Afinidad.FUEGO);
		
		Criatura blastoise=new Domesticada("Blastoise",Afinidad.AGUA, 110);
		
		pablo.agregarCriatura(blastoise);
		
		assertNotNull(pablo);
		assertEquals(1, pablo.getCriaturasACargo().size());
	}
	
	@Test
	public void queSePuedaAgregarUnaCriaturaASuRespectivoMaestroYVerificarQueSeHanSidoAsignadasCorrectamente() {
		Maestro pablo= new Maestro("Pablo", 15, Afinidad.FUEGO);
		Maestro alberto= new Maestro("Alberto", 12, Afinidad.AGUA);
		
		Criatura blastoise=new Domesticada("Blastoise",Afinidad.AGUA, 110);
		Criatura patamon=new Domesticada("Patamon",Afinidad.AIRE, 120);
		
		pablo.agregarCriatura(blastoise);
		alberto.agregarCriatura(patamon);
		
		assertNotEquals(2, pablo.getCriaturasACargo().size());
		assertTrue(pablo.getCriaturasACargo().containsKey(blastoise.getNombre()));
		
		assertEquals(1, alberto.getCriaturasACargo().size());
		assertTrue(alberto.getCriaturasACargo().containsValue(patamon));
	}
	
	@Test
	public void queAlEntrenarUnaCriaturaSusValoresDeEnergiaCambienCorrectamente() throws MaestriaInsuficienteException {
		Maestro pablo= new Maestro("Pablo", 15, Afinidad.FUEGO);
		Criatura blastoise=new Domesticada("Blastoise",Afinidad.AGUA, 110);
		
		pablo.entrenarCriatura(blastoise);
		
		assertTrue(blastoise.getEnergia()>110);
	}

	@Test(expected = MaestriaInsuficienteException.class)
    public void queLanceExcepcionCheckedSiMaestroTienePocaMaestriaAlEntrenar() throws MaestriaInsuficienteException {
        Maestro gary = new Maestro("Gary", 5, Afinidad.TIERRA);
        Criatura onix = new Domesticada("Onix", Afinidad.TIERRA, 120);

        gary.entrenarCriatura(onix); //deberia fallar porque el nivel 5<20 que puse en el metodo 
        
    }
}
