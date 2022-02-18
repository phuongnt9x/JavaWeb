<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Setting</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/setting/edit" method="post" modelAttribute="settingEmail">
    <table>
        <tr>
            <th><form:label path="language"> Languages </form:label></th>
            <td>
                <form:select path="language">
                    <form:options items="${languages}"></form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <th><form:label path="pageSize">Page Size:</form:label></th>
            <td>Show
                <form:select path="pageSize">
                    <form:options items="${pageSizes}"></form:options>
                </form:select>

                emails per page
            </td>
        </tr>
        <tr>
            <th><form:label path="spamsFilter">Spams filter:</form:label></th>
            <td>
            <form:checkbox path="spamsFilter"></form:checkbox>

                <form:label path="spamsFilter">Enable spams filter</form:label>
            </td>
        </tr>
        <tr>
            <th>Signature</th>
            <td>
                <form:textarea path="signature"></form:textarea>
            </td>
        </tr>
        <tr>
            <th></th>
            <td>
            <input type="submit" value="Submit"/>
                <button>Cancel</button>
            </td>
        </tr>
    </table>

</form:form>
</body>
</html>
