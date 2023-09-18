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
            if (esDelimitadorApertura(elemento)) {
                delimitadores.push(elemento);
            } else if (esDelimitadorCierre(elemento)) {
                if (delimitadores.isEmpty()) {
                    return false;
                }

                String delimitadorTope = delimitadores.pop();
                if (!sonPareja(delimitadorTope, elemento)) {
                    return false;
                }
            }
        }

        return delimitadores.isEmpty();
    }

    // Función para verificar si un elemento es un delimitador de apertura
    static boolean esDelimitadorApertura(String elemento) {
        return elemento.equals("(") || elemento.equals("[") || elemento.equals("{");
    }

    // Función para verificar si un elemento es un delimitador de cierre
    static boolean esDelimitadorCierre(String elemento) {
        return elemento.equals(")") || elemento.equals("]") || elemento.equals("}");
    }

    // Función para verificar si dos delimitadores son pareja (por ejemplo, '(' y ')')
    static boolean sonPareja(String delimitadorApertura, String delimitadorCierre) {
        return (delimitadorApertura.equals("(") && delimitadorCierre.equals(")")) ||
                (delimitadorApertura.equals("[") && delimitadorCierre.equals("]")) ||
                (delimitadorApertura.equals("{") && delimitadorCierre.equals("}"));
    }


    /**
     * Transforma la expresión, cambiando los símbolos de agrupación
     * de corchetes ([]) y llaves ({}) por paréntesis ()
     */

    static void reemplazarDelimitadores(List<String> expresion) {
        for (int i = 0; i < expresion.size(); i++) {
            String elemento = expresion.get(i);

            if (elemento.equals("[")) {
                expresion.set(i, "(");
            } else if (elemento.equals("]")) {
                expresion.set(i, ")");
            } else if (elemento.equals("{")) {
                expresion.set(i, "(");
            } else if (elemento.equals("}")) {
                expresion.set(i, ")");
            }
        }
    }



/**
 * Realiza la conversión de la notación infija a postfija
 * @return la expresión convertida a postfija
 * OJO: Debe usarse el algoritmo que está en el enunciado OBLIGATORIAMENTE

    static List<String> convertirAPostfijo(List<String> expresion) {
        Stack<String> pila = new Stack<>();
        List<String> salida = new ArrayList<>();

        // TODO: Escriba el algoritmo aquí

        return salida;
    }
 */


    static List<String> convertirAPostfijo(List<String> expresion) {
        Stack<String> pila = new Stack<>();
        List<String> salida = new ArrayList<>();

        // Recorremos la expresión de principio a fin
        for (String termino : expresion) {
            // Si el término es un operador, lo introducimos en la pila
            if (esOperador(termino)) {
                while (!pila.isEmpty() && esOperador(pila.peek()) && precedencia(termino) <= precedencia(pila.peek())) {
                    salida.add(pila.pop());
                }
                pila.push(termino);
            }
            // Si el término es el paréntesis que cierra ")", sacamos elementos de la pila y los agregamos a la salida
            else if (termino.equals(")")) {
                while (!pila.isEmpty() && !pila.peek().equals("(")) {
                    salida.add(pila.pop());
                }
                // Sacamos el paréntesis que abre "(" de la pila
                if (!pila.isEmpty() && pila.peek().equals("(")) {
                    pila.pop();
                }
            }
            // Si el término es el paréntesis que abre "(", lo introducimos en la pila
            else if (termino.equals("(")) {
                pila.push(termino);
            }
            // Cualquier otro término se agrega a la lista de salida
            else {
                salida.add(termino);
            }
        }

        // Vaciamos la pila y agregamos los operadores restantes a la salida
        while (!pila.isEmpty()) {
            if (pila.peek().equals("(") || pila.peek().equals(")")) {
                // Si hay paréntesis sin cerrar o abrir, hay un error en la expresión
                return null;
            }
            salida.add(pila.pop());
        }

        return salida;
    }

    // Función para verificar si un término es un operador
    static boolean esOperador(String termino) {
        return termino.equals("+") || termino.equals("-") || termino.equals("*") || termino.equals("/") || termino.equals("%");
    }

    // Función para obtener la precedencia de un operador
    static int precedencia(String operador) {
        switch (operador) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
            case "%":
                return 2;
            default:
                return 0; // Si no es un operador válido
        }
    }





    /**
     * Realiza la evaluación de la expresión postfijo utilizando una pila
     * @param expresion una lista de elementos con números u operadores
     * @return el resultado de la evaluación de la expresión.

    static int evaluarPostFija(List<String> expresion) {
        Stack<Integer> pila = new Stack<>();

        // TODO: Realiza la evaluación de la expresión en formato postfijo

        return pila.pop();
    }
     */

    static int evaluarPostFija(List<String> expresion) {
        Stack<Integer> pila = new Stack<>();

        for (String elemento : expresion) {
            if (esNumero(elemento)) {
                // Si es un número, lo introducimos en la pila
                pila.push(Integer.parseInt(elemento));
            } else {
                // Es un operador
                int operand2 = pila.pop();
                int operand1 = pila.pop();
                int resultado = aplicarOperador(elemento, operand1, operand2);
                pila.push(resultado);
            }
        }

        // Al final, el resultado estará en el tope de la pila
        return pila.pop();
    }

    static boolean esNumero(String str) {
        // Verifica si la cadena es un número
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static int aplicarOperador(String operador, int operand1, int operand2) {
        // Realiza la operación según el operador
        switch (operador) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("División por cero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operador);
        }
    }



}
