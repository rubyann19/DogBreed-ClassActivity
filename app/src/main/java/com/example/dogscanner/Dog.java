package com.example.dogscanner;

import android.os.Parcel;
import android.os.Parcelable;

public class Dog implements Parcelable {
    String message;

    public Dog(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(message);
    }
}
