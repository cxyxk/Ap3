package com.xk.application;

/*
  @Author xk @Date 2023/04/18 23:42
 */

import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GuestFragment extends Fragment {


    // Browser实体集合
    private final List<Browser> browsers = new ArrayList<>();
    BrowserAdapter adapter;
    TzCacul tzCacul = new TzCacul();
    int cycle = 0;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_guest, null);
        // 初始化数据
        final int[] imageId = new int[]{R.drawable.ic_d3, R.drawable.ic_s3, R.drawable.ic_d4, R.drawable.ic_s4, R.drawable.ic_solid};
        final String[] check = new String[]{"不提供", "错", "对"};
        // 初始化适配器
        adapter = new BrowserAdapter(getActivity(), R.layout.browser_item, browsers);
        ListView listView = view.findViewById(R.id.list_view);
        listView.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        listView.setAdapter(adapter);
        final TextView tvcurrent = view.findViewById(R.id.tvcurrent);
        Button g_d3 = view.findViewById(R.id.g_d3);
        Button g_s3 = view.findViewById(R.id.g_s3);
        Button g_d4 = view.findViewById(R.id.g_d4);
        Button g_s4 = view.findViewById(R.id.g_s4);
        Button g_ht = view.findViewById(R.id.g_ht);
        g_d3.setOnClickListener(view1 -> {
            Calendar ca = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                ca = Calendar.getInstance(Locale.US);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                cycle = (ca.get(Calendar.HOUR) * 60) + (ca.get(Calendar.MINUTE) + 1);
            }
            String datet = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                datet = "第" + ca.get(Calendar.YEAR) + "0" + ((ca.get(Calendar.MONTH)) + 1) + ca.get(Calendar.DATE) + cycle + "期";
            }
            tzCacul.getTzList().add(new TZData("<font color='#0072E3'>" + getString(R.string.d3) + "</font>", getString(R.string.you), 1, 2, 3));

            tzCacul.initDSValueT();
            adapter.add(new Browser(datet, imageId[yuced3()], R.drawable.ic_solid, R.drawable.ic_d3, check[checkD3()]));
            if (tzCacul.currentData().size() > 0) {
                tvcurrent.setText(tzCacul.currentData().get(tzCacul.currentData().size() - 1));
            }
        });
        g_s3.setOnClickListener(view12 -> {
            Calendar ca = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                ca = Calendar.getInstance(Locale.US);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                cycle = (ca.get(Calendar.HOUR) * 60) + (ca.get(Calendar.MINUTE) + 1);
            }
            assert ca != null;
            String datet = "第" + ca.get(Calendar.YEAR) + "0" + ((ca.get(Calendar.MONTH)) + 1) + ca.get(Calendar.DATE) + cycle + "期";


            tzCacul.getTzList().add(new TZData("<font color='#ff0000'>" + getString(R.string.s3) + "</font>", getString(R.string.zuo), 2, 1, 3));
            tzCacul.initDSValueT();
            adapter.add(new Browser(datet, imageId[yuced3()], R.drawable.ic_solid, R.drawable.ic_s3, check[checkS3()]));
            if (tzCacul.currentData().size() > 0) {
                tvcurrent.setText(tzCacul.currentData().get(tzCacul.currentData().size() - 1));
            }
        });
        g_d4.setOnClickListener(view13 -> {
            Calendar ca = Calendar.getInstance(Locale.US);
            cycle = (ca.get(Calendar.HOUR) * 60) + (ca.get(Calendar.MINUTE) + 1);
            String datet = "第" + ca.get(Calendar.YEAR) + "0" + ((ca.get(Calendar.MONTH)) + 1) + ca.get(Calendar.DATE) + cycle + "期";


            tzCacul.getTzList().add(new TZData("<font color='#0072E3'>" + getString(R.string.d4) + "</font>", getString(R.string.zuo), 1, 1, 4));
            tzCacul.initDSValueT();
            adapter.add(new Browser(datet, imageId[yuced3()], R.drawable.ic_solid, R.drawable.ic_d4, check[checkD4()]));
            if (tzCacul.currentData().size() > 0) {
                tvcurrent.setText(tzCacul.currentData().get(tzCacul.currentData().size() - 1));
            }

        });
        g_s4.setOnClickListener(view14 -> {
            Calendar ca = Calendar.getInstance(Locale.US);
            cycle = (ca.get(Calendar.HOUR) * 60) + (ca.get(Calendar.MINUTE) + 1);
            String datet = "第" + ca.get(Calendar.YEAR) + "0" + ((ca.get(Calendar.MONTH)) + 1) + ca.get(Calendar.DATE) + cycle + "期";

            tzCacul.getTzList().add(new TZData("<font color='#ff0000'>" + getString(R.string.s4) + "</font>", getString(R.string.you), 2, 2, 4));
            tzCacul.initDSValueT();
            adapter.add(new Browser(datet, imageId[yuced3()], R.drawable.ic_solid, R.drawable.ic_s4, check[checkS4()]));
            if (tzCacul.currentData().size() > 0) {
                tvcurrent.setText(tzCacul.currentData().get(tzCacul.currentData().size() - 1));
            }
        });
        g_ht.setOnClickListener(view15 -> {
            if (browsers.size() > 0)
                adapter.remove(browsers.get(browsers.size() - 1));


        });

        return view;
    }

    public int yuced3() {
        int id = 0;
        if (tzCacul.currentData().size() > 0) {
            for (int i = 0; i < tzCacul.currentData().size() - 1; i++) {

                if (tzCacul.currentData().get(i).equals("单右") || tzCacul.currentData().get(i).equals("右3") || tzCacul.currentData().get(i).equals("单3")) {
                    id = 0;
                }

                if (tzCacul.currentData().get(i).equals("双左") || tzCacul.currentData().get(i).equals("左3") || tzCacul.currentData().get(i).equals("双3")) {
                    id = 1;
                }

                if (tzCacul.currentData().get(i).equals("单左") || tzCacul.currentData().get(i).equals("左4") || tzCacul.currentData().get(i).equals("单4")) {
                    id = 2;
                }

                if (tzCacul.currentData().get(i).equals("双右") || tzCacul.currentData().get(i).equals("右4") || tzCacul.currentData().get(i).equals("双4")) {
                    id = 3;
                }

            }
        } else {
            id = 4;
        }
        return id;
    }

    public int checkD3() {
        int id = 0;
        if (tzCacul.currentData().size() > 0) {
            for (int i = 0; i < tzCacul.currentData().size() - 1; i++) {

                if (tzCacul.currentData().get(i).equals("单右") || tzCacul.currentData().get(i).equals("右3") || tzCacul.currentData().get(i).equals("单3")) {
                    id = 1;
                } else {
                    id = 2;
                }
            }

        }

        return id;
    }

    public int checkS3() {
        int id = 0;
        if (tzCacul.currentData().size() > 0) {
            for (int i = 0; i < tzCacul.currentData().size() - 1; i++) {

                if (tzCacul.currentData().get(i).equals("双左") || tzCacul.currentData().get(i).equals("左3") || tzCacul.currentData().get(i).equals("双3")) {
                    id = 1;
                } else {
                    id = 2;
                }
            }

        }

        return id;
    }

    public int checkD4() {
        int id = 0;
        if (tzCacul.currentData().size() > 0) {
            for (int i = 0; i < tzCacul.currentData().size() - 1; i++) {

                if (tzCacul.currentData().get(i).equals("单左") || tzCacul.currentData().get(i).equals("左4") || tzCacul.currentData().get(i).equals("单4")) {
                    id = 1;
                } else {
                    id = 2;
                }
            }

        }

        return id;
    }

    public int checkS4() {
        int id = 0;
        if (tzCacul.currentData().size() > 0) {
            for (int i = 0; i < tzCacul.currentData().size() - 1; i++) {

                if (tzCacul.currentData().get(i).equals("双右") || tzCacul.currentData().get(i).equals("右4") || tzCacul.currentData().get(i).equals("双4")) {
                    id = 1;
                } else {
                    id = 2;
                }
            }

        }

        return id;
    }
}
