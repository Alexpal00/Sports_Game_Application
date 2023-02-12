package com.example.ergasia.ui.update;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UpdateViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UpdateViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("ΕΠΕΛΕΞΕ ΚΑΤΗΓΟΡΙΑ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
