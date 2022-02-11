<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.*"%>
<%@ page import="com.Customer" %>

<%
    // just create some sample data ... normally provided by MVC
    List<Customer> data = new ArrayList<>();

    data.add(new Customer("Mai Van Hoan", "1983-08-20", "Ha Noi"));
    data.add(new Customer("Nguyen Van Nam", "1983-08-20", "Nam DInh"));
    data.add(new Customer("Nguyen Thai Hoa", "1983-08-20", "Bac Giang"));

    pageContext.setAttribute("myCustomers", data);
%>
<html>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }
    th, td {
        padding: 15px;
        text-align: center;
        border-bottom: 1px solid #ddd;
    }
    h1{
        text-align: center;
    }
</style>
<body>

<h1>List of Customers</h1>
<table>

    <tr>
        <th>Name</th>
        <th>Birthday</th>
        <th>Address</th>
    </tr>

    <c:forEach var="tempCustomer" items="${myCustomers}">

        <tr>
            <td>${tempCustomer.name}</td>
            <td>${tempCustomer.birthday}</td>
            <td>${tempCustomer.address}</td>
        </tr>

    </c:forEach>

</table>

</body>

</html>