package config;


import org.aeonbits.owner.ConfigFactory;

public class Credentials {
    public static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);


//    public static String getUserName() {
//        return config.user();
//    }
//
//    public static String getPassword() {
//        return config.password();
//    }
//
//    public static String getApp() {
//        return config.app();
//    }
//
//    public static String url() {
//        return config.url();
//    }
}
