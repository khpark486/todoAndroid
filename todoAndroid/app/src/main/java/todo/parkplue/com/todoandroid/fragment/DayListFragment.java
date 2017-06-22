package todo.parkplue.com.todoandroid.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.realm.RealmResults;
import io.realm.Sort;
import todo.parkplue.com.todoandroid.R;
import todo.parkplue.com.todoandroid.TodoApplication;
import todo.parkplue.com.todoandroid.adapter.DayViewAdapter;
import todo.parkplue.com.todoandroid.item.DayItem;

/**
 * Created by khpark on 2017-06-16.
 */

public class DayListFragment extends Fragment {

    View mView;
    RecyclerView mTodoList;

    DayViewAdapter mDayViewAdapter;
    ArrayList<DayItem> mDayItemList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        mView=inflater.inflate(R.layout.fragment_day, container,false);
        mDayItemList = new ArrayList<DayItem>();

        initView();
        setList();

        return mView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    private void initView(){

        mTodoList = (RecyclerView) mView.findViewById(R.id.listItem);

        mDayViewAdapter = new DayViewAdapter(mDayItemList, getActivity().getApplicationContext() );
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mTodoList.setLayoutManager(layoutManager);
        mTodoList.setAdapter(mDayViewAdapter);


        DividerItemDecoration divider = new DividerItemDecoration(mTodoList.getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(mTodoList.getContext(), R.drawable.divider_black));
        mTodoList.addItemDecoration(divider);
    }



    private void setList(){
        //init
        mDayItemList.clear();

        RealmResults<DayItem> dayItemList = ((TodoApplication)getActivity().getApplication()).getRealm().where(DayItem.class).findAllSorted("dayKey", Sort.DESCENDING);
        Log.i("dayItemList","dayITemList size = " + dayItemList.size());
        for (DayItem item : dayItemList) {
            mDayItemList.add(item);
        }

    }



}
