package cn.edu.bistu.course_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Third_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_);

        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.radioGroupProvince);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                RadioButton button =(RadioButton)findViewById(group.getCheckedRadioButtonId());
                String province3=button.getText().toString();
                //String province4=button.getText().toString();
                Intent mIntent=new Intent();
               // Intent nIntent=new Intent();
                mIntent.putExtra("place1",province3);//设置结果，进行传送
               // nIntent.putExtra("place2",province4);
                setResult(RESULT_OK,mIntent);
                //setResult(RESULT_OK,nIntent);
                finish();
            }

        });

    }
}
