// IDataService.aidl
package sdk.af.com.sdk;

// Declare any non-default types here with import statements

interface IDataService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    //void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
    //        double aDouble, String aString);

    void sendSessionData(String session);

    void sendEventData(String eventStr);
}
