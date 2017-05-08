package bertking.com.useandroidannotations.dbflow;

import com.raizlabs.android.dbflow.annotation.Database;

import org.androidannotations.annotations.EBean;

/**
 * Created by king on 2017/5/8.
 * 项目名称:AABook
 * 描述:
 */
@EBean
@Database(name = BookDatabase.DB_NAME,version = BookDatabase.DB_VERSION)
public class BookDatabase {
    public static final String DB_NAME = "AAbook";//我们可以添加.db后缀

    public static final int DB_VERSION = 1;
}
