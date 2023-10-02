package venta_vehiculos;



import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class CrearBaseDeDatos {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:h2:file:./venta_vehhiculos";
        //conectar con la base de datos
        ConnectionSource con = new JdbcConnectionSource(url);
        //Configurar la tabla a traves de un DAO (Data Access Object)
        Dao<Vehiculo, Integer> tablaVehiculos =
                DaoManager.createDao(con, Vehiculo.class);
        //Creo el archivo donde se guardaran las cuentas
        TableUtils.createTable(tablaVehiculos);
        System.out.println("Table Creada Exitosamente");
        //Cerrar la conexion
        con.close();


    }
}
