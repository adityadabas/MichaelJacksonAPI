package talent4assure.com.michaeljacksonapi.network;

import retrofit2.Call;
import retrofit2.http.GET;
import talent4assure.com.michaeljacksonapi.model.MainModel;

/**
 * Created by adity on 4/18/2018.
 */

public interface RequestInterface {
    @GET("search?term=Michael+jackson")
    Call<MainModel> getdetail();
}
