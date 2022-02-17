<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>The World Clock</title>

</head>
<body>
<h2>Sandwich Condiments</h2>
<form action="/save" method="post">
    <input type="checkbox" name="condiment" value="lettuce" id="lettuce">
    <label for="lettuce">Lettuce</label>
    <br>
    <input type="checkbox" name="condiment" value="tomato" id="tomato">
    <label for="tomato">Tomato</label>
    <br>
    <input type="checkbox" name="condiment" value="mustard" id="mustard">
    <label for="mustard">Mustard</label>
    <br>
    <input type="checkbox" name="condiment" value="sprouts" id="sprouts">
    <label for="sprouts">Sprouts</label>
    <hr>
    <button type="submit">Save</button>
</form>
</body>
</html>