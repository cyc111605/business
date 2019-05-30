function href(){
	if(!document.getElementById) return false;
	if(!document.getElementById("exitnews")) return false;
	exitnews.onclick=function(){
		location.href="/business/end/newsManage.jsp";
	}
}
addLoadEvent(href);