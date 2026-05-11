<html>
<head>
    <title>STEM Game - Addition Challenge</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #023047, #219ebc);
            color: white;
        }

        .container {
            width: 540px;
            margin: 70px auto;
            background: white;
            color: #023047;
            padding: 35px;
            border-radius: 18px;
            box-shadow: 0 15px 35px rgba(0,0,0,0.25);
            text-align: center;
        }

        .badge {
            display: inline-block;
            background: #fb8500;
            color: white;
            padding: 8px 15px;
            border-radius: 30px;
            margin-bottom: 20px;
            font-size: 14px;
        }

        .question-box {
            background: #e0fbfc;
            padding: 18px;
            border-radius: 12px;
            margin: 20px 0;
            font-size: 20px;
            font-weight: bold;
        }

        input {
            width: 85%;
            padding: 12px;
            margin: 8px;
            border: 2px solid #8ecae6;
            border-radius: 10px;
            font-size: 16px;
        }

        input[type="submit"] {
            background: #023047;
            color: white;
            cursor: pointer;
            width: 45%;
        }

        input[type="submit"]:hover {
            background: #fb8500;
        }

        .error {
            color: #d00000;
            font-weight: bold;
            margin-top: 15px;
        }
    </style>
</head>

<body>
<div class="container">
    <span class="badge">Math Challenge 1</span>

    <h1>Addition Problem</h1>

    <div class="question-box">
        Enter two numbers and calculate their sum.
    </div>

    <form action="/q1" method="post">
        <input type="text" name="number1" placeholder="Enter first number" />
        <br>
        <input type="text" name="number2" placeholder="Enter second number" />
        <br>
        <input type="text" name="answer" placeholder="Enter your answer" />
        <br>
        <input type="submit" value="Submit Answer" />
    </form>

    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
        <div class="error"><%= message %></div>
    <%
        }
    %>
</div>
</body>
</html>