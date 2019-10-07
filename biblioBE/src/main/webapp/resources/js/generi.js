$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/biblioBE/genere/list"
    }).then(function(data) {
       $('.generi-id').append(data.id);
       $('.generi-content').append(data.content);
    });
});