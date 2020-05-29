/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Bo.BOInventarioProductos;
import Excepcion.BuscarCategoriaException;
import Excepcion.BuscarInventarioException;
import Excepcion.CargarImagenException;
import Excepcion.ComboBoxException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarInventarioProductoException;
import Excepcion.ModificarInventarioException;
import Excepcion.NombreProductoException;
import Modelo.Producto;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class CtlInventarioProductos {

    BOInventarioProductos bo;

    public CtlInventarioProductos() {
        bo = new BOInventarioProductos();
    }

    public void guardarInventario(int idCategoriaProducto, String nombre, String cantidad, String precioUnitario, File ruta, String descripcion, String estado) throws CargarImagenException, NombreProductoException, DatosIncompletosException, GuardarInventarioProductoException {
        bo.guardarInventarioProductos(idCategoriaProducto, nombre, cantidad, precioUnitario, ruta, descripcion, estado);
    }

    public Producto buscarInventario(String nombre) throws DatosIncompletosException, BuscarInventarioException {
        return bo.buscarInventarioProducto(nombre);
    }

    public void modificarInventario(int idCategoriaProducto, String nombre, String cantidad, String precioUnitario, File ruta, String descripcion, String estado) throws DatosIncompletosException, BuscarInventarioException, CargarImagenException, NombreProductoException, ModificarInventarioException {
        bo.modificarInventario(idCategoriaProducto, nombre, cantidad, precioUnitario, ruta, descripcion, estado);
    }

    public void modificarInventario2(int idCategoriaProducto, String nombre, String cantidad, String precioUnitario, String descripcion, String estado) throws DatosIncompletosException, BuscarInventarioException, CargarImagenException, NombreProductoException, ModificarInventarioException {
        bo.modificarInventario2(idCategoriaProducto, nombre, cantidad, precioUnitario, descripcion, estado);
    }

    public ArrayList<Producto> listainventario() {
        return bo.listaInventario();
    }

    public int seleccionarArchivoCategoria(int idcategoria) {
        return bo.seleccionarArchivoCategoria(idcategoria);
    }

    public DefaultComboBoxModel llenarComboBox() {
        return bo.llenarComboBox();
    }

   

    public String obtenerDatoJtextFile(JTextField x) {
        return bo.obtenerDatoJtextFile(x);
    }

    public String obtenerDatoJComboBox(JComboBox x) {
        return bo.obtenerDatoJComboBox(x);
    }

    public String obtenerDatoJtextArea(JTextArea x) {
        return bo.obtenerDatoJtextArea(x);
    }

    public DefaultTableModel filtrar(String opcion, String accion) throws DatosIncompletosException, NumberFormatException, ComboBoxException, ParseException, BuscarCategoriaException {
        return bo.filtrar(opcion, accion);
    }

    public DefaultTableModel listarElementos() {
        return bo.listarElementos();
    }

    public BufferedImage cargarImagenBufferedImage(byte[] bytes) throws CargarImagenException {
        return bo.cargarImagenBufferedImage(bytes);
    }

    public byte[] cargarImagenBytes(File file) throws CargarImagenException {
        return bo.cargarImagenBytes(file);
    }

    public int obtenerIdCategoria(String posicioncategoria) throws DatosIncompletosException {
        return bo.obtenerIdCategoria(posicioncategoria);
    }
}
