<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2/10/2022
  Time: 2:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Product Discount Calculator</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Product Discount Calculator</h2>
<form method="post" action="/display-discount">
  <label>Product Description: </label><br/>
  <input type="text" name="description" /><br/>
  <label>List Price: </label><br/>

  <input type="text" name="price" /><br/>
  <label>Discount Percent: </label><br/>
  <input type="number" name="percent" placeholder="%" /><br/>
  <input type = "submit" id = "submit" value = "Calculate Discount"/>
</form>
</body>
</html>
