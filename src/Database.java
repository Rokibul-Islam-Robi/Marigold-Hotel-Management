import java.sql.*;

public class Database {
    private Connection conn;

    public Database() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db", "root", "85428");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void addHotel(Hotel hotel) {
        String sql = "INSERT INTO hotels (name, location) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, hotel.getName());
            stmt.setString(2, hotel.getLocation());
            stmt.executeUpdate();
            System.out.println("Hotel added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewHotels() {
        String sql = "SELECT * FROM hotels";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("Hotels:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Location: " + rs.getString("location"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateHotel(Hotel hotel) {
        String sql = "UPDATE hotels SET name = ?, location = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, hotel.getName());
            stmt.setString(2, hotel.getLocation());
            stmt.setInt(3, hotel.getId());
            stmt.executeUpdate();
            System.out.println("Hotel updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHotel(int id) {
        String sql = "DELETE FROM hotels WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Hotel deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
