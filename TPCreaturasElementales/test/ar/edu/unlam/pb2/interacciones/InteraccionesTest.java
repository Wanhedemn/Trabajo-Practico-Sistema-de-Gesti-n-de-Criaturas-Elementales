package ar.edu.unlam.pb2.interacciones;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.pb2.creaturas.*;
import ar.edu.unlam.pb2.transformaciones.*;

public class InteraccionesTest {

    @Test
    public void queSiCompartenAfinidadGanen10DeEnergiaAmbas() {
        Criatura c1 = new Domesticada("Aqua", Afinidad.AGUA, 50);
        Criatura c2 = new Domesticada("Rain", Afinidad.AGUA, 80);

        Interacciones inter = new Interacciones();
        inter.interactuar(c1, c2);

        assertEquals((Integer)60, c1.getEnergia());
        assertEquals((Integer)90, c2.getEnergia());
    }

    @Test
    public void queSiSonOpuestasAmbasQuedenInestables() {
        Criatura fuego = new Salvaje("Charmander", Afinidad.FUEGO, 100);
        Criatura agua = new Salvaje("Squirtle", Afinidad.AGUA, 100);

        Interacciones inter = new Interacciones();
        inter.interactuar(fuego, agua);

        assertTrue(fuego.isInestable());
        assertTrue(agua.isInestable());
    }

    @Test
    public void queAncestralDomineLaInteraccion() {
        Criatura ancestral = new Ancestral("Groudon", Afinidad.TIERRA, 120);
        Criatura comun = new Domesticada("Pidgey", Afinidad.AIRE, 40);

        Interacciones inter = new Interacciones();
        inter.interactuar(ancestral, comun);

        // Ancestral +20
        assertEquals((Integer)140, ancestral.getEnergia());

        // Común -15 (40 - 15 = 25)
        assertEquals((Integer)25, comun.getEnergia());
    }

    @Test
    public void queLaCriaturaNoAncestralNoBajeDeCero() {
        Criatura ancestral = new Ancestral("Lugia", Afinidad.AIRE, 150);
        Criatura debil = new Domesticada("Wurmple", Afinidad.TIERRA, 5);

        Interacciones inter = new Interacciones();
        inter.interactuar(ancestral, debil);

        assertEquals((Integer)170, ancestral.getEnergia());
        assertEquals((Integer)0, debil.getEnergia()); // no baja de 0
    }

    @Test
    public void queLasInteraccionesFuncionenConTransformacionesDecorator() {
        Criatura base = new Salvaje("Torchic", Afinidad.FUEGO, 70);

        // Aplicamos transformación (Decorator)
        Criatura transformada = new LlamaInterna(base); 
        // LlamaInterna no afecta afinidad si es FUEGO → queda estable

        Criatura agua = new Salvaje("Mudkip", Afinidad.AGUA, 60);

        Interacciones inter = new Interacciones();
        inter.interactuar(transformada, agua);

        // Afinidades opuestas → ambas inestables
        assertTrue(transformada.isInestable());
        assertTrue(agua.isInestable());
    }

    @Test
    public void queDecoratorNoAfecteDominioAncestral() {
        Criatura ancestral = new Ancestral("Rayquaza", Afinidad.AIRE, 100);

        // Criatura común, pero transformada con AscensoDelViento (Decorator)
        Criatura decorada = new AscensoDelViento(new Domesticada("Eevee", Afinidad.TIERRA, 50));

        Interacciones inter = new Interacciones();
        inter.interactuar(ancestral, decorada);

        // Ancestral domina siempre
        assertEquals((Integer)120, ancestral.getEnergia());  // +20
        assertEquals((Integer)35, decorada.getEnergia());    // 50 - 15
    }
}