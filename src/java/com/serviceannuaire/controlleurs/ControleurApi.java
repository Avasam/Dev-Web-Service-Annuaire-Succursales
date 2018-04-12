/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviceannuaire.controlleurs;

import com.serviceannuaire.services.SuccursaleService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Avasam
 */
@WebServlet(name = "ControleurApi", urlPatterns = {"/api/annuaire/succursales"})
public class ControleurApi extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        try{
            response.setContentType("text/html;charset=UTF-8");
            SuccursaleService succ = new SuccursaleService();

            String distanceStr = (String)request.getParameter("distance");
            String longitudeStr = (String)request.getParameter("longitude");
            String latitudeStr = (String)request.getParameter("latitude");
            int distance = distanceStr.isEmpty() ? 0 : Integer.parseInt(distanceStr);
            float longitude = longitudeStr.isEmpty() ? 0 : Float.parseFloat(longitudeStr);
            float latitude = latitudeStr.isEmpty() ? 0 : Float.parseFloat(latitudeStr);

            String vue = succ.getParDistance(distance, longitude, latitude);
            response.getWriter().write(vue);
        }
        catch (IOException | NumberFormatException e) {
            response.getWriter().write("{\"Error\":\""+e.toString()+"\"}");
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
