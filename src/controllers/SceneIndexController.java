/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import beans.Empleado;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import persistencia.DataAdapters.TbEmployeesAdapter;

/**
 * FXML Controller class
 *
 * @author maslu
 */
public class SceneIndexController implements Initializable {

    TbEmployeesAdapter tbEmpleados = new TbEmployeesAdapter();

    private ObservableList<Empleado> empleadosModels = FXCollections.observableArrayList(tbEmpleados.select());

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Empleado> tbData;

    @FXML
    private TableColumn<Empleado, Integer> colId;

    @FXML
    private TableColumn<Empleado, String> colNombre;

    @FXML
    private TableColumn<Empleado, String> colEmpresa;

    @FXML
    private TableColumn<Empleado, String> colFecha;

    @FXML
    private TableColumn<Empleado, String> colSucursal;

    @FXML
    private TableColumn<Empleado, String> colServicio;

    @FXML
    void btnActualizar(ActionEvent event) {
        empleadosModels = FXCollections.observableArrayList(tbEmpleados.select());
        tbData.setItems(empleadosModels);
    }

    @FXML
    void initialize() {
        assert tbData != null : "fx:id=\"tbData\" was not injected: check your FXML file 'sceneIndex.fxml'.";
        assert colId != null : "fx:id=\"colId\" was not injected: check your FXML file 'sceneIndex.fxml'.";
        assert colNombre != null : "fx:id=\"colNombre\" was not injected: check your FXML file 'sceneIndex.fxml'.";
        assert colEmpresa != null : "fx:id=\"colEmpresa\" was not injected: check your FXML file 'sceneIndex.fxml'.";
        assert colFecha != null : "fx:id=\"colFecha\" was not injected: check your FXML file 'sceneIndex.fxml'.";
        assert colSucursal != null : "fx:id=\"colSucursal\" was not injected: check your FXML file 'sceneIndex.fxml'.";
        assert colServicio != null : "fx:id=\"colServicio\" was not injected: check your FXML file 'sceneIndex.fxml'.";

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colEmpresa.setCellValueFactory(new PropertyValueFactory<>("Compania"));
        //colFecha.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colSucursal.setCellValueFactory(new PropertyValueFactory<>("Sucursal"));
        colServicio.setCellValueFactory(new PropertyValueFactory<>("Servicio"));

        tbData.setItems(empleadosModels);
    }

}
