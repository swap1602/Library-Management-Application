<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Author Form</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f4f8;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h1 {
            font-size: 24px;
            color: #333;
            margin-bottom: 20px;
        }

        .form-container {
            background: #ffffff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 500px;
            text-align: left;
        }

        table {
            width: 100%;
            border-spacing: 10px;
        }

        td {
            padding: 8px;
        }

        label {
            font-size: 14px;
            font-weight: bold;
            color: #555;
        }

        input[type="text"],
        input[type="email"] {
            padding: 10px;
            width: calc(100% - 20px);
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 14px;
            margin-top: 5px;
        }

        input[type="text"]:focus,
        input[type="email"]:focus {
            border-color: #007bff;
            outline: none;
        }

        button {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 12px 20px;
            border-radius: 4px;
            font-size: 16px;
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

        .form-footer {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h1>${author.id == null ? 'Add' : 'Edit'} Author</h1>
        <form:form modelAttribute="authors" action="${pageContext.request.contextPath}/libraryCrud/saveAuthor" method="post">
            <form:hidden path="id" />
            <table>
                <tr>
                    <td><label for="name">Name:</label></td>
                    <td><form:input path="name" id="name" /></td>
                    <td class="error"><form:errors path="name" /></td>
                </tr>
                <tr>
                    <td><label for="email">Email:</label></td>
                    <td><form:input path="email" id="email" /></td>
                    <td class="error"><form:errors path="email" /></td>
                </tr>
            </table>
            <button type="submit">Save</button>
        </form:form>
    </div>
</body>
</html>
