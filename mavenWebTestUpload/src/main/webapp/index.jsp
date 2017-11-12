<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery126.js"></script>
<script type="text/javascript">
	$(function() {
		$("#myButton").click(function() {
			//首先清除之前显示的进度
			$("#show").html("");
			//点击按钮之后，设置按钮不可用
			$(this).attr("disabled", true);
			//提交表单
			$("#form3").submit();
			//设置在500毫秒之后调用showProgress方法
			setTimeout("showProgress()", 500);
		});
	});
	//访问SeeProgressServlet这个servlet，将文件状态对象，从Java转化为json
	//确实可以显示上传进度，但是必须是要在谷歌浏览器才能显示，而且是在谷歌浏览器的下方，以后可以优化
	function showProgress() {
		$.getJSON("SeeProgressServlet", function(json) {
			$("#show").html(
					"上传进度：" + (json.bytesReadNumber / json.contentLength) * 100
							+ "%");
			if (json.bytesReadNumber == json.contentLength) {
				$("#show").html($("#show").html() + "上传结束~");
				$("#myButton").attr("disabled", false);
			} else {
				setTimeout("showProgress()", 500);
			}
		});
	}
</script>
</head>
<body>
	<h2>查看文件上传的请求正文,这是没有使用相关jar的演示，只能查看请求正文，而且会乱码</h2>
	<!--文件上传，方法必须为post,必须加上 enctype="multipart/form-data"，指定跳转的sevlet,需要在web.xml中做相关的配置-->
	<form id="form1" method="POST" enctype="multipart/form-data"
		action="SeeRequestContentServlet">
		<input type="text" name="myText" value="test" /><br />
		<!-- input输入框的type必须为 file-->
		<input type="file" name="myFile" /><br /> <input type="submit"
			value="提交" /><br />
	</form>

	<h2>使用fileupload组件实现文件上传</h2>
	<form id="form2" method="POST" enctype="multipart/form-data"
		action="FileUploadServlet">
		<input type="text" name="myText" value="test" /><br /> <input
			type="file" name="myFile" /><br /> <input type="submit" value="提交" /><br />
	</form>

	<h2>文件上传显示进度</h2>
	<!-- 为了显示上传进度，所以页面不能刷新 -->
	<iframe id='target_upload' name='target_upload' src=''
		style='display: none'></iframe>

	<!-- 当form提交时，由于使用了target="target_upload"，所以当前页面不会被刷新到，而是对应的iframe被刷新了，
	而iframe又是设置dispaly:none的，所以看起来页面好像是没有被跳转 -->

	<form id="form3" method="POST" enctype="multipart/form-data"
		action="AJAXFileUploadServlet" target="target_upload">
		<input type="file" name="myFile" /><br /> <input type="button"
			value="提交" id="myButton" /><br />
	</form>

	<!-- 这里的div的作用就是为了 显示上传进度的-->
	<div id="show"></div>

	<h2>文件下载</h2>
	<form id="form4" method="POST" action="FileDownloadServlet">
		请输入文件名：<input type="text" name="fileName" /><br /> 
		<input type="submit" value="提交" />
		<br />
	</form>
</body>
</html>