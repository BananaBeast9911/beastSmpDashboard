<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    <style>
        /* Your CSS styles here */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        h1 {
            text-align: center;
        }
        .welcome-message {
            text-align: center;
            margin-bottom: 20px;
        }
        .dropdown {
            position: relative;
            display: inline-block;
            float: right;
        }
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
            z-index: 1;
            border-radius: 5px;
        }
        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }
        .dropdown-content a:hover {
            background-color: #f1f1f1;
        }
        .dropdown:hover .dropdown-content {
            display: block;
        }
        .logout-button {
            background-color: #007bff;
            color: #fff;
            text-align: center;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            padding: 10px 20px;
            text-decoration: none;
        }
        .logout-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>User Dashboard</h1>
        <div class="dropdown">
            <button class="logout-button">Menu &#9662;</button>
            <div class="dropdown-content">
                <a href="editProfile.jsp">Edit Profile</a>
                <a href="about.jsp">About</a>
                <a href="logout.jsp" class="logout-button">Logout</a>
            </div>
        </div>
        <div class="welcome-message">
            <p>Welcome, <%= request.getSession().getAttribute("username") %>!</p>
            <!-- Retrieves the username from the session and displays it -->
        </div>
        <div class="dashboard-content">
            <!-- Add content specific to the user dashboard -->
            <p>This is your dashboard. You can add your content here.</p>
        </div>
    </div>
</body>
</html>