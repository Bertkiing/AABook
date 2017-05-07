package bertking.com.useandroidannotations.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

import bertking.com.useandroidannotations.bean.Book;
import bertking.com.useandroidannotations.datasource.BooksFinder;
import bertking.com.useandroidannotations.itemView.BookItemView;
import bertking.com.useandroidannotations.itemView.BookItemView_;

/**
 * Created by king on 2017/5/6.
 * 项目名称:UseAndroidAnnotations
 * 描述:
 */
@EBean
public class BooksAdapter extends BaseAdapter {
    List<Book> mBooks;


//    @Bean()
    @Bean(BooksFinder.class)
    BooksFinder mBooksFinder;

    @RootContext
    Context mContext;

    @AfterInject
    void initAdapter() {
        mBooks = mBooksFinder.findAll();
    }

    @Override
    public int getCount() {
        return mBooks == null?0:mBooks.size();
    }

    @Override
    public Book getItem(int i) {
        return mBooks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        BookItemView itemView;
        if(view == null){
            itemView = BookItemView_.build(mContext);
        }else {
            itemView = (BookItemView) view;
        }

        itemView.bind(mBooks.get(i));

        return itemView;
    }
}
