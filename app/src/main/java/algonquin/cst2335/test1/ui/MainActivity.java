package algonquin.cst2335.test1.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import algonquin.cst2335.test1.R;
import algonquin.cst2335.test1.data.MainViewModel;
import algonquin.cst2335.test1.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding variableBinding;
    private MainViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        model = new ViewModelProvider(this).get(MainViewModel.class);

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(variableBinding.getRoot());


        TextView theText =  variableBinding.theText;         //findViewById( R.id.theText);
        Button butt = variableBinding.theButton;                 //findViewById(R.id.theButton);
        EditText theEdit = variableBinding.theEditText;                              //findViewById( R.id.theEditText);
        CheckBox myCheckbox = variableBinding.myCheckbox;
        Switch mySwitch = variableBinding.mySwitch;
        RadioButton myRadioButton = variableBinding.myRadioButton;

        myCheckbox.setOnCheckedChangeListener( (a, b) -> {
            theText.setText("The checkbox is on?" + b);
        });

        mySwitch.setOnCheckedChangeListener( (a, b) -> {
            theText.setText("The switch is on?" + b);
        });

        myRadioButton.setOnCheckedChangeListener( (a, b) -> {
            theText.setText("The Radio Button is on?" + b);
        });


        theText.setText(model.theText);
        butt.setText(model.bText);
        theEdit.setText(model.EditString);
        variableBinding.theText.setText(model.EditString);
        variableBinding.theButton.setOnClickListener(click ->
                {
                    model.EditString = variableBinding.theEditText.getText().toString();
                    variableBinding.theText.setText(model.EditString);
                }




                );

        variableBinding.myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int width = v.getWidth();
                int height = v.getHeight();
                String message = "The width = " + width + " and height = " + height;
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });


        //b.setOnClickListener(  (v) -> {
            //model.theText = "You clicked the button";
            //model.bText = "something new here";
            //model.theEditText = theEdit.getText().toString();

            //theText.setText(model.theText);
            //b.setText(model.bText);
            //theText.setText("Your edit ext has: " + model.theEditText);



            //String words = theEdit.getText().toString();
            //theText.setText(words);
       // }
         //);

        //b.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {

               //String words = theEdit.getText().toString();
                //theText.setText(words);
            //}
        //});



    }
}






