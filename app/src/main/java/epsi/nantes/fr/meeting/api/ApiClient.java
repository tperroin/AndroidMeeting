package epsi.nantes.fr.meeting.api;

/**
 * Created by Thibault on 29/10/2015.
 */

import android.content.Context;

import com.squareup.okhttp.OkHttpClient;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import epsi.nantes.fr.meeting.WebServices;
import epsi.nantes.fr.meeting.model.Login;
import epsi.nantes.fr.meeting.model.MeetingWS;
import epsi.nantes.fr.meeting.model.UserWS;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Thibault on 29/10/2015.
 */
public class ApiClient {
    Context context;
    WebServices webService;

    public ApiClient(Context context) {
        if (webService == null) {
            this.context = context;
            OkHttpClient client = new OkHttpClient();
            client.interceptors().add(new AddCookiesInterceptor(context));
            client.interceptors().add(new ReceivedCookiesInterceptor(context));

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://epsi5-android.cleverapps.io")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client).build();

            webService = retrofit.create(WebServices.class);
        }
    }

    public retrofit.Call<Void> register(String login, String email, String password) throws IOException {
        UserWS user = new UserWS();
        user.setName(login);
        user.setEmail(email);
        user.setPassword(password);
        return webService.register(user);
    }

    public retrofit.Call<Void> login(String email, String password) {
        Login login = new Login();
        login.setEmail(email);
        login.setPassword(password);
        return webService.login(login);
    }

    /**
     * List all events
     *
     * @return Call
     */
    public Call<List<MeetingWS>> listEvents() {
        return webService.listMeetings();
    }

    public Call<Void> createMeeting(MeetingWS event) {

        return webService.createMeeting(event);
    }

}