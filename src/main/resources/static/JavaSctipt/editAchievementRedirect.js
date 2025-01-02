
function editAchievementScr(name) {
    window.location.href = 'upravNapredovanie?name=' + name;
}

function deleteAchievementScr(name) {
    if (confirm('Chcete skutočne vymazať napredovanie s názvom ' + name)) {
        window.location.href = 'zmazNapredovanie?name=' + name;
    }
}