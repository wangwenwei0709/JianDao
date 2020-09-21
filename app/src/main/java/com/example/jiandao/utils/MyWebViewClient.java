package com.example.jiandao.utils;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebViewClient extends WebViewClient {

    private WebViewFinishedClieck webViewFinishedClieck;

    public MyWebViewClient(WebViewFinishedClieck webViewFinishedClieck) {
        this.webViewFinishedClieck = webViewFinishedClieck;
    }

    public interface WebViewFinishedClieck{
        void webViewFinished();
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        webViewFinishedClieck.webViewFinished();
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        view.loadUrl(request.getUrl().toString(),request.getRequestHeaders());
        return true;
    }
}
