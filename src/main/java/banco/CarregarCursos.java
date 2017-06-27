package banco;

import extras.Curso;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by lecad-100 on 06/06/17.
 */
public class CarregarCursos {

    public static void carregar(ArrayList<Curso> cursos, Connection c, String sql){

        if(sql == null){
            sql = "select * from curso;";
        }

        ResultSet r = null;
        Curso lista;
        try{
            PreparedStatement pmt = c.prepareStatement(sql);
            r = pmt.executeQuery();

            while(r.next()){
                lista = new Curso();
                lista.setId(r.getString("id"));
                lista.setNome(r.getString("nome"));
                lista.setDescricao(r.getString("descricao"));
                lista.setDuracao(r.getString("duracao"));
                lista.setLocal(r.getString("local"));

                cursos.add(lista);
            }

        }catch(Exception ex){
            System.out.println("Erro no sql "+ex);
        }

        ///return cursos;

    }

    public static void salvar(HttpServletRequest request, String local){

        String sql = "insert into curso(nome,descricao,duracao,local) values(?,?,?,?);";
        ConexaoBanco conexao = ConexaoBanco.conectar();
        Connection c = conexao.getCon();

        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String duracao = request.getParameter("duracao");

        try{
            PreparedStatement pmt = c.prepareStatement(sql);
            pmt.setString(1,nome);
            pmt.setString(2,descricao);
            pmt.setString(3,duracao);
            pmt.setString(4,local);

            pmt.executeUpdate();
            pmt.close();

        }catch(Exception ex){
            System.out.println("Erro salva sql "+ex);
        }

    }



}
