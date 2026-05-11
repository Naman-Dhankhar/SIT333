<html>
<head>
    <title>STEM Game - Date Challenge 1</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #1d3557, #457b9d);
            color: #ffffff;
        }

        .container {
            width: 520px;
            margin: 80px auto;
            background: #ffffff;
            color: #1d3557;
            padding: 35px;
            border-radius: 18px;
            box-shadow: 0 15px 35px rgba(0,0,0,0.25);
            text-align: center;
        }

        h1 {
            margin-bottom: 10px;
            color: #1d3557;
        }

        .badge {
            display: inline-block;
            background: #e63946;
            color: white;
            padding: 8px 15px;
            border-radius: 30px;
            margin-bottom: 20px;
            font-size: 14px;
        }

        .question-box {
            background: #f1faee;
            padding: 18px;
            border-radius: 12px;
            margin: 20px 0;
            font-size: 20px;
            font-weight: bold;
        }

        input {
            width: 90%;
            padding: 13px;
            border: 2px solid #a8dadc;
            border-radius: 10px;
            font-size: 16px;
            margin-top: 10px;
        }

        button {
            margin-top: 22px;
            padding: 13px 28px;
            border: none;
            border-radius: 10px;
            background: #1d3557;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background: #e63946;
        }

        .error {
            color: #e63946;
            font-weight: bold;
            margin-top: 15px;
        }

        .hint {
            font-size: 14px;
            color: #555;
            margin-top: 12px;
        }
    </style>
</head>

<body>
<div class="container">
    <span class="badge">Date Utility Challenge 1</span>

    <h1>Future Date Problem</h1>

    <div class="question-box">
        If the date is <b>2026-05-11</b>, what date will it be after <b>10 days</b>?
    </div>

    <form action="/date1" method="post">
        <input type="text" name="answer" placeholder="Enter answer in yyyy-MM-dd format" />
        <br>
        <button type="submit">Submit Answer</button>
    </form>

    <div class="hint">
        Example format: 2026-05-21
    </div>

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