package xyz.saru.customcalendar.MyCalendar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by SARU on 2015/04/19.
 */
public class MyCalendarDate extends TextView {
    //--------------------------------------------------------------------------------------------- 定数定義
    public final String TAG = "MyCalendarDate";
    //--------------------------------------------------------------------------------------------- メンバー
    private Calendar mCalendar;
    private int mIndex;
    private int mMonth;
    private int mDate;
    private boolean mWork;
    private boolean mSelected;

    //--------------------------------------------------------------------------------------------- イベントリスナー
    private class TextViewListener implements OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            boolean result = false;
            switch ( event.getAction() ) {
                case MotionEvent.ACTION_DOWN:
                    result = true;
                    break;
                case MotionEvent.ACTION_MOVE:
                    result = true;
                    break;
                case MotionEvent.ACTION_UP:
                    result = true;
                    break;
            }
            return result;
        }
    }

    //--------------------------------------------------------------------------------------------- イベントサプライヤー

    //--------------------------------------------------------------------------------------------- Override

    //--------------------------------------------------------------------------------------------- コンストラクタ
    public MyCalendarDate(Context context) {
        super(context);
        if ( ! isInEditMode() ) {
            init();
        }
    }

    public MyCalendarDate(Context context, AttributeSet attrs) {
        super(context, attrs);
        if ( ! isInEditMode() ) {
            init();
        }
    }

    public MyCalendarDate(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if ( ! isInEditMode() ) {
            init();
        }
    }

    //--------------------------------------------------------------------------------------------- 主処理
    private void init(){

    }

    //--------------------------------------------------------------------------------------------- アクセサ
    public Calendar getCalendar() {
        return mCalendar;
    }
    public void setCalendar(Calendar mCalendar) {
        this.mCalendar = mCalendar;
    }
    public int getIndex() {
        return mIndex;
    }
    public void setIndex(int mIndex) {
        this.mIndex = mIndex;
    }
    public int getMonth() {
        return mMonth;
    }
    public void setMonth(int mMonth) {
        this.mMonth = mMonth;
    }
    public boolean isWork() {
        return mWork;
    }
    public void setWork(boolean mWork) {
        if ( this.mWork = mWork ) {
            this.setText( "<Strong><U>" + String.valueOf(this.mDate) + "</U></Strong>", BufferType.SPANNABLE );
        } else {
            this.setText( String.valueOf(this.mDate), BufferType.NORMAL );
        }
    }
    public boolean isSelected() {
        return mSelected;
    }
    public void setSelected(boolean mSelected) {
        this.mSelected = mSelected;
        this.setBackgroundColor( mSelected ? MyCalendarCommon.SELECTED : MyCalendarCommon.UNSELECTED );
    }
}
