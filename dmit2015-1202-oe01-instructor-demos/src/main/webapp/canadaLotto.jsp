<%@ page import="java.util.Random" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.TreeSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%-- JSTL core library https://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/ --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- JSTL formatting library https://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/ --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%-- JSTL functions library https://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/ --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--JSP Tag Reference https://docs.oracle.com/cd/E13226_01/workshop/docs81/pdf/files/workshop/JSPTagsReference.pdf  --%>

<!DOCTYPE html>
<html>
<head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    <title>Lotto Quick Pick</title>

</head>
<body>
<h1>Lotto Quick Pick</h1>
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
    // Create a Set to store the unique lotto numbers


    // TODO 3: Add a HTML form with input text field and a submit button where the user and specify the quantity of quick picks
    //  Hint 1: Set the form method to post
    //  Hint 2: To check if the page is being accessed from a postback operation
    if (request.getMethod().equalsIgnoreCase("post")) {
        String lottoType = request.getParameter("lottoType");
        String quantityString = request.getParameter("quantity");
        int quantity = Integer.parseInt(quantityString);

        // Create a Random object for generating random numbers
        Random rand = new Random();

        if (lottoType.contains("649")) {
            // Generate quick picks for Lotto649
            // Create a Set to store the unique lotto numbers
            Set<Integer> lotto649Set = new TreeSet<>();
            // Define constants for Lotto 649
            final int LOTTO649_MAX_VALUE = 49;
//    final int LOTTO649_MIN_VALUE = 1;
            final int LOTTO649_SELECT_COUNT = 6;
            // Setup a loop to generate and store the quick pick numbers
            while (lotto649Set.size() < LOTTO649_SELECT_COUNT) {
                // Generate a random number between MIN and MAX
                int randomNumber = rand.nextInt(LOTTO649_MAX_VALUE) + 1;
                lotto649Set.add(randomNumber);
            }
            // Iterate through each number in lotto649Set and display its value
            out.print("<p>The lotto 649 quick pick numbers are: ");
            for (Integer singleNumber : lotto649Set ) {
                out.print(singleNumber + " ");
            }
            out.print("</p>");

        } else if (lottoType.contains("MAX")) {
            // Generate quick picks for LottoMAX
            Set<Integer> lottoMaxSet = new TreeSet<>();
            // Define constants for Lotto MAX
            final int LOTTOMAX_MAX_VALUE = 50;
            final int LOTTOMAX_SELECT_COUNT = 7;
            // Setup a loop to generate and store the quick pick numbers
            while (lottoMaxSet.size() < LOTTOMAX_SELECT_COUNT) {
                // Generate a random number between MIN and MAX
                int randomNumber = rand.nextInt(LOTTOMAX_MAX_VALUE) + 1;
                lottoMaxSet.add(randomNumber);
            }
            // Iterate through each number in lotto649Set and display its value
            out.print("<p>The lotto MAX quick pick numbers are: ");
            for (Integer singleNumber : lottoMaxSet ) {
                out.print(singleNumber + " ");
            }
            out.print("</p>");
        } else {
            // Display error message
            out.print("<p>Invalid input value for lotto type.</p>");
        }
    }

%>

<form method="post">
    <div class="form-group">
        <label for="lottoType">Lotto Type (649/MAX)</label>
        <input type="text" id="lottoType" name="lottoType">
    </div>
    <div class="form-group">
        <label for="quantity">Quantity</label>
        <input type="number" min="1" max="10" id="quantity" name="quantity">
    </div>
    <button type="submit">Submit</button>
</form>

<!-- Optional JavaScript: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous"></script>

</body>

</html>