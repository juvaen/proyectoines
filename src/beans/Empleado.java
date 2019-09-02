/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author maslu
 */
public class Empleado {

    private SimpleIntegerProperty id;
    private SimpleStringProperty nombre;
    private SimpleStringProperty compania;
    private SimpleStringProperty servicio;
    private SimpleStringProperty sucursal;

    public Empleado(Integer id, String nombre, String compania, String servicio, String sucursal) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.compania = new SimpleStringProperty(compania);
        this.servicio = new SimpleStringProperty(servicio);
        this.sucursal = new SimpleStringProperty(sucursal);
    }

    public Empleado(String nombre, String compania, String servicio, String sucursal) {
        this.nombre = new SimpleStringProperty(nombre);
        this.compania = new SimpleStringProperty(compania);
        this.servicio = new SimpleStringProperty(servicio);
        this.sucursal = new SimpleStringProperty(sucursal);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public String getCompania() {
        return compania.get();
    }

    public void setCompania(String compania) {
        this.compania = new SimpleStringProperty(compania);
    }

    public String getServicio() {
        return servicio.get();
    }

    public void setServicio(String servicio) {
        this.servicio = new SimpleStringProperty(servicio);
    }

    public String getSucursal() {
        return sucursal.get();
    }

    public void setSucursal(String sucursal) {
        this.sucursal = new SimpleStringProperty(sucursal);
    }

}
