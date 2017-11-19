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
	<h1>404</h1>
	<h3 class="font-bold">页面未找到！</h3>

	<div class="error-desc">
		抱歉，页面好像去火星了~
		<form class="form-inline m-t" role="form">
			<div class="form-group">
				<input type="email" class="form-control" placeholder="请输入您需要查找的内容 …">
			</div>
			<button type="submit" class="btn btn-primary">搜索</button>
		</form>
	</div>
</div>
<script src="${staticUrl}/static/js/jquery.min.js?v=2.1.4"></script>
<script src="${staticUrl}/static/js/bootstrap.min.js?v=3.3.6"></script>

</body>

</html>

