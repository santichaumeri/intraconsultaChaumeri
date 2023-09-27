package ar.unlam.intraconsulta;

public class RegistroNotasDeExamen {
	
	private Alumno alumno;
	private Nota nota;
	
	
	public RegistroNotasDeExamen(Alumno alumno, Nota nota) {
		
		this.alumno = alumno;
		this.nota = nota;
		
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

}
