package epsi.nantes.fr.meeting.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import epsi.nantes.fr.meeting.R;
import epsi.nantes.fr.meeting.model.MeetingWS;

public class AddMeetingActivity extends AppCompatActivity {

    Button ok, cancel;
    TextView title, description, date_begin, date_end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ok = (Button) findViewById(R.id.event_form_validate);
        cancel = (Button) findViewById(R.id.event_form_cancel);
        title = (TextView) findViewById(R.id.event_form_title);
        description = (TextView) findViewById(R.id.event_form_desc);
        date_begin = (TextView) findViewById(R.id.event_form_date_begin);
        date_end = (TextView) findViewById(R.id.event_form_date_end);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MeetingWS event = new MeetingWS();
                event.setTitle(String.valueOf(title.getText()));
                event.setDescription(String.valueOf(description.getText()));
                event.setBegin(date_begin.toString());
                event.setEnd(date_end.toString());

                Log.d("title", event.toString());
            }
        });
    }

}
