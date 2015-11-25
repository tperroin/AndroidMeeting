package epsi.nantes.fr.meeting.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.HashSet;

/**
 * Created by Thibault on 29/10/2015.
 */
public class ReceivedCookiesInterceptor implements Interceptor {

    Context ctx;

    public ReceivedCookiesInterceptor(Context ctx){
        this.ctx = ctx;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());

        if(!originalResponse.headers("Set-Cookie").isEmpty()){
            HashSet<String> cookies = new HashSet<>();

            for(String header : originalResponse.headers("Set-Cookie")){
                cookies.add(header);
                Log.v("app", "storing cookies:" + header);
            }

            SharedPreferences.Editor ed = this.ctx.getSharedPreferences("epsiapp", Context.MODE_PRIVATE).edit();
            ed.putStringSet("cookies", cookies).apply();

        }
        return originalResponse;
    }
}
