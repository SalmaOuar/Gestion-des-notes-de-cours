/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.CommentaireNoteDao;
import dao.NoteCoursDao;
import entities.CommentaireNote;
import entities.Enseignant;
import entities.NoteCours;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.CommentaireNoteService;
import services.NoteCoursService;

/**
 *
 * @author Yoga
 */
public class CommentaireServlet extends HttpServlet {

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
            out.println("<title>Servlet CommentaireServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CommentaireServlet at " + request.getContextPath() + "</h1>");
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
        String contenu = request.getParameter("contenu");
        String noteIdStr = request.getParameter("noteId");

        try {
            int noteId = Integer.parseInt(noteIdStr);
            Enseignant enseignant = (Enseignant) request.getSession().getAttribute("user");
            NoteCoursService noteService = new NoteCoursService();
            CommentaireNoteService commentaireService = new CommentaireNoteService();

            NoteCours note = noteService.findById(noteId);
            CommentaireNote commentaire = new CommentaireNote(contenu, note, enseignant);
            commentaireService.create(commentaire);

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("commentaires.jsp");
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
