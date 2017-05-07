package bertking.com.useandroidannotations.activity;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ItemLongClick;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

import bertking.com.useandroidannotations.R;
import bertking.com.useandroidannotations.adapter.BooksAdapter;
import bertking.com.useandroidannotations.util.ToastUtil;

@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.activity_bookshelf)
public class BookShelfActivity extends Activity {

    @ViewById(R.id.listView)
    ListView mListView;

    //如果此处不加.class ,是会出现空指针的。切记
    @Bean(BooksAdapter.class)
    BooksAdapter mAdapter;


    @AfterViews
        void bindAdapter(){
        mListView.setAdapter(mAdapter);
    }



    public View getViewByPosition(int pos, ListView listView) {
        try {
            final int firstListItemPosition = listView
                    .getFirstVisiblePosition();
            final int lastListItemPosition = firstListItemPosition
                    + listView.getChildCount() - 1;

            if (pos < firstListItemPosition || pos > lastListItemPosition) {
                //This may occure using Android Monkey, else will work otherwise
                return listView.getAdapter().getView(pos, null, listView);
            } else {
                final int childIndex = pos - firstListItemPosition;
                return listView.getChildAt(childIndex);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 注意这里的方法只能有一个参数(object or position)，否则出错，
     * @param postion
     */
    @ItemClick(R.id.listView)
    void onItemClickede(int postion){
        ToastUtil.shortToast(mAdapter.getItem(postion).getBookName());
        //该方法只计算可视的item,也就是从position只是从第一个可以看到的item算起，这和实际获取的position是不一样的。
//        mListView.getChildAt(postion);
    }

    @ItemLongClick(R.id.listView)
    void onLong(int position){
        ToastUtil.shortToast("position:"+position);
    }

}
