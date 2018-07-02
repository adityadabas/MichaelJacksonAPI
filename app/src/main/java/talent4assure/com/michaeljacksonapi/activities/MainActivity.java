package talent4assure.com.michaeljacksonapi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import talent4assure.com.michaeljacksonapi.R;

public class MainActivity extends AppCompatActivity {

    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = findViewById(R.id.img_profileMJ);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "after", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MJ.class);
                startActivity(intent);

            }
        });
    }//onCreate finish
}
