package com.example.jiandao.accountset;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;

import com.example.jiandao.R;
import com.example.jiandao.base.BaseActivity;
import com.example.jiandao.base.BasePresenter;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AccountSetActivity extends BaseActivity {


    @BindView(R.id.back_imag)
    ImageView backImag;
    @BindView(R.id.header_iv_set)
    ImageView headerIvSet;
    @BindView(R.id.tv4_set)
    TextView tv4Set;
    @BindView(R.id.cl0)
    ConstraintLayout cl0;
    private PopupWindow popupWindow;
    private Uri uri;

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_account_set;
    }

    @Override
    public void initListener() {
        backImag.setOnClickListener(v -> {
            finish();
        });
        headerIvSet.setOnClickListener(v -> {
            pow();
        });
    }

    private void pow() {
        View view = LayoutInflater.from(this).inflate(R.layout.pow_main3, null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        setAlpha(0.5f);
        popupWindow.setAnimationStyle(R.style.PopAnimation);
        popupWindow.showAtLocation(cl0, Gravity.BOTTOM, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setAlpha(1.0f);
            }
        });
        Button quxiao = view.findViewById(R.id.btu_quxiao);
        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        Button xiangji = view.findViewById(R.id.btu_xiangji);
        xiangji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camera();
                Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                it.putExtra(MediaStore.EXTRA_OUTPUT, uri);//MediaStore.EXTRA_OUTPUT 设置拍照时照片的输出位置
                startActivityForResult(it, 100);
            }
        });
        Button xiangce = view.findViewById(R.id.btu_xiangce);
        xiangce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 200);
            }
        });
    }

    private void setAlpha(float v) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = v;
        getWindow().setAttributes(attributes);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==200 && resultCode==RESULT_OK){
            Uri uri = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = this.getContentResolver().query(uri,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            //picturePath就是图片在储存卡所在的位置
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            File file = new File(picturePath);

            //upheader(file);
            popupWindow.dismiss();
        }else if (requestCode == 100 && resultCode == RESULT_OK){
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    //uploadForm(null,"file",mFile,mFile.getName(),mUpFileUrl); //原始的上传
                    //retrofit上传
                    //retrofitUpload();
                }
            }.start();
        }
    }

    private void camera() {
        //System.currentTimeMillis()  获得系统时间，毫秒级 作为图片的名字，避免重复
        File mFile = new File("/storage/emulated/0/" + System.currentTimeMillis() + ".jpg");//方图片的位置
        try {
            mFile.createNewFile();//创建文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        //版本适配  7.0以下 和 7.0以上的区别
        uri = null;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            uri = Uri.fromFile(mFile);
        } else {
            uri = FileProvider.getUriForFile(this, "aaa", mFile);//7.0以上需要内容提供者处理
        }


    }
}
