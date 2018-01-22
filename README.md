 

# 众付平台文档


* ## 阅读对象

> 本文档面向的是对支付系统支付API支付业务存在需求的公司、机构及合作商户的网上应用开发人员、维护人员和业务管理人员。


* ## 术语解释

> 
| 术语   | 说明 | 
| ----   |----   |
| 商户号 | 支付系统分配给商户的唯一标识。 如:100512501190760 |
| 商户 key| 调用服务接口所需要的密钥 (如:9d6c8a99-4b3b-40d2-ad48-58f16c809293) |
| 商户 secret | 签名的密钥 (如:505d777b-6cd3-4cf3-a7c9-ff13fb5bea96) |
| 通知 | 服务器异步通知。支付系统根据所得数据进行处理完成后，服务器主动发起通知给商户网站，并携带完成处理的结果信息反馈给商户网站。 |



**请求域名**　

| 域名   | ip | 
| ----   |----   |
| [pay.hezhongpay.com](pay.hezhongpay.com) | [47.95.1.215](47.95.1.215) |




**签名规则**　

* 1 构造源串
    *   将除“sign”外的所有不为空(""或null)参数按key进行字典升序排列，将api_name和排序后的参数(key=value)用&拼接起来。
* 2 签名
    *   sign=md5(源串+商户 secret) 结果 转小写 。
    
    
    
    
**传输协议**　

* 1 http
      
* 2 数据交互
      post 提交 ,返回json
      



**交易流程**　

* 1 商户下单
      
* 2 支付订单

* 3 异步通知

* 4 订单完成
                
      




**接口列表**

- **网关支付接口**

- **代付接口**

- **查询订单结果**

- **订单完成通知**

- **银联二维码接口**



**接口说明**


 

***

* 1 网关接口

    * 请求地址

	> http://域名/gate/way/order/down


    * 请求参数

| 参数   | 说明| 是否必传 |
| ----   | --- | --- |
| orderId |订单号 | y|
| merchantId	| 商户号 | y|
| amount	| 订单金额 单位 分 |y |
| trxType	| 交易类型  默认传3    T1(2,"T1"), D0(3,"D0");|y |
| type	| 2 借记卡 |y |
| bankCode	| 银行代码 |y |
| name	| 商户展示名称|y |
| body	| 商品名称 |y |
| frontUrl  | 前台地址 | y |
| notifyUrl  | 通知url | y |
| merchantKey | 通商户key  | y  |
| timestamp | 时间戳|y |
| sign | 签名|y |

    * 响应结果


| 参数   | 说明|
| ----   | --- |
| orderId |订单号 | y|
| merchantId	| 商户号 | y|
| amount	| 订单金额 单位 分 |y |
| trxType	| 交易类型  默认传3    T1(2,"T1"), D0(3,"D0");|y |
| type	| 2 借记卡 |y |
| bankCode	| 银行代码 |y |
| name	| 商户展示名称|y |
| body	| 商品名称 |y |
| frontUrl  | 前台地址  get 请求地址 frontUrl?code=0000&orderId=xxx&msg=xxx | y |
| notifyUrl  | 通知url  | y |
| url | 支付url |
| timestamp | 时间戳|
| code	| 响应码  |  
| msg	| 响应消息 |  
| sign	| 签名 |

***


* 2 代付接口

    代付状态以回调结果为准

    * 请求地址

	> http://域名/proxy/pay/v2


    * 请求参数

    > province、city、cnapsName 参数不做校验，但是必须传

| 参数   | 说明| 是否必传 |
| ----   | --- | --- |
| orderId |订单号 | y|
| merchantId	| 商户号 | y|
| amount	| 订单金额 (分) |y |
| trxType	| 交易类型  默认传3   T1(2,"T1"), D0(3,"D0");|y |
| acctType	| 渠道类型 1对私2对公|y |
| type	| 钱包类型 2 网关,5 快捷, 8 微信 , 10 QQ钱包, 13银联二维码 ,16 微信h5 ,28 qq h5 ,29 众付宝 |y |
| acctName	| 收款人姓名|y |
| acctNo	| 收款人账号|y |
| bankName	| 开户行名称|y |
| bankSettNo	| 清算行号|y |
| bankCode	| 开户行代码|y |
| province	| 开户行所在省|y |
| city	| 开户行所在省|y |
| cnapsName	| 开户支行名称|y |
| mobile	| 开户人手机号|y |
| certificateCode | 开户人身份证号|y |
|notifyUrl  | 通知url | y |
|merchantKey | 通商户key  | y  |
| timestamp | 时间戳|y |
| sign | 签名|y |



    * 响应结果


| 参数   | 说明|
| ----   | --- |
| orderId |订单号 |
| merchantId	| 商户号 |
| amount	| 订单金额|
| trxType	| 交易类型  默认传3    T1(2,"T1"), D0(3,"D0");|
| acctType	| 渠道类型 1对私2对公|
| type	| 钱包类型 2 网关,5 快捷, 8 微信 , 10 QQ钱包, 13银联二维码 ,16 微信h5 ,28 qq h5 ,29 众付宝 |y |
| acctName	| 收款人姓名|
| acctNo	| 收款人账号|
| bankName	| 开户行名称|
| bankSettNo	| 清算行号|
| bankCode	| 开户行代码|
| province	| 开户行所在省|
| city	| 开户行所在省|
| cnapsName	| 开户支行名称|
| mobile	| 开户人手机号|
| certificateCode | 开户人身份证号|
| notifyUrl  | 通知url |
|merchantKey | 通商户key  |
| timestamp | 时间戳|
| code	| 响应码  |  
| msg	| 响应消息  申请代付成功 |  
| sign	| 签名 |




***



*  3 查询订单接口


 * 请求地址

	> http://域名/order/query

 * 请求参数

| 参数   | 说明| 是否必传 |
| ----   | --- | --- |
| orderId |订单号 | y|
| merchantId	| 商户号 | y|
| merchantKey | 通商户key  | y  |
| timestamp | 时间戳|y |
| sign | 签名|y |


  > 订单返回数据

| 参数   | 说明|
| ----   | --- |
| timestamp | 时间戳  |
| orderId| 	订单号 |
| merchantId	| 商户号 |
| merchantKey	| 商户key |
| code	| 响应码 |  
| msg	| 响应消息 |  
| sign	| 签名 |


  

***


*  4 通知接口

 
  > 通知返回数据
    	
| 参数   | 说明| 
| ----   | --- |
| timestamp | 时间戳  | 
| orderId| 	订单号 |
| merchantId	| 商户号 |
| amount	| 订单金额|
| merchantKey	| 商户key |
| code	| 响应码 |  
| msg	| 响应消息 |  
| sign	| 签名 |

   > 使用request  key 直接获取,收到通知后返回  true 字符串,
  
  ```java
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String merchantId=request.getParameter("merchantId");
		String orderId=request.getParameter("orderId");
		String code=request.getParameter("code");
		String msg=request.getParameter("msg");
		String amount=request.getParameter("amount");
		String merchantKey=request.getParameter("merchantKey");
		String timestamp=request.getParameter("timestamp");
		String sign=request.getParameter("sign");
		
		if(验证签名){
			if("0000".equals(code)){
				//成功 处理逻辑
			}else if("0001".equals(code)){
				//失败 处理逻辑
			}else{
				//其它 处理逻辑
			}
		}
	}
```
   

***



* 5 银联二维码接口

    * 请求地址

	> http://域名/union/qrcode


    * 请求参数

| 参数   | 说明| 是否必传 |
| ----   | --- | --- |
| orderId |订单号 | y|
| merchantId	| 商户号 | y|
| amount	| 订单金额 单位 分 |y |
| productName	| 商品名|y |
| terminalId | 付款码 有值主扫 、为空时 生成码 |n |
| notifyUrl  | 通知url | y |
| merchantKey | 通商户key  | y  |
| timestamp | 时间戳|y |
| sign | 签名|y |

    * 响应结果


| 参数   | 说明|
| ----   | --- |
| orderId |订单号 | y|
| merchantId	| 商户号 | y|
| amount	| 订单金额 单位 分 |y |
| productName	| 商品名|y |
| terminalId | 付款码 有值主扫 、为空时 生成码 |n |
| notifyUrl  | 通知url  | y |
| url | 支付地址 |
| timestamp | 时间戳|
| code	| 响应码  |  
| msg	| 响应消息 |  
| sign	| 签名 |

***



### 附录

* 1 **响应码说明**　


| code   | msg |
| -------- | ---|
| 0000	| 交易：成功 ; 代付：已结算 |
| 0001 | 交易：失败 ; 代付：打款失败|
| 0002	| 交易：等待支付 ; 代付：打款中 |
| 0003	| 请求超时 | 
| 0004	| 参数错误 |
| 0005	| 签名错误 |
| 0007	| 商户号不存在 |
| 0008	| 订单号重复 |
| 0009	| 通道已经关闭 |
| 0011	| 系统错误 |
| 0012	| 超过代付最大金额 |
| 0013	| 代付余额不足 |
| 0015	| 订单号重复 |
| 0018	| 代付结果以异步通知为准 |
| 0019	| 交易不在营业时间内 |
| 0020	| 查询过于频繁，请稍后再试 |
| 0021	| 订单号不存在 |



 


* 2 **网银 bankCode编码**　

银行名称     | 银行编号
-------- | ---|
工商银行	| ICBC   |
| 农业银行| 	ABC |
| 中国银行	| BOC |
| 建设银行	| CCB| | 
| 交通银行	| BCOM |
| 招商银行	| CMB |
| 光大银行	| CEB |
| 北京银行	| BOB |
| 上海银行	| BOS |
| 邮政银行	| PSBC |
| 工商银行	| ICBC |




### 备注### 

如需帮助，请联系开发人员[lishiwen@hezhongpay.com][1].


