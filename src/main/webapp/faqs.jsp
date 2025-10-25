<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>FAQs</title>
<link rel="stylesheet" href="css/faqs.css">
<link rel="icon" href="images/icon.jpg">
<!-- Font Awesome if your sidebar uses icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>
<%
    request.setAttribute("activePage", "faqs"); // so sidebar can highlight active page
%>

<jsp:include page="sidenav.jsp" />

<div class="faq-container">
<h1>Frequently Asked Questions?</h1><hr>
    <div class="faq-item" onclick="toggleFaq(this)">
        <div class="faq-question">
            <span class="icon">+</span>
            What happens if I lose my master password?
        </div>
        <div class="faq-answer">
            We recommend that you memorise your master password, or write it down and keep it safe, because it can't be recovered if forgotten. 
            There is no way to access your password locker or your data without your master password – if you lose it, you’ll also lose access to your data.
        </div>
    </div>
    <div class="faq-item" onclick="toggleFaq(this)">
        <div class="faq-question">
            <span class="icon">+</span>
            How this application secure my passwords and personal data ?
        </div>
        <div class="faq-answer">
            We use strong encryption (AES-256) and store data securely.
        </div>
    </div>
    <div class="faq-item" onclick="toggleFaq(this)">
        <div class="faq-question">
            <span class="icon">+</span>
            Is my data shared with any third-parties?
        </div>
        <div class="faq-answer">
            No, your passwords and data are stored locally and never shared.
        </div>
    </div>
    <div class="faq-item" onclick="toggleFaq(this)">
        <div class="faq-question">
            <span class="icon">+</span>
            How do I sync my devices with Password Manager?
        </div>
        <div class="faq-answer">
            Sign in with your Password Manager account on all devices to enable sync.
        </div>
    </div>
    
    <!-- ✨ NEW FAQs added below -->
    <div class="faq-item" onclick="toggleFaq(this)">
        <div class="faq-question">
            <span class="icon">+</span>
            Can I export my saved passwords?
        </div>
        <div class="faq-answer">
            Yes, you can export your passwords in an encrypted format from the settings page.
        </div>
    </div>
    <div class="faq-item" onclick="toggleFaq(this)">
        <div class="faq-question">
            <span class="icon">+</span>
            Does Password Manager work offline?
        </div>
        <div class="faq-answer">
            Yes, you can view and manage your saved passwords without an internet connection. Some features like sync require internet.
        </div>
    </div>
    <div class="faq-item" onclick="toggleFaq(this)">
        <div class="faq-question">
            <span class="icon">+</span>
            How often should I change my master password?
        </div>
        <div class="faq-answer">
            For better security, we recommend changing your master password every 3–6 months.
        </div>
    </div>
</div>

<script>
function toggleFaq(item) {
    const answer = item.querySelector('.faq-answer');
    const icon = item.querySelector('.icon');
    if (answer.style.display === "block") {
        answer.style.display = "none";
        icon.textContent = "+";
        item.classList.remove("active");
    } else {
        answer.style.display = "block";
        icon.textContent = "-";
        item.classList.add("active");
    }
}
</script>
</body>
</html>
