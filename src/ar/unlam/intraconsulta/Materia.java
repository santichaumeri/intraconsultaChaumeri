package ar.unlam.intraconsulta;

import java.util.ArrayList; 

public class Materia {
	
	private static Integer incrementoId= 0;
	private String nombre; 
	private Integer codigo; 
	private ArrayList<Materia> correlativas; 
	
	public Materia(Integer codigo, String nombre) {
		this.codigo = incrementoId; 
		incrementoId++;
		this.nombre = nombre; 
		correlativas = new ArrayList<>();
	}

	public static Integer getIncrementoId() {
		return incrementoId;
	}

	public static void setIncrementoId(Integer incrementoId) {
		Materia.incrementoId = incrementoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Materia> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(ArrayList<Materia> correlativas) {
		this.correlativas = correlativas;
	}
	
	public boolean agregarCorrelativa(Materia correlativa) {
		if (correlativas.contains(correlativa))
			return false;
		
		return correlativas.add(correlativa);
	}
	
	public boolean eliminarCorrelativa(Materia correlativa) {
		if (correlativas.contains(correlativa)) {
			
			return correlativas.remove(correlativa);
			
		}
		return false;
		
	}
	
	
}
