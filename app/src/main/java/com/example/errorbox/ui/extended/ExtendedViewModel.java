package com.example.errorbox.ui.extended;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ExtendedViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ExtendedViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Congratulations, you fixed installation and other dependency errors\n But this is just a starting the game");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
