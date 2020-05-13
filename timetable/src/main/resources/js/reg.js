window.addEventListener('load', function () {

    function handleSubmit(e) {
		e.preventDefault();
        var regForm = document.getElementById("regForm");
        var firstName = document.getElementById("firstName").value;
        var lastName = document.getElementById("lastName").value;
        var email = document.getElementById("email").value;
        var emailVerify = document.getElementById("emailVerify").value;
        var password = document.getElementById("password").value;
        var passwordVerify = document.getElementById("passwordVerify").value;
       

        var xhr = new XMLHttpRequest();
        var url = "http://timetable.ddns.net:8080/security/registration";
        xhr.open("POST", url, true);
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                var json = JSON.parse(xhr.responseText);
                console.log(json);
				return true;
            }
        };
        var data = JSON.stringify({
            "firstName": firstName,
            "lastName": lastName,
            "email": email,
            "password": password
        });
        xhr.send(data);
    }

    regForm.addEventListener("submit", handleSubmit);
});


function doCheck() {
    var matches = true;

    var firstName = document.getElementById("firstName");
    var lastName = document.getElementById("lastName");
    var email = document.getElementById("email");
    var emailVerify = document.getElementById("emailVerify");
    var password = document.getElementById("password");
    var passwordVerify = document.getElementById("passwordVerify");
    if(email.value != emailVerify.value || password.value != passwordVerify.value
        || email.value == '' || emailVerify.value == ''
        || password.value == '' || passwordVerify.value == ''
        || firstName.value == '' || lastName.value == '') {
        matches = false;
    }

    document.getElementById("submitButton").disabled = !matches;

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
    document.getElementById("submitButton").disabled = true;
    var inputs = document.getElementsByTagName('input');
    for(var i=0; i<inputs.length; i++){
        inputs[i].onkeyup = doCheck;
        inputs[i].onblur = doCheck;
    }
}