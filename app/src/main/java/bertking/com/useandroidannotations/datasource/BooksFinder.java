package bertking.com.useandroidannotations.datasource;

import android.content.Context;
import android.content.res.TypedArray;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bertking.com.useandroidannotations.R;
import bertking.com.useandroidannotations.bean.Book;

/**
 * Created by king on 2017/5/6.
 * 项目名称:UseAndroidAnnotations
 * 描述:
 */
@EBean
public class BooksFinder implements IBooksFinder {
    @RootContext
    Context mContext;

    @Override
    public List<Book> findAll() {
       List<Book> mBooks = new ArrayList<>();

        TypedArray intArray1 = mContext.getResources().obtainTypedArray(R.array.booksImg);
        List<String> bookTitles= Arrays.asList(mContext.getResources().getStringArray(R.array.books_title));
        List<String> bookEditors= Arrays.asList(mContext.getResources().getStringArray(R.array.book_editors));

        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            int resourceId = intArray1.getResourceId(i, 0);
            book.setBookEditor("作者:"+bookEditors.get(i));
            book.setBookImg(resourceId);
            book.setBookName("书名:"+bookTitles.get(i));
            mBooks.add(book);
        }
        return mBooks;
    }
}
