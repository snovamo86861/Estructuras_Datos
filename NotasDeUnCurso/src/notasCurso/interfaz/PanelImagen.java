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

import javax.swing.*;
import javax.swing.border.*;

/**
 * Panel de la imagen del curso.
 */
@SuppressWarnings("serial")
public class PanelImagen extends JPanel {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Etiqueta usada para mostrar la imagen.
     */
    private JLabel etiquetaImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     */
    public PanelImagen() {
        setBorder(new EmptyBorder(3, 3, 3, 3));
        etiquetaImagen = new JLabel(new ImageIcon("./data/imagenClase.jpg"));
        JPanel panelBorde = new JPanel();
        panelBorde.setBorder(new TitledBorder(""));
        panelBorde.add(etiquetaImagen);
        add(panelBorde);
    }
}
