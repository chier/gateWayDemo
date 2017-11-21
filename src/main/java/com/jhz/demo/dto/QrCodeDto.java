package com.jhz.demo.dto;

/**
 * Created by lishi on 2017/11/21.
 */
public class QrCodeDto extends CommonDto {
    private String terminalId;//付款码

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }
}
