<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="tag.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

	<%@ include file="/WEB-INF/view/common/static_resources.jsp"%>
	<!--[if lt IE 9]>
	<meta http-equiv="refresh" content="0;ie.html" />
	<![endif]-->
	<script>
		if(window.top!==window.self){window.top.location=window.location};
	</script>

</head>

<body class="gray-bg">
<div class="middle-box text-center animated fadeInDown">
	<h1>500</h1>
	<h3 class="font-bold">服务器内部错误</h3>

	<div class="error-desc">
		服务器好像出错了...
		<br/>您可以返回主页看看
		<br/><a href="/" class="btn btn-primary m-t">主页</a>
	</div>
</div>
<script src="${staticUrl}/static/js/jquery.min.js?v=2.1.4"></script>
<script src="${staticUrl}/static/js/bootstrap.min.js?v=3.3.6"></script>

</body>

</html>

