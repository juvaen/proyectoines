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

    // ************************************************************************
    // Hacer un listado de los empleados. READ
    // ************************************************************************
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

    // ************************************************************************
    // Agregar empleado a la base de datos. CREATE
    // ************************************************************************
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

    // ************************************************************************
    // BUuscar empleado en la base de datos.
    // ************************************************************************
    public Empleado buscarEmpleado(String id) {
        try {
            PreparedStatement verificarStmt
                    = c.prepareStatement("SELECT employee_id, employee_name, payment_company, branch, service FROM employees WHERE employee_id = ?");
            verificarStmt.setInt(1, Integer.parseInt(id));
            ResultSet rs = verificarStmt.executeQuery();

            if (rs.next()) {
                Integer employee_id = rs.getInt("employee_id");
                String nombre = rs.getString("employee_name");
                String compania = rs.getString("payment_company");
                String sucursal = rs.getString("branch");
                String servicio = rs.getString("service");

                Empleado empleado = new Empleado(employee_id, nombre, compania, sucursal, servicio);
                return empleado;
            }
        } catch (SQLException e) {
            Logger.getLogger(TbEmployeesAdapter.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    // ************************************************************************
    // Editar empleado en la base de datos. UPDATE
    // ************************************************************************
    public void actualizarEmpleado(Empleado empleado) {
        try {
            String query = "UPDATE employees SET employee_name = ? ,payment_company= ?, branch=?, service=? WHERE employee_id=?";
            PreparedStatement preparedStmt = c.prepareStatement(query);

            preparedStmt.setString(1, empleado.getNombre());
            preparedStmt.setString(2, empleado.getCompania());
            preparedStmt.setString(3, empleado.getSucursal());
            preparedStmt.setString(4, empleado.getServicio());
            preparedStmt.setInt(5, empleado.getId());

            preparedStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TbEmployeesAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // ************************************************************************
    // Borrar empleado de la base de datos. DELETE
    // ************************************************************************
    public void borrarEmpleado(String id) {
        try {
            PreparedStatement verificarStmt
                    = c.prepareStatement("DELETE FROM employees WHERE employee_id = ?");
            verificarStmt.setInt(1, Integer.parseInt(id));
            verificarStmt.execute();
        } catch (SQLException e) {
            Logger.getLogger(TbEmployeesAdapter.class.getName()).log(Level.SEVERE, null, e);
        }
    }


}
