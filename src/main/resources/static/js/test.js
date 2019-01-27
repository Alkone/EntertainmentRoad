var ListUser = document.getElementById("incomplete-tasks");
var EnterFilm;

var dataUserList = [];

var myNodelist = document.getElementsByTagName("LI");
var i;
for (i = 0; i < myNodelist.length; i++) {
    var span = document.createElement("SPAN");
    var txt = document.createTextNode("\u00D7");
    span.className = "close";
    span.appendChild(txt);
    myNodelist[i].appendChild(span);
}

// Click on a close button to hide the current list item
var close = document.getElementsByClassName("close");
var i;
for (i = 0; i < close.length; i++) {
    close[i].onclick = function() {
        var div = this.parentElement;
        div.style.display = "none";
    }
}

function addUser() {
    EnterFilm = document.getElementById("film");
    var li = document.createElement("li");
    var inputValue = document.getElementById("new-task").value;
    var t = document.createTextNode(inputValue);
    dataUserList.push(inputValue.split(' ')[1]);
    li.appendChild(t);
    if (inputValue === '') {
        alert("You must write something!");
    } else {
        document.getElementById("incomplete-tasks").appendChild(li);
    }
    document.getElementById("new-task").value = "";
    var deleteButton = document.createElement("Button");
    var txt = document.createTextNode("delete");
    deleteButton.className = "close";
    deleteButton.appendChild(txt);
    li.appendChild(deleteButton);

    for (i = 0; i < close.length; i++) {
        close[i].onclick = function() {
            var div = this.parentElement;
            div.style.display = "none";
        }
    }
    console.debug(dataUserList,EnterFilm)
    $.ajax({
        url: 'your servlet url',
        data: yourArray
    });
}