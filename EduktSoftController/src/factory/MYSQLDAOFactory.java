/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import config.DBManager;
import dao.EmpleadoDAO;
import dao.UsuarioDAO;
import implementation.mysql.EmpleadoMySQL;
import implementation.mysql.UsuarioMySQL;

/**
 *
 * @author alulab14
 */
public class MYSQLDAOFactory extends DAOFactory {
    public MYSQLDAOFactory(){
        try{
            Class.forName(DBManager.getInstance().getMysqlDriverClass());
        } catch (ClassNotFoundException ex) {
           System.out.println(ex.getMessage());
        }
    }

    @Override
    public UsuarioDAO getUsuarioDAO() {
        return new UsuarioMySQL();
    }

    @Override
    public EmpleadoDAO getEmpleadoDAO() {
        return new EmpleadoMySQL();
    }
}
