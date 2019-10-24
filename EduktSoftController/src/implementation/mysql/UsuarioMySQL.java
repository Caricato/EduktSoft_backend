/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation.mysql;

import config.DBManager;
import dao.UsuarioDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.EstadoUsuario;
import model.Usuario;

/**
 *
 * @author alulab14
 */
public class UsuarioMySQL implements UsuarioDAO {
    Connection con = null;
    Statement st = null;
    CallableStatement cs = null;
    @Override
    public int insertar(Usuario usuario) {
        int resultado = 0;
        try{       
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_USUARIO(?,?,?,?,?)} ");
            cs.setString("_NOMBRE_USUARIO", usuario.getNombre());
            cs.setString("_ESTADO",usuario.getEstado().toString());
            cs.setString("_CONTRASEÑA", usuario.getContraseña());
            cs.setBoolean("_ACTIVE", usuario.isActive());
            resultado = cs.executeUpdate();
            usuario.setId(cs.getInt("_ID_USUARIO"));
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();} catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public Usuario encontrarPorId(int id) {
        Usuario usuario = new Usuario();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ENCONTRAR_USUARIO_POR_ID(?)}");
            cs.setInt("_ID_USUARIO",id);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                
            }
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();} catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return usuario;
    }

    @Override
    public int actualizar(Usuario usuario) {
        int resultado = 0;
        
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ACTUALIZAR_USUARIO(?,?,?)}");
            cs.setInt("_ID_USUARIO", usuario.getId());
            cs.setString("_NOMBRE_USUARIO", usuario.getNombre());
            cs.setString("_CONTRASEÑA", usuario.getContraseña());
            cs.setString("_ESTADO",usuario.getEstado().toString());
            resultado = cs.executeUpdate();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();} catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int eliminar(int id) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call ELIMINAR_USUARIO(?)}");
            cs.setInt("_ID_USUARIO", id);
            resultado = cs.executeUpdate();
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();} catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<Usuario> listarTodos() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_USUARIO()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("ID_USUARIO"));
                usuario.setNombre(rs.getString("NOMBRE_USUARIO"));
                usuario.setContraseña(rs.getString("CONTRASEÑA"));
                usuario.setEstado(EstadoUsuario.valueOf(rs.getString("ESTADO")));
                usuario.setActive(rs.getBoolean("ACTIVE"));
                usuarios.add(usuario);
            }
            
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();} catch(SQLException ex){System.out.println(ex.getMessage());}
        }
        return usuarios;
    }
    
}
