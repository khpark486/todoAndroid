package todo.parkplue.com.todoandroid.util;

import io.realm.Realm;
import todo.parkplue.com.todoandroid.item.DayItem;
import todo.parkplue.com.todoandroid.item.TodoItem;

/**
 * Created by khpark on 2017-06-15.
 */

public class Util {


    public static void addSchedule(TodoItem item){
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        DayItem dayItem = realm.where(DayItem.class).equalTo("dayKey", item.startDate).findFirst();
        if(dayItem == null){
            dayItem = realm.createObject(DayItem.class);
            dayItem.dayKey = item.startDate;
            dayItem.lastTodoThing = item.thingTodo;
            dayItem.lastWriteDate = item.writeDate;
        }

        TodoItem todoItem = realm.createObject(TodoItem.class);
        todoItem.startDate = item.startDate;
        todoItem.finishDate = item.finishDate;
        todoItem.isDone = item.isDone;
        todoItem.dayKey = dayItem.dayKey;
        todoItem.writeDate = item.writeDate;
        todoItem.thingTodo = item.thingTodo;






//        final Dog managedDog = realm.copyToRealm(dog); // 비관리 객체를 영속화하기
//        Person person = realm.createObject(Person.class); // 관리 객체를 직접 만들기
//        person.getDogs().add(managedDog);
        realm.commitTransaction();

    }

}
