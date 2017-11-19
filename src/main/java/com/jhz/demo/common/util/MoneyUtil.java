package com.jhz.demo.common.util;

import java.math.BigDecimal;

/**
 * Created by lishi on 2017/11/6.
 */
public class MoneyUtil {

    public static BigDecimal fen2yuan(BigDecimal fen) {
        return fen.divide(new BigDecimal(100));
    }

    public static BigDecimal yuan2fen(BigDecimal yuan) {
        return yuan.multiply(new BigDecimal(100));
    }

    public static BigDecimal fen2Yuan(Long amount) {
        return new BigDecimal(amount).divide(new BigDecimal(100));
    }
}
