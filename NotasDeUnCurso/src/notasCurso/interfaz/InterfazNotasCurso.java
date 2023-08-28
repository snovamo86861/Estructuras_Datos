/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Desarrollo de Software - Guía 2 - Actividad 2
 * Ejercicio: Notas de un curso
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package notasCurso.interfaz;

import notasCurso.mundo.Curso;

import java.awt.*;

import javax.swing.*;

/**
 * Esta es la ventana principal de la aplicación.
 */
@SuppressWarnings("serial")
public class InterfazNotasCurso extends JFrame {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo.
     */
    private Curso curso;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel banner de la aplicación.
     */
    private PanelBanner panelBanner;

    /**
     * Panel imagen del curso.
     */
    private PanelImagen panelImagen;

    /**
     * Panel donde se muestran las notas.
     */
    private PanelDatos panelDatos;

    /**
     * Panel de opciones adicionales.
     */
    private PanelAdicionales panelAdicionales;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye la interfaz de notas del curso. <br>
     * <b>post: </b> Se inicializaron los componentes gráficos de la aplicación.
     */
    public InterfazNotasCurso() {
        setTitle("Sistema de Manejo de Notas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);

        // Crea la clase principal
        curso = new Curso();
        // organizar el panel principal
        setLayout(new BorderLayout());

        panelBanner = new PanelBanner();
        add(panelBanner, BorderLayout.NORTH);

        panelImagen = new PanelImagen();
        add(panelImagen, BorderLayout.WEST);

        panelDatos = new PanelDatos(this, Curso.TOTAL_EST);
        add(panelDatos, BorderLayout.CENTER);

        panelAdicionales = new PanelAdicionales(this);
        add(panelAdicionales, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setResizable(false);
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Cambia la nota de un estudiante.
     *
     * @param pEstudiante Estudiante a modificar. 1 <= pEstudiante <=12.
     */
    public void cambiarNota(int pEstudiante) {
        String notaStr = JOptionPane.showInputDialog(this, "Nueva nota:", "Nota", JOptionPane.QUESTION_MESSAGE);
        try {
            if (notaStr != null) {
                double nota = Double.parseDouble(notaStr);
                // valida el valor de nota
                if (nota < 0 || nota > 100) {
                    JOptionPane.showMessageDialog(this, "La nota debe tener un valor entre 0.0 y 100.0", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    // Cambia la nota
                    curso.cambiarNota(pEstudiante, nota);
                    // Repinta el panel
                    panelDatos.refrescarNota(pEstudiante, curso.darNota(pEstudiante));
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La nota debe tener un valor numérico. (ej. 2.5)", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Muestra el promedio en un mensaje de texto.
     */
    public void mostrarPromedio() {
        JOptionPane.showMessageDialog(this, "Promedio: " + Double.toString(curso.promedio()), "Promedio", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra el número de estudiantes con nota mayor al promedio.
     */
    public void mostrarMayores() {
        JOptionPane.showMessageDialog(this, "Número de estudiantes con nota mayor al promedio: " + Integer.toString(curso.darCantidadSobrePromedio()), "Estudiantes", JOptionPane.INFORMATION_MESSAGE);
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 3.
     */
    public void reqFuncOpcion3() {
        double porcentaje = curso.darPorcentajePasaron();
        String resultado = String.format("El porcentaje de estudiantes que pasaron es de %.2f %%", porcentaje);
        JOptionPane.showMessageDialog(this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para la extensión 2.
     */
    public void reqFuncOpcion2() {
        double mejorNota = curso.mejorNota();
        String resultado = String.format("La mejor nota del curso fue %.2f", mejorNota);
        JOptionPane.showMessageDialog(this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para la extensión 1.
     */
    public void reqFuncOpcion1() {
        int cont = curso.cantidadReprobados();
        String resultado = "Hay " + cont + " estudiantes que reprobaron el curso";
        JOptionPane.showMessageDialog(this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para la extensión 4
     */
    public void reqFuncOpcion4() {
        String resultado;
        if (curso.todosPasaron()) {
            resultado = "En esta oportunidad, todos aprobaron el curso.";
        }
        else {
            resultado = "En el curso, hay estudiantes que reprobaron!";
        }
        JOptionPane.showMessageDialog(this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Ejecuta la aplicación.
     *
     * @param pArgs Parámetros de la ejecución. No son necesarios.
     */
    public static void main(String[] pArgs) {
        try {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

            InterfazNotasCurso interfaz = new InterfazNotasCurso();
            interfaz.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}