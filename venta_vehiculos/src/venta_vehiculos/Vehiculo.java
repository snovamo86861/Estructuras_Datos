package venta_vehiculos;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

//Esta es la tabla que se guarda en la base de datos
@DatabaseTable(tableName = "vehiculos")    //Llave primaria
public class Vehiculo {

    //Atributos
    @DatabaseField(id = true)
    private String placa;


    @DatabaseField
    private String modelo;
    @DatabaseField
    private int año;
    @DatabaseField
    private int numEjes;
    @DatabaseField
    private double cilindrada;
    @DatabaseField
    private double valor;
    @DatabaseField
    private String marca;

    @DatabaseField
    private String tipovehiculo;


    //Metodos

    public Vehiculo(String placa, String modelo, int año, int numEjes, double cilindrada, double valor, String marca, String tipovehiculo) {
        this.placa = placa;
        this.modelo = modelo;
        this.año = año;
        this.numEjes = numEjes;
        this.cilindrada = cilindrada;
        this.valor = valor;
        this.marca = String.valueOf(marca);
        this.tipovehiculo = tipovehiculo;
    }


    // Constructor vacio

    public Vehiculo() {


    }
    //Getters and setters


    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAño() {
        return año;
    }

    public int getNumEjes() {
        return numEjes;
    }

    public double getCilindrada() {
        return cilindrada;
    }

    public double getValor() {
        return valor;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipovehiculo() {
        return tipovehiculo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setNumEjes(int numEjes) {
        this.numEjes = numEjes;
    }

    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipovehiculo(String tipovehiculo) {
        this.tipovehiculo = tipovehiculo;
    }
}







