/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.factory;

import dao.UsuarioDAO;
import dao.implementation.UsuarioMySQL;

/**
 *
 * @author alulab14
 */
public class UsuarioDAOFactory {
    public UsuarioDAO getUsuarioDAO(){
        return new UsuarioMySQL();
    }
}
