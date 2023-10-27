/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewClass {

    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/datos?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
            String usuario = "root";
            String contraseña = ""; // Pon tu contraseña aquí si la tienes

            Class.forName("com.mysql.cj.jdbc.Driver"); // Carga el controlador

            Connection conexion = DriverManager.getConnection(url, usuario, contraseña); // Establece la conexión
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT Nombre, Apellido, Edad, Genero, Identificacion, TipoID, TipoRol FROM base"; // Sentencia SQL
            ResultSet resultado = instruccion.executeQuery(sql);
            while (resultado.next()) {
                System.out.print("Nombre: " + resultado.getString("Nombre"));
                System.out.print(" Apellido: " + resultado.getString("Apellido"));
                System.out.print(" Edad: " + resultado.getInt("Edad"));
                System.out.print(" Genero: " + resultado.getString("Genero"));
                System.out.print(" Identificacion: " + resultado.getString("Identificacion"));
                System.out.println(" TipoID: " + resultado.getString("TipoID"));
                System.out.println(" TipoRol: " + resultado.getString("TipoRol"));
            }
            // Cerramos los elementos que abrimos anteriormente
            resultado.close();
            instruccion.close();
            conexion.close();

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
