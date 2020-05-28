/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOCategoriaProductos;
import Definiciones.IDAOInventarioProductos;
import Excepcion.BuscarInventarioException;
import Excepcion.CargarImagenException;
import Excepcion.ComboBoxException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarInventarioProductoException;
import Excepcion.ModificarInventarioException;
import Excepcion.NombreProductoException;
import Fabrica.FactoryDAO;
import Modelo.CategoriaProducto;
import Modelo.Producto;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class BOInventarioProductos {

    private final IDAOInventarioProductos dao;
    private final IDAOCategoriaProductos daocategoria;

    public BOInventarioProductos() {
        dao = FactoryDAO.getFabrica().crearDAOInventarioProductos();
        daocategoria = FactoryDAO.getFabrica().crearDAOCategoriaProductos();
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

    public void guardarInventarioProductos(int idCategoriaProducto, String nombre, String cantidad, String precioUnitario, File ruta, String descripcion, String estado) throws CargarImagenException, NombreProductoException, DatosIncompletosException, GuardarInventarioProductoException {
        Producto producto = new Producto(0, idCategoriaProducto, nombre, cantidad, precioUnitario, cargarImagenBytes(ruta), descripcion, estado);
        if (!dao.guardarInventarioProductos(producto)) {
            throw new GuardarInventarioProductoException();
        }
    }

    public Producto buscarInventarioProducto(String nombre) throws DatosIncompletosException, BuscarInventarioException {
        if (nombre == null) {
            throw new DatosIncompletosException();
        }
        Producto producto = dao.buscarInventarioProductos(nombre);
        if (producto == null) {
            throw new BuscarInventarioException();
        }
        return producto;
    }

    public void modificarInventario(int idCategoriaProducto, String nombre, String cantidad, String precioUnitario, File ruta, String descripcion, String estado) throws DatosIncompletosException, BuscarInventarioException, CargarImagenException, NombreProductoException, ModificarInventarioException {
        Producto producto = new Producto(buscarInventarioProducto(nombre).getId(), idCategoriaProducto, nombre, cantidad, precioUnitario, cargarImagenBytes(ruta), descripcion, estado);
        if (!dao.modificarInventarioProductos(producto)) {
            throw new ModificarInventarioException();
        }
    }

    public void modificarInventario2(int idCategoriaProducto, String nombre, String cantidad, String precioUnitario, String descripcion, String estado) throws DatosIncompletosException, BuscarInventarioException, CargarImagenException, NombreProductoException, ModificarInventarioException {
        Producto producto = new Producto(buscarInventarioProducto(nombre).getId(), idCategoriaProducto, nombre, cantidad, precioUnitario, null, descripcion, estado);
        if (!dao.modificarInventarioProductos2(producto)) {
            throw new ModificarInventarioException();
        }
    }

    public ArrayList<Producto> listaInventario() {
        return dao.listaInventarioProducto();
    }

    public ArrayList<CategoriaProducto> listaCategoria() {
        return daocategoria.listarCategoriaProductos();
    }

    public DefaultComboBoxModel llenarComboBox() {
        ArrayList<CategoriaProducto> listarCategoriaProductos = listaCategoria();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Seleccione");
        for (int i = 0; i < listarCategoriaProductos.size(); i++) {
            if (listarCategoriaProductos.get(i).getEstado().equalsIgnoreCase("Disponible")) {
                modelo.addElement(listarCategoriaProductos.get(i).getNombre());
            }

        }
        return modelo;
    }

    public int seleccionarArchivoCategoria(int idcategoria) {
        ArrayList<CategoriaProducto> listacategorias = listaCategoria();
        int valor = 0;
        for (int i = 0; i < listacategorias.size(); i++) {
            if (listacategorias.get(i).getId() == idcategoria) {
                valor = i;
                break;
            }
        }
        return valor;
    }

    public String obtenerDatoJtextFile(JTextField x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }

    public String obtenerDatoJtextArea(JTextArea x) {
        String informacion = x.getText();
        if (informacion.equals("")) {
            informacion = null;
        }
        return informacion;
    }

    public String obtenerDatoJComboBox(JComboBox x) {
        String informacion = x.getSelectedItem().toString();
        if (informacion.equals("Seleccione")) {
            informacion = null;
        }
        return informacion;
    }

    public DefaultTableModel listarElementos() {

        ArrayList<Producto> lista = listaInventario();
        ArrayList<CategoriaProducto> listacategoria = listaCategoria();
        String nombreColumnas[] = {"Id", "Categoria", "Nombre", "Cantidad", "Precio Unitario", "Descripcion", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 7:
                        return true;
                    default:
                        return false;
                }
            }
        };

        String categorias = "";

        for (Producto producto : lista) {
            if (producto.getEstado().equalsIgnoreCase("Disponible")) {
                for (CategoriaProducto categoria : listacategoria) {

                    if (producto.getIdCategoriaProducto() == categoria.getId()) {

                        categorias = categoria.getNombre();

                        break;
                    }

                }
                modelo.addRow(new Object[]{producto.getId(), categorias, producto.getNombre(), producto.getCantidad(), producto.getPrecioUnitario(), producto.getDescripcion(), producto.getEstado()});
            }

        }
        return modelo;
    }

    public int obtenerIdCategoria(int posicioncategoria) {
        ArrayList<CategoriaProducto> listacategoria = listaCategoria();
        CategoriaProducto producto = listacategoria.get(posicioncategoria);

        return producto.getId();
    }

    public DefaultTableModel filtrar(String opcion, String accion) throws ComboBoxException, NumberFormatException, ParseException {

        String categoria = "";
        ArrayList<Producto> Listaproducto = listaInventario();

        String nombreColumnas[] = {"Id", "Categoria", "Nombre", "Cantidad", "Precio Unitario", "Descripcion", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 7:
                        return true;
                    default:
                        return false;
                }
            }

        };
        ArrayList<CategoriaProducto> Listacategoria = listaCategoria();
        switch (opcion) {
            case "Seleccione":
                throw new ComboBoxException();

            case "Id":
                try {
                    int x = Integer.parseInt(accion);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException();

                }
                if (!accion.equals("Seleccione")) {
                    for (int i = 0; i < Listaproducto.size(); i++) {
                        if (Integer.parseInt(accion) == Listaproducto.get(i).getId() && Listaproducto.get(i).getEstado().equals("Disponible")) {
                            for (int j = 0; j < Listacategoria.size(); j++) {

                                if (Listaproducto.get(i).getIdCategoriaProducto() == Listacategoria.get(j).getId()) {

                                    categoria = Listacategoria.get(j).getNombre();

                                    break;
                                }

                            }
                            modelo.addRow(new Object[]{Listaproducto.get(i).getId(), categoria, Listaproducto.get(i).getNombre(), Listaproducto.get(i).getCantidad(), Listaproducto.get(i).getPrecioUnitario(), Listaproducto.get(i).getDescripcion(), Listaproducto.get(i).getEstado()});
                        }
                    }
                    return modelo;
                } else {
                    throw new ComboBoxException();
                }

            case "Categoria":
                try {
                    int x = Integer.parseInt(accion);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException();

                }
                if (!accion.equals("Seleccione")) {
                    for (int i = 0; i < Listaproducto.size(); i++) {
                        if (Integer.parseInt(accion) == Listaproducto.get(i).getId() && Listaproducto.get(i).getEstado().equals("Disponible")) {
                            for (int j = 0; j < Listacategoria.size(); j++) {

                                if (Listaproducto.get(i).getIdCategoriaProducto() == Listaproducto.get(j).getId()) {

                                    categoria = Listacategoria.get(j).getNombre();

                                    break;
                                }

                            }

                            modelo.addRow(new Object[]{Listaproducto.get(i).getId(), categoria, Listaproducto.get(i).getNombre(), Listaproducto.get(i).getCantidad(), Listaproducto.get(i).getPrecioUnitario(), Listaproducto.get(i).getDescripcion(), Listaproducto.get(i).getEstado()});
                        }
                    }

                    return modelo;

                } else {
                    throw new ComboBoxException();
                }

            case "Nombre":

                if (!accion.equals("Seleccione")) {
                    for (int i = 0; i < Listaproducto.size(); i++) {
                        if (accion.equals(Listaproducto.get(i).getNombre()) && Listaproducto.get(i).getEstado().equals("Disponible")) {
                            for (int j = 0; j < Listacategoria.size(); j++) {

                                if (Listaproducto.get(i).getIdCategoriaProducto() == Listacategoria.get(j).getId()) {

                                    categoria = Listacategoria.get(j).getNombre();

                                    break;
                                }

                            }
                            modelo.addRow(new Object[]{Listaproducto.get(i).getId(), categoria, Listaproducto.get(i).getNombre(), Listaproducto.get(i).getCantidad(), Listaproducto.get(i).getPrecioUnitario(), Listaproducto.get(i).getDescripcion(), Listaproducto.get(i).getEstado()});
                        }
                    }
                    return modelo;
                } else {
                    throw new ComboBoxException();
                }
            case "Cantidad":

                if (!accion.equals("Seleccione")) {
                    for (int i = 0; i < Listaproducto.size(); i++) {
                        if (accion.equals(Listaproducto.get(i).getCantidad()) && Listaproducto.get(i).getEstado().equals("Disponible")) {
                            for (int j = 0; j < Listacategoria.size(); j++) {

                                if (Listaproducto.get(i).getIdCategoriaProducto() == Listacategoria.get(j).getId()) {

                                    categoria = Listacategoria.get(j).getNombre();

                                    break;
                                }

                            }
                            modelo.addRow(new Object[]{Listaproducto.get(i).getId(), categoria, Listaproducto.get(i).getNombre(), Listaproducto.get(i).getCantidad(), Listaproducto.get(i).getPrecioUnitario(), Listaproducto.get(i).getDescripcion(), Listaproducto.get(i).getEstado()});
                        }
                    }
                    return modelo;
                } else {
                    throw new ComboBoxException();
                }

            case "Precio Unitario":

                if (!accion.equals("Seleccione")) {
                    for (int i = 0; i < Listaproducto.size(); i++) {
                        if (accion.equals(Listaproducto.get(i).getPrecioUnitario()) && Listaproducto.get(i).getEstado().equals("Disponible")) {
                            for (int j = 0; j < Listacategoria.size(); j++) {

                                if (Listaproducto.get(i).getIdCategoriaProducto() == Listacategoria.get(j).getId()) {

                                    categoria = Listacategoria.get(j).getNombre();

                                    break;
                                }

                            }
                            modelo.addRow(new Object[]{Listaproducto.get(i).getId(), categoria, Listaproducto.get(i).getNombre(), Listaproducto.get(i).getCantidad(), Listaproducto.get(i).getPrecioUnitario(), Listaproducto.get(i).getDescripcion(), Listaproducto.get(i).getEstado()});
                        }
                    }
                    return modelo;
                } else {
                    throw new ComboBoxException();
                }
            case "Estado":

                if (!accion.equals("Seleccione")) {
                    for (int i = 0; i < Listaproducto.size(); i++) {
                        if (accion.equals(Listaproducto.get(i).getEstado())) {
                            for (int j = 0; j < Listacategoria.size(); j++) {

                                if (Listaproducto.get(i).getIdCategoriaProducto() == Listacategoria.get(j).getId()) {

                                    categoria = Listacategoria.get(j).getNombre();

                                    break;
                                }

                            }
                            modelo.addRow(new Object[]{Listaproducto.get(i).getId(), categoria, Listaproducto.get(i).getNombre(), Listaproducto.get(i).getCantidad(), Listaproducto.get(i).getPrecioUnitario(), Listaproducto.get(i).getDescripcion(), Listaproducto.get(i).getEstado()});
                        }
                    }
                    return modelo;
                } else {
                    throw new ComboBoxException();
                }
            default:
                break;
        }
        return modelo;
    }

}
