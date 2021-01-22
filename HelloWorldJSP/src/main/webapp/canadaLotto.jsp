<%--
  Created by IntelliJ IDEA.
  User: user2015
  Date: 1/8/21
  Time: 8:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Canada Lottery</title>
</head>
<body>
    <h1>Winning Lotto 649 and Lotto MAX numbers</h1>
<%
    // TODO 1: Generate 6 unique Lotto 649 numbers between 1 and 49 sorted ascending with no duplicate numbers.
    //          Print the 6 Lotto 649 numbers
    //  Hint 1: You can use the Random class to generate random numbers
    //  Hint 2: To avoid duplicate values in a collection use a Set instead of a List
    //  Hint 3: To sort the Set you can use a TreeSet instead.

    // TODO 2: Generate 7 unique Lotto MAX numbers between 1 and 50 sorted ascending with no duplicate numbers.
    //          Print the 7 Lotto MAX numbers
    //  Hint 1: You can use the Random class to generate random numbers
    //  Hint 2: To avoid duplicate values in a collection use a Set instead of a List
    //  Hint 3: To sort the Set you can use a TreeSet instead.

    // TODO 3: Add a HTML form with input text field and a submit button where the user and specify the quantity of quick picks
    //  Hint 1: Set the form method to post
    //  Hint 2: To check if the page is being accessed from a postback operation
    if (request.getMethod().equals("post")) {
        out.print("");
    }


%>
</body>
</html>
