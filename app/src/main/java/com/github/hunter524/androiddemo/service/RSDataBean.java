package com.github.hunter524.androiddemo.service;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hunter on 2017/2/13.
 */

public class RSDataBean implements Parcelable {
    private int data1;
    private int data2;



    public int getData2() {
        return data2;
    }

    public void setData2(int data2) {
        this.data2 = data2;
    }

    public int getData1() {
        return data1;
    }

    public void setData1(int data1) {
        this.data1 = data1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.data1);
        dest.writeInt(this.data2);
    }

    public RSDataBean() {
    }

    protected RSDataBean(Parcel in) {
        this.data1 = in.readInt();
        this.data2 = in.readInt();
    }

    public static final Parcelable.Creator<RSDataBean> CREATOR = new Parcelable.Creator<RSDataBean>() {
        @Override
        public RSDataBean createFromParcel(Parcel source) {
            return new RSDataBean(source);
        }

        @Override
        public RSDataBean[] newArray(int size) {
            return new RSDataBean[size];
        }
    };
}
