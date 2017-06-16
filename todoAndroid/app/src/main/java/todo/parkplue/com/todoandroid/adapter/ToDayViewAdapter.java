package todo.parkplue.com.todoandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import todo.parkplue.com.todoandroid.R;
import todo.parkplue.com.todoandroid.holder.DayViewHolder;
import todo.parkplue.com.todoandroid.item.DayItem;
import todo.parkplue.com.todoandroid.item.TodoItem;

/**
 * Created by khpark on 2017-06-16.
 */

public class ToDayViewAdapter extends RecyclerView.Adapter<DayViewHolder> {

    ArrayList<TodoItem> mTodoItemList;
    DayItem mDayItem;
    Context mContext;


    public ToDayViewAdapter(ArrayList<TodoItem>  item, DayItem dayItem, Context context){
        mTodoItemList = item;
        mDayItem = dayItem;
        mContext = context;
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

        final TodoItem todoItem = mTodoItemList.get(position);

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        holder.titleTxt.setText(todoItem.thingTodo);

    }

    @Override
    public int getItemCount() {
        return mTodoItemList.size();
    }

}
