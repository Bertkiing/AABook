package bertking.com.useandroidannotations.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

import bertking.com.useandroidannotations.R;
import bertking.com.useandroidannotations.util.ToastUtil;

@WindowFeature(Window.FEATURE_NO_TITLE)
@Fullscreen
@EActivity(R.layout.activity_book_detail)
public class BookDetailActivity extends AppCompatActivity {

    @ViewById(R.id.tv_title)
    TextView mTextView;

    @ViewById(R.id.et_feedback)
    TextView mEt_feedback;

    @ViewById(R.id.listView)
    ListView mListView;

    //表明这个方法保证在绑定view成功之后调用
    @AfterViews
    void setTitle(){
        mTextView.setText("胜天半子");
    }




    //处理一个点击
    @Click(R.id.btn_back)
    void handleBack(){
        ToastUtil.shortToast("返回");
        finish();
    }
    //处理多个点击
    @Click({R.id.btn_save,R.id.btn_forgetPwd,R.id.btn_login})
    void onHandleClicks(View view){
        switch (view.getId()){
            case R.id.btn_login:
                ToastUtil.shortToast("登录");
                break;
            case R.id.btn_save:
                ToastUtil.shortToast("保存");
                break;
            case R.id.btn_forgetPwd:
                ToastUtil.shortToast("忘记密码");
                break;
        }
    }



}
