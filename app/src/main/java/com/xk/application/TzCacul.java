package com.xk.application;

/**
 * @Author xk
 * @Date 2023/04/18 23:28
 */

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TzCacul {
    MainActivity mainActivity;
    private int dFlag, sFlag;
    private int dsFlagT4 = 0;
    private int zyFlagT4 = 0;
    private int tzFlagF4 = 0;
    private int dsFlagF4 = 0;
    private int zyFlagF4 = 0;
    private int tzFlagT4 = 0;
    private int dsFlagT6 = 0;
    private int zyFlagF6 = 0;
    private int tzFlagT6 = 0;
    private int dsFlagF6 = 0;
    private int zyFlagT6 = 0;
    private int tzFlagF6 = 0;
    private int fd3 = 0;
    ;
    private int fd4 = 0;
    private int fs3 = 0;
    private int fs4 = 0;

    private List<TZData> tzList = new CopyOnWriteArrayList<>();//原始数据
    private List<Integer> ds7_10 = Collections.synchronizedList(new ArrayList<>());
    private List<Integer> zy7_10 = Collections.synchronizedList(new ArrayList<>());
    private List<Integer> tz7_10 = Collections.synchronizedList(new ArrayList<>());
    private List<String> dsCurrent = Collections.synchronizedList(new ArrayList<>());
    private List<String> zyCurrent = Collections.synchronizedList(new ArrayList<>());
    private List<String> tzCurrent = Collections.synchronizedList(new ArrayList<>());
    private List<Integer> dsListT4 = Collections.synchronizedList(new ArrayList<>());//单双正确规律1+2数据
    private List<Integer> zyListT4 = Collections.synchronizedList(new ArrayList<>());//左右正确规律1+2数据
    private List<Integer> tzListT4 = Collections.synchronizedList(new ArrayList<>());//梯子正确规律1+2数据
    private List<Integer> dsList6 = Collections.synchronizedList(new ArrayList<>());//单双2+3正确规律数据
    private List<Integer> zyList6 = Collections.synchronizedList(new ArrayList<>());//左右2+3正确规律数据
    private List<Integer> tzList6 = Collections.synchronizedList(new ArrayList<>());//梯子2+3正确规律数据
    private List<Integer> dsListT6 = Collections.synchronizedList(new ArrayList<>());//单双正确规律1+2衍生2+3正确规律数据
    private List<Integer> zyListT6 = Collections.synchronizedList(new ArrayList<>());//左右正确规律1+2衍生2+3正确规律数据
    private List<Integer> tzListT6 = Collections.synchronizedList(new ArrayList<>());//梯子正确规律1+2衍生2+3正确规律数据

    public TzCacul() {

    }

    public String culFinal() {
        String s = "";
        fd3 = (cD() + cD6() + cY6() + c36() + cD4() + cY4() + c34() + cD46() + cY46() + c346() + cuD3() + cuD4() + cuS3() + cuS4() + CD3data());
        fs3 = (cS() + cS6() + cZ6() + c36() + cS4() + cZ4() + c34() + cS46() + cZ46() + c346() + cuD3() + cuD4() + cuS3() + cuS4() + CS3data());
        fd4 = (cD() + cD6() + cZ6() + c46() + cD4() + cZ4() + c34() + cD46() + cZ46() + c446() + cuD3() + cuD4() + cuS3() + cuS4() + CD4data());
        fs4 = (cS() + cS6() + cY6() + c46() + cS4() + cY4() + c34() + cS46() + cY46() + c446() + cuD3() + cuD4() + cuS3() + cuS4() + CS4data());
        //Log.d("if(dFlag>sFlag:",""+cD());
        //  Log.d("if(sFlag>dFlag:",""+cS());
        if (fd3 > fs3 && fd3 > fd4 && fd3 > fs4) {
            s += 123;
        } else if (fs3 > fd3 && fs3 > fd4 && fs3 > fs4) {
            s += 213;
        } else if (fd4 > fs3 && fd4 > fs3 && fd4 > fs4) {
            s += 114;
        } else if (fd3 > fs3 && fd3 > fd4 && fd3 > fs4) {
            s += 224;
        }


        return s;

    }

    public int getFd3() {
        return fd3;
    }

    public void setFd3(int fd3) {
        this.fd3 = fd3;
    }

    public int getFd4() {
        return fd4;
    }

    public void setFd4(int fd4) {
        this.fd4 = fd4;
    }

    public int getFs3() {
        return fs3;
    }

    public void setFs3(int fs3) {
        this.fs3 = fs3;
    }

    public int getFs4() {
        return fs4;
    }

    public void setFs4(int fs4) {
        this.fs4 = fs4;
    }

    public int getDsFlagT4() {
        return dsFlagT4;
    }

    public void setDsFlagT4(int dsFlagT4) {
        this.dsFlagT4 = dsFlagT4;
    }

    public int getZyFlagT4() {
        return zyFlagT4;
    }

    public void setZyFlagT4(int zyFlagT4) {
        this.zyFlagT4 = zyFlagT4;
    }

    public int getTzFlagF4() {
        return tzFlagF4;
    }

    public void setTzFlagF4(int tzFlagF4) {
        this.tzFlagF4 = tzFlagF4;
    }

    public int getDsFlagF4() {
        return dsFlagF4;
    }

    public void setDsFlagF4(int dsFlagF4) {
        this.dsFlagF4 = dsFlagF4;
    }

    public int getZyFlagF4() {
        return zyFlagF4;
    }

    public void setZyFlagF4(int zyFlagF4) {
        this.zyFlagF4 = zyFlagF4;
    }

    public int getTzFlagT4() {
        return tzFlagT4;
    }

    public void setTzFlagT4(int tzFlagT4) {
        this.tzFlagT4 = tzFlagT4;
    }

    public int getDsFlagT6() {
        return dsFlagT6;
    }

    public void setDsFlagT6(int dsFlagT6) {
        this.dsFlagT6 = dsFlagT6;
    }

    public int getZyFlagF6() {
        return zyFlagF6;
    }

    public void setZyFlagF6(int zyFlagF6) {
        this.zyFlagF6 = zyFlagF6;
    }

    public int getTzFlagT6() {
        return tzFlagT6;
    }

    public void setTzFlagT6(int tzFlagT6) {
        this.tzFlagT6 = tzFlagT6;
    }

    public int getDsFlagF6() {
        return dsFlagF6;
    }

    public void setDsFlagF6(int dsFlagF6) {
        this.dsFlagF6 = dsFlagF6;
    }

    public int getZyFlagT6() {
        return zyFlagT6;
    }

    public void setZyFlagT6(int zyFlagT6) {
        this.zyFlagT6 = zyFlagT6;
    }

    public int getTzFlagF6() {
        return tzFlagF6;
    }

    public void setTzFlagF6(int tzFlagF6) {
        this.tzFlagF6 = tzFlagF6;
    }

    public int getDFlag() {
        return dFlag;
    }

    public void setDFlag(int dFlag) {
        this.dFlag = dFlag;
    }

    public int getSFlag() {
        return sFlag;
    }

    public void setSFlag(int sFlag) {
        this.sFlag = sFlag;
    }

    public List<Integer> getDsList6() {
        return dsList6;
    }


    public List<Integer> getZyList6() {
        return zyList6;
    }


    public List<Integer> getTzList6() {
        return tzList6;
    }

    public List<Integer> getTzListT4() {
        return tzListT4;
    }

    public List<Integer> getDsListT6() {
        return dsListT6;
    }

    public List<Integer> getZyListT6() {
        return zyListT6;
    }

    public List<Integer> getTzListT6() {
        return tzListT6;
    }

    public List<TZData> getTzList() {
        return tzList;
    }

    public List<Integer> getDsListT4() {
        return dsListT4;
    }


    public List<Integer> getZyListT4() {
        return zyListT4;
    }

    public void initDSValueT() {
        if (tzList.size() > 9) {
            List<Integer> list = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < tzList.size() - 4; i++) {

                if ((tzList.get(i).getDsValue() + tzList.get(i + 1).getDsValue() + tzList.get(i + 2).getDsValue() + tzList.get(i + 3).getDsValue()) % 2 == 0) {
                    list.add(1);

                } else {
                    list.add(0);
                }


                if ((tzList.get(i).getZyValue() + tzList.get(i + 1).getZyValue() + tzList.get(i + 2).getZyValue() + tzList.get(i + 3).getZyValue()) % 2 == 0) {
                    list1.add(1);
                } else {
                    list1.add(0);
                }

                if ((tzList.get(i).getTzValue() + tzList.get(i + 1).getTzValue() + tzList.get(i + 2).getTzValue() + tzList.get(i + 3).getTzValue()) % 2 == 0) {
                    list2.add(1);
                } else {
                    list2.add(0);
                }

            }
            ds7_10 = list;
            zy7_10 = list1;
            tz7_10 = list2;
        } else {


        }
        if (tzList.size() > 9) {
            List<String> list = new ArrayList<>();
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            for (int i = 3; i < tzList.size() - 4; i++) {
                if (ds7_10.get(i) == 1) {

                    if ((tzList.get(i).getDsValue() + tzList.get(i + 1).getDsValue() + tzList.get(i + 2).getDsValue() == 3)) {
                        list.add("双");
                    } else if (tzList.get(i).getDsValue() + tzList.get(i + 1).getDsValue() + tzList.get(i + 2).getDsValue() == 4) {
                        list.add("单");

                    } else if (tzList.get(i).getDsValue() + tzList.get(i + 1).getDsValue() + tzList.get(i + 2).getDsValue() == 6) {
                        list.add("单");
                    } else if (tzList.get(i).getDsValue() + tzList.get(i + 1).getDsValue() + tzList.get(i + 2).getDsValue() == 5) {
                        list.add("双");
                    }
                } else {
                    if ((tzList.get(i).getDsValue() + tzList.get(i + 1).getDsValue() + tzList.get(i + 2).getDsValue() == 3)) {
                        list.add("单");

                    } else if (tzList.get(i).getDsValue() + tzList.get(i + 1).getDsValue() + tzList.get(i + 2).getDsValue() == 4) {
                        list.add("双");
                    } else if ((tzList.get(i).getDsValue() + tzList.get(i + 1).getDsValue() + tzList.get(i + 2).getDsValue() == 5)) {
                        list.add("单");

                    } else if ((tzList.get(i).getDsValue() + tzList.get(i + 1).getDsValue() + tzList.get(i + 2).getDsValue() == 6)) {
                        list.add("双");
                    }

                }
                if (zy7_10.get(i) == 1) {

                    if ((tzList.get(i).getZyValue() + tzList.get(i + 1).getZyValue() + tzList.get(i + 2).getZyValue() == 3)) {
                        list1.add("右");
                    } else if (tzList.get(i).getZyValue() + tzList.get(i + 1).getZyValue() + tzList.get(i + 2).getZyValue() == 4) {
                        list1.add("左");

                    } else if (tzList.get(i).getZyValue() + tzList.get(i + 1).getZyValue() + tzList.get(i + 2).getZyValue() == 6) {
                        list1.add("左");
                    } else if (tzList.get(i).getZyValue() + tzList.get(i + 1).getZyValue() + tzList.get(i + 2).getZyValue() == 5) {
                        list1.add("右");
                    }
                } else {
                    if ((tzList.get(i).getZyValue() + tzList.get(i + 1).getZyValue() + tzList.get(i + 2).getZyValue() == 3)) {
                        list1.add("左");

                    } else if (tzList.get(i).getZyValue() + tzList.get(i + 1).getZyValue() + tzList.get(i + 2).getZyValue() == 4) {
                        list1.add("右");
                    } else if ((tzList.get(i).getZyValue() + tzList.get(i + 1).getZyValue() + tzList.get(i + 2).getZyValue() == 5)) {
                        list1.add("左");

                    } else if ((tzList.get(i).getZyValue() + tzList.get(i + 1).getZyValue() + tzList.get(i + 2).getZyValue() == 6)) {
                        list1.add("右");
                    }

                }
                if (tz7_10.get(i) == 1) {

                    if ((tzList.get(i).getTzValue() + tzList.get(i + 1).getTzValue() + tzList.get(i + 2).getTzValue() == 9)) {
                        list2.add("4");
                    } else if (tzList.get(i).getTzValue() + tzList.get(i + 1).getTzValue() + tzList.get(i + 2).getTzValue() == 10) {
                        list2.add("3");

                    } else if (tzList.get(i).getTzValue() + tzList.get(i + 1).getTzValue() + tzList.get(i + 2).getTzValue() == 12) {
                        list2.add("3");
                    } else if (tzList.get(i).getTzValue() + tzList.get(i + 1).getTzValue() + tzList.get(i + 2).getTzValue() == 11) {
                        list2.add("4");
                    }
                } else {
                    if ((tzList.get(i).getTzValue() + tzList.get(i + 1).getTzValue() + tzList.get(i + 2).getTzValue() == 9)) {
                        list2.add("3");

                    } else if (tzList.get(i).getTzValue() + tzList.get(i + 1).getTzValue() + tzList.get(i + 2).getTzValue() == 10) {
                        list2.add("4");
                    } else if ((tzList.get(i).getTzValue() + tzList.get(i + 1).getTzValue() + tzList.get(i + 2).getTzValue() == 11)) {
                        list2.add("3");

                    } else if ((tzList.get(i).getTzValue() + tzList.get(i + 1).getTzValue() + tzList.get(i + 2).getTzValue() == 12)) {
                        list2.add("4");
                    }

                }


            }
            dsCurrent = list;
            zyCurrent = list1;
            tzCurrent = list2;
        } else {


        }

        if (tzList.size() > 3) {
            List<Integer> list = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < tzList.size() - 3; i++) {

                if ((tzList.get(i).getDsValue() + tzList.get(i + 1).getDsValue() + tzList.get(i + 2).getDsValue() + tzList.get(i + 3).getDsValue()) % 2 == 0) {
                    list.add(1);

                } else {
                    list.add(0);
                }


                if ((tzList.get(i).getZyValue() + tzList.get(i + 1).getZyValue() + tzList.get(i + 2).getZyValue() + tzList.get(i + 3).getZyValue()) % 2 == 0) {
                    list1.add(1);
                } else {
                    list1.add(0);
                }

                if ((tzList.get(i).getTzValue() + tzList.get(i + 1).getTzValue() + tzList.get(i + 2).getTzValue() + tzList.get(i + 3).getTzValue()) % 2 == 0) {
                    list2.add(1);
                } else {
                    list2.add(0);
                }

            }
            dsListT4 = list;
            zyListT4 = list1;
            tzListT4 = list2;
        } else {


        }

        if (tzList.size() > 5) {
            List<Integer> list = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int i = 0; i < tzList.size() - 5; i++) {

                if (((tzList.get(i).getDsValue() + tzList.get(i + 1).getDsValue() + tzList.get(i + 2).getDsValue() + tzList.get(i + 3).getDsValue() + tzList.get(i + 4).getDsValue() + tzList.get(i + 5).getDsValue()) == 8)) {
                    if ((tzList.get(i).getDsValue() + tzList.get(i + 1).getDsValue() + tzList.get(i + 2).getDsValue() + tzList.get(i + 3).getDsValue() + tzList.get(i + 4).getDsValue() == 7)) {
                        list.add(1);
                    } else {
                        list.add(0);
                    }
                } else if ((tzList.get(i).getDsValue() + tzList.get(i + 1).getDsValue() + tzList.get(i + 2).getDsValue() + tzList.get(i + 3).getDsValue() + tzList.get(i + 4).getDsValue() + tzList.get(i + 5).getDsValue()) == 10) {
                    if (tzList.get(i).getDsValue() + tzList.get(i + 1).getDsValue() + tzList.get(i + 2).getDsValue() + tzList.get(i + 3).getDsValue() + tzList.get(i + 4).getDsValue() == 8) {
                        list.add(1);
                    } else {
                        list.add(0);
                    }
                } else {
                    list.add(0);
                }


                if (((tzList.get(i).getZyValue() + tzList.get(i + 1).getZyValue() + tzList.get(i + 2).getZyValue() + tzList.get(i + 3).getZyValue() + tzList.get(i + 4).getZyValue() + tzList.get(i + 5).getZyValue()) == 8)) {
                    if ((tzList.get(i).getZyValue() + tzList.get(i + 1).getZyValue() + tzList.get(i + 2).getZyValue() + tzList.get(i + 3).getZyValue() + tzList.get(i + 4).getZyValue() == 7)) {
                        list1.add(1);
                    } else {
                        list1.add(0);
                    }
                } else if ((tzList.get(i).getZyValue() + tzList.get(i + 1).getZyValue() + tzList.get(i + 2).getZyValue() + tzList.get(i + 3).getZyValue() + tzList.get(i + 4).getZyValue() + tzList.get(i + 5).getZyValue()) == 10) {


                    if (tzList.get(i).getZyValue() + tzList.get(i + 1).getZyValue() + tzList.get(i + 2).getZyValue() + tzList.get(i + 3).getZyValue() + tzList.get(i + 4).getZyValue() == 8) {
                        list1.add(1);
                    } else {
                        list1.add(0);

                    }

                } else {
                    list1.add(0);
                }

                if (((tzList.get(i).getTzValue() + tzList.get(i + 1).getTzValue() + tzList.get(i + 2).getTzValue() + tzList.get(i + 3).getTzValue() + tzList.get(i + 4).getTzValue() + tzList.get(i + 5).getTzValue()) == 20)
                        || ((tzList.get(i).getTzValue() + tzList.get(i + 1).getTzValue() + tzList.get(i + 2).getTzValue() + tzList.get(i + 3).getTzValue() + tzList.get(i + 4).getTzValue() + tzList.get(i + 5).getTzValue()) == 22)) {
                    if ((tzList.get(i).getTzValue() + tzList.get(i + 1).getTzValue() + tzList.get(i + 2).getTzValue() + tzList.get(i + 3).getTzValue() + tzList.get(i + 4).getTzValue() == 17) ||
                            (tzList.get(i).getTzValue() + tzList.get(i + 1).getTzValue() + tzList.get(i + 2).getTzValue() + tzList.get(i + 3).getTzValue() + tzList.get(i + 4).getTzValue() == 18)) {
                        list2.add(1);
                    } else {
                        list2.add(0);
                    }
                } else {
                    list2.add(0);

                }
            }
            dsList6 = list;
            zyList6 = list1;
            tzList6 = list2;
        }

        if (dsListT4.size() > 5) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < dsListT4.size() - 5; i++) {

                if (((dsListT4.get(i) + dsListT4.get(i + 1) + dsListT4.get(i + 2) + dsListT4.get(i + 3) + dsListT4.get(i + 4) + dsListT4.get(i + 5)) == 2)
                        || ((dsListT4.get(i) + dsListT4.get(i + 1) + dsListT4.get(i + 2) + dsListT4.get(i + 3) + dsListT4.get(i + 4) + dsListT4.get(i + 5)) == 4)) {
                    if ((dsListT4.get(i) + dsListT4.get(i + 1) + dsListT4.get(i + 2) + dsListT4.get(i + 3) + dsListT4.get(i + 4) == 2) ||
                            (dsListT4.get(i) + dsListT4.get(i + 1) + dsListT4.get(i + 2) + dsListT4.get(i + 3) + dsListT4.get(i + 4) == 3)) {
                        list.add(1);
                    } else {
                        list.add(0);
                    }
                } else {
                    list.add(0);
                }

            }
            dsListT6 = list;
        }
        if (zyListT4.size() > 5) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < zyListT4.size() - 5; i++) {

                if (((zyListT4.get(i) + zyListT4.get(i + 1) + zyListT4.get(i + 2) + zyListT4.get(i + 3) + zyListT4.get(i + 4) + zyListT4.get(i + 5)) == 2)
                        || ((zyListT4.get(i) + zyListT4.get(i + 1) + zyListT4.get(i + 2) + zyListT4.get(i + 3) + zyListT4.get(i + 4) + zyListT4.get(i + 5)) == 4)) {
                    if ((zyListT4.get(i) + zyListT4.get(i + 1) + zyListT4.get(i + 2) + zyListT4.get(i + 3) + zyListT4.get(i + 4) == 2) ||
                            (zyListT4.get(i) + zyListT4.get(i + 1) + zyListT4.get(i + 2) + zyListT4.get(i + 3) + zyListT4.get(i + 4) == 3)) {
                        list.add(1);
                    } else {
                        list.add(0);
                    }
                } else {
                    list.add(0);
                }

            }


            zyListT6 = list;
        }
        if (tzListT4.size() > 5) {

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < tzListT4.size() - 5; i++) {

                if (((tzListT4.get(i) + tzListT4.get(i + 1) + tzListT4.get(i + 2) + tzListT4.get(i + 3) + tzListT4.get(i + 4) + tzListT4.get(i + 5)) == 2)
                        || ((tzListT4.get(i) + tzListT4.get(i + 1) + tzListT4.get(i + 2) + tzListT4.get(i + 3) + tzListT4.get(i + 4) + tzListT4.get(i + 5)) == 4)) {
                    if ((tzListT4.get(i) + tzListT4.get(i + 1) + tzListT4.get(i + 2) + tzListT4.get(i + 3) + tzListT4.get(i + 4) == 2) ||
                            (tzListT4.get(i) + tzListT4.get(i + 1) + tzListT4.get(i + 2) + tzListT4.get(i + 3) + tzListT4.get(i + 4) == 3)) {
                        list.add(1);
                    } else {
                        list.add(0);

                    }
                } else {
                    list.add(0);

                }
            }
            tzListT6 = list;

        }
    }

    public int cuD3() {
        int k = 0;
        for (int i = tzList.size(); i-- > 32; i -= 1) {
            if ((tzList.get(i - 21).getDsValue() == tzList.get(i - 10).getDsValue()) && tzList.get(i - 32).getDsValue() == tzList.get(i - 21).getDsValue()
                    && tzList.get(i - 21).getZyValue() == tzList.get(i - 10).getZyValue() && tzList.get(i - 32).getZyValue() == tzList.get(i - 21).getZyValue()
                    && tzList.get(i - 10).getDsValue() == 1 && tzList.get(i - 10).getTzValue() == 3) {
                k = 0;

            } else {
                k = 1;
            }
        }
        return k;
    }

    public int cuD4() {
        int k = 0;
        for (int i = tzList.size(); i-- > 32; i -= 1) {
            if ((tzList.get(i - 21).getDsValue() == tzList.get(i - 10).getDsValue()) && tzList.get(i - 32).getDsValue() == tzList.get(i - 21).getDsValue()
                    && tzList.get(i - 21).getZyValue() == tzList.get(i - 10).getZyValue() && tzList.get(i - 32).getZyValue() == tzList.get(i - 21).getZyValue()
                    && tzList.get(i - 10).getDsValue() == 1 && tzList.get(i - 10).getTzValue() == 4) {
                k = 0;

            } else {
                k = 1;
            }
        }
        return k;
    }

    public int cuS3() {
        int k = 0;
        for (int i = tzList.size(); i-- > 32; i -= 1) {
            if ((tzList.get(i - 21).getDsValue() == tzList.get(i - 10).getDsValue()) && tzList.get(i - 32).getDsValue() == tzList.get(i - 21).getDsValue()
                    && tzList.get(i - 21).getZyValue() == tzList.get(i - 10).getZyValue() && tzList.get(i - 32).getZyValue() == tzList.get(i - 21).getZyValue()
                    && tzList.get(i - 10).getDsValue() == 2 && tzList.get(i - 10).getTzValue() == 3) {
                k = 0;

            } else {
                k = 1;
            }
        }
        return k;
    }

    public int cuS4() {
        int k = 0;
        for (int i = tzList.size(); i-- > 32; i -= 1) {
            if ((tzList.get(i - 21).getDsValue() == tzList.get(i - 10).getDsValue()) && tzList.get(i - 32).getDsValue() == tzList.get(i - 21).getDsValue()
                    && tzList.get(i - 21).getZyValue() == tzList.get(i - 10).getZyValue() && tzList.get(i - 32).getZyValue() == tzList.get(i - 21).getZyValue()
                    && tzList.get(i - 10).getDsValue() == 2 && tzList.get(i - 10).getTzValue() == 4) {
                k = 0;

            } else {
                k = 1;
            }
        }
        return k;
    }

    public int cD() {
        if (dFlag > sFlag) {
            return 1;
        } else {
            return 0;
        }

    }

    public int cS() {
        if (sFlag > dFlag) {
            return 1;
        } else {

            return 0;
        }
    }

    public int cD6() {
        int k = 0;
        for (int i = 0; i < tzList.size() - 4; i++) {
            if ((tzList.get(i).getDsValue() + tzList.get(i + 1).getDsValue() + tzList.get(i + 2).getDsValue() + tzList.get(i + 3).getDsValue() + tzList.get(i + 4).getDsValue()) == 7) {
                k = 1;
            } else {
                k = 0;
            }

        }
        return k;
    }

    public int cS6() {
        int k = 0;
        for (int i = 0; i < tzList.size() - 4; i++) {
            if ((tzList.get(i).getDsValue() + tzList.get(i + 1).getDsValue() + tzList.get(i + 2).getDsValue() + tzList.get(i + 3).getDsValue() + tzList.get(i + 4).getDsValue()) == 8) {
                k = 1;
            } else {
                k = 0;
            }

        }
        return k;

    }

    public int cZ6() {
        int k = 0;
        for (int i = 0; i < tzList.size() - 4; i++) {
            if ((tzList.get(i).getDsValue() + tzList.get(i + 1).getDsValue() + tzList.get(i + 2).getDsValue() + tzList.get(i + 3).getDsValue() + tzList.get(i + 4).getDsValue()) == 7) {
                k = 1;
            } else {
                k = 0;
            }

        }
        return k;
    }

    public int cY6() {
        int k = 0;
        for (int i = 0; i < tzList.size() - 4; i++) {
            if ((tzList.get(i).getDsValue() + tzList.get(i + 1).getDsValue() + tzList.get(i + 2).getDsValue() + tzList.get(i + 3).getDsValue() + tzList.get(i + 4).getDsValue()) == 8) {
                k = 1;
            } else {
                k = 0;
            }

        }
        return k;
    }

    public int c36() {
        int k = 0;
        for (int i = 0; i < tzList.size() - 4; i++) {
            if ((tzList.get(i).getTzValue() + tzList.get(i + 1).getTzValue() + tzList.get(i + 2).getTzValue() + tzList.get(i + 3).getTzValue() + tzList.get(i + 4).getTzValue() == 17)) {
                k = 1;
            } else {
                k = 0;
            }

        }
        return k;
    }

    public int c46() {
        int k = 0;
        for (int i = 0; i < tzList.size() - 4; i++) {
            if ((tzList.get(i).getTzValue() + tzList.get(i + 1).getTzValue() + tzList.get(i + 2).getTzValue() + tzList.get(i + 3).getTzValue() + tzList.get(i + 4).getTzValue() == 18)) {
                k = 1;
            } else {
                k = 0;
            }

        }
        return k;
    }

    public int cD4() {
        int k = 0;
        for (int i = 0; i < dsListT4.size() - 4; i++) {
            if ((dsListT4.get(i) + dsListT4.get(i + 1) + dsListT4.get(i + 2) + dsListT4.get(i + 3) + dsListT4.get(i + 4) >= 4)
                    && (dsListT4.get(i) + dsListT4.get(i + 1) + dsListT4.get(i + 2) + dsListT4.get(i + 3) + dsListT4.get(i + 4)) % 2 == 0) {//返回0
                if (tzList.get(i + 2).getDsValue() + tzList.get(i + 3).getDsValue() + tzList.get(i + 4).getDsValue() == 4
                        || tzList.get(i + 2).getDsValue() + tzList.get(i + 3).getDsValue() + tzList.get(i + 4).getDsValue() == 3) {
                    k = 1;
                } else {
                    k = 0;
                }
            }
        }
        return k;
    }

    public int cS4() {
        int k = 0;
        for (int i = 0; i < dsListT4.size() - 4; i++) {
            if ((dsListT4.get(i) + dsListT4.get(i + 1) + dsListT4.get(i + 2) + dsListT4.get(i + 3) + dsListT4.get(i + 4) >= 4)
                    && (dsListT4.get(i) + dsListT4.get(i + 1) + dsListT4.get(i + 2) + dsListT4.get(i + 3) + dsListT4.get(i + 4)) % 2 == 0) {//返回0
                if (tzList.get(i + 2).getDsValue() + tzList.get(i + 3).getDsValue() + tzList.get(i + 4).getDsValue() == 5
                        || tzList.get(i + 2).getDsValue() + tzList.get(i + 3).getDsValue() + tzList.get(i + 4).getDsValue() == 6) {
                    k = 1;
                } else {
                    k = 0;
                }
            }
        }
        return k;
    }

    public int cZ4() {
        int k = 0;
        for (int i = 0; i < zyListT4.size() - 4; i++) {
            if ((zyListT4.get(i) + zyListT4.get(i + 1) + zyListT4.get(i + 2) + zyListT4.get(i + 3) + zyListT4.get(i + 4) >= 4)
                    && (zyListT4.get(i) + zyListT4.get(i + 1) + zyListT4.get(i + 2) + zyListT4.get(i + 3) + zyListT4.get(i + 4)) % 2 == 0) {//返回0
                if (tzList.get(i + 2).getZyValue() + tzList.get(i + 3).getZyValue() + tzList.get(i + 4).getZyValue() == 4
                        || tzList.get(i + 2).getZyValue() + tzList.get(i + 3).getZyValue() + tzList.get(i + 4).getZyValue() == 3) {
                    k = 1;
                } else {
                    k = 0;
                }
            }
        }
        return k;
    }

    public int cY4() {
        int k = 0;
        for (int i = 0; i < zyListT4.size() - 4; i++) {
            if ((zyListT4.get(i) + zyListT4.get(i + 1) + zyListT4.get(i + 2) + zyListT4.get(i + 3) + zyListT4.get(i + 4) >= 4)
                    && (zyListT4.get(i) + zyListT4.get(i + 1) + zyListT4.get(i + 2) + zyListT4.get(i + 3) + zyListT4.get(i + 4)) % 2 == 0) {//返回0
                if (tzList.get(i + 2).getZyValue() + tzList.get(i + 3).getZyValue() + tzList.get(i + 4).getZyValue() == 5
                        || tzList.get(i + 2).getZyValue() + tzList.get(i + 3).getZyValue() + tzList.get(i + 4).getZyValue() == 6) {
                    k = 1;
                } else {
                    k = 0;
                }
            }
        }
        return k;
    }

    public int c34() {
        int k = 0;
        for (int i = 0; i < tzListT4.size() - 4; i++) {
            if ((tzListT4.get(i) + tzListT4.get(i + 1) + tzListT4.get(i + 2) + tzListT4.get(i + 3) + tzListT4.get(i + 4) >= 4)
                    && (tzListT4.get(i) + tzListT4.get(i + 1) + tzListT4.get(i + 2) + tzListT4.get(i + 3) + tzListT4.get(i + 4)) % 2 == 0) {//返回0
                if (tzList.get(i + 2).getTzValue() + tzList.get(i + 3).getTzValue() + tzList.get(i + 4).getTzValue() == 10
                        || tzList.get(i + 2).getTzValue() + tzList.get(i + 3).getTzValue() + tzList.get(i + 4).getTzValue() == 9) {
                    k = 1;
                } else {
                    k = 0;
                }
            }
        }
        return k;
    }

    public int c44() {
        int k = 0;
        for (int i = 0; i < tzListT4.size() - 4; i++) {
            if ((tzListT4.get(i) + tzListT4.get(i + 1) + tzListT4.get(i + 2) + tzListT4.get(i + 3) + tzListT4.get(i + 4) >= 4)
                    && (tzListT4.get(i) + tzListT4.get(i + 1) + tzListT4.get(i + 2) + tzListT4.get(i + 3) + tzListT4.get(i + 4)) % 2 == 0) {//返回0
                if (tzList.get(i + 2).getTzValue() + tzList.get(i + 3).getTzValue() + tzList.get(i + 4).getTzValue() == 11
                        || tzList.get(i + 2).getTzValue() + tzList.get(i + 3).getTzValue() + tzList.get(i + 4).getTzValue() == 12) {
                    k = 1;
                } else {
                    k = 0;
                }
            }
        }
        return k;
    }

    public int cD46() {//审查ok  start
        int k = 0;
        for (int i = 0; i < dsListT6.size() - 5; i++) {
            if ((dsListT6.get(i) + dsListT6.get(i + 1) + dsListT6.get(i + 2) + dsListT6.get(i + 3) + dsListT6.get(i + 4)) == 3) {//返回1
                switch (dsListT4.get(i + 7) + dsListT4.get(i + 8) + dsListT4.get(i + 9)) {

                    case 3:
                        //1+1+1++1
                        switch (tzList.get(i + 10).getDsValue() + tzList.get(i + 11).getDsValue() + tzList.get(i + 12).getDsValue()) {
                            case 6:
                                //2+2+2
                                k = 0;
                                break;
                            case 5:
                                //2+2+1
                                k = 1;
                                break;
                            case 4:
                                //1+1+2
                                k = 0;
                                break;
                            case 3:
                                //1+1+1
                                k = 1;
                                break;
                        }
                        break;
                    case 2:
                        //1+1+0
                        switch (tzList.get(i + 10).getDsValue() + tzList.get(i + 11).getDsValue() + tzList.get(i + 12).getDsValue()) {
                            case 6:
                                //2+2+2
                                k = 1;
                                break;
                            case 5:
                                //2+2+1
                                k = 0;
                                break;
                            case 4:
                                //1+1+2
                                k = 1;
                                break;
                            case 3:
                                //1+1+1
                                k = 0;
                                break;
                        }
                        break;
                    case 1:
                        //1+0+0
                        switch (tzList.get(i + 10).getDsValue() + tzList.get(i + 11).getDsValue() + tzList.get(i + 12).getDsValue()) {
                            case 6:
                                //2+2+2
                                k = 0;
                                break;
                            case 5:
                                //2+2+1
                                k = 1;
                                break;
                            case 4:
                                //1+1+2
                                k = 0;
                                break;
                            case 3:
                                //1+1+1
                                k = 1;
                                break;
                        }
                        break;
                    case 0:
                        //0+0+0
                        switch (tzList.get(i + 10).getDsValue() + tzList.get(i + 11).getDsValue() + tzList.get(i + 12).getDsValue()) {
                            case 6:
                                //2+2+2
                                k = 1;
                                break;
                            case 5:
                                //2+2+1
                                k = 0;
                                break;
                            case 4:
                                //1+1+2
                                k = 1;
                                break;
                            case 3:
                                //1+1+1
                                k = 0;
                                break;
                        }
                        break;


                }

            } else if ((dsListT6.get(i) + dsListT6.get(i + 1) + dsListT6.get(i + 2) + dsListT6.get(i + 3) + dsListT6.get(i + 4)) == 2) {//返回0
                switch (dsListT4.get(i + 7) + dsListT4.get(i + 8) + dsListT4.get(i + 9)) {

                    case 3:
                        //1+1+1++1
                        switch (tzList.get(i + 10).getDsValue() + tzList.get(i + 11).getDsValue() + tzList.get(i + 12).getDsValue()) {
                            case 6:
                                //2+2+2
                                k = 1;
                                break;
                            case 5:
                                //2+2+1
                                k = 0;
                                break;
                            case 4:
                                //1+1+2
                                k = 1;
                                break;
                            case 3:
                                //1+1+1
                                k = 0;
                                break;
                        }
                        break;
                    case 2:
                        //1+1+0
                        switch (tzList.get(i + 10).getDsValue() + tzList.get(i + 11).getDsValue() + tzList.get(i + 12).getDsValue()) {
                            case 6:
                                //2+2+2
                                k = 0;
                                break;
                            case 5:
                                //2+2+1
                                k = 1;
                                break;
                            case 4:
                                //1+1+2
                                k = 0;
                                break;
                            case 3:
                                //1+1+1
                                k = 1;
                                break;
                        }
                        break;
                    case 1:
                        //1+0+0
                        switch (tzList.get(i + 10).getDsValue() + tzList.get(i + 11).getDsValue() + tzList.get(i + 12).getDsValue()) {
                            case 6:
                                //2+2+2
                                k = 1;
                                break;
                            case 5:
                                //2+2+1
                                k = 0;
                                break;
                            case 4:
                                //1+1+2
                                k = 1;
                                break;
                            case 3:
                                //1+1+1
                                k = 0;
                                break;
                        }
                        break;
                    case 0:
                        //0+0+0
                        switch (tzList.get(i + 10).getDsValue() + tzList.get(i + 11).getDsValue() + tzList.get(i + 12).getDsValue()) {
                            case 6:
                                //2+2+2
                                k = 0;
                                break;
                            case 5:
                                //2+2+1
                                k = 1;
                                break;
                            case 4:
                                //1+1+2
                                k = 0;
                                break;
                            case 3:
                                //1+1+1
                                k = 1;
                                break;
                        }
                        break;


                }

            }

        }
        return k;

        //over
    }//审查ok start

    public int cS46() {
        int k = 0;
        for (int i = 0; i < dsListT6.size() - 5; i++) {
            if ((dsListT6.get(i) + dsListT6.get(i + 1) + dsListT6.get(i + 2) + dsListT6.get(i + 3) + dsListT6.get(i + 4)) == 3) {//返回1
                switch (dsListT4.get(i + 7) + dsListT4.get(i + 8) + dsListT4.get(i + 9)) {

                    case 3:
                        //1+1+1++1
                        switch (tzList.get(i + 10).getDsValue() + tzList.get(i + 11).getDsValue() + tzList.get(i + 12).getDsValue()) {
                            case 6:
                                //2+2+2
                                k = 1;
                                break;
                            case 5:
                                //2+2+1
                                k = 0;
                                break;
                            case 4:
                                //1+1+2
                                k = 1;
                                break;
                            case 3:
                                //1+1+1
                                k = 0;
                                break;
                        }
                        break;
                    case 2:
                        //1+1+0
                        switch (tzList.get(i + 10).getDsValue() + tzList.get(i + 11).getDsValue() + tzList.get(i + 12).getDsValue()) {
                            case 6:
                                //2+2+2
                                k = 0;
                                break;
                            case 5:
                                //2+2+1
                                k = 1;
                                break;
                            case 4:
                                //1+1+2
                                k = 0;
                                break;
                            case 3:
                                //1+1+1
                                k = 1;
                                break;
                        }
                        break;
                    case 1:
                        //1+0+0
                        switch (tzList.get(i + 10).getDsValue() + tzList.get(i + 11).getDsValue() + tzList.get(i + 12).getDsValue()) {
                            case 6:
                                //2+2+2
                                k = 1;
                                break;
                            case 5:
                                //2+2+1
                                k = 0;
                                break;
                            case 4:
                                //1+1+2
                                k = 1;
                                break;
                            case 3:
                                //1+1+1
                                k = 0;
                                break;
                        }
                        break;
                    case 0:
                        //0+0+0
                        switch (tzList.get(i + 10).getDsValue() + tzList.get(i + 11).getDsValue() + tzList.get(i + 12).getDsValue()) {
                            case 6:
                                //2+2+2
                                k = 0;
                                break;
                            case 5:
                                //2+2+1
                                k = 1;
                                break;
                            case 4:
                                //1+1+2
                                k = 0;
                                break;
                            case 3:
                                //1+1+1
                                k = 1;
                                break;
                        }
                        break;


                }

            } else if ((dsListT6.get(i) + dsListT6.get(i + 1) + dsListT6.get(i + 2) + dsListT6.get(i + 3) + dsListT6.get(i + 4)) == 2) {//返回0
                switch (dsListT4.get(i + 7) + dsListT4.get(i + 8) + dsListT4.get(i + 9)) {

                    case 3:
                        //1+1+1++1
                        switch (tzList.get(i + 10).getDsValue() + tzList.get(i + 11).getDsValue() + tzList.get(i + 12).getDsValue()) {
                            case 6:
                                //2+2+2
                                k = 0;
                                break;
                            case 5:
                                //2+2+1
                                k = 1;
                                break;
                            case 4:
                                //1+1+2
                                k = 0;
                                break;
                            case 3:
                                //1+1+1
                                k = 1;
                                break;
                        }
                        break;
                    case 2:
                        //1+1+0
                        switch (tzList.get(i + 10).getDsValue() + tzList.get(i + 11).getDsValue() + tzList.get(i + 12).getDsValue()) {
                            case 6:
                                //2+2+2
                                k = 1;
                                break;
                            case 5:
                                //2+2+1
                                k = 0;
                                break;
                            case 4:
                                //1+1+2
                                k = 1;
                                break;
                            case 3:
                                //1+1+1
                                k = 0;
                                break;
                        }
                        break;
                    case 1:
                        //1+0+0
                        switch (tzList.get(i + 10).getDsValue() + tzList.get(i + 11).getDsValue() + tzList.get(i + 12).getDsValue()) {
                            case 6:
                                //2+2+2
                                k = 0;
                                break;
                            case 5:
                                //2+2+1
                                k = 1;
                                break;
                            case 4:
                                //1+1+2
                                k = 0;
                                break;
                            case 3:
                                //1+1+1
                                k = 1;
                                break;
                        }
                        break;
                    case 0:
                        //0+0+0
                        switch (tzList.get(i + 10).getDsValue() + tzList.get(i + 11).getDsValue() + tzList.get(i + 12).getDsValue()) {
                            case 6:
                                //2+2+2
                                k = 1;
                                break;
                            case 5:
                                //2+2+1
                                k = 0;
                                break;
                            case 4:
                                //1+1+2
                                k = 1;
                                break;
                            case 3:
                                //1+1+1
                                k = 0;
                                break;
                        }
                        break;


                }

            }

        }
        return k;
        //over

    }//strat

    public int cZ46() {
        int k = 0;
        for (int i = 0; i < zyListT6.size() - 5; i++) {
            if ((zyListT6.get(i) + zyListT6.get(i + 1) + zyListT6.get(i + 2) + zyListT6.get(i + 3) + zyListT6.get(i + 4)) == 3) {//返回1
                switch (zyListT4.get(i + 7) + zyListT4.get(i + 8) + zyListT4.get(i + 9)) {

                    case 3:
                        //1+1+1++1
                        switch (tzList.get(i + 10).getZyValue() + tzList.get(i + 11).getZyValue() + tzList.get(i + 12).getZyValue()) {
                            case 6:
                                //2+2+2
                                k = 0;
                                break;
                            case 5:
                                //2+2+1
                                k = 1;
                                break;
                            case 4:
                                //1+1+2
                                k = 0;
                                break;
                            case 3:
                                //1+1+1
                                k = 1;
                                break;
                        }
                        break;
                    case 2:
                        //1+1+0
                        switch (tzList.get(i + 10).getZyValue() + tzList.get(i + 11).getZyValue() + tzList.get(i + 12).getZyValue()) {
                            case 6:
                                //2+2+2
                                k = 1;
                                break;
                            case 5:
                                //2+2+1
                                k = 0;
                                break;
                            case 4:
                                //1+1+2
                                k = 1;
                                break;
                            case 3:
                                //1+1+1
                                k = 0;
                                break;
                        }
                        break;
                    case 1:
                        //1+0+0
                        switch (tzList.get(i + 10).getZyValue() + tzList.get(i + 11).getZyValue() + tzList.get(i + 12).getZyValue()) {
                            case 6:
                                //2+2+2
                                k = 0;
                                break;
                            case 5:
                                //2+2+1
                                k = 1;
                                break;
                            case 4:
                                //1+1+2
                                k = 0;
                                break;
                            case 3:
                                //1+1+1
                                k = 1;
                                break;
                        }
                        break;
                    case 0:
                        //0+0+0
                        switch (tzList.get(i + 10).getZyValue() + tzList.get(i + 11).getZyValue() + tzList.get(i + 12).getZyValue()) {
                            case 6:
                                //2+2+2
                                k = 1;
                                break;
                            case 5:
                                //2+2+1
                                k = 0;
                                break;
                            case 4:
                                //1+1+2
                                k = 1;
                                break;
                            case 3:
                                //1+1+1
                                k = 0;
                                break;
                        }
                        break;


                }

            } else if ((zyListT6.get(i) + zyListT6.get(i + 1) + zyListT6.get(i + 2) + zyListT6.get(i + 3) + zyListT6.get(i + 4)) == 2) {//返回0
                switch (zyListT4.get(i + 7) + zyListT4.get(i + 8) + zyListT4.get(i + 9)) {

                    case 3:
                        //1+1+1++1
                        switch (tzList.get(i + 10).getZyValue() + tzList.get(i + 11).getZyValue() + tzList.get(i + 12).getZyValue()) {
                            case 6:
                                //2+2+2
                                k = 1;
                                break;
                            case 5:
                                //2+2+1
                                k = 0;
                                break;
                            case 4:
                                //1+1+2
                                k = 1;
                                break;
                            case 3:
                                //1+1+1
                                k = 0;
                                break;
                        }
                        break;
                    case 2:
                        //1+1+0
                        switch (tzList.get(i + 10).getZyValue() + tzList.get(i + 11).getZyValue() + tzList.get(i + 12).getZyValue()) {
                            case 6:
                                //2+2+2
                                k = 0;
                                break;
                            case 5:
                                //2+2+1
                                k = 1;
                                break;
                            case 4:
                                //1+1+2
                                k = 0;
                                break;
                            case 3:
                                //1+1+1
                                k = 1;
                                break;
                        }
                        break;
                    case 1:
                        //1+0+0
                        switch (tzList.get(i + 10).getZyValue() + tzList.get(i + 11).getZyValue() + tzList.get(i + 12).getZyValue()) {
                            case 6:
                                //2+2+2
                                k = 1;
                                break;
                            case 5:
                                //2+2+1
                                k = 0;
                                break;
                            case 4:
                                //1+1+2
                                k = 1;
                                break;
                            case 3:
                                //1+1+1
                                k = 0;
                                break;
                        }
                        break;
                    case 0:
                        //0+0+0
                        switch (tzList.get(i + 10).getZyValue() + tzList.get(i + 11).getZyValue() + tzList.get(i + 12).getZyValue()) {
                            case 6:
                                //2+2+2
                                k = 0;
                                break;
                            case 5:
                                //2+2+1
                                k = 1;
                                break;
                            case 4:
                                //1+1+2
                                k = 0;
                                break;
                            case 3:
                                //1+1+1
                                k = 1;
                                break;
                        }
                        break;


                }

            }

        }
        return k;

        //over
    }//start

    public int cY46() {
        int k = 0;
        for (int i = 0; i < zyListT6.size() - 5; i++) {
            if ((zyListT6.get(i) + zyListT6.get(i + 1) + zyListT6.get(i + 2) + zyListT6.get(i + 3) + zyListT6.get(i + 4)) == 3) {//返回1
                switch (zyListT4.get(i + 7) + zyListT4.get(i + 8) + zyListT4.get(i + 9)) {

                    case 3:
                        //1+1+1++1
                        switch (tzList.get(i + 10).getZyValue() + tzList.get(i + 11).getZyValue() + tzList.get(i + 12).getZyValue()) {
                            case 6:
                                //2+2+2
                                k = 1;
                                break;
                            case 5:
                                //2+2+1
                                k = 0;
                                break;
                            case 4:
                                //1+1+2
                                k = 1;
                                break;
                            case 3:
                                //1+1+1
                                k = 0;
                                break;
                        }
                        break;
                    case 2:
                        //1+1+0
                        switch (tzList.get(i + 10).getZyValue() + tzList.get(i + 11).getZyValue() + tzList.get(i + 12).getZyValue()) {
                            case 6:
                                //2+2+2
                                k = 0;
                                break;
                            case 5:
                                //2+2+1
                                k = 1;
                                break;
                            case 4:
                                //1+1+2
                                k = 0;
                                break;
                            case 3:
                                //1+1+1
                                k = 1;
                                break;
                        }
                        break;
                    case 1:
                        //1+0+0
                        switch (tzList.get(i + 10).getZyValue() + tzList.get(i + 11).getZyValue() + tzList.get(i + 12).getZyValue()) {
                            case 6:
                                //2+2+2
                                k = 1;
                                break;
                            case 5:
                                //2+2+1
                                k = 0;
                                break;
                            case 4:
                                //1+1+2
                                k = 1;
                                break;
                            case 3:
                                //1+1+1
                                k = 0;
                                break;
                        }
                        break;
                    case 0:
                        //0+0+0
                        switch (tzList.get(i + 10).getZyValue() + tzList.get(i + 11).getZyValue() + tzList.get(i + 12).getZyValue()) {
                            case 6:
                                //2+2+2
                                k = 0;
                                break;
                            case 5:
                                //2+2+1
                                k = 1;
                                break;
                            case 4:
                                //1+1+2
                                k = 0;
                                break;
                            case 3:
                                //1+1+1
                                k = 1;
                                break;
                        }
                        break;


                }

            } else if ((zyListT6.get(i) + zyListT6.get(i + 1) + zyListT6.get(i + 2) + zyListT6.get(i + 3) + zyListT6.get(i + 4)) == 2) {//返回0
                switch (zyListT4.get(i + 7) + zyListT4.get(i + 8) + zyListT4.get(i + 9)) {

                    case 3:
                        //1+1+1++1
                        switch (tzList.get(i + 10).getZyValue() + tzList.get(i + 11).getZyValue() + tzList.get(i + 12).getZyValue()) {
                            case 6:
                                //2+2+2
                                k = 0;
                                break;
                            case 5:
                                //2+2+1
                                k = 1;
                                break;
                            case 4:
                                //1+1+2
                                k = 0;
                                break;
                            case 3:
                                //1+1+1
                                k = 1;
                                break;
                        }
                        break;
                    case 2:
                        //1+1+0
                        switch (tzList.get(i + 10).getZyValue() + tzList.get(i + 11).getZyValue() + tzList.get(i + 12).getZyValue()) {
                            case 6:
                                //2+2+2
                                k = 1;
                                break;
                            case 5:
                                //2+2+1
                                k = 0;
                                break;
                            case 4:
                                //1+1+2
                                k = 1;
                                break;
                            case 3:
                                //1+1+1
                                k = 0;
                                break;
                        }
                        break;
                    case 1:
                        //1+0+0
                        switch (tzList.get(i + 10).getZyValue() + tzList.get(i + 11).getZyValue() + tzList.get(i + 12).getZyValue()) {
                            case 6:
                                //2+2+2
                                k = 0;
                                break;
                            case 5:
                                //2+2+1
                                k = 1;
                                break;
                            case 4:
                                //1+1+2
                                k = 0;
                                break;
                            case 3:
                                //1+1+1
                                k = 1;
                                break;
                        }
                        break;
                    case 0:
                        //0+0+0
                        switch (tzList.get(i + 10).getZyValue() + tzList.get(i + 11).getZyValue() + tzList.get(i + 12).getZyValue()) {
                            case 6:
                                //2+2+2
                                k = 1;
                                break;
                            case 5:
                                //2+2+1
                                k = 0;
                                break;
                            case 4:
                                //1+1+2
                                k = 1;
                                break;
                            case 3:
                                //1+1+1
                                k = 0;
                                break;
                        }
                        break;


                }

            }

        }
        return k;

        //over
    }//start

    public int c346() {
        int k = 0;
        for (int i = 0; i < tzListT6.size() - 5; i++) {
            if ((tzListT6.get(i) + tzListT6.get(i + 1) + tzListT6.get(i + 2) + tzListT6.get(i + 3) + tzListT6.get(i + 4)) == 3) {//返回1
                switch (tzListT4.get(i + 7) + tzListT4.get(i + 8) + tzListT4.get(i + 9)) {

                    case 3:
                        //1+1+1++1
                        switch (tzList.get(i + 10).getTzValue() + tzList.get(i + 11).getTzValue() + tzList.get(i + 12).getTzValue()) {
                            case 12:
                                //4+4+4
                                k = 0;
                                break;
                            case 11:
                                //4+4+3
                                k = 1;
                                break;
                            case 10:
                                //3+3+4
                                k = 0;
                                break;
                            case 9:
                                //3+3+3
                                k = 1;
                                break;
                        }
                        break;
                    case 2:
                        //1+1+0
                        switch (tzList.get(i + 10).getTzValue() + tzList.get(i + 11).getTzValue() + tzList.get(i + 12).getTzValue()) {
                            case 12:
                                //4+4+4
                                k = 1;
                                break;
                            case 11:
                                //4+4+3
                                k = 0;
                                break;
                            case 10:
                                //3+3+4
                                k = 1;
                                break;
                            case 9:
                                //3+3+3
                                k = 0;
                                break;
                        }
                        break;
                    case 1:
                        //1+0+0
                        switch (tzList.get(i + 10).getTzValue() + tzList.get(i + 11).getTzValue() + tzList.get(i + 12).getTzValue()) {
                            case 12:
                                //4+4+4
                                k = 0;
                                break;
                            case 11:
                                //4+4+3
                                k = 1;
                                break;
                            case 10:
                                //3+3+4
                                k = 0;
                                break;
                            case 9:
                                //3+3+3
                                k = 1;
                                break;
                        }
                        break;
                    case 0:
                        //0+0+0
                        switch (tzList.get(i + 10).getTzValue() + tzList.get(i + 11).getTzValue() + tzList.get(i + 12).getTzValue()) {
                            case 12:
                                //4+4+4
                                k = 1;
                                break;
                            case 11:
                                //4+4+3
                                k = 0;
                                break;
                            case 10:
                                //3+3+4
                                k = 1;
                                break;
                            case 9:
                                //3+3+3
                                k = 0;
                                break;
                        }
                        break;


                }

            } else if ((tzListT6.get(i) + tzListT6.get(i + 1) + tzListT6.get(i + 2) + tzListT6.get(i + 3) + tzListT6.get(i + 4)) == 2) {//返回0
                switch (tzListT4.get(i + 7) + tzListT4.get(i + 8) + tzListT4.get(i + 9)) {

                    case 3:
                        //1+1+1++0
                        switch (tzList.get(i + 10).getTzValue() + tzList.get(i + 11).getTzValue() + tzList.get(i + 12).getTzValue()) {
                            case 12:
                                //4+4+4
                                k = 1;
                                break;
                            case 11:
                                //4+4+3
                                k = 0;
                                break;
                            case 10:
                                //3+3+4
                                k = 1;
                                break;
                            case 9:
                                //3+3+3
                                k = 0;
                                break;
                        }
                        break;
                    case 2:
                        //1+1+0
                        switch (tzList.get(i + 10).getTzValue() + tzList.get(i + 11).getTzValue() + tzList.get(i + 12).getTzValue()) {
                            case 12:
                                //4+4+4
                                k = 0;
                                break;
                            case 11:
                                //4+4+3
                                k = 1;
                                break;
                            case 10:
                                //3+3+4
                                k = 0;
                                break;
                            case 9:
                                //3+3+3
                                k = 1;
                                break;
                        }
                        break;
                    case 1:
                        //1+0+0
                        switch (tzList.get(i + 10).getTzValue() + tzList.get(i + 11).getTzValue() + tzList.get(i + 12).getTzValue()) {
                            case 12:
                                //4+4+4
                                k = 1;
                                break;
                            case 11:
                                //4+4+3
                                k = 0;
                                break;
                            case 10:
                                //3+3+4
                                k = 1;
                                break;
                            case 9:
                                //3+3+3
                                k = 0;
                                break;
                        }
                        break;
                    case 0:
                        //0+0+0
                        switch (tzList.get(i + 10).getTzValue() + tzList.get(i + 11).getTzValue() + tzList.get(i + 12).getTzValue()) {
                            case 12:
                                //4+4+4
                                k = 0;
                                break;
                            case 11:
                                //4+4+3
                                k = 1;
                                break;
                            case 10:
                                //3+3+4
                                k = 0;
                                break;
                            case 9:
                                //3+3+3
                                k = 1;
                                break;
                        }
                        break;


                }

            }

        }
        return k;
        //over

    }//start

    public int c446() {
        int k = 0;
        for (int i = 0; i < tzListT6.size() - 5; i++) {
            if ((tzListT6.get(i) + tzListT6.get(i + 1) + tzListT6.get(i + 2) + tzListT6.get(i + 3) + tzListT6.get(i + 4)) == 3) {//返回1
                switch (tzListT4.get(i + 7) + tzListT4.get(i + 8) + tzListT4.get(i + 9)) {

                    case 3:
                        //1+1+1++1
                        switch (tzList.get(i + 10).getTzValue() + tzList.get(i + 11).getTzValue() + tzList.get(i + 12).getTzValue()) {
                            case 6:
                                //4+4+4
                                k = 1;
                                break;
                            case 5:
                                //4+4+3
                                k = 0;
                                break;
                            case 4:
                                //3+3+4
                                k = 1;
                                break;
                            case 3:
                                //3+3+3
                                k = 0;
                                break;
                        }
                        break;
                    case 2:
                        //1+1+0
                        switch (tzList.get(i + 10).getTzValue() + tzList.get(i + 11).getTzValue() + tzList.get(i + 12).getTzValue()) {
                            case 6:
                                //4+4+4
                                k = 0;
                                break;
                            case 5:
                                //4+4+3
                                k = 1;
                                break;
                            case 4:
                                //3+3+4
                                k = 0;
                                break;
                            case 3:
                                //3+3+3
                                k = 1;
                                break;
                        }
                        break;
                    case 1:
                        //1+0+0
                        switch (tzList.get(i + 10).getTzValue() + tzList.get(i + 11).getTzValue() + tzList.get(i + 12).getTzValue()) {
                            case 6:
                                //4+4+4
                                k = 1;
                                break;
                            case 5:
                                //4+4+3
                                k = 0;
                                break;
                            case 4:
                                //3+3+4
                                k = 1;
                                break;
                            case 3:
                                //3+3+3
                                k = 0;
                                break;
                        }
                        break;
                    case 0:
                        //0+0+0
                        switch (tzList.get(i + 10).getTzValue() + tzList.get(i + 11).getTzValue() + tzList.get(i + 12).getTzValue()) {
                            case 6:
                                //4+4+4
                                k = 0;
                                break;
                            case 5:
                                //4+4+3
                                k = 1;
                                break;
                            case 4:
                                //3+3+4
                                k = 0;
                                break;
                            case 3:
                                //3+3+3
                                k = 1;
                                break;
                        }
                        break;


                }

            } else if ((tzListT6.get(i) + tzListT6.get(i + 1) + tzListT6.get(i + 2) + tzListT6.get(i + 3) + tzListT6.get(i + 4)) == 2) {//返回0
                switch (tzListT4.get(i + 7) + tzListT4.get(i + 8) + tzListT4.get(i + 9)) {

                    case 3:
                        //1+1+1++0
                        switch (tzList.get(i + 10).getTzValue() + tzList.get(i + 11).getTzValue() + tzList.get(i + 12).getTzValue()) {
                            case 6:
                                //4+4+4
                                k = 0;
                                break;
                            case 5:
                                //4+4+3
                                k = 1;
                                break;
                            case 4:
                                //3+3+4
                                k = 0;
                                break;
                            case 3:
                                //3+3+3
                                k = 1;
                                break;
                        }
                        break;
                    case 2:
                        //1+1+0
                        switch (tzList.get(i + 10).getTzValue() + tzList.get(i + 11).getTzValue() + tzList.get(i + 12).getTzValue()) {
                            case 6:
                                //4+4+4
                                k = 1;
                                break;
                            case 5:
                                //4+4+3
                                k = 0;
                                break;
                            case 4:
                                //3+3+4
                                k = 1;
                                break;
                            case 3:
                                //3+3+3
                                k = 0;
                                break;
                        }
                        break;
                    case 1:
                        //1+0+0
                        switch (tzList.get(i + 10).getTzValue() + tzList.get(i + 11).getTzValue() + tzList.get(i + 12).getTzValue()) {
                            case 6:
                                //4+4+4
                                k = 0;
                                break;
                            case 5:
                                //4+4+3
                                k = 1;
                                break;
                            case 4:
                                //3+3+4
                                k = 0;
                                break;
                            case 3:
                                //3+3+3
                                k = 1;
                                break;
                        }
                        break;
                    case 0:
                        //0+0+0
                        switch (tzList.get(i + 10).getTzValue() + tzList.get(i + 11).getTzValue() + tzList.get(i + 12).getTzValue()) {
                            case 6:
                                //4+4+4
                                k = 1;
                                break;
                            case 5:
                                //4+4+3
                                k = 0;
                                break;
                            case 4:
                                //3+3+4
                                k = 1;
                                break;
                            case 3:
                                //3+3+3
                                k = 0;
                                break;
                        }
                        break;


                }

            }

        }
        return k;
    }//over

    public int CD3data() {
        if (tzList.size() > 3) {
            Log.e("fffffff", tzList.get(tzList.size() - 2).getTzValue() + "单");
            if (tzList.get(tzList.size() - 2).getTzValue() == 3 && tzList.get(tzList.size() - 3).getZyValue() == 2) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }

    public int CD4data() {
        if (tzList.size() > 3) {
            Log.v("fffffff", tzList.get(tzList.size() - 3).getTzValue() + "单");
            if (tzList.get(tzList.size() - 3).getTzValue() == 4 && tzList.get(tzList.size() - 3).getZyValue() == 1) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }

    public int CS3data() {
        if (tzList.size() > 3) {
            Log.i("fffffff", tzList.get(tzList.size() - 2).getTzValue() + "双");
            if (tzList.get(tzList.size() - 2).getTzValue() == 3 && tzList.get(tzList.size() - 3).getZyValue() == 1) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }

    public int CS4data() {
        if (tzList.size() > 3) {
            Log.d("fffffff", tzList.get(tzList.size() - 3).getTzValue() + "双");
            if (tzList.get(tzList.size() - 3).getTzValue() == 4 && tzList.get(tzList.size() - 3).getZyValue() == 2) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }

    //初始化预测数据为String泛型
    public List<String> currentData() {
        List<String> s = new ArrayList<>();
        for (int i = 0; i < dsCurrent.size() - 1; i++) {
            if (i == 0 || (i % 3 == 0)) {
                s.add(dsCurrent.get(i).toString() + zyCurrent.get(i).toString());
                Log.v("12-----", (dsCurrent.get(i).toString() + zyCurrent.get(i).toString()));
            } else if (i == 1 || (i % 3 == 1)) {
                s.add(zyCurrent.get(i).toString() + tzCurrent.get(i).toString());
                Log.v("23-----", (dsCurrent.get(i).toString() + zyCurrent.get(i).toString()));
            } else if (i == 2 || (i % 3 == 2)) {
                s.add(dsCurrent.get(i).toString() + tzCurrent.get(i).toString());
                Log.v("13-----", (dsCurrent.get(i).toString() + zyCurrent.get(i).toString()));
            }
        }
        return s;
    }
}
