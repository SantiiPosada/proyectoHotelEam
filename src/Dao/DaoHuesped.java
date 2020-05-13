/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.Conexion;
import Modelo.Huesped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author santiago
 */
public class DaoHuesped {
    public boolean guardarHuesped(Huesped huesped) {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO huesped (cedula,nombreCompleto,genero,correo,telefono,fechaNacimiento,nacionalidad,contrasena,tipo,estado) values (?,?,?,?,?,?,?,?,?,?)");

            pstmt.setString(1, huesped.getCedula());
            pstmt.setString(2, huesped.getNombrecompleto());
            pstmt.setString(3, huesped.getGenero());
            pstmt.setString(4, huesped.getCorreo());
            pstmt.setString(5, huesped.getTelefono());
            pstmt.setDate(6, convertirDeDateUtilaDateSql(huesped.getFechanacimiento()));
            pstmt.setString(7, huesped.getNacionalidad());
            pstmt.setString(8, huesped.getContrasena());
            pstmt.setString(9, huesped.getTipo());
            pstmt.setString(10, huesped.getEstado());
            pstmt.executeUpdate();
            desicion = true;
        } catch (SQLException ex) {
           // ex.printStackTrace();
              System.err.println("Hubo un error al insertar");
              String conca="";
            int codigo=ex.getErrorCode();
            conca+="codigo error "+codigo+" \n";
            String state=ex.getSQLState();
            conca+="estado error "+state+" \n";
           
            String mensaje=ex.getMessage();
            conca+="mensaje error  "+mensaje+" \n";
         
            
          //  String x="prueba";
            conca+="mensaje error filtrado "+extraerVariable(mensaje)+" \n";
            JOptionPane.showMessageDialog(null, conca);
            
            
            desicion = false;
        }
        return desicion;
    }
    /**
     * metodo extraer la  variable que tuvo el codigo de error 1062
     * @param variable mensaje de error de sql (ex.getMessage())
     * @return nombre de la veriable que tiene el error
     */
    private String extraerVariable(String variable){
    int inicio=variable.indexOf(".");
    int fin=variable.indexOf("'",inicio+1);
    return variable.substring(inicio+1,fin);
    }

//    public Estudiante buscarEstudiante(int idEstudiante) {
//        Estudiante estudiante = new Estudiante();
//        try (Connection con = conexion.getConnetion()) {
//            PreparedStatement pstmt = con.prepareStatement("SELECT idEstudiante,Cedula,Nombre,Apellido,Direccion,Telefono,Correo,Fecha_nacimiento FROM Estudiante"
//                    + " " + "WHERE idEstudiante=?");
//            pstmt.setInt(1, idEstudiante);
//            //Resultset guarda los datos de la busqueda
//            ResultSet respuesta = pstmt.executeQuery();
//            if (respuesta.next()) {
//
//                estudiante.setId(respuesta.getInt("idEstudiante"));
//                estudiante.setCedula(respuesta.getString("Cedula"));
//                estudiante.setNombre(respuesta.getString("Nombre"));
//                estudiante.setApellido(respuesta.getString("Apellido"));
//                estudiante.setDireccion(respuesta.getString("Direccion"));
//                estudiante.setTelefono(respuesta.getString("Telefono"));
//                estudiante.setCorreo(respuesta.getString("Correo"));
//                estudiante.setFecha_nacimiento(respuesta.getDate("Fecha_nacimiento"));
//                return estudiante;
//            }
//        } catch (SQLException ex) {
//            estudiante = null;
//            ex.printStackTrace();
//
//        }
//        return null;
//    }
//
//    public boolean modificarEstudiante(Estudiante estudiante) {
//        boolean desicion = false;
//        try (Connection con = conexion.getConnetion()) {
//            PreparedStatement pstmt = con.prepareStatement("UPDATE Estudiante SET  idEstudiante=?, Cedula=?, Nombre=?, Apellido=?, Direccion=?, Telefono=?, Correo=?, Fecha_nacimiento=? WHERE idEstudiante=?");//preparar la sentencia sql(modificar,agregar,eliminar,etc) se llena de izquierda a derecha de 1 en 1(1,2,3)
//
//            pstmt.setInt(1, estudiante.getId());
//            pstmt.setString(2, estudiante.getCedula());//posicion 2=nombre Valor
//            pstmt.setString(3, estudiante.getNombre());//posicion 2=nombre Valor
//            pstmt.setString(4, estudiante.getApellido());
//            pstmt.setString(5, estudiante.getDireccion());
//            pstmt.setString(6, estudiante.getTelefono());
//            pstmt.setString(7, estudiante.getCorreo());
//            pstmt.setDate(8, convertirDeDateUtilaDateSql(estudiante.getFecha_nacimiento()));
//            pstmt.setInt(9, estudiante.getId());
//            int res = pstmt.executeUpdate();//retorna 0,1 o fallo al insertar
//
//            if (res > 0) {
//                desicion = true;
//            } else {
//                desicion = false;
//
//            }
//
//        } catch (SQLException e) {
//            desicion = false;
//            e.printStackTrace();
//
//        }
//
//        return desicion;
//    }
//
//    public ArrayList<Estudiante> listarEstudiante() {
//        try (Connection con = conexion.getConnetion()) {
//
//            PreparedStatement pstmt = con.prepareStatement("SELECT idEstudiante,Cedula,Nombre,Apellido,Direccion,Telefono,Correo,Fecha_nacimiento FROM Estudiante");
//
//            // pstmt.setInt(1, id);
//            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
//            ArrayList<Estudiante> listaEstudiante = new ArrayList<>();
//
//            boolean condicion = true;
//            while (condicion == true) {
//                if (respuesta.next()) {//si respuesta.next(revisa si hay un elemtento,salta al siguiente reistro) devuelve true=si encontro algo o false si no lo encontró
//                    Estudiante estudiante = new Estudiante();
//
//                    estudiante.setId(respuesta.getInt("idEstudiante"));
//                    estudiante.setCedula(respuesta.getString("Cedula"));
//                    estudiante.setNombre(respuesta.getString("Nombre"));
//                    estudiante.setApellido(respuesta.getString("Apellido"));
//                    estudiante.setDireccion(respuesta.getString("Direccion"));
//                    estudiante.setTelefono(respuesta.getString("Telefono"));
//                    estudiante.setCorreo(respuesta.getString("Correo"));
//                    estudiante.setFecha_nacimiento(respuesta.getDate("Fecha_nacimiento"));
//
//                    listaEstudiante.add(estudiante);
//
//                } else {
//                    condicion = false;
//                }
//            }
//
//            return listaEstudiante;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.err.println("Hubo un error al buscar");
//        }
//        return null;
//    }

    /**
     * metodo que permite pasar la fecha de tipo java.util.Date a java.sql.Date
     * @param uDate fecha de tipo java.util.Date que se desee cambiar a
     * java.sql.Date
     * @return la fecha lista para ser guardada en mySql
     */
    private java.sql.Date convertirDeDateUtilaDateSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;

    }
}