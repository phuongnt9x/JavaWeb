<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Info</title>
    
</head>
<body>
<h2>Setting</h2>
<h3>Language: ${settingEmail.language}</h3>
<h3>Font Size: ${settingEmail.pageSize}</h3>
<h3>Spams Filter: ${settingEmail.spamsFilter}</h3>
<h3>Signature: ${settingEmail.signature}</h3>
<button><a href="/setting/edit">Edit</a></button>
</body>
</html>
