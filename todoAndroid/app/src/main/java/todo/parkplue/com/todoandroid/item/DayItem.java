package todo.parkplue.com.todoandroid.item;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by khpark on 2017-06-15.
 */

public class DayItem extends RealmObject {

    public String lastTodoThing;
    public long lastWriteDate;
    //0:ing  1:done
    public int status;

    //day  ex: 20170615
    @PrimaryKey
    public long dayKey;



}
