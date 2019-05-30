function validateName() {
    if(!document.getElementById) return false;
    if(!document.getElementById("pass1")) return false;
    if(!document.getElementById("name")) return false;
    if(!document.getElementById("regname")) return false;
    regname=document.getElementById("regname");
    if(name.value==""){
    	if(regname.hasChildNodes()){
    		regname.removeChild(regname.firstChild);
    	}
    	regname.style.color="red";
        var text=document.createTextNode("用户名不得为空");
        regname.appendChild(text);
        name.focus();
        name.select();
    }
}
function tf1(){
    if(!document.getElementById) return false;
    if(!document.getElementById("regf")) return false;
    if(!document.getElementById("pass1")) return false;
    var pass1=document.getElementById("pass1");
    var reg=document.getElementById("regf");
    pass1.onfocus=function(){
    	validateName();
    }
}
addLoadEvent(tf1);
