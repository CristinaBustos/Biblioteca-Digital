/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.database2.accesoDatos;

/**
 *
 * @author Julián David Rodríguez
 */

import java.sql.*;
import biblioteca.database2.beans.TipoDocumento;
import biblioteca.database2.fachada.fachada;

public class DaoTipoDocumento {
    fachada fachada;

    public DaoTipoDocumento()
    {
        fachada = new fachada();
    }

    public int agregarTipo(TipoDocumento tipoMaterial)
    {
       String sql_agregar;
       sql_agregar = "INSERT INTO tipo_material(tipo_documento, descripcion) VALUES ('" +
               tipoMaterial.getTipoDocumento() + "','" + tipoMaterial.getDescripcion() + "')";

       try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_agregar);
            conn.close();
            return numFilas;
        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }

       return -1;
    }

    public void modificarTipoDocumento(String tipoDocumento, String descripcion)
    {
        String sql_modificar;
        sql_modificar="UPDATE programas SET tipo_documento = '"+ tipoDocumento + "' WHERE descripcion = '"+ descripcion + "';";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();
            int numFilas = sentencia.executeUpdate(sql_modificar);
            conn.close();

        }
        catch(SQLException e){ System.out.println(e); }
        catch(Exception e){ System.out.println(e); }
    }
}