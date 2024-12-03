function validation() {
    var name = document.getElementById("firstName").value;
    var surname = document.getElementById("lastName").value;
    var pass = document.getElementById("password").value;
    var email = document.getElementById("email").value;

    if (name === "") {
        document.getElementById("firstName").innerHTML =
            " ** Prosím vyplnte meno";
        return false;
    }

    if (surname === "") {
        document.getElementById("lastName").innerHTML =
            " ** Prosim vyplnte priezvisko";
        return false;
    }
    if (email.indexOf("@") <= 0) {
        document.getElementById("email").innerHTML = " ** Nesprávny formát emailu";
        return false;
    }

    if (email.charAt(email.length - 4) !== "." && email.charAt(email.length - 3) !== ".") {
        document.getElementById("email").innerHTML = " ** Nesprávny formát emailu";
        return false;
    }

    if (pass === "") {
        document.getElementById("password").innerHTML =
            " ** Heslo musí byť zadané";
        return false;
    }
    if (pass.length <= 5 || pass.length > 20) {
        document.getElementById("password").innerHTML =
            " ** Dĺžka hesla musí byť medzi 5 a 20";
        return false;
    }
}