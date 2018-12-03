package ng.com.hybrid.reck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    CardView sigin;
    EditText edusername,edpass,edpass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
