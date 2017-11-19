package cn.edu.bistu.course_3;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.content.Intent;





public class MainActivity extends AppCompatActivity {

    private EditText start;
    private EditText end;
    private DatePicker datePicker;
    private EditText editTextdate;
    private Button sure;
    private String d;
    private String province1;
    private String province2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (EditText) findViewById(R.id.start);
        end = (EditText) findViewById(R.id.end);
        editTextdate = (EditText) findViewById(R.id.editTextdate);
        sure = (Button) findViewById(R.id.sure);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        editTextdate.setKeyListener(null);

        editTextdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.setVisibility(View.VISIBLE);
            }
        });
        datePicker.init(2013, 8, 20, new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfyear, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, monthOfyear, dayOfMonth);
                SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
                editTextdate.setText(format.format(calendar.getTime()));
                datePicker.setVisibility(View.INVISIBLE);
                d = format.format(calendar.getTime());
            }
        });


        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent();
                intent2.setClass(MainActivity.this, Second_Activity.class);

                Bundle bundle=new Bundle();
                bundle.putString("place1",province1);
                bundle.putString("place2",province2);
                bundle.putString("date",d);

                intent2.putExtras(bundle);
                startActivity(intent2);


            }
        });


        //3的跳转：

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Third_Activity.class);
                startActivityForResult(intent,1);
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Third_Activity.class);
                startActivityForResult(intent,2);
            }
        });





    }



       /* protected void onActivityResult(int requestCode, int requestCode2, int resultCode,int resultCode2,Intent data){
            switch (requestCode){
                case 1:
                    if (requestCode==1){
                        String returndata1 = data.getStringExtra("place1");
                        province1=data.getStringExtra("place1");
                        start.setText(returndata1);

                    }

                case 2:
                    if (requestCode2==1) {
                        String returndata2 = data.getStringExtra("place2");
                        province2 = data.getStringExtra("place2");
                        end.setText(returndata2);
                    }
            }

        }

*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode ==RESULT_OK){
                    String  returndata1 = data.getStringExtra("place1");
                    start.setText(returndata1);
                    province1=returndata1;
                    break;
                }
            case 2:
                if(resultCode ==RESULT_OK){
                    String returndata2 =data.getStringExtra("place1");
                    end.setText(returndata2);
                    province2=returndata2;
                    break;

                }
        }
    }
}
