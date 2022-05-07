$(document).ready(function () {
  // 获取链接中的参数
  function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
  }
  var id = GetQueryString("id");
  var cId = GetQueryString("cId");
  //   function GetRequest() {
  //       var url = location.search; //获取url中"?"符后的字串
  //       var theRequest = new Object();
  //       if (url.indexOf("?") != -1) {
  //           var str = url.substr(1);
  //           // alert(str);
  //           strs = str.split("&");
  //           for (var i = 0; i < strs.length; i++) {
  //               theRequest[strs[i].split("=")[0]] = unescape(strs[i].split("=")[1]);
  //           }
  //       }
  //       return theRequest;
  //   }
  //   var request = new Object();
  //   request = GetRequest();
  //   var id = request['id'];
  //   var cId = request['cId'];
  // console.log(cId)

  // 视频点击播放与暂停
  $("#my-video").on("click", function () {
    if (this.paused) {
      this.play();
    } else {
      this.pause();
    }
  });

  $.ajax({
    url: "/getHomepageInfo",
    timeout: 5000,
    type: "GET",
    dataType: "json",
    async: false,
    contentType: "application/json",
    error: function () {
      console.log("error!");
    },
    success: funSucc,
  });

  function funSucc(data) {
    if (data.success) {
      // 获取课程组信息和课程组课程
      for (var i in data.data) {
        $(".subNavBox").prepend(
          '<div class="subNav"><i class="glyphicon glyphicon-chevron-down"></i>&nbsp;&nbsp;&nbsp;' +
            data.data[i].courseGroup.name +
            '</div><ul class="navContent ul-' +
            i +
            '"></ul> '
        );
        // var a = i
        for (var y in data.data[i].ordinaryCourse) {
          // console.log(i)
          $(".subNavBox")
            .find(".ul-" + i)
            .append(
              '<li><a href="/course?id=' +
                data.data[i].ordinaryCourse[y].course.id +
                '">' +
                data.data[i].ordinaryCourse[y].course.name +
                "</a></li>"
            );
        }
        for (var x in data.data[i].keyCourses) {
          // console.log(i)
          $(".subNavBox")
            .find(".ul-" + i)
            .append(
              '<li><a href="/course?id=' +
                data.data[i].keyCourses[x].course.id +
                '">' +
                data.data[i].keyCourses[x].course.name +
                "</a></li>"
            );
        }
      }
      $(".subNavBox").prepend(
        '<div style="width:100%;height:50px;line-height: 50px;text-align: center;font-size: 13px;"><i class="glyphicon glyphicon-home"></i>&nbsp;&nbsp;&nbsp;核心课程</div>'
      );
    } else {
      alert(data.message);
    }
  }

  $.ajax({
    url: "/getUnitDetail",
    type: "POST",
    dataType: "json",
    data: JSON.stringify({
      id: id,
    }),
    contentType: "application/json",
    timeout: 5000,
    async: false,
    error: function () {
      console.log("请求失败！");
    },
    success: sucFun,
  });

  function sucFun(data) {
    console.log(data);
    if (data.success) {
      $(".c-name").append(
        data.data.chapter.number +
          "&nbsp;&nbsp;" +
          data.data.unit.number +
          ":" +
          data.data.unit.name
      );
      if (data.data.videos.length == 0) {
        $("video").attr("src", "");
      } else {
        $("video").attr("src", data.data.videos[0].video.url);
      }

      for (var i in data.data.offices) {
        $(".information .stu").append(
          '<li><a href="' +
            data.data.offices[i].fileUrl +
            '" title=""><i class="glyphicon glyphicon-list-alt"></i>&nbsp;&nbsp;' +
            data.data.offices[i].description +
            "</a></li>"
        );
      }
      for (var x in data.data.knowledgePoints) {
        $(".information .point").append(
          '<li index="' +
            data.data.knowledgePoints[x].id +
            '" data-toggle="modal" data-target="#myModal"><a href="javastript:void(0);"  title="">' +
            data.data.knowledgePoints[x].content +
            "</a></li>"
        );
      }
      $(".classinfor").append(data.data.unit.content);

      var url = " ";
      for (var y in data.data.videos_chapter) {
        /*if(y.picture!=null){
            url=y.picture.url
          }else{
            url=' '
          }*/
        $(".s-list ul").append(
          '<li><div class="col-md-6"><a href="/single?id=' +
            data.data.videos_chapter[y].unit.id +
            '" title=""><img src="/pic/20180308134636349.jpg" /></a></div><div class="col-md-6 detail"><a href="/single?id=' +
            data.data.videos_chapter[y].unit.id +
            '" title="">' +
            data.data.videos_chapter[y].unit.number +
            '</a><p class="author">' +
            data.data.videos_chapter[y].unit.name +
            '</p><p class="views">' +
            data.data.videos_chapter[y].unit.content +
            "</p></div></li>"
        );
      }
      /*$('.s-list ul').append(`<div class="clear"></div>`)*/
    } else {
      alert(data.message);
    }
  }
  $(".point li").on("click", function () {
    var point = $(this).attr("index");
    $.ajax({
      url: "/getUnitsByKnowledgePoint",
      timeout: 5000,
      type: "POST",
      dataType: "json",
      async: false,
      data: JSON.stringify({
        id: point,
      }),
      contentType: "application/json",
      error: function () {
        $("#myModal iframe").css("display", "none");
        $("#myModal .modal-body div").css("display", "block");
        $("#myModal .modal-body div").html("<center>获取失败</center>");
      },
      success: successFun,
    });
    function successFun(data) {
      /*console.log(data)*/
      if (data.success) {
        $("#myModal iframe").css("display", "none");
        $("#myModal .modal-body div").css("display", "block");
        $("#myModal .modal-body div").html(" ");
        for (var i in data.data) {
          $("#myModal .modal-body div").append(
            '<li style="list-style:none;margin-left:20px;margin-top:20px;font-size:16px;"><a href="single.html?id=' +
              data.data[i].unit.id +
              '">' +
              data.data[i].course.name +
              "&nbsp;&nbsp;" +
              data.data[i].chapter.number +
              "&nbsp;&nbsp;" +
              data.data[i].unit.number +
              "&nbsp;&nbsp;" +
              data.data[i].unit.name +
              "</a></li>"
          );
        }
      } else {
        $("#myModal iframe").css("display", "none");
        $("#myModal .modal-body div").css("display", "block");
        $("#myModal .modal-body div").html(
          "<center>" + data.message + "</center>"
        );
      }
    }
  });

  $(".subNavBox div:first").addClass("active");
  $(".subNavBox ul:first").css("display", "block");
  $(".subNavBox").append(
    '<div class="copyright"><p>Copyright © 2018.合肥工业大学管理学院 版权所有</p></div>'
  );

  $(".subNav").click(function () {
    // 修改数字控制速度， slideUp(500)控制卷起速度
    $(this)
      .next(".navContent")
      .slideToggle(500)
      .siblings(".navContent")
      .slideUp(500);
  });

  // // 点击课程组信息变色
  // $('.subNavBox').find('.subNav').on('click',function () {
  //     $('.subNavBox .subNav').removeClass('active')
  //     $(this).addClass('active')
  // })
});
