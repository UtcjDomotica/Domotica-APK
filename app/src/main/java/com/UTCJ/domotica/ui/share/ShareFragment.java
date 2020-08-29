package com.UTCJ.domotica.ui.share;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
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

import java.io.File;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);
       WebView webview = (WebView) root.findViewById(R.id.web);
        webview.getSettings().setJavaScriptEnabled(true);
      //  webview.getSettings().setPluginsEnabled(true);
        webview.getSettings().setAllowFileAccess(true);
        File file = new File(Environment.getExternalStorageDirectory() + "/test.pdf");

        final Uri uri = Uri.fromFile(file);

        webview.loadUrl(uri.toString());

        return root;
    }
}