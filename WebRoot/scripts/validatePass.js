function validatePass() {
    if(!document.getElementById) return false;
    if(!document.getElementById("pass1")) return false;
    if(!document.getElementById("pass2")) return false;
    if(!document.getElementById("reginfo2")) return false;
    reginfo2=document.getElementById("reginfo2");
    var pass1=document.getElementById("pass1");
    var pass2=document.getElementById("pass2");
    if(pass1.value!=pass2.value){
    	if(reginfo2.hasChildNodes()){
    		reginfo2.removeChild(reginfo2.firstChild);
    	}
        var text=document.createTextNode("两次输入密码不一致，请重新输入");
        reginfo2.appendChild(text);
        pass2.focus();
        pass2.select();
        return false;
    }else if(pass1.value==""){
    	if(reginfo.hasChildNodes()){
    		reginfo.removeChild(reginfo.firstChild);
    	}
    	reginfo.style.color="red";
    	var text=document.createTextNode("密码不得为空");
    	reginfo.appendChild(text);
    	pass1.focus();
        pass1.select();
        return false;
    }else{
        return true;
    }
}
function check(){
    if(!document.getElementById) return false;
    if(!document.getElementById("pass1")) return false;
    if(!document.getElementById("reginfo")) return false;
    var reginfo=document.getElementById("reginfo");
    var pass1=document.getElementById("pass1");
    if(!(/^\w{6,15}$/).test(pass1.value)){
    	if(reginfo.hasChildNodes()){
    		reginfo.removeChild(reginfo.firstChild);
    	}
    	reginfo.style.color="red";
        var text=document.createTextNode("密码不得少于6位或大于15位");
        reginfo.appendChild(text);
        pass1.focus();
        pass1.select();
        return false;
    }else{
    	reginfo.style.color="green";
    	if(reginfo.hasChildNodes()){
    		reginfo.firstChild.nodeValue="密码格式正确";
    	}else{
    		var text=document.createTextNode("密码格式正确");
            reginfo.appendChild(text);
    	}
    	return true;
    }
    
}
function tf(){
    if(!document.getElementById) return false;
    if(!document.getElementById("regf")) return false;
    if(!document.getElementById("pass2")) return false;
    var pass2=document.getElementById("pass2");
    var reg=document.getElementById("regf");
    reg.onsubmit=function(){
    	return validatePass();
    }
    pass2.onfocus=function () {
        check();
    }
}
addLoadEvent(tf);
