package controllers;

import banco.ConexaoBanco;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by lecad-100 on 26/05/17.
 */

@WebServlet(name = "Cadastro", urlPatterns = "/Cadastro")
public class Cadastro extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession secao  = request.getSession();
        System.out.println(" teste");

        if(secao.getAttribute("logado") != null){

            System.out.println(secao.getAttribute("tipo"));
            String sec = (String) secao.getAttribute("tipo");
            RequestDispatcher rd = request.getRequestDispatcher("/pagina_admin/admin.jsp");
            rd.forward(request,response);
        }else{
            response.sendRedirect("/pagina_cadastro/cadastro.html");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        String sql = "insert into usuario (nome,email,senha,tipo) values(?,?,?,?)";

        ConexaoBanco con = ConexaoBanco.conectar();
        Connection c = con.getCon();

        // writer.println(""+c.);

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("password");

        System.out.println(nome+email+senha);

        try {
            PreparedStatement pmt = c.prepareStatement(sql);
            pmt.setString(1, nome);
            pmt.setString(2, email);
            pmt.setString(3, senha);
            pmt.setString(4,"1");

            pmt.execute();
            pmt.close();

            response.sendRedirect("/pagina_login/login.html");

        } catch (Exception ex) {
            System.out.println("Errooo .. "+ex);
        }

        response.sendRedirect("/Login");

    }
}
