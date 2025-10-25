<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Password</title>
<link rel="stylesheet" href="css/addpassword.css">
<link rel="icon" href="images/icon.jpg">
</head>
<body>
<div class="form-container">
    <a href="YourPasswords" class="bbtn">Back</a>
    <h2>Save New Password</h2>
    <div class="form-with-image">
        <form action="savePassword" method="post">
            Site or app: <input type="text" name="account_name" required><br>
            Username: <input type="text" name="account_user" required><br>
            Password: <input type="password" name="account_pass" required><br>
            Note: <textarea name="notes"></textarea><br>
            <input type="submit" value="Save">
        </form>
        <div class="side-image">
            <img src="images/bg_img2.png" alt="Illustration">
        </div>
    </div>
</div>
</body>
</html>
