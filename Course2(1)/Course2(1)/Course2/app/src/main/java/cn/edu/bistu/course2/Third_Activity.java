package cn.edu.bistu.course2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

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
                String province=button.getText().toString();
                Intent mIntent=new Intent();
                mIntent.putExtra("province",province);//设置结果，进行传送
                setResult(1,mIntent);
                finish();
            }

        });




    }
}
