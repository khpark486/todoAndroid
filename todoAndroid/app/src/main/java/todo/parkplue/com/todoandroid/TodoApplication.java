package todo.parkplue.com.todoandroid;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by khpark on 2017-06-15.
 */

public class TodoApplication extends Application {


    Realm mRealm;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }

    public Realm getRealm(){

        if(mRealm == null){
            mRealm =  Realm.getDefaultInstance();
        }
       return mRealm;
    }


}
