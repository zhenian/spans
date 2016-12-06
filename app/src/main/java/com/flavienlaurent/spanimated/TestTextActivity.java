package com.flavienlaurent.spanimated;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextPaint;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhenian on 2016/12/6.
 */

public class TestTextActivity extends Activity {

    @BindView(R.id.test_text)
    TextView textView;

    @BindView(R.id.test_text2)
    TextView textView2;

    @BindView(R.id.test_text3)
    EditText editText;

    private static final String TAG = "[ZN]";
    private static void d(String log){
        Log.d(TAG, log);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_text);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);

        String s = getString(R.string.test_cn);

        d("string = "+s);
        TextPaint paint = textView2.getPaint();
        int wordwidth=(int)paint.measureText("背",0,1);
        d("wordwidth = "+wordwidth);
        int screenwidth = getResources().getDisplayMetrics().widthPixels;
        d("screenwidth = "+screenwidth);
        int num = screenwidth/wordwidth;
        d("num = "+num);

        //textView2.setText(textView.getText());

        d("line count = "+textView.getLineCount());

        Rect rect = new Rect();
        paint.getTextBounds(s,0,s.length(),rect);
        d(" rect = "+rect.toShortString());
        d(" rect = "+rect.toString());
//  http://stackoverflow.com/questions/31837840/paginating-text-in-android
//        ViewTreeObserver vto = editText.getViewTreeObserver();
//        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                ViewTreeObserver obs = editText.getViewTreeObserver();
//                //obs.removeOnGlobalLayoutListener(this);
//                int height = editText.getHeight();
//                int scrollY = editText.getScrollY();
//                Layout layout = editText.getLayout();
//
//                int firstVisibleLineNumber = layout.getLineForVertical(scrollY);
//                int lastVisibleLineNumber = layout.getLineForVertical(height+scrollY);
//
//            }
//        });


    }
}
