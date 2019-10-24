/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.factory;

import dao.DepartamentoDAO;
import dao.implementation.DepartamentoMySQL;

/**
 *
 * @author alulab14
 */
public class DepartamentoDAOFactory {
    public DepartamentoDAO getDepartamentoDAO(){
        return new DepartamentoMySQL();
    }
}
