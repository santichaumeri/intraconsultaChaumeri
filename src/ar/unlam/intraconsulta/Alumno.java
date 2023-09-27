package ar.unlam.intraconsulta;

import java.util.ArrayList;

public class Alumno {
	 
	private static Integer incrementoId= 0;
	private Integer dni;
	private String apellido;
	private String nombre;
	private ArrayList<Comision> comisionesAlumno;
	private Integer id;
	
	
	public Alumno(Integer dni, String apellido, String nombre) {	
		this.dni = incrementoId;
		this.id= incrementoId;
		this.apellido = apellido;
		this.nombre = nombre;
		incrementoId++;
		comisionesAlumno = new ArrayList<>();
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Comision> getComisionesAlumno() {
		return comisionesAlumno;
	}

	public boolean agregarComisionesAlAlumno(Comision comision) {
		return this.comisionesAlumno.add(comision);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
