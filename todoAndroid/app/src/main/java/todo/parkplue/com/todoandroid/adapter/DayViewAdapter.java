package todo.parkplue.com.todoandroid.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import todo.parkplue.com.todoandroid.R;
import todo.parkplue.com.todoandroid.fragment.DayListFragment;
import todo.parkplue.com.todoandroid.fragment.TodoListFragment;
import todo.parkplue.com.todoandroid.holder.DayViewHolder;
import todo.parkplue.com.todoandroid.holder.MenuViewHolder;
import todo.parkplue.com.todoandroid.item.DayItem;

/**
 * Created by khpark on 2017-06-16.
 */

public class DayViewAdapter extends RecyclerView.Adapter<DayViewHolder> {

    ArrayList<DayItem> mDayItemList;
    AppCompatActivity mActivity;

    String[] mDayListStrAry;


    public DayViewAdapter(ArrayList<DayItem>  item, AppCompatActivity activity){
        mDayItemList = item;
        mActivity = activity;

        mDayListStrAry = mActivity.getResources().getStringArray(R.array.dayMenu);
    }

    @Override
    public DayViewHolder onCreateViewHolder(
            ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_day_row, viewGroup, false);


        return new DayViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DayViewHolder holder, final int position) {

        final DayItem dayItem = mDayItemList.get(position);
        holder.dayType.setText(mDayListStrAry[position]);


        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //set fragment
                TodoListFragment todoFragment = new TodoListFragment();
                todoFragment.setDayItem(dayItem);
                FragmentTransaction ft = mActivity.getSupportFragmentManager().beginTransaction();
                ft.add(R.id.frame, todoFragment);
                ft.addToBackStack("day");
                ft.commit();

//                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
//                intent.putExtra(Constants.PLAN_DAY, position);
//                startActivity(intent);
//
//                mBottomsheet.dismissSheet();
            }
        });

        holder.titleTxt.setText(mDayItemList.get(position).lastTodoThing);

    }

    @Override
    public int getItemCount() {
        return mDayItemList.size();
    }

}
