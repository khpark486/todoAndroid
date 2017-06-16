package todo.parkplue.com.todoandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import todo.parkplue.com.todoandroid.R;
import todo.parkplue.com.todoandroid.holder.DayViewHolder;
import todo.parkplue.com.todoandroid.holder.MenuViewHolder;
import todo.parkplue.com.todoandroid.item.DayItem;

/**
 * Created by khpark on 2017-06-16.
 */

public class DayViewAdapter extends RecyclerView.Adapter<DayViewHolder> {

    ArrayList<DayItem> mDayItemList;
    Context mContext;


    public DayViewAdapter(ArrayList<DayItem>  item, Context context){
        mDayItemList = item;
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

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
