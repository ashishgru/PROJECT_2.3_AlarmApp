

package ashishrpa.acagild.alarmclock.utilities;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class KeyUtilities {
    public static String getToken(Context caller, String resource) {
        String token = null;
        try {
            ApplicationInfo ai = caller.getPackageManager().getApplicationInfo(caller.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            token = bundle.getString("com.microsoft.mimickeralarm.token." + resource);
        } catch (Exception ex) {
            Logger.trackException(ex);
        }
        return token;
    }
}
