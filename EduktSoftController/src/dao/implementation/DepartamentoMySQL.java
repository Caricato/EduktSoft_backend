/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.implementation;

import config.DBManager;
import dao.DepartamentoDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Departamento;

/**
 *
 * @author alulab14
 */
public class DepartamentoMySQL implements DepartamentoDAO{
    Connection con = null;
    Statement st = null;
    CallableStatement cs = null;
    
    @Override
    public ArrayList<Departamento> listarTodos() {
        ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_DEPARTAMENTOS()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Departamento departamento = new Departamento();
                departamento.setId(rs.getInt("ID_DEPARTAMENTO"));
                departamento.setNombre(rs.getString("NOMBRE_DEPARTAMENTO"));
                departamento.setUbigeo(rs.getString("UBIGEO"));
                departamento.setActive(rs.getBoolean("ACTIVE"));
                departamentos.add(departamento);
            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();} catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return departamentos;
    }

    @Override
    public int insertar(Departamento objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Departamento encontrarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int actualizar(Departamento objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
