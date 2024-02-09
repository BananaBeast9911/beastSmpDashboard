import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");

        // Validate form data
        if (!password.equals(confirmPassword)) {
            response.sendRedirect("signup.html?error=" + "Passwords do not match");
            return;
        }

        try {
            // Connect to MySQL database
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s1953_Authentication", "u1953_QZks7r5vG1", "ze+gCM.9VyXHiZg@rCx!.R8g")) {
                // Insert data into 'users' table
                String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, username);
                    stmt.setString(2, password);
                    int rowsAffected = stmt.executeUpdate();

                    if (rowsAffected > 0) {
                        // Sign-up successful
                        response.sendRedirect("/login.html");
                    } else {
                        // Error handling
                        response.sendRedirect("signup.html?error=" + "Failed to sign up. Please try again.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors
            response.sendRedirect("signup.html?error=" + "An error occurred. Please try again later.");
        }
    }
}