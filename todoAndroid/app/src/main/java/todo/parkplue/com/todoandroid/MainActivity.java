package todo.parkplue.com.todoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flipboard.bottomsheet.BottomSheetLayout;

import java.util.ArrayList;

import todo.parkplue.com.todoandroid.holder.MenuViewHolder;
import todo.parkplue.com.todoandroid.util.Util;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    RecyclerView mTodoList;
    TextView mAddBtn;
    BottomSheetLayout mBottomsheet;
    View mSheetView;


    //choice menu
    RecyclerView mChoiceList;
    MenuAdapter mMenuAdapter;

    public String[] mMenuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        initView();
    }


    private void initView(){
        mTodoList = (RecyclerView) findViewById(R.id.listItem);
        mAddBtn = (TextView)findViewById(R.id.addBtn);
        mBottomsheet = (BottomSheetLayout) findViewById(R.id.bottomsheet);
        mSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.sheet_layout, mBottomsheet, false);

        mChoiceList = (RecyclerView) mSheetView.findViewById(R.id.menuList);


        setMenu();

        mAddBtn.setOnClickListener(this);
    }

    private void initData(){

        mMenuList = getResources().getStringArray(R.array.dayMenu);

    }

    public void setMenu(){
        mMenuAdapter = new MenuAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mChoiceList.setLayoutManager(layoutManager);

        mChoiceList.setAdapter(mMenuAdapter);

    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.addBtn:
                mBottomsheet.showWithSheetView(mSheetView);

                break;
        }
    }


    @Override
    public void onBackPressed() {
        if(mBottomsheet!=null && mBottomsheet.isSheetShowing()){
            mBottomsheet.dismissSheet();
        }else{
            super.onBackPressed();
        }
    }

    public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

        @Override
        public MenuViewHolder onCreateViewHolder(
                ViewGroup viewGroup, int viewType) {
            View itemView = LayoutInflater.
                    from(viewGroup.getContext()).
                    inflate(R.layout.item_menu_row, viewGroup, false);
            return new MenuViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MenuViewHolder holder, final int position) {

            holder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                    intent.putExtra(Constants.PLAN_DAY, position);
                    startActivity(intent);

                    mBottomsheet.dismissSheet();
                }
            });

            holder.titleTxt.setText(mMenuList[position]);

        }

        @Override
        public int getItemCount() {
            return mMenuList.length;
        }

    }

}
