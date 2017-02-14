package com.shapi.p2p;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.content.PermissionChecker;
import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.PromiseImpl;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.permissions.PermissionsModule;

/**
 * Created by jiw on 2017/2/14.
 * P2PDemo
 */
//
public class P2PModule extends ReactContextBaseJavaModule {

    private static final int CODE_SUC = 1;
    private static final int CODE_FAIL = -99;

    private ReactApplicationContext mReactContext;

    private P2PClass mP2PClass;
    private final PermissionsModule mPermissionsModule;

    public P2PModule(ReactApplicationContext reactContext) {
        super(reactContext);
        mReactContext = reactContext;
        mPermissionsModule = new PermissionsModule(mReactContext);
    }

    @Override
    public String getName() {
        return "P2P";
    }

    @ReactMethod
    public void registerP2PClass(final String instanceName, final int port, final Callback callback) {
        if (mP2PClass == null) {
            //   mP2PClass = new P2PClass("ShaPi", 10580);
            Callback resolve = new Callback() {
                @Override
                public void invoke(Object... args) {
                    mP2PClass = new P2PClass(instanceName, port);
                    callback.invoke(CODE_SUC);
                }
            };
            Callback reject = new Callback() {
                @Override
                public void invoke(Object... args) {
                    callback.invoke(CODE_FAIL);
                }
            };
            if (PermissionChecker.checkSelfPermission(mReactContext, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                mPermissionsModule.requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, new PromiseImpl(resolve, reject));
            } else {
                resolve.invoke(new Object[]{null});
            }
        } else {
            callback.invoke(CODE_SUC);
        }

    }

    @ReactMethod
    public void doTest(Callback callback) {
        log("doTest");
        callback.invoke(99999);
    }

    @ReactMethod
    public void doSave(Callback callback) {
        log("doSave");
        if (mP2PClass == null) {
            callback.invoke(CODE_FAIL);
        } else {
            callback.invoke(mP2PClass.doSave());
        }
    }

    @ReactMethod
    public void doStart(String url, Callback callback) {
        log("doStart", url);
        if (mP2PClass == null) {
            callback.invoke(CODE_FAIL);
        } else {
            callback.invoke(mP2PClass.doStart(url.getBytes()));
        }
    }

    @ReactMethod
    public void doAdd(String url, Callback callback) {
        log("doAdd", url);
        if (mP2PClass == null) {
            callback.invoke(CODE_FAIL);
        } else {
            callback.invoke(mP2PClass.doAdd(url.getBytes()));
        }
    }

    @ReactMethod
    public void doSetUpMax(int t, Callback callback) {
        log("doSetUpMax", t);
        if (mP2PClass == null) {
            callback.invoke(CODE_FAIL);
        } else {
            callback.invoke(mP2PClass.doSetUpMax(t));
        }
    }

    @ReactMethod
    public void doSetDownMax(int t, Callback callback) {
        log("doSetDownMax", t);
        if (mP2PClass == null) {
            callback.invoke(CODE_FAIL);
        } else {
            callback.invoke(mP2PClass.doSetDownMax(t));
        }
    }

    @ReactMethod
    public void doDownload(String url, Callback callback) {
        log("doDownload", url);
        if (mP2PClass == null) {
            callback.invoke(CODE_FAIL);
        } else {
            callback.invoke(mP2PClass.doDownload(url.getBytes()));
        }
    }

    @ReactMethod
    public void doPause(String url, Callback callback) {
        log("doPause", url);
        if (mP2PClass == null) {
            callback.invoke(CODE_FAIL);
        } else {
            callback.invoke(mP2PClass.doPause(url.getBytes()));
        }
    }

    @ReactMethod
    public void doDel(String url, Callback callback) {
        log("doDel", url);
        if (mP2PClass == null) {
            callback.invoke(CODE_FAIL);
        } else {
            callback.invoke(mP2PClass.doDel(url.getBytes()));
        }
    }

    @ReactMethod
    public void doCheck(String url, Callback callback) {
        log("doCheck", url);
        if (mP2PClass == null) {
            callback.invoke(CODE_FAIL);
        } else {
            callback.invoke(mP2PClass.doCheck(url.getBytes()));
        }
    }

    @ReactMethod
    public void doTerminate(Callback callback) {
        log("doTerminate");
        if (mP2PClass == null) {
            callback.invoke(CODE_FAIL);
        } else {
            callback.invoke(mP2PClass.doTerminate());
        }
    }

    @ReactMethod
    public void doStartHttpd(String path, String product, int port, Callback callback) {
        log("doStartHttpd", path + "--" + product + "--" + port);
        if (mP2PClass == null) {
            callback.invoke(CODE_FAIL);
        } else {
            callback.invoke(mP2PClass.doStartHttpd(path.getBytes(), product.getBytes(), port));
        }
    }

    @ReactMethod
    public void doEndHttpd(Callback callback) {
        log("doEndHttpd");
        if (mP2PClass == null) {
            callback.invoke(CODE_FAIL);
        } else {
            callback.invoke(mP2PClass.doEndHttpd());
        }
    }

    @ReactMethod
    public void doSetDuration(int t, Callback callback) {
        log("doSetDuration", t);
        if (mP2PClass == null) {
            callback.invoke(CODE_FAIL);
        } else {
            callback.invoke(mP2PClass.doSetDuration(t));
        }
    }

    @ReactMethod
    public void getSpeed(int t, Callback callback) {
        log("getSpeed", t);
        if (mP2PClass == null) {
            callback.invoke(CODE_FAIL);
        } else {
            callback.invoke(mP2PClass.getSpeed(t));
        }
    }

    @ReactMethod
    public void getDownSize(int t, Callback callback) {
        log("getDownSize", t);
        if (mP2PClass == null) {
            callback.invoke(CODE_FAIL);
        } else {
            callback.invoke(mP2PClass.getDownSize(t));
        }
    }

    @ReactMethod
    public void getFileSize(int t, Callback callback) {
        log("getFileSize", t);
        if (mP2PClass == null) {
            callback.invoke(CODE_FAIL);
        } else {
            callback.invoke(mP2PClass.getFileSize(t));
        }
    }

    @ReactMethod
    public void getPercent(Callback callback) {
        log("getPercent");
        if (mP2PClass == null) {
            callback.invoke(CODE_FAIL);
        } else {
            callback.invoke(mP2PClass.getPercent());
        }
    }

    @ReactMethod
    public void getLocalFileSize(String url, Callback callback) {
        log("getLocalFileSize", url);
        if (mP2PClass == null) {
            callback.invoke(CODE_FAIL);
        } else {
            callback.invoke(mP2PClass.getLocalFileSize(url.getBytes()));
        }
    }

    @ReactMethod
    public void getTaskStatusCode(int t, Callback callback) {
        log("getTaskStatusCode", t);
        if (mP2PClass == null) {
            callback.invoke(CODE_FAIL);
        } else {
            callback.invoke(mP2PClass.getTaskStatusCode(t));
        }
    }

    private void log(String methodName) {
        Log.e(getName(), "Call: \"" + methodName + "\"");
    }

    private void log(String methodName, String parameterValue) {
        Log.e(getName(), "Call: \"" + methodName + "\" ParameterValue \"" + parameterValue + "\"");
    }

    private void log(String methodName, int parameterValue) {
        Log.e(getName(), "Call: \"" + methodName + "\" ParameterValue \"" + parameterValue + "\"");
    }
}
