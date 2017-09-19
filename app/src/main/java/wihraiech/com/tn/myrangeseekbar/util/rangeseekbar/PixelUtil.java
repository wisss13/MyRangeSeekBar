package wihraiech.com.tn.myrangeseekbar.util.rangeseekbar;

/**
 * Created by lenovo on 29/06/2016.
 */
import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Util class for converting between dp, px and other magical pixel units
 */
public class PixelUtil {

    private PixelUtil() {
    }

    public static int dpToPx(Context context, int dp) {
        int px = Math.round(dp * getPixelScaleFactor(context));
        return px;
    }

    public static int pxToDp(Context context, int px) {
        int dp = Math.round(px / getPixelScaleFactor(context));
        return dp;
    }

    private static float getPixelScaleFactor(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT);
    }

}
