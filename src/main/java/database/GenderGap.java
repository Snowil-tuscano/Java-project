import java.sql.*;

public class GenderGap {
    private int world_m, us_m, india_m, germany_m, canada_m, brazil_m;
    private int world_f, us_f, india_f, germany_f, canada_f, brazil_f;

    public GenderGap(Connection conn) throws SQLException {
        String query = "SELECT * FROM GenderGap";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        if (rs.next()) {
            world_m = rs.getInt("world_m");
            us_m = rs.getInt("us_m");
            india_m = rs.getInt("india_m");
            germany_m = rs.getInt("germany_m");
            canada_m = rs.getInt("canada_m");
            brazil_m = rs.getInt("brazil_m");
            world_f = rs.getInt("world_f");
            us_f = rs.getInt("us_f");
            india_f = rs.getInt("india_f");
            germany_f = rs.getInt("germany_f");
            canada_f = rs.getInt("canada_f");
            brazil_f = rs.getInt("brazil_f");
        }
    }
}