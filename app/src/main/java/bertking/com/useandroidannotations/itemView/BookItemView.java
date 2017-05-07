package bertking.com.useandroidannotations.itemView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import bertking.com.useandroidannotations.bean.Book;
import bertking.com.useandroidannotations.R;

/**
 * Created by king on 2017/5/6.
 * 项目名称:UseAndroidAnnotations
 * 描述:
 */
@EViewGroup(R.layout.book_item)
public class BookItemView extends RelativeLayout {
    public BookItemView(Context context) {
        super(context);
    }

    @ViewById(R.id.iv_book)
    ImageView iv_book;
    @ViewById(R.id.tv_bookEditor)
    TextView tv_editor;
    @ViewById(R.id.tv_bookTitle)
    TextView tv_title;

    public void bind(final Book book){
        iv_book.setImageResource(book.getBookImg());
        tv_title.setText(book.getBookName());
        tv_editor.setText(book.getBookEditor());
        
        
        iv_book.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), book.getBookEditor(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    

}
