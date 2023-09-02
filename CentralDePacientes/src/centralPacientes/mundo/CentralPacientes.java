/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento de Tecnolog�as de la Informaci�n y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralPacientes.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de pacientes
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Vector de cl�nicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de cl�nicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Cl�nica del Country");
        listaClinicas.add("Cl�nica Palermo");
        listaClinicas.add("Cl�nica Reina Sof�a");
        listaClinicas.add("Cl�nica El Bosque");
        listaClinicas.add("Cl�nica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el n�mero de pacientes de la cl�nica
     *
     * @return El n�mero de pacientes de la cl�nica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     *
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlComienzo(Paciente pac) {
        // TODO: Realiar el m�todo que agrega al principio
        if (pac !=null %% !pacientes.contains(pac)){
            pacientes.add(0, pac);
        }
    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista est� vac�a el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con c�digo igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        // Verificar que el paciente no sea nulo y que no exista un paciente con el mismo código
        if (pac != null && !existePacienteConCodigo(pac.getCodigo())) {
            // Verificar si la lista está vacía
            if (pacientes.isEmpty()) {
                // Si la lista está vacía, agregar el paciente al principio
                pacientes.add(pac);
            } else {
                // Si la lista no está vacía, agregar el paciente al final
                pacientes.add(pacientes.size(), pac);
            }
        }
    }


    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el c�digo especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        ListIterator<Paciente> iterator = pacientes.listIterator();
        while (iterator.hasNext()) {
            Paciente paciente = iterator.next();
            if (paciente.getCodigo() == cod) {
                iterator.previous(); // Retrocedemos para agregar antes del paciente actual
                iterator.add(pac);
                return;
            }
        }
        throw new NoExisteException("No se encontró un paciente con el código especificado: " + cod);
    }
}

    /**
     * Adiciona un paciente a la lista de pacientes despu�s del paciente con el c�digo especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        ListIterator<Paciente> iterator = pacientes.listIterator();
        while (iterator.hasNext()) {
            Paciente paciente = iterator.next();
            if (paciente.getCodigo() == cod) {
                iterator.add(pac); // Agregamos el paciente después del paciente actual
                return;
            }
        }
        throw new NoExisteException("No se encontró un paciente con el código especificado: " + cod);
    }
}

    /**
     * Busca el paciente con el c�digo dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCodigo() == codigo) {
                return paciente; // Se encontró el paciente, lo retornamos
            }
        }

        // Si llegamos aquí, no se encontró el paciente con el código dado
        return null;
    }

    /**
     * Elimina el paciente con el c�digo especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        // TODO: Si no existe el paciente con el c�digo dado, genera la excepci�n
    }



    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de cl�nicas manejadas por la central
     */
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    /**
     * Retorna la longitud de la lista
     */
    private int darLongitud() {
        return pacientes.size();
    }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres()
        int contador = 0;
        for (Paciente paciente : pacientes){
            if(paciente.getGenero().equalsIgnoreCase("masculino")){
                contador++;
            }
        }
        return contador;
    }


    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres() {
        int contador = 0;
        for (Paciente paciente : pacientes){
            if(paciente.getGenero().equalsIgnoreCase("femenino")){
                contador++;
            }
        }
        return contador;

    }

    /**
     * De las 6 opciones de cl�nicas que tiene la central
     * �Cu�l es el nombre de la m�s ocupada, la que tiene m�s pacientes?
     *
     * @return nombre de la cl�nica
     */
    public String metodo4() {
        // TODO: Completar
        return "Respuesta 4";
    }


}
