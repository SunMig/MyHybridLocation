package com.example.lenovo.myhybridlocation.MainClass;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.example.lenovo.myhybridlocation.WifiThread.WifiLocationListener;
import com.example.lenovo.myhybridlocation.WifiThread.WifiLocationThread;

import java.io.File;

/**
 * Created by Lenovo on 2018/11/3.
 */

public class HybridLocationClass {
    private static String TAG="HybridLocation";
    private Context mcontext;
    private WifiManager mwifimanager;
    private String string,wifi_mac,wifi_RM;
    private HybridLocationListener hybridLocationListener;
    private double wifiMatchResults_x,wifiMatchResults_y;
    public HybridLocationClass(Context context, WifiManager mwifimanager, String string){
        this.mcontext=context;
        this.mwifimanager=mwifimanager;
        this.string=string;
        init();
    }

    private void init() {
        getFilePath();

    }
    //获取文件路径
    private void getFilePath() {
        wifi_mac=string+ File.separator+"wifi_mac.txt";
        wifi_RM=string+File.separator+"wifi_RM.txt";
    }

    public void start(){
        //
        WifiLocationThread wifiLocationThread=new WifiLocationThread(mwifimanager,wifi_mac,wifi_RM);
        //开启定位线程
        wifiLocationThread.start();
        wifiLocationThread.setWifiLocationListener(new WifiListener());
    }

    //混合定位的监听接口
    public void setHybridLocationListener(HybridLocationListener hybridLocationListener){
        this.hybridLocationListener=hybridLocationListener;
    }
    private class WifiListener implements WifiLocationListener{

        @Override
        public void onLocation(double x, double y, double weight) {
            //添加匹配结果的x,y坐标
            wifiMatchResults_x=x;
            wifiMatchResults_y=y;
            Log.i(TAG,"WIFI的输出结果是："+x+"  "+y);
        }
    }
}
