package model;

public class Vivienda {
	int id;
	String descripcion;
	int idLocalidad;
	
	
	public Vivienda() {
		super();
	}
	public Vivienda(int id, String descripcion, int idLocalidad) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.idLocalidad = idLocalidad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdLocalidad() {
		return idLocalidad;
	}
	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
	@Override
	public String toString() {
		return descripcion ;
	}
	
	
}
