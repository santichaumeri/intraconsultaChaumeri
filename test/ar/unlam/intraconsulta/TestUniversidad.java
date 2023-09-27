package ar.unlam.intraconsulta;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TestUniversidad {

	@Test
	public void queSePuedanAgregarAlumnos() {
		// preparacion de datos
		
		Integer dni = 4444;
		String apellido = "Perez";
		String nombre = "Julian";
		Universidad unlam = new Universidad();

		// ejecucion
		Alumno alumno = new Alumno(dni, apellido, nombre);
		// validacion

		assertTrue(unlam.agregarAlumnos(alumno));

	}

	@Test
	public void queNoSePuedaAgregarUnAlumnoSiEsteYaEstaAgregado() {
		// preparacion de datos
		Integer dni = 4444;
		String apellido = "Perez";
		String nombre = "Julian";
		Integer dni2 = 4444;
		String apellido2 = "Perez";
		String nombre2 = "Julian";
		Universidad unlam = new Universidad();

		// ejecucion
		Alumno alumno = new Alumno(dni, apellido, nombre);
		Alumno alumno2 = new Alumno(dni2, apellido2, nombre2);

		// validacion
		assertTrue(unlam.agregarAlumnos(alumno));
		assertFalse(unlam.agregarAlumnos(alumno2));

	}

	@Test
	public void queSePuedanAgregarMaterias() {
		// preparacion de datos
		Integer codigo = 4444;
		String nombre = "PB2";
		Universidad unlam =new Universidad();

		// ejecucion
		Materia materia = new Materia(codigo, nombre);

		// validacion
		assertTrue(unlam.agregarMaterias(materia));

	}

	@Test
	public void queNoSePuedaAgregarUnaMateriaSiEstaYaEstaAgregada() {
		// preparacion de datos
		Integer codigo = 4444;
		String nombre = "PB2";
		Integer codigo2 = 4444;
		String nombre2 = "PB2";
		Universidad unlam = new Universidad();

		// ejecucion
		Materia materia = new Materia(codigo, nombre);
		Materia materia2 = new Materia(codigo2, nombre2);

		// validacion
		assertTrue(unlam.agregarMaterias(materia));
		assertFalse(unlam.agregarMaterias(materia2));

	}

	@Test
	public void queSePuedanAgregarCiclosLectivos() {
		// preparacion de datos
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 2);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 31);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 8, 3);
		Universidad unlam = new Universidad();

		// ejecucion
		CicloLectivo cl = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		// validacion
		assertTrue(unlam.crearCicloLectivo(cl));

	}
	
	@Test
	public void queSeNoPuedanAgregarCiclosLectivosSiYaExisten() {
		// preparacion de datos
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 2);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 31);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 8, 3);
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2023, 12, 2);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2023, 7, 31);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2023, 8, 3);
		Universidad unlam = new Universidad();

		// ejecucion
		CicloLectivo cl = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		
		CicloLectivo cl2 = new CicloLectivo(fechaInicioCicloLectivo2, fechaFinalizacionCicloLectivo2,
				fechaInicioInscripcion2, fechaFinalizacionInscripcion2);


		// validacion
		assertTrue(unlam.crearCicloLectivo(cl));
		assertFalse(unlam.crearCicloLectivo(cl2));
	}
	
	@Test
	public void queSePuedanAgregarComisiones() {
		// preparacion de datos
		Integer codigo = 4444;
		String nombre = "PB2";
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 2);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 31);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 8, 3);
		Turno turno= Turno.MANIANA;
		Integer cantAlumnos= 100; 		
		Universidad unlam = new Universidad();

		// ejecucion
		Materia materia = new Materia(codigo, nombre);
		CicloLectivo cl = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Aula aula = new Aula(cantAlumnos); 
		Comision comision = new Comision(materia, cl, turno, aula);
				
		
		// validacion
		assertTrue(unlam.agregarComision(comision));
		
	}
	
	@Test
	public void queSeNoPuedanAgregarComisionSiEstaYaExiste() {
		// preparacion de datos
		Integer codigo = 4444;
		String nombre = "PB2";
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 2);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 31);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 8, 3);
		Turno turno= Turno.MANIANA;
		Integer cantAlumnos= 100; 	
		
		Integer codigo2 = 4444;
		String nombre2 = "PB2";
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2023, 8, 14);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2023, 12, 2);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2023, 7, 31);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2023, 8, 3);
		Turno turno2= Turno.MANIANA;
		Integer cantAlumnos2= 100; 		
		
		Universidad unlam = new Universidad();

		// ejecucion
		Materia materia = new Materia(codigo, nombre);
		CicloLectivo cl = new CicloLectivo(fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);
		Aula aula = new Aula(cantAlumnos); 
		Comision comision = new Comision(materia, cl, turno, aula);
				
		Materia materia2 = new Materia(codigo2, nombre2);
		CicloLectivo cl2 = new CicloLectivo(fechaInicioCicloLectivo2, fechaFinalizacionCicloLectivo2,
				fechaInicioInscripcion2, fechaFinalizacionInscripcion2);
		Aula aula2 = new Aula(cantAlumnos2); 
		Comision comision2 = new Comision(materia2, cl2, turno2, aula2);
		// validacion
		assertTrue(unlam.agregarComision(comision));
		assertFalse(unlam.agregarComision(comision2));
		
		
	}
	
	@Test
	public void queSePuedanAgregarDocentes() {
		// preparacion de datos
		
		Integer dni = 4444;
		String apellido = "Perez";
		String nombre = "Julian";
		Universidad unlam = new Universidad();

		// ejecucion
		Docente docente = new Docente(dni, apellido, nombre);
		// validacion

		assertTrue(unlam.agregarDocentes(docente));

	}
	
	@Test
	public void queNoSePuedaAgregarDocenteSiEsteYaExiste() {
		// preparacion de datos
		
		Integer dni = 4444;
		String apellido = "Perez";
		String nombre = "Julian";
		
		Integer dni2 = 4444;
		String apellido2 = "Perez";
		String nombre2 = "Julian";
		
		Universidad unlam = new Universidad();

		// ejecucion
		Docente docente = new Docente(dni, apellido, nombre);
		Docente docente2 = new Docente(dni2, apellido2, nombre2);
		
		// validacion
		assertTrue(unlam.agregarDocentes(docente));
		assertFalse(unlam.agregarDocentes(docente2));
	}
	
}
