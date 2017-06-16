package todo.parkplue.com.todoandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.flipboard.bottomsheet.BottomSheetLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import todo.parkplue.com.todoandroid.holder.MenuViewHolder;
import todo.parkplue.com.todoandroid.item.TodoItem;
import todo.parkplue.com.todoandroid.util.Util;

public class AddActivity extends AppCompatActivity implements View.OnClickListener{


    EditText mBodyEdit;
    TextView mEnterTxt;

    int mPlanType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        mPlanType = getIntent().getExtras().getInt(Constants.PLAN_DAY);

        initView();
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.enterView:

                //save data;
                saveData();
                finish();
                break;
        }

    }


    public void initView(){
        mBodyEdit = (EditText)findViewById(R.id.editBody);
        mEnterTxt = (TextView)findViewById(R.id.enterView);

        mEnterTxt.setOnClickListener(this);

    }

    public void saveData(){

        //alert
        if(mBodyEdit.getText().toString().trim().length() == 0){


        }


        long currentTime = System.currentTimeMillis();

        SimpleDateFormat todayFormatter = new SimpleDateFormat ( "yyyy.MM.dd" );
        Date today = new Date (currentTime);
        try {
            long todayStrTime = todayFormatter.parse(todayFormatter.format(today)).getTime();
            long nextDayTime = todayStrTime + 1000*60*60*24;


            Calendar c = Calendar.getInstance();
            c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
            long weekLastTime = c.getTime().getTime() + (1000*60*60*24);

            TodoItem todoItem = new TodoItem();
            todoItem.writeDate = currentTime;
            todoItem.isDone = false;

            if(mPlanType == Constants.PLAN_TYPE_TODAY){
                todoItem.startDate = todayStrTime;
                todoItem.finishDate = nextDayTime;

            }else if(mPlanType == Constants.PLAN_TYPE_NEXTDAY){

                todoItem.startDate = nextDayTime;
                todoItem.finishDate = nextDayTime + 1000*60*60*24;
            }else if(mPlanType == Constants.PLAN_TYPE_THISWEEK){
                todoItem.startDate = todayStrTime;
                todoItem.finishDate = weekLastTime;
            }

            todoItem.thingTodo = mBodyEdit.getText().toString();


            Util.addSchedule(todoItem);


        } catch (ParseException e) {
            e.printStackTrace();
        }







    }

}
