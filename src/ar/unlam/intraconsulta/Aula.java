package ar.unlam.intraconsulta;

public class Aula {
	private Integer numeroAula; 
	private Integer cantAlumnos;
	private static Integer incrementoId= 0;
	
	public Aula(Integer cantAlumnos) {
		this.numeroAula = incrementoId++;
		this.cantAlumnos = cantAlumnos;
	}

	public Integer getNumeroAula() {
		return numeroAula;
	}

	public void setNumeroAula(Integer numeroAula) {
		this.numeroAula = numeroAula;
	}

	public Integer getCantAlumnos() {
		return cantAlumnos;
	}

	public void setCantAlumnos(Integer cantAlumnosMaxima) {
		this.cantAlumnos = cantAlumnosMaxima;
	} 
	
	
}
