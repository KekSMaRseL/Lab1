package algonquin.cst2335.test1.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {


    public MutableLiveData<String> theText = new MutableLiveData<>();
    public MutableLiveData<Boolean> isChecked = new MutableLiveData<>();

}


