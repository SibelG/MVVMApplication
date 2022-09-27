package com.example.mvvmapplication.viewmodels;


import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;
import com.example.mvvmapplication.Model.UserModel;

public class LoginViewModel extends BaseObservable {

    private UserModel userModel;
    private String SuccessMessage="Login was Successfull";
    private String ErrorMessage="Email or Password not Valid";

    @Bindable
    private String toastMessage=null;


    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }

    @Bindable
    public String getUserEmail() {
        return userModel.getEmail();
    }

    @Bindable
    public String getUserPassword() {
        return userModel.getPassword();
    }

    public void setUserEmail(String email) {
        userModel.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }



    public void setUserPassword(String password) {
        userModel.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }
    public LoginViewModel(){
        userModel=new UserModel("","");
    }

    public void onButtonClicked(){
        if(isValid())
            setToastMessage(SuccessMessage);
        else
            setToastMessage(ErrorMessage);

    }

    public boolean isValid(){
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches()
                && getUserPassword().length()>5;
    }


}
