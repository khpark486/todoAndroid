package todo.parkplue.com.todoandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    RecyclerView mTodoList;
    TextView mAddBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }



    private void initView(){
        mTodoList = (RecyclerView) findViewById(R.id.listItem);
        mAddBtn = (TextView)findViewById(R.id.addBtn);

        mAddBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        switch (id){
            case R.id.addBtn:

                break;
        }


    }

}
