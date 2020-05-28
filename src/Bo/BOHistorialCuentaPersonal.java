/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOCategoriaProductos;
import Definiciones.IDAOHistorialCuentaPersonal;
import Definiciones.IDAOInventarioProductos;
import Excepcion.CargarImagenException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarHistorialCuentaPersonalException;
import Excepcion.ModificarCantidadException;
import Excepcion.ModificarInventarioException;
import Excepcion.NombreProductoException;
import Fabrica.FactoryDAO;
import Modelo.CategoriaProducto;
import Modelo.HistorialCuentaPersonal;
import Modelo.Producto;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author mateo
 */
public class BOHistorialCuentaPersonal {

    private final IDAOHistorialCuentaPersonal dao;
    private final IDAOInventarioProductos daoProductos;
    private final BOInventarioProductos boProductos;
    private final IDAOCategoriaProductos daoCategoria;

    public BOHistorialCuentaPersonal() {
        dao = FactoryDAO.getFabrica().crearDAOHistorialCuentaPersona();
        daoProductos = FactoryDAO.getFabrica().crearDAOInventarioProductos();
        daoCategoria = FactoryDAO.getFabrica().crearDAOCategoriaProductos();
        boProductos = new BOInventarioProductos();
    }

    /**
     * Metodo encargado de convertir un File a bytes
     *
     * @param file ruta de la imagen
     * @return imagen convertida en bytes
     * @throws CargarImagenException si hay algun error al convertir el File
     */
    public byte[] cargarImagenBytes(File file) throws CargarImagenException {
        try {
            byte[] icono = new byte[(int) file.length()];
            InputStream input = new FileInputStream(file);
            input.read(icono);
            return icono;
        } catch (IOException e) {
            throw new CargarImagenException();
        }
    }

    /**
     * Metodo encargado de convertir bytes en un BufferedImage
     *
     * @param bytes que se desea pasar a un BufferedImage
     * @return bytes convertidos en InputStream
     * @throws CargarImagenException si hay algun error al convertitir los bytes
     */
    public BufferedImage cargarImagenBufferedImage(byte[] bytes) throws CargarImagenException {
        try {
            BufferedImage imagen = null;
            InputStream input = new ByteArrayInputStream(bytes);
            imagen = ImageIO.read(input);
            return imagen;
        } catch (IOException e) {
            throw new CargarImagenException();
        }
    }

    public void guardarHistorialCuentaPersonal(int idCuentaPersonal, int idProducto, String cantidad) throws DatosIncompletosException, GuardarHistorialCuentaPersonalException, ModificarInventarioException, NombreProductoException, ModificarCantidadException {
        int cantidades = Integer.parseInt(cantidad);
        verificarCantidadDisponible(idProducto, cantidades);
        HistorialCuentaPersonal historial = new HistorialCuentaPersonal(0, idCuentaPersonal, idProducto, cantidad);

        if (!dao.guardarHistorialCuentaPersonal(historial)) {
            throw new GuardarHistorialCuentaPersonalException();
        }
    }

    public ArrayList<HistorialCuentaPersonal> listarHistorialCuentaPersonal() {
        return dao.listarHistorialPersonal();
    }

    public ArrayList<Producto> listaInventarioProductos() {
        return daoProductos.listaInventarioProducto();
    }

    public ArrayList<CategoriaProducto> listaCategoria() {
        return daoCategoria.listarCategoriaProductos();
    }

    public DefaultComboBoxModel llenarComboBoxCategoria() {
        ArrayList<CategoriaProducto> listacategorias = listaCategoria();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < listacategorias.size(); i++) {
            if (listacategorias.get(i).getEstado().equalsIgnoreCase("Disponible")) {
                modelo.addElement(listacategorias.get(i).getNombre());
            }
        }
        return modelo;
    }

    public DefaultComboBoxModel llenarComboBoxProductos(int idcategoria) {
        ArrayList<Producto> listaproductos = listaInventarioProductos();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        for (int i = 0; i < listaproductos.size(); i++) {
            int cantidad = Integer.parseInt(listaproductos.get(i).getCantidad());
            if (listaproductos.get(i).getEstado().equalsIgnoreCase("Disponible") && cantidad > 0 && listaproductos.get(i).getIdCategoriaProducto() == idcategoria) {
                modelo.addElement(listaproductos.get(i).getNombre());
            }
        }
        if (modelo == null) {
            modelo.addElement("no hay elementos disponibles");
        }
        return modelo;
    }

    public String obtenerDatoJtextFile(JTextField x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }

    public String obtenerDatoJComboBox(JComboBox x) {
        String informacion = x.getSelectedItem().toString();
        if (informacion.equals("Seleccione habitacion")) {
            informacion = null;
        }
        return informacion;
    }

    public void verificarCantidadDisponible(int idproducto, int cantidad) throws ModificarInventarioException, NombreProductoException, DatosIncompletosException, ModificarCantidadException {
        ArrayList<Producto> listaproductos = listaInventarioProductos();

        for (int i = 0; i < listaproductos.size(); i++) {
            int suministros = Integer.parseInt(listaproductos.get(i).getCantidad());
            if (listaproductos.get(i).getId() == idproducto) {
                if (suministros >= cantidad && suministros != 0) {
                    boProductos.modificarcantidad(listaproductos.get(i).getNombre(), cantidad);
                    break;
                } else {
                    throw new ModificarCantidadException();
                }

            }
        }
    }
}
