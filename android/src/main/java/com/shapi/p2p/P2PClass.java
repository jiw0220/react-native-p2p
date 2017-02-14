package com.shapi.p2p;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;

/**
 * Created by jiw on 2017/2/13.
 * P2P
 */

public class P2PClass {
    static {
        System.loadLibrary("p2p");
    }

    public P2PClass(String instanceName, int port) {
        //TODO path需要考虑多SD卡的情况
        String path = Environment.getExternalStorageDirectory().getPath();
        doStartHttpd(path.getBytes(), instanceName.getBytes(), port);
    }

    public static boolean isWifiConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiNetworkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    public native final int doSave();

    public native final int doStart(byte[] url);

    public native final int doAdd(byte[] url);

    public native final int doSetUpMax(int t);

    public native final int doSetDownMax(int t);

    public native final int doDownload(byte[] url);

    public native final int doPause(byte[] url);

    public native final int doDel(byte[] url);

    public native final int doCheck(byte[] url);

    public native final int doTerminate();

    public native final int doStartHttpd(byte[] path, byte[] product, int port);

    public native final int doEndHttpd();

    public native final int doSetDuration(int dur);

    public native final long getSpeed(int t);

    public native final long getDownSize(int t);

    public native final long getFileSize(int t);

    public native final int getPercent();

    public native final long getLocalFileSize(byte[] url);

    public native final int getTaskStatusCode(int t);
}
