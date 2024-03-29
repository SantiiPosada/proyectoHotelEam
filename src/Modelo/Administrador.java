
package Modelo;



/**
 * @author mateo gomez y santiago posada <santi.posdada.3075@eam.edu.co>
 */
public class Administrador {

    private int id;
    private String cedula;
    private String nombrecompleto;
    private String contrasena;

    public Administrador() {
        this.id = 0;
        this.cedula = null;
        this.nombrecompleto = null;
        this.contrasena = null;
    }

    public Administrador(int id, String cedula, String nombrecompleto, String contrasena) {
        this.id = id;
        this.cedula = cedula;
        this.nombrecompleto = nombrecompleto;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

 

}
