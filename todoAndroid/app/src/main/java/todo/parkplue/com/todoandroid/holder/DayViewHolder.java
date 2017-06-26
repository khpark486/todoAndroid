package todo.parkplue.com.todoandroid.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import todo.parkplue.com.todoandroid.R;

/**
 * Created by khpark on 2017-06-15.
 */

public class DayViewHolder extends RecyclerView.ViewHolder {

    public TextView titleTxt, dayType;
    public RelativeLayout rootView;

    public DayViewHolder(View itemView) {
        super(itemView);
        rootView = (RelativeLayout)itemView.findViewById(R.id.rootView);
        titleTxt = (TextView) itemView.findViewById(R.id.title);
        dayType = (TextView) itemView.findViewById(R.id.dayType);
    }

}
