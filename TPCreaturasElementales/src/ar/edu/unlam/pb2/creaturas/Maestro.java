package ar.edu.unlam.pb2.creaturas;

import java.util.HashMap;

public class Maestro {

	private String nombre;
	private Integer nivelDeMaestria;
	private Afinidad afinidad;
	private HashMap<String, Criatura> criaturasACargo; //el string es para el nombre de la criatura
	
	public Maestro(String nombre, Integer nivel, Afinidad afinidad) {
		this.nombre=nombre;
		this.nivelDeMaestria=nivel;
		this.afinidad=afinidad;
		this.criaturasACargo=new HashMap<>();
	}
	
	public void agregarCriatura(Criatura criatura) {
		this.criaturasACargo.put(criatura.getNombre(), criatura);
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

	public HashMap<String, Criatura> getCriaturasACargo() {
		return criaturasACargo;
	}
	
	
}
