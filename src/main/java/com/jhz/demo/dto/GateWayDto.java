package com.jhz.demo.dto;

/**
 * Created by lishi on 2017/11/18.
 */
public class GateWayDto extends CommonDto {

    private String name;//商户展示名称

    private String body;//商品名称

    private String bankCode;//开户行代码


    private Integer cardType;//card 类型 1
    private Integer trxType;//

    public Integer getTrxType() {
        return trxType;
    }

    public void setTrxType(Integer trxType) {
        this.trxType = trxType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }
}
