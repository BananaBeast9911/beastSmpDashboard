import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC connection parameters (replace with your database credentials)
    private static final String DB_URL = "jdbc:mysql://u1953_QZks7r5vG1:ze%2BgCM.9VyXHiZg%40rCx!.R8g@5.161.112.112:3306/s1953_Authentication";
    private static final String DB_USERNAME = "u1953_QZks7r5vG1";
    private static final String DB_PASSWORD = "ze+gCM.9VyXHiZg@rCx!.R8g";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        // Authentication successful
                        HttpSession session = request.getSession();
                        session.setAttribute("username", username);
                        response.sendRedirect("dashboard.jsp"); // Redirect to a secure page
                    } else {
                        // Authentication failed
                        response.sendRedirect("login.html?error=1"); // Redirect back to the login page with an error parameter
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database connection errors
            response.sendRedirect("error.jsp"); // Redirect to an error page
        }
    }
}