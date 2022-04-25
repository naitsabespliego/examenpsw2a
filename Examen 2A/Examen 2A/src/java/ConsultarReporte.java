/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.*;
import javax.servlet.ServletConfig;

public class ConsultarReporte extends HttpServlet {

    
    
    private Connection con;
    private Statement set;
    private ResultSet rs;
        
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Reportes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Sistema de Registro de Reportes de Inmuebles Cecyt 9</h1>"
                    + "<table border=2>"
                        + "<tr>"
                            + "<th>Laboratorio</th>"
                            + "<th>id_lab</th>"
                            + "<th>id_reporte</th>"
                            + "<th>Fecha</th>"
                            + "<th>Hora</th>"
                            + "<th>Etiqueta</th>"
                            + "<th>Serial</th>"
                            + "<th>CPU</th>"
                            + "<th>Marca</th>"
                            + "<th>Monitor</th>"
                            + "<th>Accesorios(teclado)</th>"
                            + "<th>Accesorios (mouse)</th>"
                            + "<th>Estado</th>"
                            + "<th>Fecha de Reporte</th>"
                            + "<th>Hora de Reporte</th>"
                            + "<th>Responsable</th>"
                            + "<th>Prioridad</th>"
                        + "</tr>");
            try{
                String labo, idlab, idrep, fecha, hora, eti, seri, cepeu, marc, moni, tecla, con1, mous, con2, esta, fechar, horar, respon, priori;
                
                String q1 = "select * from Claboratorio";
                String q2 = "select * from Creporte";
                String q3 = "select * from Metiqueta";
                String q4 = "select * from Mcpu";
                String q5 = "select * from Mteclado";
                String q6 = "select * from Mmouse";
                String q7 = "select * from Cmarca";
                String q8 = "select * from Mmonitor";
                String q9 = "select * from Cestadoequipo";
                String q10 = "select * from Metiqueta";
                
                set = con.createStatement();
                rs = set.executeQuery(q1);
                rs = set.executeQuery(q2);
                rs = set.executeQuery(q3);
                rs = set.executeQuery(q4);
                rs = set.executeQuery(q5);
                rs = set.executeQuery(q6);
                rs = set.executeQuery(q7);
                rs = set.executeQuery(q8);
                rs = set.executeQuery(q9);
                rs = set.executeQuery(q10);                
                
                while(rs.next()){
                    labo = rs.getString("nom_lab");
                    idlab = rs.getString("id_lab");
                    idrep = rs.getString("id_reporte");
                    fecha = rs.getString("fecha");
                    hora = rs.getString("hora");
                    eti = rs.getString("etiqueta");
                    seri = rs.getString("serial");
                    cepeu = rs.getString("descripcion1");
                    marc = rs.getString("nommarca");
                    moni = rs.getString("descripcion4");
                    tecla = rs.getString("descripcion2");
                    mous = rs.getString("descripcion3");
                    esta = rs.getString("descripcion5");
                    fechar = rs.getString("fechrepre");
                    horar = rs.getString("horrepre");
                    respon = rs.getString("responsable");
                    priori = rs.getString("prioridad");
                    
                    out.println("<tr>"
                                + "<td>"+labo+"</td>"
                                + "<td>"+idlab+"</td>"
                                + "<td>"+idrep+"</td>"
                                + "<td>"+fecha+"</td>"
                                + "<td>"+hora+"</td>"
                                + "<td>"+eti+"</td>"
                                + "<td>"+seri+"</td>"
                                + "<td>"+cepeu+"</td>"
                                + "<td>"+marc+"</td>"
                                + "<td>"+moni+"</td>"
                                + "<td>"+tecla+"</td>"
                                + "<td>"+mous+"</td>"
                                + "<td>"+esta+"</td>"
                                + "<td>"+fechar+"</td>"
                                + "<td>"+horar+"</td>"
                                + "<td>"+respon+"</td>"
                                + "<td>"+priori+"</td>"
                            + "</tr>");
                }
                
                rs.close();
                set.close();
            
            }catch(Exception e){
                System.out.println("Error al conectar a la tabla");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            
            }
            
            
            out.println("</table>");
            out.println("<a href='index.html' >Pagina principal</a>");
            out.println("</body>");
            out.println("</html>");
        }
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
    
    //creamos el destructor
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){
            super.destroy();
        }
    }

}