package bertking.com.useandroidannotations.bean;

import org.androidannotations.annotations.EBean;

/**
 * Created by king on 2017/5/6.
 * 项目名称:UseAndroidAnnotations
 * 描述:
 */
@EBean
public class Book {
    private String bookName;
    private String bookEditor;
    private int bookImg;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookEditor() {
        return bookEditor;
    }

    public void setBookEditor(String bookEditor) {
        this.bookEditor = bookEditor;
    }

    public int getBookImg() {
        return bookImg;
    }

    public void setBookImg(int bookImg) {
        this.bookImg = bookImg;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookEditor='" + bookEditor + '\'' +
                ", bookImg=" + bookImg +
                '}';
    }
}
