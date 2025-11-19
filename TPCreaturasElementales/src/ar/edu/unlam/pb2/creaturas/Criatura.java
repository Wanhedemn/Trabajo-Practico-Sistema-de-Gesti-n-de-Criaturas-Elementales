package ar.edu.unlam.pb2.creaturas;

public  class Criatura {
	
	private String nombre;
	private String afinidad;
	private Integer energia;
	private Boolean inestable = false;

	public Criatura(String nombre, String afinidad, Integer energia) {
		this.nombre = nombre;
		this.afinidad = afinidad;
		this.energia = energia;
	}

	public String getNombre() {
		return nombre;
	}

	public String getAfinidad() {
		return afinidad;
	}

	public Integer getEnergia() {
		return energia;
	}
	
	public Boolean getInestable() {
		return inestable;
	}

	public void setInestable(Boolean inestable) {
		this.inestable = inestable;
	}

}
