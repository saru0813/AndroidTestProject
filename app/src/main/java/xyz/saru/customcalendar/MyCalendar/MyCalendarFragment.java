package xyz.saru.customcalendar.MyCalendar;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import xyz.saru.customcalendar.MainActivity;
import xyz.saru.customcalendar.R;

// TODO: MainActivity への参照があったら[Reference to MainActivity]のtodoを貼っつけてonDestoryまでには破棄するように頑張れ

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MyCalendarFragment.MyCalendarEventSupplier} interface
 * to handle interaction events.
 * Use the {@link MyCalendarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyCalendarFragment extends Fragment {
    //--------------------------------------------------------------------------------------------- 定数定義
    public final String TAG = "MyCalendarFragment";

    //--------------------------------------------------------------------------------------------- メンバー
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MyCalendarEventSupplier mMyCalendarEventSupplier;

    //--------------------------------------------------------------------------------------------- イベントリスナー

    //--------------------------------------------------------------------------------------------- イベントサプライヤー
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface MyCalendarEventSupplier {
        // TODO: Update argument type and name
        public void confirm();
        public void onFragmentInteraction(Uri uri);
    }

    //--------------------------------------------------------------------------------------------- Override
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mMyCalendarEventSupplier = (MyCalendarEventSupplier) ((MainActivity)activity).getmMyCalendarListener();
            mMyCalendarEventSupplier.confirm();
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement MyCalendarEventSupplier");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my_calendar, container, false);

        // DatePicker
        initializeDatePicker( v, (DatePicker)v.findViewById( R.id.datePicker ) );

        return v;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mMyCalendarEventSupplier = null;
    }

    //--------------------------------------------------------------------------------------------- コンストラクタ
    public MyCalendarFragment() {
        // Required empty public constructor
    }

    //--------------------------------------------------------------------------------------------- 主処理
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyCalendarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MyCalendarFragment newInstance(String param1, String param2) {
        MyCalendarFragment fragment = new MyCalendarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mMyCalendarEventSupplier != null) {
            mMyCalendarEventSupplier.onFragmentInteraction(uri);
        }
    }

    private void initializeDatePicker( View v, DatePicker dp ){
        dp.findViewById( Resources.getSystem().getIdentifier("day", "id", "android") )
                .setVisibility(View.GONE);
        dp.setVisibility(View.GONE);
    }
    //--------------------------------------------------------------------------------------------- アクセサ
}
