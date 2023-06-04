package com.xk.application;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebViewClient;


/**
 * @Author xk
 * @Date 2023/04/18 23:41
 */


public class WebFragment extends Fragment implements OnClickListener {

    public AgentWeb mAgentWeb;
    private ValueCallback<Uri[]> mUploadCallback;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_web, null);
        LinearLayout view1 = view.findViewById(R.id.lview14);

        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(view1, new ViewGroup.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setWebChromeClient(new AgentWebChromeClient())
                .setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        if (url.startsWith("http:") || url.startsWith("https:")) {
                            view.loadUrl(url);
                        } else {
                            try {
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                                startActivity(intent);
                            } catch (ActivityNotFoundException e) {
                                // 处理外部浏览器未安装的情况
                            }
                        }
                        return true;

                    }


                })
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
                .createAgentWeb()
                .ready()
                .go(getString(R.string.url));
        // 设置 UserAgent
        WebSettings settings = mAgentWeb.getWebCreator().getWebView().getSettings();
        String userAgent = "Mozilla/5.0 (Linux; Android 13; SM-G970F) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.210 Mobile Safari/537.36";
        settings.setUserAgentString(userAgent);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }


        Button webBack = view.findViewById(R.id.webback);
        Button webForward = view.findViewById(R.id.webforward);
        Button webLogin = view.findViewById(R.id.webReload);
        Button webRegister = view.findViewById(R.id.webregister);
        webBack.setOnClickListener(this);
        webForward.setOnClickListener(this);
        webLogin.setOnClickListener(this);
        webRegister.setOnClickListener(this);


        return view;
    }
//处理blank标签


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View p1) {
        switch (p1.getId()) {
            case R.id.webback:
                if (mAgentWeb.getWebCreator().getWebView().canGoBack()) {
                    mAgentWeb.getWebCreator().getWebView().goBack();
                }
                break;
            case R.id.webforward:
                if (mAgentWeb.getWebCreator().getWebView().canGoForward()) {
                    mAgentWeb.getWebCreator().getWebView().goForward();
                }
                break;
            case R.id.webReload:
                mAgentWeb.getWebCreator().getWebView().reload();
                break;
            case R.id.webregister:

                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == AgentWebFileUploader.REQUEST_CODE_FILE_PICKER) {
            if (mUploadCallback != null) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    mUploadCallback.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(resultCode, data));
                }
                mUploadCallback = null;
            }
        } else {
            //  mAgentWeb.uploadFileResult(requestCode, resultCode, data);
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private class AgentWebChromeClient extends WebChromeClient {
        @Override
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            mUploadCallback = filePathCallback;
            AgentWebFileUploader.showFileChooser(WebFragment.this);
            return true;
        }

    }

}