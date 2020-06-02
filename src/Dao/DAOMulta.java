/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DTO.DTOMulta;
import Definiciones.IDAOMulta;
import java.sql.Connection;
import java.util.ArrayList;
import Conexion.Conexion;
import Excepcion.DatosIncompletosException;
import Modelo.Multa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mateo
 */
public class DAOMulta implements IDAOMulta {

    @Override
    public boolean guardarMulta(Multa multa) throws DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("INSERT INTO multa (idHuesped,cantidadPagar,estado) values (?,?,?)");

            pstmt.setInt(1, multa.getIdHuesped());
            pstmt.setString(2, multa.getCantidadPagar());
            pstmt.setString(3, multa.getEstado());
            pstmt.executeUpdate();
            desicion = true;

        } catch (SQLException ex) {
            //   ex.printStackTrace();
            int codigo = ex.getErrorCode();

            if (codigo == 1048) {
                throw new DatosIncompletosException();
            }

            desicion = false;
        }
        return desicion;

    }

    @Override
    public Multa buscarMulta(int idHuesped) {
        Multa multa = new Multa();
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("SELECT  id,idHuesped,cantidadPagar,estado FROM multa where idHuesped=?");
            pstmt.setInt(1, idHuesped);
            //Resultset guarda los datos de la busqueda
            ResultSet respuesta = pstmt.executeQuery();
            if (respuesta.next()) {

                multa.setId(respuesta.getInt("id"));
                multa.setIdHuesped(respuesta.getInt("idHuesped"));
                multa.setCantidadPagar(respuesta.getString("cantidadPagar"));
                multa.setEstado(respuesta.getString("estado"));

                return multa;
            }
        } catch (SQLException ex) {
            multa = null;

        }
        return null;
    }

    @Override
    public boolean modificarMultas(Multa multa) throws DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE multa SET  cantidadPagar=? WHERE id=?");//preparar la sentencia sql(modificar,agregar,eliminar,etc) se llena de izquierda a derecha de 1 en 1(1,2,3)

            pstmt.setString(1, multa.getCantidadPagar());
            pstmt.setInt(2, multa.getId());
            int res = pstmt.executeUpdate();

            desicion = res > 0;

        } catch (SQLException ex) {
            //ex.printStackTrace();
            int codigo = ex.getErrorCode();

            if (codigo == 1048) {
                throw new DatosIncompletosException();
            }
            desicion = false;
        }

        return desicion;
    }

    @Override
    public boolean modificarEstadoMulta(Multa multa) throws DatosIncompletosException {
        boolean desicion = false;
        try (Connection con = Conexion.getConnection()) {
            PreparedStatement pstmt = con.prepareStatement("UPDATE multa SET  estado=? WHERE id=?");//preparar la sentencia sql(modificar,agregar,eliminar,etc) se llena de izquierda a derecha de 1 en 1(1,2,3)

            pstmt.setString(1, multa.getEstado());
            pstmt.setInt(2, multa.getId());
            int res = pstmt.executeUpdate();

            desicion = res > 0;

        } catch (SQLException ex) {
            //ex.printStackTrace();
            int codigo = ex.getErrorCode();

            if (codigo == 1048) {
                throw new DatosIncompletosException();
            }
            desicion = false;
        }

        return desicion;
    }

    @Override
    public ArrayList<Multa> listaMulta() {
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("SELECT  id,idHuesped,cantidadPagar,estado FROM multa");

            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado
            ArrayList<Multa> listar = new ArrayList<>();

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {//si respuesta.next(revisa si hay un elemtento,salta al siguiente reistro) devuelve true=si encontro algo o false si no lo encontró
                    Multa multa = new Multa();

                    multa.setId(respuesta.getInt("id"));
                    multa.setIdHuesped(respuesta.getInt("idHuesped"));
                    multa.setCantidadPagar(respuesta.getString("cantidadPagar"));
                    multa.setEstado(respuesta.getString("estado"));
                    listar.add(multa);

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

    @Override
    public ArrayList<DTOMulta> BuscarMultasDTO(String cedula) {
        ArrayList<DTOMulta> listamultas = new ArrayList<>();
        try (Connection con = Conexion.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement("select m.id,r.id,h.cedula,h.nombreCompleto,ha.nombre,r.fechaHoraCheckIn,r.fechaHoraCheckOut,r.fechaHoraReserva,m.estado,m.cantidadPagar,r.estado from multa m join huesped h on m.idHuesped=h.id join reservaHabitacion r on r.idHuesped=h.id join habitacion ha on r.idHabitacion=ha.id where h.cedula=?");
            pstmt.setString(1, cedula);
            ResultSet respuesta = pstmt.executeQuery();//Me va a traer todo lo que venga como resultado

            boolean condicion = true;
            while (condicion == true) {
                if (respuesta.next()) {//si respuesta.next(revisa si hay un elemtento,salta al siguiente reistro) devuelve true=si encontro algo o false si no lo encontró
                    DTOMulta multas = new DTOMulta();

                    multas.setId(respuesta.getInt(1));
                    multas.setIdreserva(respuesta.getInt(2));
                    multas.setCedula(respuesta.getString(3));
                    multas.setNombrehuesped(respuesta.getString(4));
                    multas.setNombreHabitacion(respuesta.getString(5));
                    multas.setFechaHoraCheckIn(convertirDeDatetimeUtilaDate(respuesta.getString(6)));
                    multas.setFechaHoraCheckOut(convertirDeDatetimeUtilaDate(respuesta.getString(7)));
                    multas.setFechaHoraReserva(convertirDeDatetimeUtilaDate(respuesta.getString(8)));
                    multas.setEstadomulta(respuesta.getString(9));
                    multas.setCantidadPagar(respuesta.getString(10));
                    multas.setEstadoreservacion(respuesta.getString(11));
                    listamultas.add(multas);

                } else {
                    condicion = false;
                }
            }

            return listamultas;
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Hubo un error al buscar");
        }
        return listamultas;
    }

    /**
     * Metodo convertir el datetime de la base de datos a tipo date
     *
     * @param datetime objeto de la fechatime de la base dato
     * @return objeto tipo dato
     */
    private Date convertirDeDatetimeUtilaDate(String datetime) {
        SimpleDateFormat formatter6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//      dd/MM/yyyy
        try {
            Date date6 = formatter6.parse(datetime);
            return date6;
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return null;
    }

}
