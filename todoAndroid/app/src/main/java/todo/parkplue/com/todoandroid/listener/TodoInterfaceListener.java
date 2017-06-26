package todo.parkplue.com.todoandroid.listener;

/**
 * Created by khpark on 2017-06-26.
 */

public interface TodoInterfaceListener {
    void complete(int position);
    void unComplete(int position);
}
