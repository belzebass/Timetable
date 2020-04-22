window.addEventListener('load', function () {
    var regForm = document.getElementById("regForm");
    var firstName = document.getElementById("firstName").value;
    var lastName = document.getElementById("lastName").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;
    var passwordVerify = document.getElementById("passwordVerify").value;

    function handleSubmit(e) {
        e.preventDefault();
        console.log(firstName);
        console.log(lastName);
        console.log(email);
        console.log(password);
        console.log(passwordVerify);

        var xhr = new XMLHttpRequest();
        var url = "http://localhost:8080/users/add";
        xhr.open("POST", url, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                var json = JSON.parse(xhr.responseText);
                console.log(json);
            }
        };
        var data = JSON.stringify({"firstName": firstName,
            "lastName": lastName,
            "email": email,
            "password" : password});
        xhr.send(data);

    }

    regForm.addEventListener("submit", handleSubmit);

});