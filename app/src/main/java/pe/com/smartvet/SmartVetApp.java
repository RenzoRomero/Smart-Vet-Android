package pe.com.smartvet;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

import pe.com.smartvet.models.Vet;
import pe.com.smartvet.network.SmartVetService;

public class SmartVetApp extends Application {
    private static SmartVetApp instance;
    private SmartVetService smartVetService;

    public SmartVetApp() {
        super();
        instance = this;
    }

    public static SmartVetApp getInstance() {
        return instance;
    }

    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
        smartVetService = new SmartVetService();
    }

    public Vet getVet() {
        return smartVetService.getCurrentVet();
    }

    public SmartVetApp setVet(Vet vet) {
        smartVetService.setCurrentVet(vet);
        return this;
    }

    public String getToken() {
        return smartVetService.getCurrentToken();
    }

    public SmartVetApp setToken(String token) {
        smartVetService.setCurrentToken(token);
        return this;
    }
}
