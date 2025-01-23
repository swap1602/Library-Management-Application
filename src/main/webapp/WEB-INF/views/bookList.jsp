<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book List</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding-top: 40px;
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        a {
            font-size: 16px;
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        table {
            width: 80%;
            margin-top: 20px;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007bff;
            color: white;
            font-size: 16px;
        }

        td {
            font-size: 14px;
        }

        td a {
            color: #28a745;
            text-decoration: none;
        }

        td a:hover {
            text-decoration: underline;
        }

        button {
            background-color: #dc3545;
            color: white;
            border: none;
            padding: 5px 10px;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #c82333;
        }

        form {
            width: 80%;
            max-width: 600px;
            margin-top: 30px;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        form input[type="text"], form select {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        form button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 4px;
            cursor: pointer;
        }

        form button:hover {
            background-color: #0056b3;
        }

        form h2 {
            margin-top: 0;
            color: #333;
        }
    </style>
</head>
<body>
    <h1>Book List</h1>
    <a href="${pageContext.request.contextPath}/libraryCrud/createBook">Add Book</a>
    <br/><br/>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Published Date</th>
            <th>Author</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.genre}</td>
                <td><fmt:formatDate value="${book.publishedDate}" pattern="yyyy-MM-dd"/></td>
                <td>${book.author != null ? book.author.name : 'No Author'}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/libraryCrud/editBook/${book.id}">Edit</a> |
                    <form action="${pageContext.request.contextPath}/libraryCrud/deleteBook/${book.id}" method="POST" onsubmit="return confirm('Are you sure?')">
                            <input type="hidden" name="_method" value="DELETE"/>
                            <button type="submit">Delete</button>
                        </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h2>Search Books</h2>
    <form action="${pageContext.request.contextPath}/libraryCrud/search" method="get">
        Title: <input type="text" name="title"><br/>
        Genre:
        <select name="genre">
            <option value="">All</option>
            <option value="Fiction">Fiction</option>
            <option value="Non_Fiction">Non-Fiction</option>
            <option value="Science">Science</option>
            <option value="History">History</option>
        </select><br/>
        Author:
        <select name="authorId">
            <option value="">All</option>
            <c:forEach items="${authors}" var="author">
                <option value="${author.id}">${author.name}</option>
            </c:forEach>
        </select><br/>
        <button type="submit">Search</button>
    </form>
</body>
</html>
