package xyz.saru.customcalendar.MyCalendar;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Calendar;

import xyz.saru.customcalendar.MainActivity;

/**
 * Created by SARU on 2015/04/19.
 */
public class MyCalendarDays {
    //--------------------------------------------------------------------------------------------- 定数定義
    public final String TAG = "MyCalendarDays";

    //--------------------------------------------------------------------------------------------- メンバー
    private MainActivity mMainActivity;
    private SharedPreferences mSharedPreferences;
    private Calendar mCalendar;
    private ArrayList<MyCalendarDate> mMyCalendarDates;

    //--------------------------------------------------------------------------------------------- イベントリスナー

    //--------------------------------------------------------------------------------------------- イベントサプライヤー

    //--------------------------------------------------------------------------------------------- Override

    //--------------------------------------------------------------------------------------------- コンストラクタ
    public MyCalendarDays( Context c ) {
        mMainActivity = (MainActivity)c;
        init( );
    }

    //--------------------------------------------------------------------------------------------- 主処理
    private void init( ){
        if ( mMainActivity != null )
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences( mMainActivity );
        mCalendar = Calendar.getInstance();
        int year = mSharedPreferences.getInt("SETTING_ONETIME_YEAR", mCalendar.get(Calendar.YEAR) );
        int month = mSharedPreferences.getInt("SETTING_ONETIME_MONTH", mCalendar.get(Calendar.MONTH) );
        int date = mSharedPreferences.getInt("SETTING_ONETIME_DATE", mCalendar.get(Calendar.DATE) );

    }
    private void destroy(){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.remove("SETTING_ONETIME_YEAR");
        editor.remove("SETTING_ONETIME_MONTH");
        editor.remove("SETTING_ONETIME_DATE");
        editor.commit();
    }

    //--------------------------------------------------------------------------------------------- アクセサ
}
