function validateName() {
    if(!document.getElementById) return false;
    if(!document.getElementById("uid")) return false;
    if(!document.getElementById("upass")) return false;
    if(!document.getElementById("reginfo")) return false;
    regin=document.getElementById("reginfo");
    id=document.getElementById("uid");
    if(id.value==""){
    	if(regin.hasChildNodes()){
    		regin.removeChild(regin.firstChild);
    	}
    	regin.style.color="red";
        var text=document.createTextNode("ID不得为空");
        regin.appendChild(text);
        id.focus();
        id.select();
    }else{
    	if(regin.hasChildNodes()){
    		regin.removeChild(regin.firstChild);
    	}
    	regin.style.color="green";
        var text=document.createTextNode("ID格式正确");
        regin.appendChild(text);
    }
}
function tf2(){
    if(!document.getElementById) return false;
    if(!document.getElementById("upass")) return false;
    var pass1=document.getElementById("upass");
    pass1.onfocus=function(){
    	validateName();
    }
}
addLoadEvent(tf2);
