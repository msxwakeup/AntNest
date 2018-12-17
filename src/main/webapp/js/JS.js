

/*用c控制图片*/
var c=0;

function run(){
	c++;
	 if(c==4){
	 c=0;
	 }
	 //c号图片显示，其他图片隐藏
	 $("#flash img").eq(c).fadeIn(300).siblings('img').fadeOut(300);
	 // c号li变红  其他li变灰色
	 $("#flash ul li").eq(c).css('background','#933').siblings('li').css('background','#DDDDDD');
}
  var timer=setInterval(run,2500)

$("#flash").hover(function(){
	
	clearInterval(timer);
},function(){
	
    timer=setInterval(run,2500);
})

//移入li属性
$("#flash ul li").mouseenter(function(){
//获取当前移入的li
   c=$(this).index();
   clearInterval(timer);
   $("#flash img").eq(c).fadeIn(300).siblings('img').fadeOut(300);
	 // c号li变红  其他li变灰色
	 $("#flash ul li").eq(c).css('background','#933').siblings('li').css('background','#DDDDDD');
})
