function highlightRows() {
    if(!document.getElementsByTagName) return false;
    var all_tr=document.getElementsByTagName("tr");
    for(var i=0;i<all_tr.length;i++){
        all_tr[i].onmouseover=function () {
            this.style.fontWeight="bold";
        }
        all_tr[i].onmouseout=function () {
            this.style.fontWeight="normal";
        }
    }
}
addLoadEvent(highlightRows);