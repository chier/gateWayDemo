package com.jhz.demo.dto;

/**
 * 代付数据传输对象
 * Created by lishi on 2017/11/6.
 */
public class ProxyPayDto extends CommonDto {

    private Integer trxType = 3;//   T1(2,"T1"), D0(3,"D0");

    private Integer acctType;// 1对私  2对公

    private String acctName;//收款人姓名

    private String acctNo;//收款人账号

    private String bankName;//开户行名称

    private String bankSettNo;//清算银行号

    /**
     * 工商银行	ICBC
     * 农业银行	ABC
     * 中国银行	BOC
     * 建设银行	CCB
     * 交通银行	BCOM
     * 招商银行	CMB
     * 广东发展银行	GDB
     * 中信银行	CITIC
     * 民生银行	CMBC
     * 光大银行	CEB
     * 平安银行	PABC
     * 上海浦东发展银行	SPDB
     * 中国邮政储蓄银行	PSBC
     * 华夏银行	HXB
     * 兴业银行	CIB
     * 北京银行	BJBANK
     * 北京农商行	BJRCB
     * 上海银行	BOS
     * 渤海银行	CBHB
     * 重庆三峡银行	CCQTGB
     * 长沙银行	CSCB
     */
    private String bankCode;//开户行代码

    private String province;//开户行所在省

    private String city;//开户行所在市

    private String cnapsName;//开户支行名称

    private String mobile;//开户支行名称

    private String certificateCode;//开户支行名称


    public Integer getTrxType() {
        return trxType;
    }

    public void setTrxType(Integer trxType) {
        this.trxType = trxType;
    }

    public Integer getAcctType() {
        return acctType;
    }

    public void setAcctType(Integer acctType) {
        this.acctType = acctType;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankSettNo() {
        return bankSettNo;
    }

    public void setBankSettNo(String bankSettNo) {
        this.bankSettNo = bankSettNo;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCnapsName() {
        return cnapsName;
    }

    public void setCnapsName(String cnapsName) {
        this.cnapsName = cnapsName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode;
    }
}
