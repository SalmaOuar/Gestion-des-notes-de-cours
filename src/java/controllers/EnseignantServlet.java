/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.EnseignantDao;
import entities.Enseignant;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Yoga
 */
public class EnseignantServlet extends HttpServlet {

    private final EnseignantDao dao = new EnseignantDao();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EnseignantServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EnseignantServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
         try {
        String action = request.getParameter("action");

        EnseignantDao dao = new EnseignantDao();

        if ("create".equals(action)) {
            String nom = request.getParameter("nom");
            String email = request.getParameter("email");
            String specialite = request.getParameter("specialite");
            String password = request.getParameter("password");

            Enseignant e = new Enseignant(nom, email, password, specialite);
            dao.create(e);
            response.sendRedirect("enseignants.jsp");

        } else if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String email = request.getParameter("email");
            String specialite = request.getParameter("specialite");
            String password = request.getParameter("password");

            Enseignant e = dao.findById(id);
            if (e != null) {
                e.setNom(nom);
                e.setEmail(email);
                e.setSpecialite(specialite);
                if (password != null && !password.isEmpty()) {
                    e.setMotDePasse(password);
                }
                dao.update(e);
            }
            response.sendRedirect("enseignants.jsp");

        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            Enseignant e = dao.findById(id);
            if (e != null) {
                dao.delete(e);
            }
            response.sendRedirect("enseignants.jsp");
        }
    } catch (Exception e) {
        e.printStackTrace(); 
        response.getWriter().println("Erreur : " + e.getMessage());
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

}
