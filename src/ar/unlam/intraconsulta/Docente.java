package ar.unlam.intraconsulta;

import java.util.ArrayList;

public class Docente {
	
	private Integer dni;
	private String nombre;
	private String apellido;
	private ArrayList<Comision> comisionesDelDocente; 
	
	
	public Docente(Integer dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public ArrayList<Comision> getComisionesDelDocente() {
		return comisionesDelDocente;
	}

	public boolean agregarComisionesAlDocente(Comision comision) {
		return this.comisionesDelDocente.add(comision);
	}
	

}
