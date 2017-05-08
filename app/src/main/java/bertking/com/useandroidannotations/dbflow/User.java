package bertking.com.useandroidannotations.dbflow;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import org.androidannotations.annotations.EBean;

/**
 * Created by king on 2017/5/8.
 * 项目名称:AABook
 * 描述:
 */
@EBean

@Table(database = BookDatabase.class)
public class User extends BaseModel {
    //DBFlow supports multiple primary keys
    @PrimaryKey(autoincrement = true)
    long id;

    @Column(defaultValue = "书童")
    String name;

    @Column(defaultValue = "0")
    int readAge;//书令

    @Column
    String userIcon;

    @Column(defaultValue = "书生" )
    String readLevel;

    @Column
    String phoneNumber;

    @Column
    String pwd;

//    For Boolean classes, use "1" for true, "0" for false.
    @Column(defaultValue = "0")
    Boolean onSchool;//上学中

    @Column(defaultValue = "天道酬勤")
    String Motto;//座右铭



}
