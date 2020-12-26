<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Servlet</title>
</head>
<body>
    <h1>${say}</h1>
    <form action="/servlet_war_exploded/save" method="post">

        <input type="text" name = "name" placeholder = "Your name">
        <input type = "number" name = "age" placeholder = "Your age">
        <input type = "text" name = "phone" placeholder = "Your phone">
        <input type = "date" name = "dateOfBirthday" placeholder = "Your date of Birthday">
        <input type = "number" name = "salary" placeholder = "Your salary">
        <button>save</button>
    </form>

    <table>
        <tr>
            <td>Id</td>
            <td>Name of user</td>
            <td>Age</td>
            <td>Phone number</td>
            <td>BirthDay</td>
            <td>Salary</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getAge()}</td>
                <td>${user.getPhone()}</td>
                <td>${user.getDateOfBirthday()}</td>
                <td>${user.getSalary()}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
