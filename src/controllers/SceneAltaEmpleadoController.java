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
import javafx.fxml.Initializable;
import persistencia.DataAdapters.TbEmployeesAdapter;

/**
 * FXML Controller class
 *
 * @author maslu
 */
public class SceneAltaEmpleadoController implements Initializable {

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
    void altaEmpleado(ActionEvent event) {
        String nombre = txtNombre.getText();
        String servicio = txtServicio.getText();
        String sucursal = txtSucursal.getText();
        String compania = txtCompania.getText();
        Empleado empleadoNuevo = new Empleado(nombre, compania, servicio, sucursal);

        TbEmployeesAdapter tbEmpleados = new TbEmployeesAdapter();
        tbEmpleados.altaEmpleado(empleadoNuevo);

        //new Alert(AlertType.INFORMATION, "Registro Insertado").showAndWait();
        txtNombre.setText("");
        txtCompania.setText("");
        txtServicio.setText("");
        txtSucursal.setText("");

    }

    @FXML
    void initialize() {
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'sceneAltaEmpleado.fxml'.";
        assert txtfecha != null : "fx:id=\"txtfecha\" was not injected: check your FXML file 'sceneAltaEmpleado.fxml'.";
        assert txtServicio != null : "fx:id=\"txtServicio\" was not injected: check your FXML file 'sceneAltaEmpleado.fxml'.";
        assert txtSucursal != null : "fx:id=\"txtSucursal\" was not injected: check your FXML file 'sceneAltaEmpleado.fxml'.";
        assert txtCompania != null : "fx:id=\"txtCompania\" was not injected: check your FXML file 'sceneAltaEmpleado.fxml'.";
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
