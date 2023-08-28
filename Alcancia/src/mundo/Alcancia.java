/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Desarrollo de Software - Guía 2 - Actividad 2
 * Ejercicio: alcancia
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package mundo;

public class Alcancia {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Número de monedas de $50 que hay en la alcancía.
     */
    private int numeroMonedas50;

    /**
     * Número de monedas de $100 que hay en la alcancía.
     */
    private int numeroMonedas100;

    /**
     * Número de monedas de $200 que hay en la alcancía.
     */
    private int numeroMonedas200;

    /**
     * Número de monedas de $500 que hay en la alcancía.
     */
    private int numeroMonedas500;

    /**
     * Número de monedas de $1000 que hay en la alcancía.
     */
    private int numeroMonedas1000;

    /**
     * Estado de la alcancía. <br>
     * 0 indica que no está rota. <br>
     * 1 indica que está rota.
     */
    private int estado;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye la alcancía. <br>
     * <b>post: </b> El número de monedas de 50, número de monedas de 100, número de monedas de 200, número de monedas de 500, número de monedas de 1000 <br>
     * y el estado fueron inicializados en 0.
     */
    public Alcancia() {
        numeroMonedas50 = 0;
        numeroMonedas100 = 0;
        numeroMonedas200 = 0;
        numeroMonedas500 = 0;
        numeroMonedas1000 = 0;
        estado = 0;
    }

    /**
     * Retorna el número de monedas de $50 que hay en la alcancía.
     *
     * @return Número de monedas de $50 en la alcancía.
     */
    public int darNumeroMonedas50() {
        return numeroMonedas50;
    }

    /**
     * Retorna el número de monedas de $100 que hay en la alcancía.
     *
     * @return Número de monedas de $100 en la alcancía.
     */
    public int darNumeroMonedas100() {
        return numeroMonedas100;
    }

    /**
     * Retorna el número de monedas de $200 que hay en la alcancía.
     *
     * @return Número de monedas de $200 en la alcancía.
     */
    public int darNumeroMonedas200() {
        return numeroMonedas200;
    }

    /**
     * Retorna el número de monedas de $500 que hay en la alcancía.
     *
     * @return Número de monedas de $500 en la alcancía.
     */
    public int darNumeroMonedas500() {
        return numeroMonedas500;
    }

    /**
     * Retorna el número de monedas de $1000 que hay en la alcancía.
     *
     * @return Número de monedas de $1000 en la alcancía.
     */
    public int darNumeroMonedas1000() {
        return numeroMonedas1000;

    }

    /**
     * Informa si la alcancía está rota o no.
     *
     * @return Retorna "ROTA" si está rota, "NO ROTA" en caso contrario.
     */
    public String darEstado() {
        if (estado == 0) {
            return "NO ROTA";
        } else {
            return "ROTA";
        }
    }

    /**
     * Retorna el total de dinero que hay en la alcancía.
     *
     * @return Total de dinero que hay en la alcancía.
     */
    public int calcularTotalDinero() {
        int totalDinero = (numeroMonedas50 * 50) + (numeroMonedas100 * 100) +
                (numeroMonedas200 * 200) + (numeroMonedas500 * 500) +
                (numeroMonedas1000 * 1000);
        return totalDinero;
    }

    /**
     * Retorna el estado de la alcancía. <br>
     * <b>pre: </b> La alcancía no está rota.
     *
     * @return Cadena que informa la cantidad de monedas que había en la alcancía y la cantidad total de dinero.
     */
    public String darEstadoAlcancia() {
        int totalDinero = calcularTotalDinero();

        return "La alcancía tenía: \n " + numeroMonedas50 + " moneda(s) de $50 \n " + numeroMonedas100 + " moneda(s) de $100 \n " + numeroMonedas200 + " moneda(s) de $200 \n " + numeroMonedas500 + " moneda(s) de $500 \n " + numeroMonedas1000
                + " moneda(s) de $1000 \n " + "Para un total de $" + totalDinero + " pesos.";
    }

    /**
     * Agrega una moneda de $50 a la alcancía. <br>
     * <b>pre: </b> La alcancía no está rota. <br>
     * <b>post: </b> Aumentó en uno la cantidad de monedas de $50 en la alcancía.
     */
    public void agregarMoneda50() {
        numeroMonedas50++;
    }


    /**
     * Agrega una moneda de $100 a la alcancía. <br>
     * <b>pre: </b> La alcancía no está rota. <br>
     * <b>post: </b> Aumentó en uno la cantidad de monedas de $100 en la alcancía.
     */
    public void agregarMoneda100() {
        numeroMonedas100++;
    }

    /**
     * Agrega una moneda de $200 a la alcancía. <br>
     * <b>pre: </b> La alcancía no está rota. <br>
     * <b>post: </b> Aumentó en uno la cantidad de monedas de $200 en la alcancía.
     */
    public void agregarMoneda200() {
        numeroMonedas200++;
    }

    /**
     * Agrega una moneda de $500 a la alcancía. <br>
     * <b>pre: </b> La alcancía no está rota. <br>
     * <b>post: </b> Aumentó en una la cantidad de monedas de $500 en la alcancía.
     */
    public void agregarMoneda500() {
        numeroMonedas500++;
    }

    /**
     * Agrega una moneda de $1000 a la alcancía. <br>
     * <b>pre: </b> La alcancía no está rota. <br>
     * <b>post: </b> Aumentó en uno la cantidad de monedas de $1000 en la alcancía.
     */
    public void agregarMoneda1000() {
        numeroMonedas1000++;
    }

    /**
     * Rompe la alcancía. Es decir, cambia el estado a 1<br>
     */
    public void romperAlcancia() {
        estado = 1;
    }


    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * De las 5 denominaciones de monedas que hay en la alcancía (de 50, de 100,
     * de 200, de 500 y de 1000), retorna cuál tiene la mayor cantidad de monedas.
     *
     * @return la denominación más numerosa en la alcancía: 50 o 100 o 200 o 500 o 1000.
     */
    public int obtenerDenominacionMasNumerosa() {
        int maxDenominacion = Math.max(numeroMonedas50, Math.max(numeroMonedas100, Math.max(numeroMonedas200, Math.max(numeroMonedas500, numeroMonedas1000))));
        if (maxDenominacion == numeroMonedas50) {
            return 50;
        } else if (maxDenominacion == numeroMonedas100) {
            return 100;
        } else if (maxDenominacion == numeroMonedas200) {
            return 200;
        } else if (maxDenominacion == numeroMonedas500) {
            return 500;
        } else {
            return 1000;
        }
    }

    /**
     * Una alcancía es valiosa si solo posee monedas de 1000 y de 500, y no hay
     * monedas de otras denominaciones.
     *
     * Este método permite determinar si la alcancía es valiosa, o sea, solo posee
     * monedas de 1000 pesos y de 500
     *
     * @return si es valiosa o no
     */
    public boolean valiosa() {
        return (numeroMonedas50 == 0 && numeroMonedas100 == 0 && numeroMonedas200 == 0 && numeroMonedas500 > 0 && numeroMonedas1000 > 0);
    }
}
