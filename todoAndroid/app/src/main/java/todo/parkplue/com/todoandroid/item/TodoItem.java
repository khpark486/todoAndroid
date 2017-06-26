package todo.parkplue.com.todoandroid.item;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by khpark on 2017-06-15.
 */

public class TodoItem extends RealmObject {


    public String thingTodo;
    public boolean isDone;

    public long startDate;
    public long finishDate;

    public long dayKey;

    @PrimaryKey
    public long writeDate;
}
