

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
var timer=setInterval(run,1500)

$("#flash").hover(function(){

    clearInterval(timer);
},function(){

    timer=setInterval(run,1500);
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


$(document).ready(function(){
    $(".video").addClass("video1");
    $(".video:eq(3)").removeClass("video1").addClass("video2");
    $(".video:eq(7)").removeClass("video1").addClass("video2");
    $(".video:eq(11)").removeClass("video1").addClass("video2");
    $(".video:eq(15)").removeClass("video1").addClass("video2");
    $(".reward").addClass("reward1");
    $(".reward:eq(2)").removeClass("reward1").addClass("reward2");
    $(".reward:eq(5)").removeClass("reward1").addClass("reward2");
});

$(document).ready(function(){
    $(".pagination a").click(function(){
        $(".pagination a").removeClass("active");
        $(this).addClass("active");
    });
});

function show(num)
{
    for(var i=1; i<=3; i++)
    {
        document.getElementById("d"+i).style.display="none";
    }
    document.getElementById("d"+num).style.display="block";
}

