package com.pro.chang.beanmovie;

import android.app.Application;

import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by chang on 2016/3/17.
 */
public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "900022155", true);
    }
}
