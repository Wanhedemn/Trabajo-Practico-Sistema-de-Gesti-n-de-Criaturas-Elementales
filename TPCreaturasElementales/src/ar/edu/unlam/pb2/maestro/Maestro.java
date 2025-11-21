package ar.edu.unlam.pb2.maestro;

import java.util.Map;
import java.util.HashMap;

import ar.edu.unlam.pb2.creaturas.Afinidad;
import ar.edu.unlam.pb2.creaturas.Criatura;

public class Maestro {

	private String nombre;
	private Integer nivelDeMaestria;
	private Afinidad afinidad;
	private Map<String, Criatura> criaturasACargo = new HashMap<>(); //el string es para el nombre de la criatura
	
	public Maestro(String nombre, Integer nivel, Afinidad afinidad) {
		this.nombre=nombre;
		this.nivelDeMaestria=nivel;
		this.afinidad=afinidad;
	}
	
	public void agregarCriatura(Criatura criatura) {
		this.criaturasACargo.put(criatura.getNombre(), criatura);
	}

	public void entrenarCriatura(Criatura criaturaAEntrenar) throws MaestriaInsuficienteException{
		if(this.nivelDeMaestria<20) { // solo puse un numero simbolico, es para probar nada mas
			throw new MaestriaInsuficienteException("El nivel del maestro " + this.nombre + " es insuficiente para realizar el entrenamiento");
		}
		criaturaAEntrenar.entrenar();
	}
	
	public String getNombre() {
		return nombre;
	}

	public Integer getNivelDeMaestria() {
		return nivelDeMaestria;
	}

	public Afinidad getAfinidad() {
		return afinidad;
	}

	public Map<String, Criatura> getCriaturasACargo() {
		return criaturasACargo;
	}
	
}
