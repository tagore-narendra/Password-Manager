<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("activePage", "home");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="css/home.css">
<link rel="icon" href="images/icon.jpg">
</head>
<body>

<jsp:include page="sidenav.jsp" />

<div class="main-content">
<video autoplay muted loop playsinline class="bg-video">
        <source src="images/video2.mp4" type="video/mp4">
    </video>
    <h1>🔐 Welcome to SafeVault</h1>
    <p>Your secure solution to store, generate and manage your passwords effortlessly.</p>

    <div class="features">
        <div class="feature-item">✅ Store all your passwords securely</div>
        <div class="feature-item">🧰 Generate strong, unique passwords</div>
        <div class="feature-item">🕵️‍♂️ Check password strength easily</div>
        <div class="feature-item">📊 View and manage all saved passwords</div>
    </div>

    <div class="cta-buttons">
        <a href="YourPasswords" class="btn">View Your Passwords</a>
        <a href="password_generator.jsp" class="btn">Generate New Password</a>
    </div>
</div>

</body>
</html>
