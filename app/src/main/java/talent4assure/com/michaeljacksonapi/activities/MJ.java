package talent4assure.com.michaeljacksonapi.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import talent4assure.com.michaeljacksonapi.R;
import talent4assure.com.michaeljacksonapi.adapter.MainAdapter;
import talent4assure.com.michaeljacksonapi.model.DataList;
import talent4assure.com.michaeljacksonapi.model.MainModel;
import talent4assure.com.michaeljacksonapi.network.ApiUrl;
import talent4assure.com.michaeljacksonapi.network.RequestInterface;

public class MJ extends AppCompatActivity {

    MainModel results;
    List<DataList> dataListList;
    private MainAdapter songAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mj);
        recyclerView = findViewById(R.id.recycler);

        get_data();
    }

    public void get_data() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface service = retrofit.create(RequestInterface.class);
        Call<MainModel> call = service.getdetail();
        call.enqueue(new Callback<MainModel>() {
            @Override
            public void onResponse(Call<MainModel> call, Response<MainModel> response) {

                if (response.isSuccessful()) {
                    dataListList = response.body().getResults();
                    Log.e("rrr", String.valueOf(dataListList.get(0).getImage()));

                    songAdapter = new MainAdapter(getApplicationContext(), dataListList);

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MJ.this);

                    recyclerView.setLayoutManager(layoutManager);

                    recyclerView.setAdapter(songAdapter);
                } else {

                    Toast.makeText(getApplicationContext(), "else unresponse", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<MainModel> call, Throwable t) {
                Log.e("faill", t.toString());
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();

            }

        });
    }
}