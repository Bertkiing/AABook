package bertking.com.useandroidannotations;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import org.androidannotations.annotations.EApplication;

/**
 * Created by king on 2017/5/7.
 * 项目名称:UseAndroidAnnotations
 * 描述:
 *
 * http://www.jianshu.com/p/464fa025229e RxJava2.0
 */

@EApplication
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //DBFlow默认初始化
//        FlowManager.init(this);

        //DBFlow自定义初始化
        FlowConfig.Builder builder = new FlowConfig.Builder(this);
        FlowConfig config = builder.openDatabasesOnInit(true).build();
        FlowManager.init(config);

    }
}
