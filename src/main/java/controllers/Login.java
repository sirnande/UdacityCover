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
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by lecad-100 on 26/05/17.
 */
@WebServlet(name = "Login", urlPatterns = "/Login")
public class Login extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession secao  = request.getSession();
        if(secao.getAttribute("logado") != null){


                System.out.println(secao.getAttribute("tipo"));
                String sec = (String) secao.getAttribute("tipo");
                RequestDispatcher rd = request.getRequestDispatcher("/pagina_admin/admin.jsp");
                rd.forward(request,response);
        }else{
            response.sendRedirect("/pagina_login/login.html");
        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        ArrayList<Curso> cursos = new ArrayList<Curso>();

        String email = request.getParameter("email");
        String senha = request.getParameter("password");

        String sql = "select * from usuario where email = ? and senha = ?;";
      //  String lista = "select * from curso;";

        ConexaoBanco con = ConexaoBanco.conectar();
        Connection c = con.getCon();
        ResultSet r = null;
      //  ResultSet listcurso = null;

        System.out.println(email + "   "+senha);

        try{
            PreparedStatement pmt = c.prepareStatement(sql);
            pmt.setString(1,email);
            pmt.setString(2,senha);
            r = pmt.executeQuery();

            CarregarCursos.carregar(cursos,c,null);


            if(r.next()){

                request.getSession().setAttribute("logado",new Boolean(true));
                request.getSession().setAttribute("nome",r.getString("nome"));
                request.getSession().setAttribute("email",email);
                request.getSession().setAttribute("tipo",r.getString("tipo"));
                request.getSession().setAttribute("curso",cursos);

                System.out.println(r.getString("nome"));
                System.out.println("Naegation Udacity cover");

                RequestDispatcher rd  = request.getRequestDispatcher("/pagina_admin/admin.jsp");
                System.out.println(rd);
                rd.forward(request,response);


                pmt.close();
                    //getServletContext().getRequestDispatcher("/pagina_home/admin.jsp").forward(request,response);

            }else{
                System.out.println("Erro...");
                response.sendRedirect("/pagina_login/login.html");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }


}
