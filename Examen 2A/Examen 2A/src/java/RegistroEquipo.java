/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */
public class RegistroEquipo extends HttpServlet {

    private Connection con;
    private Statement set;
    private ResultSet rs;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     public void init(ServletConfig cfg) throws ServletException{
        String URL = "jdbc:mysql:3306//localhost/docentes";
        String userName = "root";
        String password = "spyXfam_11";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            URL = "jdbc:mysql://localhost/docentes";
            
            con = DriverManager.getConnection(URL, userName, password);
            set = con.createStatement();
            
            System.out.println("Se conecto a la BD");
        }catch(Exception e){
            
            System.out.println("No se conecto a la BD");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }
    
    }
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Datos de Equipo</title>");            
            out.println("</head>");
            out.println("<body>");
            
            try{
                String eti, prob, seri, desc1, tec, desc2, mou, desc3, marc, nommar, moni, desc4, estequ, desc5;
                
                eti = request.getParameter("etiqueta");
                prob= request.getParameter("problema");
                seri = request.getParameter("serial");
                desc1 = request.getParameter("descripcion1");
                tec = request.getParameter("teclado");
                desc2 = request.getParameter("descripcion2");
                mou = request.getParameter("mouse");
                desc3 = request.getParameter("descripcion3");
                marc = request.getParameter("idmarca");
                nommar = request.getParameter("nommarca");
                moni = request.getParameter("monitor");
                desc4 = request.getParameter("descripcion4");
                estequ = request.getParameter("edoequipo");
                desc5 = request.getParameter("descripcion5");
                
                //querry
                String q1 = "insert into Mcpu "
                        + "values ("+seri+", '"+desc1+"')";
                
                String q2 = "insert into Mteclado "
                        + "values ("+tec+", '"+desc2+"')";
                
                String q3 = "insert into Mmouse "
                        + "values ("+mou+", '"+desc3+"')";
                
                String q4 = "insert into Cmarca "
                        + "values ("+marc+", '"+nommar+"')";
                
                String q5 = "insert into Mmonitor "
                        + "values ("+moni+", '"+desc4+"')";
                
                String q6 = "insert into Cestadoequipo "
                        + "values ("+estequ+", '"+desc5+"')";
                
                String q7 = "insert into Metiqueta "
                        + "values ("+eti+")";
                
                String q8 = "insert into Mproblema "
                        + "values ("+prob+")";
                                
                set.executeUpdate(q1);
                
                set.executeUpdate(q2);
                
                set.executeUpdate(q3);
                
                set.executeUpdate(q4);
                
                set.executeUpdate(q5);
                
                set.executeUpdate(q6);
                
                set.executeUpdate(q7);
                
                set.executeUpdate(q8);
                out.println("<h1>Registro Exitoso</h1>");
                System.out.println("Se registro un nuevo equipo para Reporte");
                
                
            
            }catch(Exception e){
                
                System.out.println("Error al registrar en la tabla");
                out.println("<h1>Registro No Exitoso</h1>");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
            
            
            
            out.println("<a href='reporte.html' >Datos del Registro</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){
            super.destroy();
        }
    }

}