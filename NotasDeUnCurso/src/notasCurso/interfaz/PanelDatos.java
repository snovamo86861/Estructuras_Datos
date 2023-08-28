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
package notasCurso.interfaz;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Panel donde se muestran los datos.
 */
@SuppressWarnings("serial")
public class PanelDatos extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal.
     */
    private InterfazNotasCurso ventana;

    /**
     * Número de estudiantes en el curso.
     */
    private int numEstudiantes;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiquetas de los números de estudiantes.
     */
    private JLabel etiquetasNumeros[];

    /**
     * Etiquetas de las notas de los estudiantes.
     */
    private JLabel etiquetasNotas[];

    /**
     * Botones de cambiar nota.
     */
    private JButton btnCambiar[];

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     *
     * @param pVentana     Ventana principal. pVentana != null.
     * @param pNumeroNotas Número de notas a manejar. pNumeroNotas >0
     */
    public PanelDatos(InterfazNotasCurso pVentana, int pNumeroNotas) {
        // Guarda los datos
        ventana = pVentana;
        numEstudiantes = pNumeroNotas;

        etiquetasNumeros = new JLabel[numEstudiantes];
        etiquetasNotas = new JLabel[numEstudiantes];
        btnCambiar = new JButton[numEstudiantes];

        setBorder(new TitledBorder("Notas"));
        setLayout(new GridLayout(numEstudiantes, 3, 5, 5));

        Font fuenteTexto = new JLabel().getFont();
        fuenteTexto = fuenteTexto.deriveFont(fuenteTexto.getStyle() ^ Font.BOLD);

        // Crea los datos usando un ciclo
        for (int i = 0; i < numEstudiantes; i++) {
            etiquetasNumeros[i] = new JLabel("Estudiante " + Integer.toString(i + 1) + ": ");
            etiquetasNumeros[i].setFont(fuenteTexto);
            add(etiquetasNumeros[i]);

            etiquetasNotas[i] = new JLabel("0.0");
            etiquetasNotas[i].setForeground(Color.BLUE);
            etiquetasNotas[i].setHorizontalAlignment(JLabel.CENTER);
            add(etiquetasNotas[i]);

            btnCambiar[i] = new JButton("Cambiar");
            btnCambiar[i].setBackground(new Color(245, 245, 245));
            btnCambiar[i].addActionListener(this);
            btnCambiar[i].setActionCommand(Integer.toString(i));
            add(btnCambiar[i]);
        }
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza las notas en la interfaz.
     *
     * @param pNota             Nota del estudiante.
     * @param pNumeroEstudiante Número de estudiante. 1 <= pNumeroEstudiante <= 12.
     */
    public void refrescarNota(int pNumeroEstudiante, double pNota) {
        etiquetasNotas[pNumeroEstudiante - 1].setText(Double.toString(pNota));
    }

    /**
     * Manejo de eventos de los botones.
     *
     * @param pEvento Evento que generó la acción. pEvento != null.
     */
    public void actionPerformed(ActionEvent pEvento) {
        // Saca el numero del estudiante
        int estudiante = Integer.parseInt(pEvento.getActionCommand()) + 1;
        ventana.cambiarNota(estudiante);
    }
}