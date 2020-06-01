/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import DTO.DTOMulta;
import Definiciones.IDAOHabitacion;
import Definiciones.IDAOHuesped;
import Definiciones.IDAOMulta;
import Definiciones.IDAOReserva;
import Excepcion.BuscarCedulaHuespedException;
import Excepcion.BuscarHuespedException;
import Excepcion.BuscarMultasException;
import Excepcion.DatosIncompletosException;
import Excepcion.ModificarMultaException;
import Excepcion.ModificarReservaException;
import Excepcion.MultaIdReservaException;
import Fabrica.FactoryDAO;
import Modelo.Habitacion;
import Modelo.Huesped;
import Modelo.ReservaHabitacion;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import Modelo.Multa;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.TabSettings;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author mateo
 */
public class BOMultas {

    private IDAOMulta dao;
    private final DateFormat formato;
    private final IDAOHuesped daoHuesped;
    private final IDAOReserva daoReserva;
    private final IDAOHabitacion daoHabitacion;

    public BOMultas() {
        dao = FactoryDAO.getFabrica().crearDAOMulta();
        daoHuesped = FactoryDAO.getFabrica().crearDAOHuesped();
        daoReserva = FactoryDAO.getFabrica().crearDAOReserva();
        daoHabitacion = FactoryDAO.getFabrica().crearDAOHabitacIon();
        formato = DateFormat.getDateInstance();
    }

    public Multa buscarMulta(int idHuesped) throws DatosIncompletosException, BuscarMultasException {
        Integer huesped = idHuesped;
        if (huesped == null) {
            throw new DatosIncompletosException();
        }
        Multa multa = dao.buscarMulta(huesped);
        if (multa == null) {
            throw new BuscarMultasException();
        }
        return multa;
    }

    public void modificarMulta(String cedula, String valorapagar) throws BuscarCedulaHuespedException, BuscarHuespedException, DatosIncompletosException, BuscarMultasException, ModificarMultaException {
        Huesped huesped = buscarHuespedCedula(cedula);

        if (huesped == null) {
            throw new BuscarHuespedException();
        }
        Multa multa = buscarMulta(huesped.getId());
        multa.setCantidadPagar(valorapagar);

        if (!dao.modificarMultas(multa)) {
            throw new ModificarMultaException();
        }

    }

    public void modificarEstadoMulta(String cedula, int idreserva) throws BuscarCedulaHuespedException, BuscarHuespedException, DatosIncompletosException, BuscarMultasException, ModificarMultaException, ModificarReservaException {
        Huesped huesped = buscarHuespedCedula(cedula);

        if (huesped == null) {
            throw new BuscarHuespedException();
        }
        Multa multa = buscarMulta(huesped.getId());
        multa.setEstado("Sin Multa");

        if (!dao.modificarEstadoMulta(multa)) {
            throw new ModificarMultaException();
        } else {
            if (!daoReserva.modificarReserva("Sin Multa", "inactivo", idreserva)) {
                throw new ModificarReservaException();
            }

        }

    }

    public Huesped buscarHuespedCedula(String cedula) throws BuscarCedulaHuespedException {
        if (cedula == null) {
            throw new BuscarCedulaHuespedException();
        }
        ArrayList<Huesped> listahuesped = listaHuesped();

        for (int i = 0; i < listahuesped.size(); i++) {
            if (listahuesped.get(i).getCedula().equalsIgnoreCase(cedula)) {
                return listahuesped.get(i);

            }
        }
        return null;
    }

    public DTO.DTOMulta buscarMultaDTO(int id, String cedula) throws DatosIncompletosException, BuscarMultasException {
        ArrayList<DTO.DTOMulta> listaMulta = listaMultasDTO(cedula);
        DTO.DTOMulta multa = new DTOMulta();
        for (int i = 0; i < listaMulta.size(); i++) {
            if (listaMulta.get(i).getEstadomulta().equalsIgnoreCase("Multado") && listaMulta.get(i).getEstadoreservacion().equalsIgnoreCase("Multado")) {
                if (listaMulta.get(i).getCedula().equalsIgnoreCase(cedula) && listaMulta.get(i).getId() == id) {

                    return listaMulta.get(i);
                }
            }
        }
        return multa;
    }

    public ArrayList<Multa> listarMultas() {
        return dao.listaMulta();
    }

    public ArrayList<DTO.DTOMulta> listaMultasDTO(String cedula) throws DatosIncompletosException, BuscarMultasException {
        if (cedula == null) {
            throw new DatosIncompletosException();
        }
        ArrayList<DTO.DTOMulta> lista = dao.BuscarMultasDTO(cedula);
        if (lista == null) {
            throw new BuscarMultasException();
        }
        return lista;
    }

    public ArrayList<ReservaHabitacion> listaReservas() {
        return daoReserva.listarReserva();
    }

    public ArrayList<Habitacion> listaHabitacion() {
        return daoHabitacion.listarHabitacion();
    }

    public ArrayList<Huesped> listaHuesped() {
        return daoHuesped.listarHuesped();
    }

    public DefaultTableModel listarElementosMultasDTO(String cedula) throws DatosIncompletosException, BuscarMultasException {
        ArrayList<DTO.DTOMulta> lista = listaMultasDTO(cedula);

        String nombreColumnas[] = {"Id", "Cedula", "Nombre Huesped", "Habitacion", "Estado Reserva", "Fecha Reserva", "Check-in", "Check-out", "Cantidad a Pagar", "Estado Multa"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 10:
                        return true;
                    default:
                        return false;
                }
            }
        };

        for (DTO.DTOMulta multa : lista) {
            if (multa.getEstadomulta().equalsIgnoreCase("Multado") && multa.getEstadoreservacion().equalsIgnoreCase("Multado")) {
                String fechacheckin = formato.format(multa.getFechaHoraCheckIn());
                String fechacheckout = formato.format(multa.getFechaHoraCheckOut());
                String fechareservacion = formato.format(multa.getFechaHoraReserva());
                modelo.addRow(new Object[]{multa.getId(), multa.getCedula(), multa.getNombrehuesped(), multa.getNombreHabitacion(), multa.getEstadoreservacion(), fechareservacion, fechacheckin, fechacheckout, multa.getCantidadPagar(), multa.getEstadomulta()});
            }

        }

        return modelo;
    }

    public String valorMultaDTO(String idReserva) throws MultaIdReservaException {
        if (idReserva.equalsIgnoreCase(null)) {
            throw new MultaIdReservaException();
        }
        int idreserva = Integer.parseInt(idReserva);
        ArrayList<ReservaHabitacion> listareserva = listaReservas();
        ArrayList<Habitacion> listahabitacion = listaHabitacion();
        for (int i = 0; i < listareserva.size(); i++) {
            if (listareserva.get(i).getId() == idreserva) {
                Calendar calLlegada = new GregorianCalendar();
                calLlegada.setTime(listareserva.get(i).getFechaHoraCheckIn());
                int yearHoraFechaLlegada = calLlegada.get(Calendar.YEAR);
                int monthHoraFechaLlegada = calLlegada.get(Calendar.MONTH);
                int dayHoraFechaLlegada = calLlegada.get(Calendar.DAY_OF_MONTH);

                Calendar calSalida = new GregorianCalendar();
                calSalida.setTime(listareserva.get(i).getFechaHoraCheckOut());
                int yearFechaHoraSalida = calSalida.get(Calendar.YEAR);
                int monthFechaHoraSalida = calSalida.get(Calendar.MONTH);
                int dayFechaHoraSalida = calSalida.get(Calendar.DAY_OF_MONTH);

                int cantidadnoches = dayFechaHoraSalida - dayHoraFechaLlegada;
                int valornoche = 0;
                for (int j = 0; j < listahabitacion.size(); j++) {
                    if (listahabitacion.get(j).getId() == listareserva.get(i).getIdHabitacion()) {
                        valornoche = Integer.parseInt(listahabitacion.get(j).getValorPorNoche());
                        break;
                    }
                }
                int valortotal = cantidadnoches * valornoche;
                return valortotal + "";
            }
        }
        return null;

    }

    public String obtenerDatoJtextFile(JTextField x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }

    public ArrayList<DTOMulta> listaReporte(String cedula, int idReserva) throws DatosIncompletosException, BuscarMultasException {
        ArrayList<DTOMulta> lista = listaMultasDTO(cedula);
        ArrayList<DTOMulta> reporte = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdreserva() == idReserva && lista.get(i).getEstadomulta().equalsIgnoreCase("Multado")) {
                reporte.add(lista.get(i));
            }
        }
        return reporte;
    }

    public void GenerarReporteMulta(String filePath) {
        ArrayList<Multa> lista = dao.listaMulta();
        String fileName = filePath;
        //El documento que vamos a crear y empezamos a construir
        Document document = new Document();

        try {
            //Tomamos la instancia del documento y el archivo donde lo guardaremos
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            //Abrimos el documento
            document.open();
            /**
             * Cada Paragraph es equivalente a cada una de las líneas que vamos
             * a poner en el documento
             */
            Paragraph p = new Paragraph("Este es un ejemplo de pdf.");
            /*Debemos agregar al documento los Paragraph que vamos creando*/
            document.add(p);
            /*-----------------------------------------*/

            /**
             * Para insertar una línea en blanco
             */
            document.add(Chunk.NEWLINE);
            /*-----------------------------------------*/

            /**
             * Creamos un Paragraph para agregar una imagen
             */
            p = new Paragraph();
            p.add(Image.getInstance("Internet.png"));
            document.add(p);
            /*-----------------------------------------*/

            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            /**
             * Creamos un nuevo Paragraph y le configuramos el tabulado que va a
             * tener
             */
            p = new Paragraph();
            /*Se le indica la propiedad de tabulado*/
            p.setTabSettings(new TabSettings(56f));
            /*Se añade la línea por Chunks, es decir por trozos
             *Aquí se añade un tabulado
             */
            p.add(Chunk.TABBING);
            /*Aquí se añade un nuevo segmento a la misma línea*/
            p.add(new Chunk("Código"));
            p.add(Chunk.TABBING);
            p.add(new Chunk("Nombre"));
            p.add(Chunk.TABBING);
            p.add(new Chunk("Teléfono"));
            document.add(p);
            /*-----------------------------------------*/

            document.add(Chunk.NEWLINE);
            document.add(Chunk.NEWLINE);

            /**
             * Recorremos la lista regresada por la BD y aplicamos las
             * propiedades descritas anteriormente
             */
//            for (DTOMulta multa : lista) {
//                p = new Paragraph();
//                p.setTabSettings(new TabSettings(56f));
//                p.add(Chunk.TABBING);
//                p.add(new Chunk(docente.getCodigo() + ""));
//                p.add(Chunk.TABBING);
//                p.add(new Chunk(docente.getNombre()));
//                p.add(Chunk.TABBING);
//                p.add(new Chunk(docente.getTelefono()));
//                document.add(p);
//            }
            /*-----------------------------------------*/
            //Al finalizar se debe cerrar el documento para terminar
            document.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
