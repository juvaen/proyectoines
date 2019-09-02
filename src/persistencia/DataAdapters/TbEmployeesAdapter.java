/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.DataAdapters;

import beans.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.MYSQL;

/**
 *
 * @author maslu
 */
public class TbEmployeesAdapter {

    MYSQL con = new MYSQL();
    Connection c = con.getConnection();

    public List<Empleado> select() {
        List<Empleado> lsEmpleado = new ArrayList<>();

        try {
            PreparedStatement verificarStmt
                    = c.prepareStatement("SELECT employee_id,employee_name, payment_company, branch, service FROM employees");

            ResultSet rs = verificarStmt.executeQuery();

            while (rs.next()) {
                Integer id = rs.getInt("employee_id");
                String nombre = rs.getString("employee_name");
                String compania = rs.getString("payment_company");
                String sucursal = rs.getString("branch");
                String servicio = rs.getString("service");
                //String fecha = rs.getString("");
                Empleado empleado = new Empleado(id, nombre, compania, sucursal, servicio);
                lsEmpleado.add(empleado);
            }

            return lsEmpleado;

        } catch (SQLException e) {
            Logger.getLogger(TbEmployeesAdapter.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public void altaEmpleado(Empleado empleado) {
        try {
            String query = "insert into employees (employee_name,payment_company, branch, service) values (?,?,?,?)";
            PreparedStatement preparedStmt = c.prepareStatement(query);

            preparedStmt.setString(1, empleado.getNombre());
            preparedStmt.setString(2, empleado.getCompania());
            preparedStmt.setString(3, empleado.getSucursal());
            preparedStmt.setString(4, empleado.getServicio());

            preparedStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TbEmployeesAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}