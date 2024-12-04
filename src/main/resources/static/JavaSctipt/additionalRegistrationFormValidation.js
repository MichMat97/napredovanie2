function validation() {
    document.getElementById("firstNameError").innerHTML = "";
    document.getElementById("lastNameError").innerHTML = "";
    document.getElementById("emailError").innerHTML = "";
    document.getElementById("passwordError").innerHTML = "";

    let name = document.getElementById("firstName").value;
    let surname = document.getElementById("lastName").value;
    let pass = document.getElementById("password").value;
    let email = document.getElementById("email").value;

    if (name === "") {
        document.getElementById("firstNameError").innerHTML =
            " ** Prosím vyplnte meno";
        return false;
    }

    if (surname === "") {
        document.getElementById("lastNameError").innerHTML =
            " ** Prosim vyplnte priezvisko";
        return false;
    }
    if (email.indexOf("@") <= 0) {
        document.getElementById("emailError").innerHTML = " ** Nesprávny formát emailu";
        return false;
    }

    if (email.charAt(email.length - 4) !== "." && email.charAt(email.length - 3) !== ".") {
        document.getElementById("emailError").innerHTML = " ** Nesprávny formát emailu";
        return false;
    }

    if (pass === "") {
        document.getElementById("passwordError").innerHTML =
            " ** Heslo musí byť zadané";
        return false;
    }
    if (pass.length <= 5 || pass.length > 20) {
        document.getElementById("passwordError").innerHTML =
            " ** Dĺžka hesla musí byť medzi 5 a 20";
        return false;
    }

    return true;
}