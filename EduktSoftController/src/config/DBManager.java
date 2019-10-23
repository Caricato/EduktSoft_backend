/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alulab14
 */
public class DBManager {
    
    private String mysqlDriverClass;
    private static DBManager dbManager;
    private ConnectionParameters connectionParameters;
    
    public DBManager(){
        connectionParameters = new ConnectionParameters();
        mysqlDriverClass = "com.mysql.cj.jdbc.Driver";
    }
    
    public java.sql.Connection getConnection(){
        try{
            return DriverManager.getConnection(DBManager.dbManager.connectionParameters.getUrl(),DBManager.dbManager.connectionParameters.getUser(),
                DBManager.dbManager.connectionParameters.getPassword());
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public static DBManager getInstance(){
        return dbManager;
    }

    public String getMysqlDriverClass() {
        return mysqlDriverClass;
    }

    public void setMysqlDriverClass(String mysqlDriverClass) {
        this.mysqlDriverClass = mysqlDriverClass;
    }
    
    
}
