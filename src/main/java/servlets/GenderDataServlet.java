// GenderDataServlet.java
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.sasl.SaslException;

import database.DBUtil;

@WebServlet("/genderData")
public class GenderDataServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws SaslException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try (Connection conn = DBUtil.getConnection()) {
            String query = "SELECT * FROM gender_data";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            JSONArray jsonArray = new JSONArray();
            while (rs.next()) {
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("country", rs.getString("country"));
                jsonObj.put("year", rs.getInt("year"));
                jsonObj.put("gdi", rs.getDouble("gdi"));
                jsonObj.put("gii", rs.getDouble("gii"));
                jsonObj.put("labor_force_participation", rs.getDouble("labor_force_participation"));
                jsonArray.put(jsonObj);
            }
            
            response.getWriter().write(jsonArray.toString());
            
        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
}