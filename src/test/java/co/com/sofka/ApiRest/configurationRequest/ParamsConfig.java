package co.com.sofka.ApiRest.configurationRequest;

import static co.com.sofka.util.util.md5;

public class ParamsConfig {
    public static final  String publicKey = "44cf5f942492d56f288661708c66ac01";
    public static final  String privateKey = "34d900692bfc19800f8829d1ba101552d9a4f38a";
    public static final  String baseUrl = "https://gateway.marvel.com/v1/public";
    public static final  String timestamp = String.valueOf(System.currentTimeMillis() / 1000);

    public static final  String hash = md5(timestamp + privateKey + publicKey);

    public static final String TS = "ts";
    public static final String API_KEY = "apikey";
    public static final String HASH = "hash";
    public static final String ID = "id";



}
