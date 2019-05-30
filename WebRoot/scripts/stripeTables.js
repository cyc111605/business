function stripeTables() {
    if(!document.getElementsByTagName) return false;
    if(!document.getElementsByTagName("table")) return false;
    var alltable=document.getElementsByTagName("table");
    for (var i=0;i<alltable.length;i++){
        var odd=false;
        alltr=alltable[i].getElementsByTagName("tr");
        for(var j=0;j<alltr.length;j++) {
            if (odd == true) {
                alltr[j].style.backgroundColor = "#808080";
                alltr[j].style.color="white";
                odd = false;
            } else {
                odd = true;
            }
        }
    }
}
addLoadEvent(stripeTables);