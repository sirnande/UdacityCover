package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by lecad-100 on 29/05/17.
 */
public class ConexaoBanco {

    private static ConexaoBanco con;
    private static Connection conexao = null;

   private ConexaoBanco() {
       try{

               //Class.forName("com.mysql.jdbc.Driver");
               conexao = DriverManager.getConnection("postgres://fzvfminzvijebo:07c42fb05b10eccfd0f0378e48e74c8bd8a5e5bcf6a571fe4a2c5830a45e9c77@ec2-23-23-86-179.compute-1.amazonaws.com:5432/db0c0krsvl11do", "fzvfminzvijebo", "07c42fb05b10eccfd0f0378e48e74c8bd8a5e5bcf6a571fe4a2c5830a45e9c77");

       }catch(ClassNotFoundException ex){
           ex.printStackTrace();
       }
       catch(SQLException ex){

           ex.printStackTrace();
       }
       catch(NoClassDefFoundError ex){
           ex.printStackTrace();
       }catch (Exception ex){
           ex.printStackTrace();
       }
   }

    public static ConexaoBanco conectar(){

      return con == null ? new ConexaoBanco() : con;

    }

    public Connection getCon() {
        return conexao;
    }
}
