/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Evaluador de Expresiones Postfijas
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.desarrollosw.postfijo;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.*;

/**
 * Esta clase representa una clase que evalúa expresiones en notación polaca o
 * postfija. Por ejemplo: 4 5 +
 */
public class EvaluadorPostfijo {

    /**
     * Permite saber si la expresión en la lista está balanceada
     * o no. Cada elemento de la lista es un elemento. DEBE OBlIGATORIAMENTE
     * USARSE EL ALGORITMO QUE ESTÁ EN EL ENUNCIADO.
     */
    static boolean estaBalanceada(List<String> expresion) {
        Stack<String> delimitadores = new Stack<>();
        for (String elemento : expresion) {
            if (esOperando(elemento)) {
                // Si es un operando (número), ignóralo y continúa con el siguiente elemento.
                continue;
            } else if (esOperador(elemento)) {
                if (delimitadores.isEmpty()) {
                    // Si la pila está vacía y encontramos un operador, la expresión no está balanceada.
                    return false;
                }

                // Retira un elemento de la pila y verifica si coincide con el operador actual.
                String delimitador = delimitadores.pop();
                if (!coincideDelimitadorOperador(delimitador, elemento)) {
                    return false;
                }
            } else {
                // Si el elemento no es ni operando ni operador, la expresión no está balanceada.
                return false;
            }
        }

        // Si la pila está vacía al final, la expresión está balanceada.
        return delimitadores.isEmpty();
    }



    /**
     * Transforma la expresión, cambiando los símbolos de agrupación
     * de corchetes ([]) y llaves ({}) por paréntesis ()
     */


    static void reemplazarDelimitadores(List<String> expresion) {
        for (int i = 0; i < expresion.size(); i++) {
            String token = expresion.get(i);
            StringBuilder nuevoToken = new StringBuilder();

            for (int j = 0; j < token.length(); j++) {
                char caracter = token.charAt(j);

                if (caracter == '[' || caracter == ']') {
                    nuevoToken.append('('); // Reemplaza corchetes por paréntesis
                } else if (caracter == '{' || caracter == '}') {
                    nuevoToken.append('('); // Reemplaza llaves por paréntesis
                } else {
                    nuevoToken.append(caracter);
                }
            }

            expresion.set(i, nuevoToken.toString());
        }
    }

    /**
     * Realiza la conversión de la notación infija a postfija
     * @return la expresión convertida a postfija
     * OJO: Debe usarse el algoritmo que está en el enunciado OBLIGATORIAMENTE
     */
    static List<String> convertirAPostfijo(List<String> expresion) {
        Stack<String> pila = new Stack<>();
        List<String> salida = new ArrayList<>();

        // TODO: Escriba el algoritmo aquí

        return salida;
    }

    static List<String> convertirAPostfijo(List<String> expresion) {
        Stack<String> pila = new Stack<>();
        List<String> salida = new ArrayList<>();

        // Definimos la precedencia de los operadores
        Map<String, Integer> precedencia = new HashMap<>();
        precedencia.put("+", 1);
        precedencia.put("-", 1);
        precedencia.put("*", 2);
        precedencia.put("/", 2);

        for (String token : expresion) {
            if (esOperando(token)) {
                // Si es un operando, lo agregamos a la salida directamente
                salida.add(token);
            } else if (esOperador(token)) {
                // Si es un operador, manejamos la precedencia
                while (!pila.isEmpty() && esOperador(pila.peek()) &&
                        precedencia.get(pila.peek()) >= precedencia.get(token)) {
                    salida.add(pila.pop());
                }
                pila.push(token);
            } else if (token.equals("(")) {
                // Si es un paréntesis abierto, lo colocamos en la pila
                pila.push(token);
            } else if (token.equals(")")) {
                // Si es un paréntesis cerrado, desapilamos operadores hasta encontrar el paréntesis abierto correspondiente
                while (!pila.isEmpty() && !pila.peek().equals("(")) {
                    salida.add(pila.pop());
                }
                pila.pop(); // Quitamos el paréntesis abierto de la pila
            }
        }

        // Desapilamos cualquier operador que quede en la pila
        while (!pila.isEmpty()) {
            salida.add(pila.pop());
        }

        return salida;
    }

    /**
     * Realiza la evaluación de la expresión postfijo utilizando una pila
     * @param expresion una lista de elementos con números u operadores
     * @return el resultado de la evaluación de la expresión.
     */

    static int evaluarPostFija(List<String> expresion) {
        Stack<Integer> pila = new Stack<>();

        for (String elemento : expresion) {
            if (esNumero(elemento)) {
                // Si el elemento es un número, lo conviertes a Integer y lo apilas en la pila
                pila.push(Integer.parseInt(elemento));
            } else {
                // Si el elemento es un operador, desapilas los dos últimos números de la pila
                int operand2 = pila.pop();
                int operand1 = pila.pop();

                // Realizas la operación correspondiente y apilas el resultado en la pila
                int resultado = realizarOperacion(operand1, operand2, elemento);
                pila.push(resultado);
            }
        }

        // Al final, la pila debe contener el resultado final de la expresión
        return pila.pop();
    }


}

