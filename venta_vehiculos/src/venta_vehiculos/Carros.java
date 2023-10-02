package venta_vehiculos;
/*
public class Carros{
    public static void main(String[] args) throws Exception {


        Scanner teclado = new Scanner(System.in);

        String url = "jdbc:h2:file:./venta_vehhiculos";
        //conectar con la base de datos
        ConnectionSource con = new JdbcConnectionSource(url);
        //Configurar la tabla a traves de un DAO (Data Access Object)
        Dao<Vehiculo, String> tablaVehiculos =
                DaoManager.createDao(con, Vehiculo.class);

        //Este es el menu para agregar informacion a la base de datos



        System.out.print("Numero de Placa:");
        String placa = teclado.nextLine();
        System.out.print("Nombre del Modelo:");
        String modelo = teclado.nextLine();
        System.out.print("Escriba el Año:");
        int año = teclado.nextInt();
        System.out.print("Numero de ejes:");
        int numEjes = teclado.nextInt();
        System.out.print("Numero de Cilindros:");
        int cilindrado = teclado.nextInt();
        System.out.print("Cual es el valor?:");
        int valor = teclado.nextInt();
        System.out.print("Cual es la marca?:");
        String marca = teclado.nextLine();
        teclado.nextLine(); //Limpiar teclado
        System.out.print("Cual es el tipo de vehiculo?:");
        String tipovehiculo = teclado.nextLine();


        Vehiculo vehiculo = new Vehiculo(placa, modelo, año, numEjes, cilindrado, valor, marca, tipovehiculo);
        // Guardar en la base de datos
        if (!tablaVehiculos.idExists((placa))) {

            tablaVehiculos.create(vehiculo);
            //Mensaje de salida
            System.out.println("Vehiculo guardada en la base de datos");
            System.out.println(" Ahora hay " + tablaVehiculos.countOf() + " Vehiculos");

        } else {
            System.out.println("El vehiculo con ese numero de placa ya existe!!");

        }
        //Cerramos conecxion


        con.close();

    }



}
*/

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Carros {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        String url = "jdbc:h2:file:./venta_vehhiculos";
        ConnectionSource con = new JdbcConnectionSource(url);
        Dao<Vehiculo, String> tablaVehiculos = DaoManager.createDao(con, Vehiculo.class);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Obtener lista de placas de vehículos a la venta");
            System.out.println("2. Obtener información detallada de un vehículo por placa");
            System.out.println("3. Agregar un nuevo vehículo a la venta");
            System.out.println("4. Ordenar la lista de vehículos por modelo, por marca o por año");
            System.out.println("5. Hacer una búsqueda de placas usando el modelo y el año del vehículo");
            System.out.println("6 Comprar un vehículo (eliminarlo de la lista de vehículos que están a la venta)");
            System.out.println("7 Disminuir en un 10% el precio de los vehículos que tienen un valor mayor a una cantidad dada");
            System.out.println("8 Localizar el vehículo más antiguo");
            System.out.println("9 Localizar el vehículo más potente (el de más cilindrada)");
            System.out.println("10 Localizar el vehículo más barato (el de menor precio).");

            System.out.println("0. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    obtenerListaPlacasVenta(tablaVehiculos);
                    break;

                case 2:
                    obtenerInfoVehiculoPorPlaca(tablaVehiculos, scanner);
                    break;

                case 3:
                    agregarNuevoVehiculo(tablaVehiculos, scanner);
                    break;

                case 4:
                    ordenarListaVehiculos(tablaVehiculos, scanner);
                    break;

                case 5:
                    buscarPlacasPorModeloYaño(tablaVehiculos, scanner);
                    break;

                case 6:
                    comprarVehiculo(tablaVehiculos, scanner);
                    break;

                case 7:
                    disminuirPrecio(tablaVehiculos, scanner);
                    break;

                case 8:
                    localizarVehiculoMasAntiguo(tablaVehiculos, scanner);
                    break;
                case 9:
                    localizarVehiculoMasPotente(tablaVehiculos, scanner);
                    break;
                case 10:
                    localizarVehiculoMasBarato(tablaVehiculos, scanner);
                    break;

                case 0:
                    con.close();
                    System.out.println("Saliendo del programa.");
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }


    // 1. Obtener lista de placas de vehículos a la venta
    public static void obtenerListaPlacasVenta(Dao<Vehiculo, String> tablaVehiculos) throws SQLException {
        System.out.println("Lista de placas de vehículos a la venta:");
        List<Vehiculo> vehiculos = tablaVehiculos.queryForAll();
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("Placa: " + vehiculo.getPlaca());
        }
    }


    //2.Obtener información detallada de un vehículo por placa

    public static void obtenerInfoVehiculoPorPlaca(Dao<Vehiculo, String> tablaVehiculos, Scanner scanner) throws SQLException {
        System.out.print("Escriba la placa del vehículo: ");
        String placa = scanner.nextLine();

        Vehiculo vehiculo = tablaVehiculos.queryForId(placa);
        if (vehiculo != null) {
            System.out.println("Información del vehículo:");
            System.out.println("Placa: " + vehiculo.getPlaca());
            System.out.println("Modelo: " + vehiculo.getModelo());
            System.out.println("Año: " + vehiculo.getAño());
            System.out.println("Número de ejes: " + vehiculo.getNumEjes());
            System.out.println("Cilindrada: " + vehiculo.getCilindrada());
            System.out.println("Valor: " + vehiculo.getValor());
            System.out.println("Marca: " + vehiculo.getMarca());
            System.out.println("Tipo de vehículo: " + vehiculo.getTipovehiculo());
        } else {
            System.out.println("No se encontró ningún vehículo con esa placa.");
        }
    }

    //   3. Agregar un vehiculo a la venta
    public static void agregarNuevoVehiculo(Dao<Vehiculo, String> tablaVehiculos, Scanner scanner) throws SQLException {
        System.out.print("Ingrese la placa del vehículo: ");
        String placa = scanner.nextLine();

        System.out.print("Ingrese el modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese el año: ");
        int año = scanner.nextInt();
        System.out.print("Ingrese el número de ejes: ");
        int numEjes = scanner.nextInt();
        System.out.print("Ingrese el número de cilindros: ");
        int cilindrada = scanner.nextInt();
        System.out.print("Ingrese el valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese la marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese el tipo de vehículo: ");
        String tipoVehiculo = scanner.nextLine();

        Vehiculo vehiculo = new Vehiculo(placa, modelo, año, numEjes, cilindrada, valor, marca, tipoVehiculo);
        tablaVehiculos.create(vehiculo);
        System.out.println("Nuevo vehículo agregado a la venta exitosamente.");
    }

    // 4. Ordenar la lista de vehículos por modelo, por marca o por año


    public static void buscarPlacasPorModeloYaño(Dao<Vehiculo, String> tablaVehiculos, Scanner scanner) throws SQLException {
        // Ordenar por modelo
        List<Vehiculo> vehiculosPorModelo = tablaVehiculos.queryBuilder().orderBy("modelo", true).query();
        System.out.println("Lista de vehículos ordenada por modelo:");
        for (Vehiculo vehiculo : vehiculosPorModelo) {
            System.out.println("Modelo: " + vehiculo.getModelo() + ", Placa: " + vehiculo.getPlaca());
        }

        // Ordenar por marca
        List<Vehiculo> vehiculosPorMarca = tablaVehiculos.queryBuilder().orderBy("marca", true).query();
        System.out.println("\nLista de vehículos ordenada por marca:");
        for (Vehiculo vehiculo : vehiculosPorMarca) {
            System.out.println("Marca: " + vehiculo.getMarca() + ", Placa: " + vehiculo.getPlaca());
        }

        // Ordenar por año
        List<Vehiculo> vehiculosPorAño = tablaVehiculos.queryBuilder().orderBy("año", true).query();
        System.out.println("\nLista de vehículos ordenada por año:");
        for (Vehiculo vehiculo : vehiculosPorAño) {
            System.out.println("Año: " + vehiculo.getAño() + ", Placa: " + vehiculo.getPlaca());
        }
    }


    //5. Hacer una búsqueda de placas usando el modelo y el año del vehículo
    public static void ordenarListaVehiculos(Dao<Vehiculo, String> tablaVehiculos, Scanner scanner) throws SQLException {
        QueryBuilder<Vehiculo, String> queryBuilder = tablaVehiculos.queryBuilder();
        queryBuilder.orderBy("modelo", true).orderBy("marca", true).orderBy("año", true);

        List<Vehiculo> vehiculos = queryBuilder.query();

        System.out.println("Resultado de la lista de vehículos ordenada:");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println("Modelo: " + vehiculo.getModelo() + ", Marca: " + vehiculo.getMarca() + ", Año: " + vehiculo.getAño());
        }
    }

    //6.Comprar un vehículo (eliminarlo de la lista de vehículos que están a la venta)
    public static void comprarVehiculo(Dao<Vehiculo, String> tablaVehiculos, Scanner scanner) throws SQLException {
        System.out.println("Ingrese la placa del vehiculo que desea comprar:");
        String placa = scanner.nextLine();

        Vehiculo vehiculo = tablaVehiculos.queryForId(placa);
        if (vehiculo != null) {
            tablaVehiculos.delete(vehiculo);
            System.out.println("Vehiculo exitosamente comprado y elimidado del sistema de vehiculos para la venta.");
        } else {
            System.out.println("No se encontro ningun vehiculo con ese numero de placa");
        }

    }

    //7. Disminuir en un 10% el precio de los vehículos que tienen un valor mayor a una cantidad dada
    public static void disminuirPrecio(Dao<Vehiculo, String> tablaVehiculos, Scanner scanner) throws SQLException {
        // Obtener todos los vehículos
        List<Vehiculo> vehiculos = tablaVehiculos.queryForAll();

        // Aplicar un 10% de descuento en el precio de todos los vehículos
        for (Vehiculo vehiculo : vehiculos) {
            double precioAnterior = vehiculo.getValor();
            double nuevoPrecio = precioAnterior * 0.9;
            vehiculo.setValor(nuevoPrecio);
            tablaVehiculos.update(vehiculo);

            System.out.println("Precio anterior del vehículo con placa " + vehiculo.getPlaca() + ": " + precioAnterior);
            System.out.println("Nuevo precio después del descuento: " + nuevoPrecio);
        }

        if (vehiculos.isEmpty()) {
            System.out.println("No se encontraron vehículos.");
        }
    }


    //8.Localizar el vehículo más antiguo
    public static void localizarVehiculoMasAntiguo(Dao<Vehiculo, String> tablaVehiculos, Scanner scanner) throws SQLException {
        QueryBuilder<Vehiculo, String> queryBuilder = tablaVehiculos.queryBuilder();
        queryBuilder.orderBy("año", true);  // Ordenar por año de forma ascendente

        Vehiculo vehiculo = queryBuilder.queryForFirst();
        if (vehiculo != null) {
            System.out.println("El vehículo más antiguo es:");
            System.out.println("Placa: " + vehiculo.getPlaca());
            System.out.println("Modelo: " + vehiculo.getModelo());
            System.out.println("Año: " + vehiculo.getAño());
        } else {
            System.out.println("No se encontró ningún vehículo en la base de datos.");
        }
    }
    //9. Localizar vehiculo mas potente(Cilindraje)

    public static void localizarVehiculoMasPotente(Dao<Vehiculo, String> tablaVehiculos, Scanner scanner) throws SQLException {
        QueryBuilder<Vehiculo, String> queryBuilder = tablaVehiculos.queryBuilder();
        queryBuilder.orderBy("cilindrada", false);  // Ordenar por cilindrada de forma descendente

        Vehiculo vehiculo = queryBuilder.queryForFirst();
        if (vehiculo != null) {
            System.out.println("El vehículo más potente es:");
            System.out.println("Placa: " + vehiculo.getPlaca());
            System.out.println("Modelo: " + vehiculo.getModelo());
            System.out.println("Cilindrada: " + vehiculo.getCilindrada());
        } else {
            System.out.println("No se encontró ningún vehículo en la base de datos.");
        }
    }

    ////10. Localizar vehiculo mas barato(el del menor precio)

    public static void localizarVehiculoMasBarato(Dao<Vehiculo, String> tablaVehiculos, Scanner scanner) throws SQLException {
        QueryBuilder<Vehiculo, String> queryBuilder = tablaVehiculos.queryBuilder();
        queryBuilder.orderBy("valor", true);  // Ordenar por precio en orden ascendente
        List<Vehiculo> vehiculos = queryBuilder.query();

        if (!vehiculos.isEmpty()) {
            Vehiculo vehiculoMasBarato = vehiculos.get(0);
            System.out.println("Vehículo más barato:");
            System.out.println("Modelo: " + vehiculoMasBarato.getModelo() +
                    ", Marca: " + vehiculoMasBarato.getMarca() +
                    "placa: " + vehiculoMasBarato.getPlaca() +
                    "Numero de ejes: " + vehiculoMasBarato.getNumEjes() +
                    "Cilindraje: " + vehiculoMasBarato.getNumEjes() +
                    ", Año: " + vehiculoMasBarato.getAño() + "Tipo de vehiculo" + vehiculoMasBarato.getTipovehiculo() +
                    ", Precio: " + vehiculoMasBarato.getValor());
        } else {
            System.out.println("No hay vehículos en la lista.");
        }
    }


}













