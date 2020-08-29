package com.UTCJ.domotica.ui.share;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.UTCJ.domotica.R;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);
        WebView webView = (WebView) root.findViewById(R.id.web);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("https://drive.google.com/file/d/1NGTkBSSsCDknB8khJh8G8Mz-tQc39l1z/view");

        return root;
    }
}