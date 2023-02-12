package com.example.ergasia.ui.insert;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InsertViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public InsertViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("ΕΠΕΛΕΞΕ ΚΑΤΗΓΟΡΙΑ ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}