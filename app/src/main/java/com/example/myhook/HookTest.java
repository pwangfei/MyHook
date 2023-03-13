package com.example.myhook;
import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
public class HookTest implements IXposedHookLoadPackage {
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        Log.d("wpf123wpf", "try to hook " + loadPackageParam.packageName);
        if ("com.example.mytexts".equals(loadPackageParam.packageName)) {
            XposedBridge.log("ready to hook method.");
//            XposedHelpers.findAndHookMethod("com.example.mytexts.MainActivity",
//                    loadPackageParam.classLoader, "getString",
//                    new XC_MethodHook() {
//                        @Override
//                        protected void afterHookedMethod(
//                                MethodHookParam param) throws Throwable {
//                            super.afterHookedMethod(param);
//                            // 获取方法的返回值
//                            String result = (String) param.getResult();
//                            Log.d("wpf123wpf", "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkk------------------------------------------------------------------ " +result);
//                            param.setResult("xposed test");
//                        }
//                    });
//
            XposedHelpers.findAndHookMethod("com.example.mytexts.MainActivity", loadPackageParam.classLoader, "getString", new XC_MethodReplacement() {
                @Override
                protected Object replaceHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                    // 修改返回值为 100
                    return "yemian";
                }
            });
        }
    }
}
