/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Definiciones.IDAOHabitacion;
import Excepcion.DatosIncompletosException;
import Excepcion.ImagenException;
import Excepcion.NombreHabitacionException;
import Excepcion.NombreImagenException;
import Modelo.Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mateo
 */
public class DAOHabitacion implements IDAOHabitacion {

    @Override
    public boolean guardarHabitacion(Habitacion habitacion) throws NombreHabitacionException, DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("INSERT INTO habitacion (nombre,piso,bano,sala,estado,imagen,descripcion,valorPorNoche) values (?,?,?,?,?,?,?,?,?)");

            pstmt.setString(1, habitacion.getNombre());
            pstmt.setString(2, habitacion.getPiso());
            pstmt.setString(3, habitacion.getBano());
            pstmt.setString(4, habitacion.getSala());
            pstmt.setString(5, habitacion.getEstado());
            pstmt.setBytes(6, habitacion.getImagen());
            // falta imagen
            pstmt.setString(7, habitacion.getDescripcion());
            pstmt.setString(8, habitacion.getValorPorNoche());

            desicion = true;

        } catch (SQLException ex) {
            //   ex.printStackTrace();
            int codigo = ex.getErrorCode();
            if (codigo == 1062) {
                String variable = extraerVariable(ex.getMessage(), extraerDosUltimasLetras(ex.getMessage()));
                switch (variable) {
                    case "habitacion.nombr":
                        throw new NombreHabitacionException();
                    default:
                        break;
                }

            } else if (codigo == 1048) {
                throw new DatosIncompletosException();
            }

            desicion = false;
        }
        return desicion;
    }

    @Override
    public Habitacion buscarHabitacion(String Nombre) {
        Habitacion habitacion = new Habitacion();
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,nombre,piso,bano,sala,estado,imagen,descripcion,valorPorNoche FROM habitacion where nombre=?");
            pstmt.setString(1, Nombre);
            //Resultset guarda los datos de la busqueda
            ResultSet respuesta = pstmt.executeQuery();
            if (respuesta.next()) {

                habitacion.setId(respuesta.getInt("id"));
                habitacion.setNombre(respuesta.getString("nombre"));
                habitacion.setPiso(respuesta.getString("piso"));
                habitacion.setBano(respuesta.getString("bano"));
                habitacion.setSala(respuesta.getString("sala"));
                habitacion.setEstado(respuesta.getString("estado"));
                habitacion.setImagen(respuesta.getBytes("imagen"));
                //falta imagen
                habitacion.setDescripcion(respuesta.getString("descripcion"));
                habitacion.setValorPorNoche(respuesta.getString("valorPorNoche"));

                return habitacion;
            }
        } catch (SQLException ex) {
            habitacion = null;

        }
        return null;
    }

    @Override
    public boolean modificarHabitacion(Habitacion habitacion) throws NombreHabitacionException,  DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE habitacion SET  nombre=?, piso=?, bano=?, sala=?, estado=?, imagen=?, descripcion=?,valorPorNoche=? WHERE id=?");//preparar la sentencia sql(modificar,agregar,eliminar,etc) se llena de izquierda a derecha de 1 en 1(1,2,3)

            pstmt.setString(1, habitacion.getNombre());
            pstmt.setString(2, habitacion.getPiso());
            pstmt.setString(3, habitacion.getBano());
            pstmt.setString(4, habitacion.getSala());
            pstmt.setString(5, habitacion.getEstado());
            pstmt.setBytes(6, habitacion.getImagen());
            // falta imagen
            pstmt.setString(7, habitacion.getDescripcion());
            pstmt.setString(8, habitacion.getValorPorNoche());
            int res = pstmt.executeUpdate();

            desicion = res > 0;

        } catch (SQLException ex) {
            //ex.printStackTrace();
            int codigo = ex.getErrorCode();
            if (codigo == 1062) {
                String variable = extraerVariable(ex.getMessage(), extraerDosUltimasLetras(ex.getMessage()));
                switch (variable) {
                    case "habitacion.nombr":
                        throw new NombreHabitacionException();
                 
                      
                }

            } else if (codigo == 1048) {
                throw new DatosIncompletosException();
            }
            desicion = false;
        }

        return desicion;
    }

    @Override
    public ArrayList<Habitacion> listarHabitacion() {
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("SELECT  id,nombre,piso,bano,sala,estado,imagen,descripcion,valorPorNoche FROM habitacion");

            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<Habitacion> listar = new ArrayList<>();

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {//si respuesta.next(revisa si hay un elemtento,salta al siguiente reistro) devuelve true=si encontro algo o false si no lo encontró
                    Habitacion habitacion = new Habitacion();

                    habitacion.setId(respuesta.getInt("id"));
                    habitacion.setNombre(respuesta.getString("nombre"));
                    habitacion.setPiso(respuesta.getString("piso"));
                    habitacion.setBano(respuesta.getString("bano"));
                    habitacion.setSala(respuesta.getString("sala"));
                    habitacion.setEstado(respuesta.getString("estado"));
                    habitacion.setImagen(respuesta.getBytes("imagen"));
                    //falta imagen
                    habitacion.setDescripcion(respuesta.getString("descripcion"));
                    habitacion.setValorPorNoche(respuesta.getString("valorPorNoche"));

                    listar.add(habitacion);

                } else {
                    condicion = false;
                }
            }

            return listar;
        } catch (SQLException e) {
            // e.printStackTrace();
            System.err.println("Hubo un error al listar");
        }
        return null;
    }

    /**
     * Método extraer la variable que tuvo el codigo de error 1062
     *
     * @param variable mensaje de error de sql (ex.getMessage())
     * @param termina dos ultimos datos que terminar del mensaje del error
     * @return nombre de la variable que tiene el error
     */
    private String extraerVariable(String variable, String termina) {
        int inicio = variable.indexOf("key '");
        int fin = variable.indexOf(termina, inicio + 1);
        return variable.substring(inicio + 5, fin);
    }

    /**
     * Método para extraer las dos ultmias letras de una cadena de texto
     *
     * @param variable cadena de texto
     * @return dos ultimos datos de la cadena de texto
     */
    private String extraerDosUltimasLetras(String variable) {
        int tamano = variable.length();
        return variable.substring((tamano - 2), tamano);
    }

}
