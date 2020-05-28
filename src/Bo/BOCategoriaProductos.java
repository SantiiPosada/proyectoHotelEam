/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import Definiciones.IDAOCategoriaProductos;
import Excepcion.BuscarHabitacionException;
import Excepcion.ComboBoxException;
import Excepcion.DatosIncompletosException;
import Excepcion.GuardarCategoriaProductosException;
import Excepcion.ModificarCategoriaProductosException;
import Excepcion.NombreCategoriaException;

import Fabrica.FactoryDAO;
import Modelo.CategoriaProducto;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateo
 */
public class BOCategoriaProductos {

    private final IDAOCategoriaProductos dao;

    public BOCategoriaProductos() {
        dao = FactoryDAO.getFabrica().crearDAOCategoriaProductos();
    }

    public void guardarCategoriaProductos(String nombre, String descripcion, String estado) throws NombreCategoriaException, DatosIncompletosException, GuardarCategoriaProductosException {

        CategoriaProducto categoria = new CategoriaProducto(0, nombre, descripcion, estado);
        if (!dao.guardarCategoriaProductos(categoria)) {
            throw new GuardarCategoriaProductosException();
        }

    }

    public CategoriaProducto buscarCategoriaProducto(String nombre) throws DatosIncompletosException, BuscarHabitacionException {
        if (nombre == null) {
            throw new DatosIncompletosException();
        }
        CategoriaProducto categoria = dao.buscarCategoriaProductos(nombre);
        if (categoria == null) {
            throw new BuscarHabitacionException();
        }
        return categoria;
    }

    public void modificarCategoriaProducto(String nombre, String descripcion, String estado) throws DatosIncompletosException, BuscarHabitacionException, NombreCategoriaException, ModificarCategoriaProductosException {
        CategoriaProducto categoria = new CategoriaProducto(buscarCategoriaProducto(nombre).getId(), nombre, descripcion, estado);
        if (!dao.modificarCategoriaProductos(categoria)) {
            throw new ModificarCategoriaProductosException();
        }
    }

    public ArrayList<CategoriaProducto> listarCategoriaProductos() {
        return dao.listarCategoriaProductos();
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

    public DefaultTableModel listarElementos() {

        ArrayList<CategoriaProducto> lista = listarCategoriaProductos();
        String nombreColumnas[] = {"Id", "Nombre", "Descripcion", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 4:
                        return true;
                    default:
                        return false;
                }
            }
        };

        lista.forEach((Categoria) -> {

            if (!Categoria.getEstado().equalsIgnoreCase("No Disponible")) {

                modelo.addRow(new Object[]{Categoria.getId(), Categoria.getNombre(), Categoria.getDescripcion(), Categoria.getEstado()});

            }

        });

        return modelo;

    }

    public DefaultTableModel filtrar(String opcion, String accion) throws DatosIncompletosException, NumberFormatException, ComboBoxException {
        if (accion == null) {
            throw new DatosIncompletosException();
        }

        String nombre = "";
        ArrayList<CategoriaProducto> lista = listarCategoriaProductos();
        String nombreColumnas[] = {"Id", "Nombre", "Descripcion", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, nombreColumnas) {
            @Override
            public boolean isCellEditable(int filas, int columnas) {
                switch (columnas) {
                    case 4:
                        return true;
                    default:
                        return false;
                }
            }
        };

        switch (opcion) {
            case "Seleccione":
                throw new ComboBoxException();

            case "Nombre":
                lista.forEach((categoria) -> {
                    if (categoria.getNombre().equalsIgnoreCase(accion)) {

                        if (!categoria.getEstado().equalsIgnoreCase("No Disponible")) {

                            modelo.addRow(new Object[]{categoria.getId(), categoria.getNombre(), categoria.getDescripcion(), categoria.getEstado()});
                        }
                    }

                });
                return modelo;

            case "Estado":
                lista.forEach((categoria) -> {

                    if (categoria.getEstado().equalsIgnoreCase(accion)) {
                        modelo.addRow(new Object[]{categoria.getId(), categoria.getNombre(), categoria.getDescripcion(), categoria.getEstado()});
                    }

                });
                return modelo;

            default:
                break;
        }
        return modelo;

    }
}
