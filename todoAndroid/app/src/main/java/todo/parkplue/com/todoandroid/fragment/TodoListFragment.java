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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import todo.parkplue.com.todoandroid.R;
import todo.parkplue.com.todoandroid.TodoApplication;
import todo.parkplue.com.todoandroid.adapter.DayViewAdapter;
import todo.parkplue.com.todoandroid.adapter.ToDayViewAdapter;
import todo.parkplue.com.todoandroid.item.DayItem;
import todo.parkplue.com.todoandroid.item.TodoItem;
import todo.parkplue.com.todoandroid.listener.TodoInterfaceListener;

/**
 * Created by khpark on 2017-06-16.
 */



public class TodoListFragment extends Fragment implements TodoInterfaceListener{

    View mView;
    RecyclerView mTodoList;


    ToDayViewAdapter mToDayViewAdapter;
    ArrayList<TodoItem> mTodoItemList;
    DayItem mDayItem;

    long mDate;
    TodoInterfaceListener mTodoListInterface;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        mView =inflater.inflate(R.layout.fragment_todo, container,false);

        mTodoItemList = new ArrayList<TodoItem>();

        initView();
        setList();
        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    private void initView(){


        mTodoListInterface = this;


        mTodoList = (RecyclerView) mView.findViewById(R.id.listItem);

        mToDayViewAdapter = new ToDayViewAdapter(mTodoItemList,mDayItem, getActivity().getApplicationContext(),mTodoListInterface);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mTodoList.setLayoutManager(layoutManager);
        mTodoList.setAdapter(mToDayViewAdapter);


        DividerItemDecoration divider = new DividerItemDecoration(mTodoList.getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(mTodoList.getContext(), R.drawable.divider_black));
        mTodoList.addItemDecoration(divider);
    }



    private void setList(){
        //init
        mTodoItemList.clear();

        RealmResults<TodoItem> todoItemList = ((TodoApplication)getActivity().getApplication()).getRealm().where(TodoItem.class).equalTo("startDate",mDayItem.dayKey).findAll();

        for (TodoItem item : todoItemList) {
            if(!mTodoItemList.contains(item)) {
                mTodoItemList.add(item);
            }
        }

        if(mToDayViewAdapter!=null){
            mToDayViewAdapter.notifyDataSetChanged();
        }
    }

    public void setDayItem(DayItem dayItem){
        mDayItem = dayItem;
    }


    public void todoChangeDone(boolean done, int position){

        TodoItem tmpItem = mTodoItemList.get(position);
        TodoItem changeTmpItem = ((TodoApplication)getActivity().getApplication()).getRealm().where(TodoItem.class).equalTo("writeDate",tmpItem.writeDate).findFirst();

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        changeTmpItem.isDone = done;

        realm.copyToRealmOrUpdate(changeTmpItem);
        realm.commitTransaction();

        //reload list
        mTodoItemList.get(position).isDone = done;
        if(mToDayViewAdapter!=null){
            mToDayViewAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void complete(int position) {
        todoChangeDone(true,position);
    }

    @Override
    public void unComplete(int position) {
        todoChangeDone(false,position);
    }


}
