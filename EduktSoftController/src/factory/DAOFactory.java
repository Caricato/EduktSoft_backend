/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import config.DBManager;
import dao.EmpleadoDAO;
import dao.UsuarioDAO;

/**
 *
 * @author alulab14
 */
public abstract class DAOFactory {
    public abstract UsuarioDAO getUsuarioDAO();
    public abstract EmpleadoDAO getEmpleadoDAO();
    
    public static DAOFactory getDAOFactory(){
        if (DBManager.getInstance().getMysqlDriverClass().contains("mysql"))
            return new MYSQLDAOFactory();
        else
            return null;
    }
}
