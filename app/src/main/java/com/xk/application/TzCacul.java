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

    private List<TZData> tzList = new CopyOnWriteArrayList<>();//原始数据
    private List<Integer> ds7_10 = Collections.synchronizedList(new ArrayList<>());
    private List<Integer> zy7_10 = Collections.synchronizedList(new ArrayList<>());
    private List<Integer> tz7_10 = Collections.synchronizedList(new ArrayList<>());
    private List<String> dsCurrent = Collections.synchronizedList(new ArrayList<>());
    private List<String> zyCurrent = Collections.synchronizedList(new ArrayList<>());
    private List<String> tzCurrent = Collections.synchronizedList(new ArrayList<>());


    public TzCacul() {

    }


    public List<TZData> getTzList() {
        return tzList;
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
