function fnDate(){
var timeDiv=document.getElementById("time");
var date=new Date();
var year=date.getFullYear();//当前年份
var month=date.getMonth();//当前月份
var data=date.getDate();//天
var hours=date.getHours();//小时
var minute=date.getMinutes();//分
var second=date.getSeconds();//秒
var time=year+"-"+fnW((month+1))+"-"+fnW(data)+" "+fnW(hours)+":"+fnW(minute)+":"+fnW(second);
timeDiv.innerHTML=time;
}
function fnW(str){
var num;
str>=10?num=str:num="0"+str;
return num;
}
function time(){
	setInterval(function(){
		fnDate();
		},1000);
}
addLoadEvent(fnDate);
addLoadEvent(time);