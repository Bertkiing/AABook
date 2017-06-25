package bertking.com.useandroidannotations.util;

import android.content.Context;
import android.widget.Toast;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import bertking.com.useandroidannotations.MyApp_;


/**
 * Created by king on 2017/5/7.
 * 项目名称:UseAndroidAnnotations
 * 描述:
 */
@EBean(scope = EBean.Scope.Singleton)
public class ToastUtil {
    @RootContext
   static Context mContext = MyApp_.getInstance().getApplicationContext();

    public static void shortToast(String string) {
        Toast.makeText(mContext, string, Toast.LENGTH_SHORT).show();
    }

    public static void longToast(String string){
        Toast.makeText(mContext, string,Toast.LENGTH_LONG).show();
    }

    public static void shortToast(int strId){
        String string = mContext.getResources().getString(strId);
        shortToast(string);
    }

    public static void longToast(int resId){
        String string = mContext.getResources().getString(resId);
        longToast(string);
    }

}
