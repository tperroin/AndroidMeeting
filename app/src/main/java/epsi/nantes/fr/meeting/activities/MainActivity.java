package epsi.nantes.fr.meeting.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import epsi.nantes.fr.meeting.R;
import epsi.nantes.fr.meeting.UserForm;
import epsi.nantes.fr.meeting.api.ApiClient;
import epsi.nantes.fr.meeting.model.MeetingWS;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    Button add;
    ListView listView;
    ArrayList<Integer> meetings;
    int count = 0;

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("epsiapp", Context.MODE_PRIVATE);
        if (prefs.getString("current_user_email", "").equals("")) {
            Intent form_user = new Intent(MainActivity.this, UserForm.class);
            startActivity(form_user);
        } else {
            if(prefs.getStringSet("cookies", new HashSet<String>()).isEmpty()) {
                ApiClient apiClient = new ApiClient(this);
                apiClient.login(prefs.getString("current_user_email", ""), prefs.getString("current_user_password", "")).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Response<Void> response, Retrofit retrofit) {
                        Log.d("login", response.raw().toString());
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.e("Cannot login", t.getMessage());
                    }
                });
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button) findViewById(R.id.add_meeting);
        listView = (ListView) findViewById(R.id.list_view_meetings);

        meetings = new ArrayList<>();
        SharedPreferences prefs = getSharedPreferences("epsiapp", Context.MODE_PRIVATE);

        ApiClient apiClient = new ApiClient(this);
        apiClient.listEvents().enqueue(new Callback<List<MeetingWS>>() {
            @Override
            public void onResponse(Response<List<MeetingWS>> response, Retrofit retrofit) {
                Log.d("meetings", response.raw().toString());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent form_event = new Intent(MainActivity.this, AddMeetingActivity.class);
                startActivity(form_event);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == 1) {
                Bundle res = data.getExtras();
                String result = res.getString("meeting");
                Log.d("result", "meeting: " + result);
            } else {

            }
        }
    }
}
