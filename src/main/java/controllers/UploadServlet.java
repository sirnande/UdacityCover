package controllers;

import banco.CarregarCursos;
import banco.ConexaoBanco;
import extras.Curso;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * Created by lecad-100 on 01/06/17.
 */
@WebServlet(name = "Upload", urlPatterns = "/Upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    private static final String pasta = "Udacity";
    private static String caminho = null;

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        //File diretorio = new File(System.getProperty("user.home"),pasta);
      //  System.out.println(System.getProperty("user.home"));
        File diretorio = new File(System.getProperty("user.home")+"/IdeaProjects/Servidor/web/"+pasta);
        if(!diretorio.exists()){
            diretorio.mkdirs();
        }


        Part imagem = request.getPart("file");
        String nome = getNome(imagem);
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        OutputStream out = null;
        InputStream input = null;
         try{
             ConexaoBanco conexao = ConexaoBanco.conectar();
             Connection c = conexao.getCon();



             out = new FileOutputStream(diretorio+File.separator+nome);
             input = imagem.getInputStream();
             int read = 0;
             byte bit[] = new byte[1024];

             while ((read = input.read(bit)) != -1){
                 out.write(bit,0,read);
             }

             CarregarCursos.salvar(request,"../Udacity/"+getNome(imagem));

             CarregarCursos.carregar(cursos, c,null);

         }catch (Exception ex){
             System.out.println("Erro.... "+ex);
         }

        HttpSession secao  = request.getSession();
        System.out.println(secao.getAttribute("tipo"));
        request.getSession().setAttribute("curso",cursos);
        String sec = (String) secao.getAttribute("tipo");
        RequestDispatcher rd = request.getRequestDispatcher("/pagina_admin/admin.jsp");
        rd.forward(request,response);

        System.out.println(getNome(imagem));

    }


    private String getNome(final Part part){
        //String parthider = part.getHeader("content-disposition");

        for (String content : part.getHeader("content-disposition").split(";")){
          if (content.trim().startsWith("filename")) {
            return content.substring(content.indexOf('=')+1).trim().replace("\"","");
          }


        }

        return null;
    }

}
