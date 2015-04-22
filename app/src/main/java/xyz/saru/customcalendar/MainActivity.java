package xyz.saru.customcalendar;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import xyz.saru.customcalendar.MyCalendar.MyCalendarFragment;
import xyz.saru.customcalendar.MyCalendar.MyCalendarFragment.MyCalendarEventSupplier;

// TODO: プロジェクト名がダサいので、かっこいい名前を考えること
public class MainActivity extends ActionBarActivity {
    //--------------------------------------------------------------------------------------------- 定数定義
    public final String TAG = "MainActivity";

    //--------------------------------------------------------------------------------------------- メンバー

    //

    // イベントリスナー
    MyCalendarListener mMyCalendarListener;


    //--------------------------------------------------------------------------------------------- イベントリスナー
    private class MyCalendarListener implements MyCalendarEventSupplier {
        @Override
        public void confirm() {
            Log.i(TAG,"MyCalendarListener Set OK!");
        }

        @Override
        public void onFragmentInteraction(Uri uri) {

        }
    }

    //--------------------------------------------------------------------------------------------- イベントサプライヤー

    //--------------------------------------------------------------------------------------------- Override Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate_start");
        super.onCreate(savedInstanceState);

        // フラグメントの取得
        MyCalendarFragment mcf = (MyCalendarFragment)getFragmentManager().findFragmentById( R.id.my_calendar );
        // イベントリスナーの初期化
        mMyCalendarListener = new MyCalendarListener();

        // コンポーネントの生成
        // フラグメント側からイベントリスナーを Setter で取得するため
        // フラグメントのリスナーはここより前に初期化すること
        setContentView( R.layout.activity_main );

        Log.i(TAG, "onCreate_end");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    //--------------------------------------------------------------------------------------------- Override OptionMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //--------------------------------------------------------------------------------------------- アクセサ
    public MyCalendarListener getmMyCalendarListener() {
        return mMyCalendarListener;
    }
}
