<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Book Form</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f7fa;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        .form-container {
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 600px;
        }

        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
        }

        td {
            padding: 10px;
            vertical-align: top;
        }

        label {
            font-weight: bold;
            color: #555;
        }

        input, select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border-radius: 4px;
            border: 1px solid #ccc;
            font-size: 14px;
        }

        input[type="date"]:focus, select:focus {
            border-color: #007bff;
            outline: none;
        }

        button {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 12px 20px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
            margin-top: 20px;
        }

        button:hover {
            background-color: #218838;
        }

        .error {
            color: red;
            font-size: 12px;
        }

    </style>
</head>
<body>
    <div class="form-container">
        <h1>${book.id == null ? 'Add' : 'Edit'} Book</h1>
        <form:form modelAttribute="books"
            action="${pageContext.request.contextPath}/libraryCrud/saveBook"
            method="post">
            <form:hidden path="id" />
            <table>
                <tr>
                    <td><label for="title">Title:</label></td>
                    <td><form:input path="title" id="title" /></td>
                    <td class="error"><form:errors path="title" /></td>
                </tr>
                <tr>
                    <td><label for="genre">Genre:</label></td>
                    <td>
                        <form:select path="genre" id="genre">
                            <option value="Fiction">Fiction</option>
                            <option value="Non_Fiction">Non-Fiction</option>
                            <option value="Science">Science</option>
                            <option value="History">History</option>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td><label for="publishedDate">Published Date:</label></td>
                    <td><form:input type="date" path="publishedDate" id="publishedDate" /></td>
                </tr>
                <tr>
                    <td><label for="author">Author:</label></td>
                    <td>
                        <form:select path="author.id" id="author">
                            <c:forEach items="${authors}" var="author">
                                <form:option value="${author.id}">${author.name}</form:option>
                            </c:forEach>
                        </form:select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;">
                        <button type="submit">Save</button>
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>
