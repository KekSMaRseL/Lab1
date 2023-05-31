package algonquin.cst2335.test1.ui;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
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

        variableBinding.myCheckbox.setOnCheckedChangeListener((a, b) -> {
            model.isChecked.postValue(b);
        });

        variableBinding.mySwitch.setOnCheckedChangeListener((a, b) -> {
            model.isChecked.postValue(b);
        });

        variableBinding.myRadioButton.setOnCheckedChangeListener((a, b) -> {
            model.isChecked.postValue(b);
        });

        model.isChecked.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                variableBinding.myCheckbox.setChecked(aBoolean);
                variableBinding.mySwitch.setChecked(aBoolean);
                variableBinding.myRadioButton.setChecked(aBoolean);
                Toast.makeText(MainActivity.this, "The value is now: " + aBoolean, Toast.LENGTH_SHORT).show();
            }
        });

        model.theText.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                variableBinding.theText.setText(s);
            }
        });

        variableBinding.theButton.setOnClickListener(click -> {
            model.theText.postValue(variableBinding.theEditText.getText().toString());
        });

        variableBinding.myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int width = v.getWidth();
                int height = v.getHeight();
                String message = "The width = " + width + " and height = " + height;
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}