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
    private static String dbUrl = "";

   private ConexaoBanco() {
       try{

               //Class.forName("com.mysql.jdbc.Driver");
               dbUrl = "jdbc:postgres://ec2-23-23-86-179.compute-1.amazonaws.com:5432/db0c0krsvl11do";
               String user = "fzvfminzvijebo";
               String passw = "07c42fb05b10eccfd0f0378e48e74c8bd8a5e5bcf6a571fe4a2c5830a45e9c77";
               conexao = DriverManager.getConnection(dbUrl, user, passw);

               System.out.println("Fez requisicao");

       }catch(SQLException ex){
           System.out.println("Entro sql exception");
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
