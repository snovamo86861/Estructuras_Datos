/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Desarrollo de Software - Guía 2 - Actividad 2
 * Ejercicio: notas de un curso
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package notasCurso.mundo;

/**
 * Clase que representa un curso.
 */
public class Curso {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Total de estudiantes en el curso.
     */
    public final static int TOTAL_EST = 12;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Notas de los estudiantes.
     */
    private double[] notas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo curso, inicializando todas las notas en cero.
     */
    public Curso() {
        notas = new double[TOTAL_EST];
        for (int i = 0; i < notas.length; i++) {
            notas[i] = 0.0;
        }
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Calcula el promedio del curso.
     *
     * @return Promedio de todas las notas del curso. promedio >= 0.
     */

    public double promedio() {
        double sumaNotas = 0;

        for (double nota : notas) {
            sumaNotas += nota;
        }

        return sumaNotas / TOTAL_EST;
    }

    /**
     * Devuelve el número de estudiantes que tienen la nota mayor al promedio.
     *
     * @return Número de estudiantes que tienen la nota mayor al promedio. número >= 0.
     */
    public int darCantidadSobrePromedio() {
        double promedioCurso = promedio();
        int cantidadSobrePromedio = 0;

        for (double nota : notas) {
            if (nota > promedioCurso) {
                cantidadSobrePromedio++;
            }
        }

        return cantidadSobrePromedio;
    }

    /**
     * Devuelve la nota de un estudiante del curso.
     *
     * @param pNumEstudiante Número del estudiante : 1 <= estudiante <= 12.
     * @return Nota del estudiante.
     */
    public double darNota(int pNumEstudiante) {
        return notas[pNumEstudiante - 1];
    }

    /**
     * Cambia la nota de un estudiante en el curso.
     *
     * @param pNumEstudiante Número del estudiante. 1 <= estudiante <= 12.
     * @param pNota          Nota del estudiante.
     *
     * OJO: La nota debe estar entre 0 y 100
     */
    public void cambiarNota(int pNumEstudiante, double pNota) {
        if (pNota >= 0 && pNota <= 100) {
            notas[pNumEstudiante - 1] = pNota;
        }
    }


    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------
    /**
     * Obtener la cantidad de estudiantes que no pasaron el curso
     * Recuerde que la nota mínima para pasar el curso es 60.0
     */
    public int cantidadReprobados() {
        int cantidadReprobados = 0;

        for (double nota : notas) {
            if (nota < 60.0) {
                cantidadReprobados++;
            }
        }

        return cantidadReprobados;
    }

    /**
     * Obtener la mejor nota del curso.
     */
    public double mejorNota() {
        double mejorNota = 0;

        for (double nota : notas) {
            if (nota > mejorNota) {
                mejorNota = nota;
            }
        }

        return mejorNota;
    }

    /**
     * Obtener el porcentaje de estudiantes que pasaron el curso
     * Debe ser un número entre 0 y 100.
     */
    public double darPorcentajePasaron() {
        int cantidadAprobados = 0;

        for (double nota : notas) {
            if (nota >= 60.0) {
                cantidadAprobados++;
            }
        }

        return (double) cantidadAprobados / TOTAL_EST * 100;
    }

    /**
     * Determinar si todos los estudiantes del curso pasaron la materia
     * Retorna true si todos tuvieron notas aprobatorias, o false cuando al menos
     * un estudiante reprobó la materia.
     * Recuerde que para pasar la nota, esta nota debe ser mínimo 60.0
     */
    public boolean todosPasaron() {
        for (double nota : notas) {
            if (nota < 60.0) {
                return false;
            }
        }
        return true;
    }
}