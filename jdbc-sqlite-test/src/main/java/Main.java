import java.sql.*;


public class Main {
    public static void main(String[] args) {
        String db = "jdbc:sqlite:src/main/resources/moviemagic.db";
        try (Connection con = DriverManager.getConnection(db)){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT movie.name, movie.year_ FROM movie ORDER BY movie.year_ ASC");
            while (rs.next()) {
                System.out.printf("%s %d %n", rs.getString("name"), rs.getInt("year_"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
