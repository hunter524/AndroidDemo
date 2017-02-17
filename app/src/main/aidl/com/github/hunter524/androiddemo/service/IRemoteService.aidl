// IRemoteService.aidl
package com.github.hunter524.androiddemo.service;
import com.github.hunter524.androiddemo.service.RSDataBean;
// Declare any non-default types here with import statements

interface IRemoteService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
//    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
//            double aDouble, String aString);
int getPid();
RSDataBean getMyData(int i);
}
