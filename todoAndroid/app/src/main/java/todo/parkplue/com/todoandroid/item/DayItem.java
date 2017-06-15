package todo.parkplue.com.todoandroid.item;

import io.realm.RealmObject;

/**
 * Created by khpark on 2017-06-15.
 */

public class DayItem extends RealmObject {

    public String lastTodoThing;

    //day  ex: 20170615
    public long dayKey;

}
