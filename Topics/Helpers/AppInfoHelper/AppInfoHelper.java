package it.negusweb.starterkit.classes.helper;

import android.content.Context;
import android.os.Build;

/**
 * App
 * @version 1
 */
public class AppInfoHelper {

    // Version info
    public static String versionName(Context ctx)
    {
        String outStr = "-";
        try
        {
            outStr = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 0).versionName;
        }
        catch (Exception excp)
        {
            excp.printStackTrace();
        }
        return outStr;
    }

    // Device operative system
    public static String deviceOS() {
        return String.format("%s %s %s - SDK %s (API %d)", Build.MANUFACTURER, Build.BRAND, Build.DEVICE, Build.VERSION.RELEASE, Build.VERSION.SDK_INT);
    }
}