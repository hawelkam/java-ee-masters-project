/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mikehawek.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mikehawek.business.dto.ItemManagement.ItemNameDto;
import com.mikehawek.business.facade.MultimediaShopFacade;

/**
 *
 * @author Hawek
 */
@WebServlet(name = "AddItem", urlPatterns = {"/AddItem"})
public class AddItem extends HttpServlet {

    @EJB
    private MultimediaShopFacade multimediaShopFacade;


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
        String name=request.getParameter("name");
        String productCode=request.getParameter("productCode");
        String medium=request.getParameter("itemType");
        if (name != null && productCode != null) {
            ItemNameDto dto = new ItemNameDto();
            dto.setProductCode(productCode);
            dto.setName(name);
            multimediaShopFacade.addItemName(dto);
            response.sendRedirect("ListItems");
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListItems</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListItems at " + request.getContextPath() + "</h1>");
            out.println("<form>");
            out.println("Name: <input type='text' name='name'><br/>");
            out.println("ProductCode: <textarea name='productCode'></textarea><br/>");
            out.println("Type: <select name='itemType'>" +
                    " <option value=\"Movie\">Movie</option>" +
                    " <option value=\"VideoGame\">Video Game</option>" +
                    " <option value=\"MusicAlbum\">Music Album</option></select><br/>");
            out.println("<input type='submit'><br/>");
            out.println("</form>");
            
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
        processRequest(request, response);
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
