package cn.edu.bistu.course2;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


private String gradesss=null;
private String datesssss=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         EditText editText1=(EditText)findViewById(R.id.editText);
         final RadioButton radioMale=(RadioButton) findViewById(R.id.radioMale);
         final RadioButton radioFamale=(RadioButton)findViewById(R.id.radioFemale);
         final CheckBox checkBox1=(CheckBox)findViewById(R.id.checkBox);
         final CheckBox checkBox2=(CheckBox)findViewById(R.id.checkBox2);
         final EditText editBirthday=(EditText)findViewById(R.id.editTextBirthday);
        editBirthday.setKeyListener(null);
         final DatePicker datePicker=(DatePicker)findViewById(R.id.datePicker);
         Button calbutton=(Button)findViewById(R.id.button);
         Spinner spin=(Spinner)findViewById(R.id.spinner4);
        editBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                datePicker.setVisibility(View.VISIBLE);
            }
        });
        datePicker.init(2013,8,20, new DatePicker.OnDateChangedListener() {

            public void onDateChanged(DatePicker view, int year, int monthOfyear, int dayOfMonth) {
                Calendar calendar=Calendar.getInstance();
                calendar.set(year,monthOfyear,dayOfMonth);
                SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日");
                editBirthday.setText(format.format(calendar.getTime()));
                datePicker.setVisibility(View.INVISIBLE);
                datesssss=format.format(calendar.getTime());
            }
        });

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.grade,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               String[] grades=getResources().getStringArray(R.array.grade);
                gradesss=grades[i];
                Toast.makeText(MainActivity.this,"你点击的是："+grades[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        calbutton=(Button)findViewById(R.id.button);
        calbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sex="";
                if(radioMale.isChecked())
                    sex="男";
                else if(radioFamale.isChecked())
                    sex="女";



                String intrest="";
                if (checkBox1.isChecked())
                    intrest="足球";
                if (checkBox2.isChecked())
                    intrest="篮球";
                if(checkBox1.isChecked()&&checkBox2.isChecked())
                    intrest="足球和篮球";
                Toast.makeText(MainActivity.this,"性别："+sex+" "+"选择的是"+intrest+" "+"Grade"+gradesss+"Birthday"+datesssss, Toast.LENGTH_SHORT).show();


            }
        });








    }
}
