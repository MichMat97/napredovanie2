function editUserScr(email) {
    window.location.href = '/editUser?email=' + email;
}

function editUserPasswdScr(email) {
    window.location.href = '/editUserPasswd?email=' + email;
}

function deleteUserScr(email) {
    if (confirm('Chcete skutočne vymazať používateľa s emailom ' + email)) {
        window.location.href = '/deleteUser?email=' + email;
    }
}