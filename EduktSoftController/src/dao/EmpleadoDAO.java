/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Area;
import model.Empleado;

/**
 *
 * @author alulab14
 */
public interface EmpleadoDAO extends CrudDAO<Empleado>{
    ArrayList<Empleado> listarPorArea(Area area);
}
