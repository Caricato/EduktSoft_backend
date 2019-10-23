package EduktSoft.EduktSoftDAO;

import java.util.ArrayList;
public interface CrudDAO{
  int insertar(Object objeto);
  Object encontrarPorId(int id);
  int actualizar(Object objeto);
  int eliminar(int id);
  ArrayList<Object> listar();
}
