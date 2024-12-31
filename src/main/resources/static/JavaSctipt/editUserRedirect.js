function editUserScr(email) {
    window.location.href = '/editUser?email=' + email;
}

// function editUserScr(button) {
//     const email = button.getAttribute('data-email');
//     const url = '/editUser/' + encodeURIComponent(email);
//     window.location.href = url;
// }

function deleteUserScr(email) {
    if (confirm('Chcete skutočne vymazať používateľa s emailom ' + email)) {
        window.location.href = '/deleteUser?email=' + email;
    }
}