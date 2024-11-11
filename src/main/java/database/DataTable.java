import java.sql.*;

public class DataTable {
    private int[] brazil, canada, china, germany, india, usa, world;

    public DataTable(Connection conn) throws SQLException {
        String query = "SELECT * FROM DataTable";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        // Initialize arrays and populate them as required
        // Example: populate 'brazil' array
        while (rs.next()) {
            // Loop to populate each country array based on the database structure
        }
    }
}