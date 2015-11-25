package epsi.nantes.fr.meeting.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Thibault on 29/10/2015.
 */
public class AddCookiesInterceptor implements Interceptor {
    Context ctx;
    public AddCookiesInterceptor(Context ctx){
        this.ctx = ctx;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        SharedPreferences prefs = ctx.getSharedPreferences("epsiapp", Context.MODE_PRIVATE);
        Set<String> preferences = prefs.getStringSet("cookies", new HashSet<String>());
        for(String cookie : preferences){
            builder.addHeader("Cookie", cookie);
            Log.v("OkHttp", "Adding Header: " + cookie);
        }
        return chain.proceed(builder.build());
    }
}
