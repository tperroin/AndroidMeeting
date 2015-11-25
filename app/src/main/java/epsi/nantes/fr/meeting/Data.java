package epsi.nantes.fr.meeting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Locale;

import epsi.nantes.fr.meeting.model.MeetingWS;
import epsi.nantes.fr.meeting.model.UserWS;

/**
 * Created by Thibault on 29/10/2015.
 */
public class Data {
    Context context;
    StorageHelper helper;

    public Data(Context context) {
        context = context;
        helper = new StorageHelper(context);
    }

    public Cursor get_user_by_id(String id) {

        SQLiteDatabase db = helper.getReadableDatabase();
        String[] projection = {"id", "name","email"};
        String[] values = {id};
        Cursor c = db.query("Users",projection,"id=?",values, null, null, null);
        c.moveToFirst();
        return c;
    }

    public Cursor getUserById(String id) {
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] projection = {"id", "name", "email"};
        String[] values = {id};
        Cursor c = db.query("users", projection, "id=?", values, null, null, null);
        c.moveToFirst();
        return c;
    }

    public Cursor getMeetingById(String id) {
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] projection = {"id", "author", "titre", "description", "begin", "end"};
        String[] values = {id};
        Cursor c = db.query("events", projection, "id=?", values, null, null, null);
        c.moveToFirst();
        return c;
    }

    public Cursor getMeetings() {
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] projection = {"id", "author", "titre", "description", "begin", "end"};
        Cursor c = db.query("EVENTS", projection, null, null, null, null, null);
        c.moveToFirst();
        return c;
    }

    public Cursor getParticipants() {
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] projection = {"id_meeting", "id_user", "status"};
        Cursor c = db.query("PARTICIPATION", projection, null, null, null, null, null);
        c.moveToFirst();
        return c;
    }

    public Boolean hasUsers() {
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] projection = {"id"};
        Cursor c = db.query("Users", projection, null, null, null, null, null);
        c.moveToFirst();
        return c.getCount() != 0;
    }

    public Cursor getParticipatingById(String id) {
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] projection = {"id_meeting", "id_user", "status"};
        String[] values = {id};
        Cursor c = db.query("participation", projection, "id=?", values, null, null, null);
        c.moveToFirst();
        return c;
    }

    public void createUser(UserWS user){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", String.valueOf(user.getId()));
        values.put("name", user.getName());
        values.put("email", user.getEmail());
        long row = db.insert("Users", "null", values);

        Log.d("sql", "Users : inserted a line");
    }

    public void createMeeting(MeetingWS meeting){
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("id", String.valueOf(meeting.getId()));
        values.put("title", meeting.getTitle());
        values.put("description", meeting.getDescription());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

        values.put("begin", dateFormat.format(meeting.getBegin()));
        values.put("end", dateFormat.format(meeting.getEnd()));
        String author = String.valueOf(meeting.getAuthor());
        if(author != null && !author.isEmpty()) {
            values.put("author", dateFormat.format(meeting.getAuthor()));
        }
        long row = db.insert("Events", "null", values);

        Log.d("sql", "Meeting : inserted a line");
    }

}
