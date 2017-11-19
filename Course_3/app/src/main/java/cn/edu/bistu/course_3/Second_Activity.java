package cn.edu.bistu.course_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Second_Activity extends AppCompatActivity {

    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);

        show=(TextView)findViewById(R.id.show);
        Bundle bundle=this.getIntent().getExtras();
        String p=bundle.getString("place1");
        String p2=bundle.getString("place2");
        String d=bundle.getString("date");
        show.setText(p+"\n"+p2+"\n"+d);


    }
}
