package com.xk.application;

/**
 * @Author xk
 * @Date 2023/04/18 23:27
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class YuCeFragment extends Fragment implements View.OnClickListener {
    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_cacul, null);
        webView = view.findViewById(R.id.web1);
        webView.loadUrl(getString(R.string.url));
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                Toast.makeText(getActivity(), "web1加载中,当前进度:" + newProgress + "%", Toast.LENGTH_SHORT).show();
            }
        });
        Button webBack = view.findViewById(R.id.webback1);
        Button webForward = view.findViewById(R.id.webforward1);
        Button webLogin = view.findViewById(R.id.weblogin1);
        Button webRegister = view.findViewById(R.id.webregister1);
        webBack.setOnClickListener(this);
        webForward.setOnClickListener(this);
        webLogin.setOnClickListener(this);
        webRegister.setOnClickListener(this);
        initWebView();


        return view;
    }

    private void initWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSavePassword(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setCacheMode(webSettings.LOAD_NO_CACHE);
        webSettings.setDefaultTextEncodingName("utf-8");
        webSettings.setAllowFileAccess(true);
    }

    @Override
    public void onClick(View p1) {
        switch (p1.getId()) {
            case R.id.webback1:
                if (webView.canGoBack()) {
                    webView.goBack();
                }
                break;
            case R.id.webforward1:
                if (webView.canGoForward()) {
                    webView.goForward();
                }
                break;
            case R.id.weblogin1:
                webView.loadUrl(getString(R.string.loginUrl));
                break;
            case R.id.webregister1:
                webView.loadUrl(getString(R.string.registerUrl));
                break;
        }
    }


}
