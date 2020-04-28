window.addEventListener('load', function () {

    function handleSubmit(e) {
        var loginForm = document.getElementById("loginForm");
        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;
        e.preventDefault();

        var xhr = new XMLHttpRequest();
        var url = "http://localhost:8080/security/login";
        xhr.open("POST", url, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                var json = JSON.parse(xhr.responseText);
                console.log(json);
            }
        };
        var data = JSON.stringify({
            "email": email,
            "password": password
        });
        xhr.send(data);
    }

    loginForm.addEventListener("submit", handleSubmit);
});