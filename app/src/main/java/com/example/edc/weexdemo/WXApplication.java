package com.example.edc.weexdemo;

import android.app.Application;

import com.taobao.weex.InitConfig;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;
import com.taobao.weex.utils.WXLogUtils;

/**
 * Created by edc on 14/11/2016.
 */

public class WXApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        WXEnvironment.addCustomOptions("appName", "WeexDemo");
        InitConfig config = new InitConfig.Builder()
                .setImgAdapter(new ImageAdaptor())
                .build();
        WXSDKEngine.initialize(this, config);

        try {
            WXSDKEngine.registerModule("myModule", MyModule.class);
        } catch (WXException e) {
            WXLogUtils.e(e.getMessage());
        }
    }
}
