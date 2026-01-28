package com.example.navgraphapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Meal implements Parcelable {
    private String title;
    private String price;
    private String description;
    private String deliveryTime;
    private int imageResId;

    public Meal(String title, String price, String description, String deliveryTime, int imageResId) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.deliveryTime = deliveryTime;
        this.imageResId = imageResId;
    }

    protected Meal(Parcel in) {
        title = in.readString();
        price = in.readString();
        description = in.readString();
        deliveryTime = in.readString();
        imageResId = in.readInt();
    }

    public static final Creator<Meal> CREATOR = new Creator<Meal>() {
        @Override
        public Meal createFromParcel(Parcel in) {
            return new Meal(in);
        }

        @Override
        public Meal[] newArray(int size) {
            return new Meal[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(price);
        dest.writeString(description);
        dest.writeString(deliveryTime);
        dest.writeInt(imageResId);
    }

    public String getTitle() { return title; }
    public String getPrice() { return price; }
    public String getDescription() { return description; }
    public String getDeliveryTime() { return deliveryTime; }
    public int getImageResId() { return imageResId; }
}