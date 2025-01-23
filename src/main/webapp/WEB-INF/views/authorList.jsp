<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Author List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 40px;
            text-align: center;
        }
        h1 {
            color: #333;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background: white;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: center;
        }
        th {
            background-color: #007bff;
            color: white;
            text-transform: uppercase;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        a, button {
            text-decoration: none;
            color: white;
            background: #28a745;
            padding: 8px 12px;
            border-radius: 5px;
            border: none;
            cursor: pointer;
            font-size: 14px;
            transition: 0.3s;
        }
        a:hover, button:hover {
            background: #218838;
        }
        .delete-button {
            background: #dc3545;
        }
        .delete-button:hover {
            background: #c82333;
        }
        form {
            display: inline;
        }
        .add-author {
            display: inline-block;
            margin-top: 20px;
            background: #007bff;
        }
        .add-author:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Author List</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="author" items="${authors}">
                <tr>
                    <td>${author.id}</td>
                    <td>${author.name}</td>
                    <td>${author.email}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/libraryCrud/editAuthor/${author.id}">Edit</a>
                        |
                        <form action="${pageContext.request.contextPath}/libraryCrud/deleteAuthor/${author.id}" method="POST" onsubmit="return confirm('Are you sure?')">
                            <input type="hidden" name="_method" value="DELETE"/>
                            <button type="submit" class="delete-button">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/libraryCrud/createAuthor" class="add-author">Add New Author</a>
</body>
</html>
