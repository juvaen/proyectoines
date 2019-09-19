/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Empleado;
import com.gluonhq.charm.glisten.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import persistencia.DataAdapters.TbEmployeesAdapter;

/**
 * FXML Controller class
 *
 * @author maslu
 */
// ************************************************************************
// Estos maneja botones de borrar y editar un Empleado.
// ************************************************************************
public class SceneBorrarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtfecha;

    @FXML
    private TextField txtServicio;

    @FXML
    private TextField txtSucursal;

    @FXML
    private TextField txtCompania;

    @FXML
    private TextField txtId;

    @FXML
    void deleteEmpleado(ActionEvent event) {
        String id = txtId.getText();
        TbEmployeesAdapter tbEmpleados = new TbEmployeesAdapter();
        tbEmpleados.borrarEmpleado(id);

        txtId.setText("");
        txtNombre.setText("");
        txtCompania.setText("");
        txtServicio.setText("");
        txtSucursal.setText("");

    }

    @FXML
    void searchEmpleado(ActionEvent event) {
        String id = txtId.getText();
        TbEmployeesAdapter tbEmpleados = new TbEmployeesAdapter();
        Empleado busqueda = tbEmpleados.buscarEmpleado(id);

        txtNombre.setText(busqueda.getNombre());
        txtCompania.setText(busqueda.getCompania());
        txtServicio.setText(busqueda.getServicio());
        txtSucursal.setText(busqueda.getSucursal());
    }

    @FXML
    void updateEmpleado(ActionEvent event) {

        int id = Integer.parseInt(txtId.getText());
        String nombre = txtNombre.getText();
        String servicio = txtServicio.getText();
        String sucursal = txtSucursal.getText();
        String compania = txtCompania.getText();
        Empleado empleado = new Empleado(id, nombre, compania, servicio, sucursal);

        TbEmployeesAdapter tbEmpleados = new TbEmployeesAdapter();
        tbEmpleados.actualizarEmpleado(empleado);

        //new Alert(AlertType.INFORMATION, "Registro Insertado").showAndWait();
        txtId.setText("");
        txtNombre.setText("");
        txtCompania.setText("");
        txtServicio.setText("");
        txtSucursal.setText("");

    }

    @FXML
    void initialize() {
        assert txtNombre != null : "fx:id=\"txtNombre2\" was not injected: check your FXML file 'sceneBorrar.fxml'.";
        assert txtfecha != null : "fx:id=\"txtfecha\" was not injected: check your FXML file 'sceneBorrar.fxml'.";
        assert txtServicio != null : "fx:id=\"txtServicio\" was not injected: check your FXML file 'sceneBorrar.fxml'.";
        assert txtSucursal != null : "fx:id=\"txtSucursal\" was not injected: check your FXML file 'sceneBorrar.fxml'.";
        assert txtCompania != null : "fx:id=\"txtCompania\" was not injected: check your FXML file 'sceneBorrar.fxml'.";
        assert txtId != null : "fx:id=\"txtId\" was not injected: check your FXML file 'sceneBorrar.fxml'.";

    }
}
