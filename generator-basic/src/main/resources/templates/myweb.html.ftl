<!DOCTYPE html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>欢迎来到lhl的官网</h1>
    <ul>
        <#list menuItems as item>
            <li>${item}</li>
        </#list>
    </ul>
    <footer>
        ${currentYear} lhl的官网
    </footer>
</body>
</html>