package cn.edu.bistu.course2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Second_Activity extends AppCompatActivity {
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);

        textView2=(TextView)findViewById(R.id.textView2);

        Bundle bundle=this.getIntent().getExtras();
        String name=bundle.getString("name");
        String d=bundle.getString("birthday");
        String sex=bundle.getString("sex");
        String interest=bundle.getString("interest");
        String g=bundle.getString("grade");
        String add=bundle.getString("address");
        String  aaaaaaaa="!!!!!!!!!!!!!!!!!!!!!!!!";

        textView2.setText(add);

    }
}
