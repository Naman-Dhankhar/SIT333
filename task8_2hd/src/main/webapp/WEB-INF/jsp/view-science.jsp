<html>
<head>
    <title>STEM Game - Science Challenge</title>

    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #3a0ca3, #4361ee);
            color: #ffffff;
        }

        .container {
            width: 560px;
            margin: 70px auto;
            background: #ffffff;
            color: #240046;
            padding: 35px;
            border-radius: 18px;
            box-shadow: 0 15px 35px rgba(0,0,0,0.25);
            text-align: center;
        }

        h1 {
            margin-bottom: 10px;
            color: #3a0ca3;
        }

        .badge {
            display: inline-block;
            background: #7209b7;
            color: white;
            padding: 8px 15px;
            border-radius: 30px;
            margin-bottom: 20px;
            font-size: 14px;
        }

        .formula {
            background: #f3e8ff;
            padding: 14px;
            border-radius: 12px;
            margin-bottom: 18px;
            font-size: 18px;
            font-weight: bold;
        }

        .question-box {
            background: #edf2fb;
            padding: 18px;
            border-radius: 12px;
            margin: 20px 0;
            font-size: 20px;
            font-weight: bold;
        }

        input {
            width: 90%;
            padding: 13px;
            border: 2px solid #bde0fe;
            border-radius: 10px;
            font-size: 16px;
            margin-top: 10px;
        }

        button {
            margin-top: 22px;
            padding: 13px 28px;
            border: none;
            border-radius: 10px;
            background: #3a0ca3;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background: #7209b7;
        }

        .error {
            color: #d00000;
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
    <span class="badge">Science Challenge</span>

    <h1>Density Problem</h1>

    <div class="formula">
        Density = Mass / Volume
    </div>

    <div class="question-box">
        A metal cube has a mass of <b>80 grams</b> and a volume of <b>20 cm³</b>.
        <br>
        What is its density?
    </div>

    <form action="/science" method="post">
        <input type="text" name="answer" placeholder="Enter density value only, example: 4" />
        <br>
        <button type="submit">Submit Answer</button>
    </form>

    <div class="hint">
        Unit: g/cm³. Only enter the number.
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