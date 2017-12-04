 

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
    *   将除“sign”外的所有不为空(""或null)参数按key进行字典升序排列，将api_name和排序后的参数(key=value)用&拼接起来。
* 2 数据交互
    *  post 提交 ,返回json

**接口列表**

- **网关支付接口**

- **代付接口**

- **查询订单结果**

- **订单完成通知**

- **银联二维码接口**

* ## 接口说明


 

***

* 1 网关接口

    * 请求地址

	> http://host/gate/way/order/down


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

    * 请求地址

	> http://host/proxy/pay


    * 请求参数

    > province、city、cnapsName 参数不做校验，但是必须传

| 参数   | 说明| 是否必传 |
| ----   | --- | --- |
| orderId |订单号 | y|
| merchantId	| 商户号 | y|
| amount	| 订单金额|y |
| trxType	| 交易类型  默认传3   T1(2,"T1"), D0(3,"D0");|y |
| acctType	| 渠道类型 1对私2对公|y |
| type	| 钱包类型 2 网关 8 微信  10 QQ钱包 |y |
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
| type	| 钱包类型 2 网关 8 微信  10 QQ钱包 |y |
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

	> http://host/order/query

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

   > 使用request  key 直接获取
   

***



* 5 银联二维码接口

    * 请求地址

	> http://host/union/qrcode


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
| 0000	| 成功  |
| 0001 | 失败 |
| 0002	| 待支付 |
| 0003	| 请求超时 | 
| 0004	| 参数错误 |
| 0005	| 签名错误 |
| 0007	| 商户号不存在 |
| 0008	| 订单号重复 |
| 0012	| 超过代付最大金额 |
| 0013	| 代付余额不足 |





* 2 **代付bankCode编码**　

银行名称     | 银行编号
-------- | ---|
工商银行	| ICBC   |
| 农业银行| 	ABC |
| 中国银行	| BOC |
| 建设银行	| CCB| | 
| 交通银行	| BCOM |
| 招商银行	| CMB |
| 广东发展银行| 	GDB
| 中信银行	| CITIC
| 民生银行	| CMBC
| 光大银行	| CEB
| 平安银行	| PABC
| 上海浦东发展银行	| SPDB
| 中国邮政储蓄银行	| PSBC
| 华夏银行	| HXB
| 兴业银行	| CIB
| 北京银行	| BJBANK
| 北京农商行	| BJRCB
| 上海银行	| BOS
| 渤海银行	| CBHB
| 重庆三峡银行	| CCQTGB
| 长沙银行	| CSCB




### 备注### 

如需帮助，请联系开发人员[lishiwen@hezhongpay.com][1].


