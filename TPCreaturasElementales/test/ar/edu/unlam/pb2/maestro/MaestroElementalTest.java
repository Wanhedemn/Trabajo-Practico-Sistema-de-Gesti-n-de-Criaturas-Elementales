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

	@Test(expected = MaestriaInsuficienteException.class)
    public void queLanceExcepcionCheckedSiMaestroTienePocaMaestriaAlEntrenar() throws MaestriaInsuficienteException {
        Maestro gary = new Maestro("Gary", 5, Afinidad.TIERRA);
        Criatura onix = new Domesticada("Onix", Afinidad.TIERRA, 120);

        gary.entrenar(onix); //deberia fallar porque el nivel 5<20 que puse en el metodo 
        
    }
}
