package epsi.nantes.fr.meeting;

import java.util.List;

import epsi.nantes.fr.meeting.model.Hello;
import epsi.nantes.fr.meeting.model.Login;
import epsi.nantes.fr.meeting.model.MeetingWS;
import epsi.nantes.fr.meeting.model.UserWS;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by Thibault on 29/10/2015.
 */
public interface WebServices {

    @GET("/meetings")
    Call<List<MeetingWS>> listMeetings();

    @GET("/meetings/{id}")
    Call<MeetingWS> getMeeting(@Path("id") String id);

    @GET("/meetings/{id}/accept")
    Call<MeetingWS> acceptMeeting(@Path("id") String id);

    @GET("/meetings/{id}/deny")
    Call<MeetingWS> denyMeeting(@Path("id") String id);

    @GET("/meetings/{id}/invite")
    Call<MeetingWS> inviteMeeting(@Path("id") String id, @Body String userId);

    @GET("/users")
    Call<List<UserWS>> users();

    @GET("/users/search/{username}")
    Call<UserWS> getUser(@Path("id") String id);

    @POST("/users")
    Call<Void> register(@Body UserWS user);

    @POST("/login")
    Call<Void> login(@Body Login login);

    @GET("/")
    Call<Hello> hello();

}
