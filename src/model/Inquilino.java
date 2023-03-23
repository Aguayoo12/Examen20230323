package model;

import java.sql.Date;

public class Inquilino {
	int id;
	String dni;
	String nombreCompleto;
	Date fechaIni;
	Date fechaFin;
	float cuotaMensual;
	int idVivienda;
	public Inquilino() {
		super();
	}
	public Inquilino(int id, String dni, String nombreCompleto, Date fechaIni, Date fechaFin, float cuotaMensual,
			int idVivienda) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.cuotaMensual = cuotaMensual;
		this.idVivienda = idVivienda;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public Date getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public float getCuotaMensual() {
		return cuotaMensual;
	}
	public void setCuotaMensual(float cuotaMensual) {
		this.cuotaMensual = cuotaMensual;
	}
	public int getIdVivienda() {
		return idVivienda;
	}
	public void setIdVivienda(int idVivienda) {
		this.idVivienda = idVivienda;
	}
	@Override
	public String toString() {
		return "Inquilino [id=" + id + ", dni=" + dni + ", nombreCompleto=" + nombreCompleto + ", fechaIni=" + fechaIni
				+ ", fechaFin=" + fechaFin + ", cuotaMensual=" + cuotaMensual + ", idVivienda=" + idVivienda + "]";
	}
	
	
}
