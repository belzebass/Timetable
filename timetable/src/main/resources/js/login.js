window.addEventListener('load', function () {

    function handleSubmit(e) {
        var loginForm = document.getElementById("loginForm");
        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;
        e.preventDefault();

        var xhr = new XMLHttpRequest();
        var url = "http://timetable.ddns.net:8080/security/login";
        xhr.open("POST", url, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {				
				window.location.replace("http://timetable.ddns.net/mainpage.html");
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

function doCheck() {
    var matches = true;

    var inputEmail = document.getElementById("email");
    var inputPassword = document.getElementById("password");
    if(inputEmail.value == '' || inputPassword.value == '') {
        matches = false;
    }

    document.getElementById("signIn").disabled = !matches;

    // var allFilled = true;
    //
    // var inputs = document.getElementsByTagName('input');
    // for(var i=0; i<inputs.length; i++){
    //     if(inputs[i].value == ''){
    //         allFilled = false;
    //         break;
    //     }
    // }
    //
    // document.getElementById("submitButton").disabled = !allFilled;
}

window.onload = function() {
    document.getElementById("signIn").disabled = true;
    var inputEmail = document.getElementById("email");
    var inputPassword = document.getElementById("password");
	inputEmail.onkeyup = doCheck;
	inputEmail.onblur = doCheck;
    inputPassword.onkeyup = doCheck;
	inputPassword.onblur = doCheck;
}