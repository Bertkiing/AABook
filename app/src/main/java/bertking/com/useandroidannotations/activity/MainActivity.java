package bertking.com.useandroidannotations.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.AfterTextChange;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.LongClick;
import org.androidannotations.annotations.TextChange;
import org.androidannotations.annotations.Touch;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;

import bertking.com.useandroidannotations.R;
import bertking.com.useandroidannotations.util.ToastUtil;
import bertking.com.useandroidannotations.view.AutoAdjustSizeEditText;

@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.activity_main)
@Fullscreen
public class MainActivity extends AppCompatActivity {
    
    @ViewById(R.id.et_phoneNumber)
    EditText et_phone;

    @ViewById(R.id.et_pwd)
    EditText et_pwd;

    @ViewById(R.id.btn_login)
    Button btn_login;

    @ViewById(R.id.et_autoAdjustSize)
    AutoAdjustSizeEditText et_adjustSize;

//    @AfterViews
//    public void setPhoneNumber(){
//        et_phone.setText("1234567890");
//    }


    @LongClick(R.id.btn_login)
    void test_longClick(){
        ToastUtil.shortToast("进入书单");
    }

    @Touch(R.id.tv_warn)
    void warning(){
        ToastUtil.shortToast("警告");
    }

    @Click({R.id.btn_bookshelf,R.id.btn_login,R.id.btn_back})
    void onClick(View view){
        int id = view.getId();
        switch (id){
            case R.id.btn_bookshelf:
                //利用AA启动其他的Activity
                BookShelfActivity_.intent(this).start();
                break;
            case R.id.btn_login:
                Toast.makeText(this,"登录",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_back:
                finish();
                break;
        }
    }

    //Error:(70, 5) 错误: org.androidannotations.annotations.TextChange can only be used on a method with a void return type
    @TextChange(R.id.et_phoneNumber)
    void   judgePhone(TextView editText){
        int length = editText.getText().length();
        if(length>11){
            editText.setTextColor(Color.RED);
            ToastUtil.shortToast("手机号码是11位");
        }
    }

    @TextChange(R.id.et_pwd)
    void judgePwd(TextView textView){
        int length = textView.length();
        if(length >=8){
            textView.setTextColor(Color.BLUE);
            ToastUtil.shortToast("密码必须是8位");
        }
    }

    /**
     * 根据两者来判断登录按钮的状态
     * @param textView
     */
    @AfterTextChange({R.id.et_pwd,R.id.et_phoneNumber})
    void changeLoginState(TextView textView){
        int id = textView.getId();
        switch (id){
            case R.id.et_phoneNumber:
                if(textView.getText().length()==11 && et_pwd.getText().length() == 8){
                    btn_login.setBackgroundColor(Color.RED);
                }else {
                    btn_login.setBackgroundColor(Color.WHITE);
                }

                break;
            case R.id.et_pwd:
                if(textView.getText().length()==8 && et_phone.getText().length() == 11){
                    btn_login.setBackgroundColor(Color.RED);
                }else {
                    btn_login.setBackgroundColor(Color.WHITE);
                }
                break;
        }
    }
}
