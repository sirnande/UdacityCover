package controllers;

import banco.CarregarCursos;
import banco.ConexaoBanco;
import extras.Curso;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by lecad-100 on 13/06/17.
 */
@WebServlet(name = "Teste", urlPatterns = "/Teste")
public class Teste extends HttpServlet {

      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          HttpSession secao = request.getSession();
          ConexaoBanco con = ConexaoBanco.conectar();
          Connection c = con.getCon();

          String nome = request.getParameter("nome");
          System.out.println(nome);
          String sql = "select * from curso where nome LIKE '%"+nome+"%' or descricao LIKE '%"+nome+"%'";
          ArrayList<Curso> cursos = new ArrayList<Curso>();
          CarregarCursos.carregar(cursos,c,sql);

            for(int i = 0; i < cursos.size(); i++){
                System.out.println("Cursos "+cursos.get(i).toString());
            }
          secao.setAttribute("listatudo",cursos);
          RequestDispatcher rd  = request.getRequestDispatcher("/outros/PesquisaCursos.jsp");
         // System.out.println(rd);
          rd.forward(request,response);

    }
}
