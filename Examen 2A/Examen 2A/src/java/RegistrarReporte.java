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
public class RegistrarReporte extends HttpServlet {

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
            out.println("<title>Reporte</title>");            
            out.println("</head>");
            out.println("<body>");
            
            try{
                String idlab, nomlab, idrep, fech, hor, prio, esta, fechrep, horrep, respo;
                
                idlab = request.getParameter("id_lab");
                nomlab = request.getParameter("nom_lab");
                idrep = request.getParameter("id_reporte");
                fech = request.getParameter("fecha");
                hor = request.getParameter("hora");
                prio = request.getParameter("prioridad");
                fechrep = request.getParameter("fechrepre");
                horrep = request.getParameter("horrepre");
                respo = request.getParameter("responsable");
                
                //querry
                String q9 = "insert into Claboratorio "
                        + "values ("+idlab+", '"+nomlab+"')";
                
                String q10 = "insert into Creporte "
                        + "values ("+idrep+", '"+fech+"', '"+hor+"', '"+prio+"', '"+fechrep+"', '"+horrep+"', '"+respo+"')";
                                
                set.executeUpdate(q9);
                
                set.executeUpdate(q10);
                
                out.println("<h1>Registro Exitoso</h1>");
                System.out.println("Se registro un nuevo Reporte");
                
                
                
            
            }catch(Exception e){
                
                System.out.println("Error al registrar en la tabla");
                out.println("<h1>Registro No Exitoso</h1>");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
            
            
            
            out.println("<a href='ConsultarReporte' >Consultar Reporte</a>");
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