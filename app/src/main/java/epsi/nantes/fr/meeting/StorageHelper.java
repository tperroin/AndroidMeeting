package epsi.nantes.fr.meeting;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Thibault on 29/10/2015.
 */
public class StorageHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "calendar";
    public static final int DB_VERSION = 1;

    public StorageHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    /**
     * Create the db schemas
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        String MEETING_TABLE_CREATION = "CREATE TABLE Meetings (" +
                "id TEXT, " +
                "title TEXT, " +
                "author TEXT, " +
                "description TEXT, " +
                "date_begin TEXT, " +
                "date_end TEXT, " +
                "FOREIGN KEY(author) REFERENCES Users(id))";

        String PARTICIPATION_TABLE_CREATION = "CREATE TABLE Participants (" +
                "id_event TEXT, " +
                "id_user TEXT, " +
                "status TEXT, " +
                "FOREIGN KEY(id_event) REFERENCES Meetings(id), " +
                "FOREIGN KEY(id_user) REFERENCES Users(id))";

        String USER_TABLE_CREATION = "CREATE TABLE Users (" +
                "id TEXT, " +
                "name TEXT, " +
                "email TEXT)";

        db.execSQL(USER_TABLE_CREATION);
        db.execSQL(MEETING_TABLE_CREATION);
        db.execSQL(PARTICIPATION_TABLE_CREATION);
    }


    /**
     * Reset DB when new version (usefull for tests)
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}