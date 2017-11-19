<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<title>系统后台</title>
	<%@ include file="/WEB-INF/view/common/static_resources.jsp"%>
</head>


<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
	<div class="row">
		<div class="col-sm-6">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>微信二维码</h5>
					<div class="ibox-tools">
						<a class="collapse-link">
							<i class="fa fa-chevron-up"></i>
						</a>
						<a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
							<i class="fa fa-wrench"></i>
						</a>
						<ul class="dropdown-menu dropdown-user">
							<li><a href="form_basic.html#">选项1</a>
							</li>
							<li><a href="form_basic.html#">选项2</a>
							</li>
						</ul>
						<a class="close-link">
							<i class="fa fa-times"></i>
						</a>
					</div>
				</div>
				<div class="ibox-content">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-3 control-label">商户号：</label>

							<div class="col-sm-8">
								<input type="email" placeholder="商户号" class="form-control"> 
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">商户key：</label>

							<div class="col-sm-8">
								<input type="text" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">产品名称 ：</label>

							<div class="col-sm-8">
								<input type="text" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-8">
								<button class="btn btn-sm btn-white" type="submit">提交</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="ibox float-e-margins">
				<div class="ibox-title">
					<h5>查询订单</h5>
					<div class="ibox-tools">
						<a class="collapse-link">
							<i class="fa fa-chevron-up"></i>
						</a>
						<a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
							<i class="fa fa-wrench"></i>
						</a>
						<ul class="dropdown-menu dropdown-user">
							<li><a href="form_basic.html#">选项1</a>
							</li>
							<li><a href="form_basic.html#">选项2</a>
							</li>
						</ul>
						<a class="close-link">
							<i class="fa fa-times"></i>
						</a>
					</div>
				</div>
				<div class="ibox-content">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-3 control-label">商户号：</label>

							<div class="col-sm-8">
								<input type="email" placeholder="商户号" class="form-control"> 
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">商户key：</label>

							<div class="col-sm-8">
								<input type="text" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">订单id ：</label>

							<div class="col-sm-8">
								<input type="text" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-8">
								<button class="btn btn-sm btn-white" type="submit">提交</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>
</div>

<%@ include file="/WEB-INF/view/common/foot.jsp"%>

</body>



</html>
