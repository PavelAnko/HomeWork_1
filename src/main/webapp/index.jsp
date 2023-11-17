<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Poll</title>
</head>
<body>
<%--<form action="hello-servlet" method="post">--%>
<%--    <h3>Do you love Java?</h3>--%>
<%--    <input type="radio" name="questionJava" value="YesJava"> Yes--%>
<%--    <input type="radio" name="questionJava" value="NoJava"> No--%>
<%--    <h3>Do you love C#?</h3>--%>
<%--    <input type="radio" name="questionCsharp" value="YesCsharp"> Yes--%>
<%--    <input type="radio" name="questionCsharp" value="NoCsharp"> No--%>
<%--    <br><br><input type="submit" value="Submit">--%>
<%--</form>--%>
<%--<script>--%>
<%--    function validateForm() {--%>
<%--        var questionJava = document.getElementsByName("questionJava");--%>
<%--        var questionCsharp = document.getElementsByName("questionCsharp");--%>

<%--        if (!isChecked(questionJava) || !isChecked(questionCsharp)) {--%>
<%--            alert("Please answer both questions.");--%>
<%--            return false;--%>
<%--        }--%>
<%--        return true;--%>
<%--    }--%>

<%--    function isChecked(elements) {--%>
<%--        for (var i = 0; i < elements.length; i++) {--%>
<%--            if (elements[i].checked) {--%>
<%--                return true;--%>
<%--            }--%>
<%--        }--%>
<%--        return false;--%>
<%--    }--%>
<%--</script>--%>
<form action="hello-servlet" method="post" onsubmit="return validateForm()">
    <h3>Do you love Java?</h3>
    <label><input type="radio" name="javaAnswer" value="Yes"> Yes</label>
    <label><input type="radio" name="javaAnswer" value="No"> No</label>

    <h3>Do you love C#?</h3>
    <label><input type="radio" name="csharpAnswer" value="Yes"> Yes</label>
    <label><input type="radio" name="csharpAnswer" value="No"> No</label>

    <br><br>
    <input type="submit" value="Submit">
</form>
<script>
    function validateForm() {
        var javaAnswer = document.getElementsByName("javaAnswer");
        var csharpAnswer = document.getElementsByName("csharpAnswer");

        if (!isChecked(javaAnswer) || !isChecked(csharpAnswer)) {
            alert("Будь ласка, дайте відповідь на два запитання.");
            return false;
        }
        return true;
    }

    function isChecked(elements) {
        for (var i = 0; i < elements.length; i++) {
            if (elements[i].checked) {
                return true;
            }
        }
        return false;
    }
</script>
<h3>Responses</h3>
<table border="1">
    <tr>
        <td></td>
        <td>Yes</td>
        <td>No</td>
    </tr>
    <tr>
        <td>Java</td>
        <td><%= session.getAttribute("javaYes") %></td>
        <td><%= session.getAttribute("javaNo") %></td>
    </tr>
    <tr>
        <td>C#</td>
        <td><%= session.getAttribute("csharpYes") %></td>
        <td><%= session.getAttribute("csharpNo") %></td>
    </tr>
</table>
</body>
</html>