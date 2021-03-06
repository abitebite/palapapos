package com.palapapos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Terkini extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private WebView myWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_terkini, container, false);

        myWebView = (WebView) rootView.findViewById(R.id.webView);
        myWebView.getSettings().setJavaScriptEnabled(true);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        myWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        myWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        myWebView.getSettings().setAppCacheEnabled(true);
        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);

        myWebView.requestFocusFromTouch();
        myWebView.setWebChromeClient(new WebChromeClient());
        myWebView.loadUrl("http://www.palapapos.co.id/berita/all.html");

        myWebView.setWebViewClient(new WebViewClient());

//        FloatingActionButton myFab = (FloatingActionButton) rootView.findViewById(R.id.fab);
//        myFab.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                myWebView.setWebViewClient(new WebViewClient() {
//                    public void onPageFinished(WebView view, String url) {
//                        view.scrollTo(0,0);
//                    }
//                });
//            }
//        });
        return rootView ;
    }

    public void myOnKeyDown(int key_code){
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            getActivity().finish();
        }
    }

}
