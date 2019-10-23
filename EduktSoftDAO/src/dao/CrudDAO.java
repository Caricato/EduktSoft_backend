package dao;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alulab14
 */
public interface CrudDAO {
    int insertar(Object objeto);
    Object encontrarPorId(int id);
    int actualizar(Object objeto);
    int eliminar(int id);
    ArrayList<Object> listarTodos();
}
