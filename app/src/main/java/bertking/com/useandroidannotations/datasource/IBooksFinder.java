package bertking.com.useandroidannotations.datasource;

import java.util.List;

import bertking.com.useandroidannotations.bean.Book;

/**
 * Created by king on 2017/5/6.
 * 项目名称:UseAndroidAnnotations
 * 描述:
 */

public interface IBooksFinder {
    List<Book> findAll();

}
