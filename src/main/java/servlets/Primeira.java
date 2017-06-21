// Import required java libraries
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.sql.SQLException;


@WebServlet(urlPatterns = "/primeira")
public class Primeira extends HttpServlet {
 
 @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)throws IOException
  {
        PrintWriter writer = response.getWriter();
        writer.println("oi");

  }
  
}
