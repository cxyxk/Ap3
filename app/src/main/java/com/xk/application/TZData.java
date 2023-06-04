package com.xk.application;

/*
  @Author xk
 * @Date 2023/04/18 23:31
 */

public class TZData {
    private final int dsValue;
    private final int zyValue;
    private final int tzValue;

    public TZData(String dsName, String zyName, int dsValue, int zyValue, int tzValue) {
        this.dsValue = dsValue;
        this.zyValue = zyValue;
        this.tzValue = tzValue;
    }


    public int getDsValue() {
        return dsValue;
    }

    public int getZyValue() {
        return zyValue;
    }

    public int getTzValue() {
        return tzValue;
    }


}
