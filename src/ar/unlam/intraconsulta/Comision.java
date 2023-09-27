package ar.unlam.intraconsulta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Comision {

	private Integer id;
	private static Integer incrementoId= 0;
	private Materia materia;
	private CicloLectivo cicloLectivo;
	private Turno turno;
	private Aula aula;
	private ArrayList<Docente> docentesDeLaComision;
	private ArrayList<Alumno> alumnosDeLaComision;
	private ArrayList<RegistroNotasDeExamen> registroDeNotas;

	public Comision(Materia materia, CicloLectivo cicloLectivo, Turno turno, Aula aula) {
		this.id = incrementoId;
		incrementoId++;
		this.materia = materia;
		this.cicloLectivo = cicloLectivo;
		this.turno = turno;
		this.aula = aula;
		this.alumnosDeLaComision = new ArrayList<>();
		this.docentesDeLaComision = new ArrayList<>();
	}

	public Boolean registrarNota(Integer idComision, Integer idAlumno, Nota nota) {

		Alumno alumnoACalificar = buscarAlumnoDeLaComision(idAlumno);

		if (alumnoACalificar == null || nota == null) {
			return false;
		}

		if (nota.getValor() < 0 || nota.getValor() > 10) {
			return false;

		}

		Nota recuPrimerParcial = buscarNotaPorTipo(TipoNota.RECUPERATORIO_PRIMERPARCIAL, idAlumno);
		Nota recuSegundoParcial = buscarNotaPorTipo(TipoNota.RECUPERATORIO_SEGUNDOPARCIAL, idAlumno);
		Nota primerParcial = buscarNotaPorTipo(TipoNota.PRIMER_PARCIAL, idAlumno);
		Nota segundoParcial = buscarNotaPorTipo(TipoNota.SEGUNDO_PARCIAL, idAlumno);

		if (recuPrimerParcial.getValor() != 0 && nota.getTipoNota().equals(recuSegundoParcial.getTipoNota())) {
			return false;
		}

		if (recuSegundoParcial.getValor() != 0 && nota.getTipoNota().equals(recuPrimerParcial.getTipoNota())) {
			return false;
		}

		if (nota.getTipoNota().equals(TipoNota.FINAL) && primerParcial.getValor() < 4 || segundoParcial.getValor() < 4
				|| recuPrimerParcial.getValor() < 4 || recuSegundoParcial.getValor() < 4) {
			return false;
		}

		RegistroNotasDeExamen notaARegistrar = new RegistroNotasDeExamen(alumnoACalificar, nota);

		return this.registroDeNotas.add(notaARegistrar);

	}

	public Integer calcularPromedio(Integer idAlumno) {

		Integer promedioDeAlumno;
		Integer acumDeNotas = null;
		Alumno alumnoQueDeseaSaberElPromedio = buscarAlumnoDeLaComision(idAlumno);

		for (int i = 0; i < registroDeNotas.size(); i++) {
			if (registroDeNotas.get(i).getAlumno().getId().equals(idAlumno)) {
				acumDeNotas += registroDeNotas.get(i).getNota().getValor();
			}
		}
		promedioDeAlumno = acumDeNotas / 4;

		return promedioDeAlumno;
	}

	private Nota buscarNotaPorTipo(TipoNota tipoDeNotaAbuscar, Integer idAlumno) {

		Nota notaEncontrada = null;

		for (int i = 0; i < registroDeNotas.size(); i++) {
			if (registroDeNotas.get(i).getNota().getTipoNota().equals(tipoDeNotaAbuscar)
					&& registroDeNotas.get(i).getAlumno().getId().equals(idAlumno)) {
				notaEncontrada = registroDeNotas.get(i).getNota();
				return notaEncontrada;
			}
		}
		return notaEncontrada;
	}

	private Alumno buscarAlumnoDeLaComision(Integer idAlumno) {

		Alumno alumnoEncontrado = null;

		for (int i = 0; i < alumnosDeLaComision.size(); i++) {
			if (alumnosDeLaComision.get(i).getDni() == idAlumno) {
				alumnoEncontrado = alumnosDeLaComision.get(i);
				return alumnoEncontrado;
			}
		}

		return alumnoEncontrado;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}

	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public ArrayList<Docente> getDocentesDeLaComision() {
		return docentesDeLaComision;
	}

	public boolean agregarDocentesALaComision(Docente docente) {
		return this.docentesDeLaComision.add(docente);
	}

	public ArrayList<Alumno> getAlumnosDeLaComison() {
		return alumnosDeLaComision;
	}

	public boolean agregarAlumnosALaComison(Alumno alumno) {
		return this.alumnosDeLaComision.add(alumno);
	}

}
