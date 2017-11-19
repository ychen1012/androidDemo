package cn.edu.bistu.course2;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private RadioButton radioMale;
    private RadioButton radioFamale;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private EditText editBirthday;
    private DatePicker datePicker;
    private Button calbutton;
    private Spinner spin;

    private String g;
    private String d;
    String addddddddddd;

    private EditText editTextProvince;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1=(EditText)findViewById(R.id.editText);
        radioMale=(RadioButton) findViewById(R.id.radioMale);
        radioFamale=(RadioButton)findViewById(R.id.radioFemale);
        checkBox1=(CheckBox)findViewById(R.id.checkBox);
        checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        editBirthday=(EditText)findViewById(R.id.editTextBirthday);
        editBirthday.setKeyListener(null);

        datePicker=(DatePicker)findViewById(R.id.datePicker);
        calbutton=(Button)findViewById(R.id.button);
        spin=(Spinner)findViewById(R.id.spinner4);


        editBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.setVisibility(View.VISIBLE);
            }
        });
        datePicker.init(2013,8,20, new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfyear, int dayOfMonth) {
                Calendar calendar=Calendar.getInstance();
                calendar.set(year,monthOfyear,dayOfMonth);
                SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日");
                editBirthday.setText(format.format(calendar.getTime()));
                datePicker.setVisibility(View.INVISIBLE);
                d=format.format(calendar.getTime());
            }
        });




        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.grade,android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] grades=getResources().getStringArray(R.array.grade);
                g=grades[i];

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//页面3的跳转：
        editTextProvince=(EditText)findViewById(R.id.editText2);

        editTextProvince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Third_Activity.class);
                startActivityForResult(intent,1);





            }
        });
calbutton=(Button)findViewById(R.id.button);
        calbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =editText1.getText().toString();
                String birthday=editBirthday.getText().toString();
                String sex=radioMale.isChecked()?"男":"女";
                String address =editTextProvince.getText().toString();
                String interest="";
                if(checkBox1.isChecked()) interest+="足球";
                if(checkBox2.isChecked()) interest+="篮球";
                Intent intent=new Intent(MainActivity.this,Second_Activity.class);
                Bundle bundle=new Bundle();
                bundle.putString("name",name);
                bundle.putString("sex",sex);
                bundle.putString("interest",interest);
                bundle.putString("grade",g);
                bundle.putString("birthday",d);
                bundle.putString("address",addddddddddd);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode==1){
                    String returndata =data.getStringExtra("province");
                    addddddddddd=data.getStringExtra("province");
                    editTextProvince.setText(returndata);
                    ;


                }
        }
    }
}
