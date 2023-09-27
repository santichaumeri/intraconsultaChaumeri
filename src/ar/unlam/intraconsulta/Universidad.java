package ar.unlam.intraconsulta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {

	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias;
	private ArrayList<CicloLectivo> ciclosLectivos;
	private ArrayList<Comision> comisiones;
	private ArrayList<Docente> docentes;

	public Universidad() {
		this.alumnos = new ArrayList<>();
		this.materias = new ArrayList<>();
		this.ciclosLectivos = new ArrayList<>();
		this.comisiones = new ArrayList<>();
		this.docentes = new ArrayList<>();
	}

	public Boolean agregarAlumnos(Alumno alumno) {
		if (alumnos.contains(alumno))
			return false;

		return alumnos.add(alumno);

	}

	public Boolean agregarMaterias(Materia materia) {

		if (materias.contains(materia))
			return false;

		return materias.add(materia);
	}

	public Boolean crearCicloLectivo(CicloLectivo cl) {

		if (ciclosLectivos.contains(cl))
			return false;

		return ciclosLectivos.add(cl);

	}

	public Boolean agregarComision(Comision comision) {

		for (int i = 0; i < comisiones.size(); i++) {
			if ((comisiones.get(i).getId() == comision.getId())
					|| (comisiones.get(i).getCicloLectivo().getId() == comision.getId())
					|| (comisiones.get(i).getTurno().equals(comision.getTurno()))) {
				return false;
			}

		}

		return comisiones.add(comision);
	}

	public Boolean agregarDocentes(Docente docente) {
		if (docentes.contains(docente))
			return false;

		return docentes.add(docente);

	}

	public Docente existeDocente(Integer dni) {
		Docente docenteEncontrado = null;

		for (int i = 0; i < docentes.size(); i++) {
			if (docentes.get(i).getDni() == dni) {
				docenteEncontrado = docentes.get(i);
				return docenteEncontrado;
			}
		}
		return docenteEncontrado;
	}

	public Comision existeComision(Integer idComision) {
		Comision comisionEncontrada = null;

		for (int i = 0; i < comisiones.size(); i++) {
			if (comisiones.get(i).getId() == idComision) {
				comisionEncontrada = comisiones.get(i);
				return comisionEncontrada;
			}
		}

		return comisionEncontrada;
	}

	public Alumno buscarAlumno(Integer dniAlumno) {

		Alumno alumnoEncontrado = null;

		for (int i = 0; i < alumnos.size(); i++) {
			if (alumnos.get(i).getDni() == dniAlumno) {
				alumnoEncontrado = alumnos.get(i);
				return alumnoEncontrado;
			}
		}

		return alumnoEncontrado;
	}

	public Boolean inscribirAlumnoACurso(Integer dniAlumno, Integer idComision, LocalDate fechaActual) {

		// Verificar que el alumno y el curso este dado de alta
		// No se puede inscribir Alumnos si este no tiene al menos cursada todas las
		// correlativas
		// (Todas las correlativas Con nota >=4)
		// La inscripción no se puede realizar si esta fuera de fecha Inscripción
		// No se puede inscribir el alumno si excede la cantidad de alumnos permitos en
		// el aula
		// No se puede inscribir el Alumno si ya está inscripto a otro curso para el
		// mismo día y Turno

		Alumno alumnoDeAlta = buscarAlumno(dniAlumno);
		Comision comisionDeAlta = existeComision(idComision);

		if (alumnoDeAlta == null || comisionDeAlta == null) {
			return false;
		}

//		ArrayList<Materia> correlativas= comisionDeAlta.getMateria().getCorrelativas();
//		for (int i = 0; i < correlativas.size(); i++) {
//			
//		}

		if (fechaActual.isAfter(comisionDeAlta.getCicloLectivo().getFechaFinalizacionInscripcion())
				|| fechaActual.isBefore(comisionDeAlta.getCicloLectivo().getFechaInicioInscripcion())) {
			return false;
		}

		if (alumnoDeAlta.getId() > comisionDeAlta.getAula().getCantAlumnos()) {
			return false;
		}

		ArrayList<Comision> comisionesDelAlumno = alumnoDeAlta.getComisionesAlumno();
		for (int i = 0; i < comisionesDelAlumno.size(); i++) {
			if (comisionesDelAlumno.get(i).getTurno().equals(comisionDeAlta.getTurno())) {
				return false;
			}
		}

		return alumnoDeAlta.getComisionesAlumno().add(comisionDeAlta)
				&& comisionDeAlta.getAlumnosDeLaComison().add(alumnoDeAlta);

	}
	
	public Boolean asignarDocenteAlCurso(Integer idComision, Integer dniDocente) {
		
		Docente docenteDeAlta= existeDocente(dniDocente); 
		Comision comisionDeAlta= existeComision(idComision); 
		Integer cantAlumnos = comisionDeAlta.getAula().getCantAlumnos();
		Boolean asignado= false;
		
		
		if(docenteDeAlta != null && comisionDeAlta != null) {
			
			if(cantAlumnos < 20 && comisionDeAlta.getDocentesDeLaComision().size() == 0) {
				
				docenteDeAlta.agregarComisionesAlDocente(comisionDeAlta); 
				asignado= comisionDeAlta.agregarDocentesALaComision(docenteDeAlta); 
				
			}else 
				if(comisionDeAlta.getDocentesDeLaComision().size() >= 1) {
					for (int i = 0; i < comisionDeAlta.getDocentesDeLaComision().size(); i++) {
						
						if (comisionDeAlta.getDocentesDeLaComision().get(i).getDni() != dniDocente) {
							
							if (cantAlumnos < 40 && comisionDeAlta.getDocentesDeLaComision().size() == 1) {
								docenteDeAlta.agregarComisionesAlDocente(comisionDeAlta); 
								asignado= comisionDeAlta.agregarDocentesALaComision(docenteDeAlta); 
							}
							
							if (cantAlumnos < 60 && comisionDeAlta.getDocentesDeLaComision().size() == 2) {
								docenteDeAlta.agregarComisionesAlDocente(comisionDeAlta); 
								asignado= comisionDeAlta.agregarDocentesALaComision(docenteDeAlta); 
							}
							
							if (cantAlumnos < 80 && comisionDeAlta.getDocentesDeLaComision().size() == 3) {
								docenteDeAlta.agregarComisionesAlDocente(comisionDeAlta); 
								asignado= comisionDeAlta.agregarDocentesALaComision(docenteDeAlta); 
							}
							
							if (cantAlumnos < 100 && comisionDeAlta.getDocentesDeLaComision().size() == 4) {
								docenteDeAlta.agregarComisionesAlDocente(comisionDeAlta); 
								asignado= comisionDeAlta.agregarDocentesALaComision(docenteDeAlta); 
							}
						}
					}
			}
		}

		return asignado;
	}
	
	
	

}
