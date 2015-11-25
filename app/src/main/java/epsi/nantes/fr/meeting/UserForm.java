package epsi.nantes.fr.meeting;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import epsi.nantes.fr.meeting.api.ApiClient;
import epsi.nantes.fr.meeting.model.UserWS;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class UserForm extends AppCompatActivity {

    TextView inputEmail, inputUsername, inputPassword;
    Button add, cancel;
    Data data = new Data(UserForm.this);
    private static UserWS user = new UserWS();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);

        inputEmail = (TextView) findViewById(R.id.email_input);
        inputUsername = (TextView) findViewById(R.id.username_text);
        inputPassword = (TextView) findViewById(R.id.password_input);

        add = (Button) findViewById(R.id.add_user);
        cancel = (Button) findViewById(R.id.cancel_user);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ApiClient apiClient = new ApiClient(UserForm.this);
                try {
                    user.setEmail(inputEmail.getText().toString());
                    user.setName(inputUsername.getText().toString());
                    user.setPassword(inputPassword.getText().toString());
                    apiClient.register(user.getName(), user.getEmail(), user.getPassword()).enqueue(new Callback<Void>() {
                        @Override
                        public void onResponse(Response<Void> response, Retrofit retrofit) {
                            data.createUser(user);
                            SharedPreferences prefs = getSharedPreferences("epsiapp", Context.MODE_PRIVATE);
                            if (prefs.getString("current_user_email", "").equals("")) {
                                SharedPreferences.Editor ed = prefs.edit();
                                ed.putString("current_user_email", user.getEmail());
                                ed.putString("current_user_password", user.getPassword());
                                ed.apply();
                            }
                            Log.d("response", response.message());

                            Toast.makeText(UserForm.this, "user registered", Toast.LENGTH_LONG).show();
                            UserForm.this.finish();
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            Toast.makeText(UserForm.this, "user registered error", Toast.LENGTH_LONG).show();
                            Log.e("error user form", t.getMessage());
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserForm.this.finish();
            }
        });
    }
}
