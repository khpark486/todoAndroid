package todo.parkplue.com.todoandroid.item;

import io.realm.RealmObject;

/**
 * Created by khpark on 2017-06-15.
 */

public class TodoItem extends RealmObject {


    public String thingTodo;
    public boolean isDone;

    public long writeDate;
    public long startDate;
    public long finishDate;

    public long dayKey;
}
