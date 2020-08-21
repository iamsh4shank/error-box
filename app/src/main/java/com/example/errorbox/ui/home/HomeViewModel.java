package com.example.errorbox.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Congratulations, you fixed installation and other dependency errors\n But this is just a starting the game");
    }

    public LiveData<String> getText() {
        return mText;
    }
}