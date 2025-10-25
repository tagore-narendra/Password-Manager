<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("activePage", "about");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>About Us - Password Manager</title>
    <link rel="stylesheet" href="css/about.css">
    <link rel="icon" href="images/icon.jpg">
</head>
<body>

<jsp:include page="sidenav.jsp" />

<div class="main-content">
    <div class="about-wrapper">
        <div class="about-text">
            <h1>About Us</h1>
            <p>Welcome to <strong>Password Manager</strong> — your trusted companion for keeping your passwords secure and easy to manage.</p>

            <h2>Our Mission</h2>
            <p>We help you generate, store, and check the strength of your passwords, so you can stay safe online without stress.</p>

            <h2>Features</h2>
            <ul>
                <li>Save and manage passwords securely</li>
                <li>Generate strong, random passwords</li>
                <li>Check your password strength</li>
                <li>Easy-to-use, modern interface</li>
            </ul>

            <h2>Privacy & Security</h2>
            <p>Your data belongs to you. We don’t share or sell your data — security and privacy come first.</p>
        </div>
        <div class="about-image">
            <img src="images/abp.jpg" alt="About Image" height=600px;>
        </div>
    </div>
</div>

</body>
</html>
