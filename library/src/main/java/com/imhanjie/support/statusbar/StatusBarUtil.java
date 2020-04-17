package com.imhanjie.support.statusbar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.view.View;

/**
 * Author:      hanjie
 * Created at:  2017/11/29.
 * Email:
 * Description:
 */


public class StatusBarUtil {

    /**
     * 亮色状态栏
     */
    public static void setLightMode(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        StatusBarUtil.compatThirdRomStatusBar(activity, true);
    }

    /**
     * 布局延伸至状态栏
     */
    public static void setLayoutFullScreen(Activity activity, boolean lightMode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
            activity.getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (lightMode) {
                    activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    StatusBarUtil.compatThirdRomStatusBar(activity, true);
                }
            }
        }
    }

    /**
     * 兼容国内第三方定制 ROM 白色状态栏
     */
    private static void compatThirdRomStatusBar(Activity activity, boolean isLight) {
        FlymeStatusbarColorUtil.setStatusBarDarkIcon(activity, isLight);
        MIUIStatusBarUtil.setStatusBarDarkMode(isLight, activity);
    }

    /**
     * 获取状态栏高度
     */
    public static int getStatusBarHeight(Activity activity) {
        // 获取状态栏高度
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return activity.getResources().getDimensionPixelSize(resourceId);
    }

}
