package ar.edu.unlam.pb2.creaturas;

public abstract class Criatura implements Entrenamiento{
	
	private String nombre;
	private Afinidad afinidad;
	protected Integer energia;
	protected Boolean inestable = false;

	public Criatura(String nombre, Afinidad afinidad, Integer energia) {
		if (energia < 0 || energia > 200) {
			throw new IllegalArgumentException("La energia debe ser entre entre 0 y 200 puntos");
		}
		
		this.nombre = nombre;
		this.afinidad = afinidad;
		this.energia = energia;
	}
	
	public Criatura() {
		
	}
	
	public void pacificar() { //sirve para que podamos cambiarle el estado
	    if (this.inestable) {
	        this.inestable = false;
	    }
	}

	public String getNombre() {
		return nombre;
	}

	public Afinidad getAfinidad() {
		return afinidad;
	}

	public Integer getEnergia() {
		return energia;
	}
	
	public Boolean isInestable() {
		return inestable;
	}

	public void setInestable(Boolean inestable) {
		this.inestable = inestable;
	}

	public void setEnergia(Integer energia) {
		this.energia = energia;
	}

	public abstract void entrenar();

}
