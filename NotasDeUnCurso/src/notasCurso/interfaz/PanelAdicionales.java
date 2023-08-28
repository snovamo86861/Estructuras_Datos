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
 * Panel donde se muestran los datos adicionales y las opciones.
 */
@SuppressWarnings("serial")
public class PanelAdicionales extends JPanel implements ActionListener {

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando promedio.
     */
    private static final String PROMEDIO = "PROMEDIO";

    /**
     * Comando mayores.
     */
    private static final String MAYORES = "MAYORES";

    /**
     * Comando opción 1: cuantos perdieron
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Comando opción 2: la mejor nota
     */
    private static final String OPCION_2 = "OPCION_2";

    /**
     * Comando opción 3: el porcentaje de estudiantes pasaron
     */
    private static final String OPCION_3 = "OPCION_3";

    /**
     * Comando opción 2: todos ganaron la unidad de estudios
     */
    private static final String OPCION_4 = "OPCION_4";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal.
     */
    private InterfazNotasCurso ventana;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Botón promedio.
     */
    private JButton btnPromedio;

    /**
     * Botón número de estudiantes con nota mayor al promedio.
     */
    private JButton btnMayores;

    /**
     * Botón Extensión 1.
     */
    private JButton btnExtension1;

    /**
     * Botón Extensión 2.
     */
    private JButton btnExtension2;

    /**
     * Botón Extensión 3.
     */
    private JButton btnExtension3;

    /**
     * Botón Extensión 4.
     */
    private JButton btnExtension4;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     *
     * @param pPrincipal Ventana principal.
     */
    public PanelAdicionales(InterfazNotasCurso pPrincipal) {
        ventana = pPrincipal;
        setBorder(new TitledBorder("Adicionales"));
        setLayout(new GridLayout(2, 3));

        // Botón Promedio
        btnPromedio = new JButton("Promedio");
        btnPromedio.addActionListener(this);
        btnPromedio.setActionCommand(PanelAdicionales.PROMEDIO);
        add(btnPromedio);

        // Botón Mayores
        btnMayores = new JButton("# Mayor al promedio");
        btnMayores.addActionListener(this);
        btnMayores.setActionCommand(PanelAdicionales.MAYORES);
        add(btnMayores);

        // Botón Extensión 1
        btnExtension1 = new JButton("Reprobaron");
        btnExtension1.addActionListener(this);
        btnExtension1.setActionCommand(PanelAdicionales.OPCION_1);
        add(btnExtension1);

        // Botón Extensión 2
        btnExtension2 = new JButton("Mejor Nota");
        btnExtension2.addActionListener(this);
        btnExtension2.setActionCommand(PanelAdicionales.OPCION_2);
        add(btnExtension2);

        // Botón Extensión 3
        btnExtension3 = new JButton("Porcentaje Pasaron");
        btnExtension3.addActionListener(this);
        btnExtension3.setActionCommand(PanelAdicionales.OPCION_3);
        add(btnExtension3);

        // Botón Extensión 4
        btnExtension4 = new JButton("Todos Ganaron?");
        btnExtension4.addActionListener(this);
        btnExtension4.setActionCommand(PanelAdicionales.OPCION_4);
        add(btnExtension4);
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de eventos de los botones.
     *
     * @param pEvento Evento que generó la acción. pEvento != null.
     */
    public void actionPerformed(ActionEvent pEvento) {
        String comando = pEvento.getActionCommand();
        if (OPCION_1.equals(comando)) {
            ventana.reqFuncOpcion1();
        }
        else if (OPCION_2.equals(comando)) {
            ventana.reqFuncOpcion2();
        }
        else if (OPCION_3.equals(comando)) {
            ventana.reqFuncOpcion3();
        }
        else if (OPCION_4.equals(comando)) {
            ventana.reqFuncOpcion4();
        }
        else if (PROMEDIO.equals(comando)) {
            ventana.mostrarPromedio();
        }
        else if (MAYORES.equals(comando)) {
            ventana.mostrarMayores();
        }
    }
}
