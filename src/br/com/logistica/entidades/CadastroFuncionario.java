package br.com.logistica.entidades;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class CadastroFuncionario extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String m = request.getParameter("fmatriculaId");
        String n = request.getParameter("fnome");
        String s = request.getParameter("fsetor");
        String c = request.getParameter("fcargo");
        String p = request.getParameter("fsenha");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:mysql://3306/tdw", "root", "");
            PreparedStatement stmt = con.prepareStatement("insert into userlogin values(?,?,?,?,?)");
            stmt.setString(1, m);
            stmt.setString(2, n);
            stmt.setString(3, s);
            stmt.setString(4, c);
            stmt.setString(5, p);
            int i = stmt.executeUpdate();
            if (i > 0) {
                out.println("Funcionario registrado com sucesso.....");
            }
        } catch (Exception ey) {
            System.out.println(ey);
        }
        out.close();
    }
}