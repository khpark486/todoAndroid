package todo.parkplue.com.todoandroid.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import todo.parkplue.com.todoandroid.R;
import todo.parkplue.com.todoandroid.fragment.TodoListFragment;
import todo.parkplue.com.todoandroid.holder.DayViewHolder;
import todo.parkplue.com.todoandroid.item.DayItem;
import todo.parkplue.com.todoandroid.item.TodoItem;
import todo.parkplue.com.todoandroid.listener.TodoInterfaceListener;

/**
 * Created by khpark on 2017-06-16.
 */

public class ToDayViewAdapter extends RecyclerView.Adapter<DayViewHolder> {

    ArrayList<TodoItem> mTodoItemList;
    DayItem mDayItem;
    Context mContext;

    TodoInterfaceListener  mInterface;


    public ToDayViewAdapter(ArrayList<TodoItem>  item, DayItem dayItem, Context context, TodoInterfaceListener l){
        mTodoItemList = item;
        mDayItem = dayItem;
        mContext = context;
        mInterface = l;
    }

    @Override
    public DayViewHolder onCreateViewHolder(
            ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.item_todo_row, viewGroup, false);

        return new DayViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final DayViewHolder holder, final int position) {

        final TodoItem todoItem = mTodoItemList.get(position);

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.titleTxt.setPaintFlags(holder.titleTxt.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                mInterface.complete(position);

                //update db


            }
        });


        holder.titleTxt.setText(todoItem.thingTodo);

    }

    @Override
    public int getItemCount() {
        return mTodoItemList.size();
    }

}
