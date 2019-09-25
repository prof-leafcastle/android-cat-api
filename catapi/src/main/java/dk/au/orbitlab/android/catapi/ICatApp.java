package dk.au.orbitlab.android.catapi;

import android.content.Context;

public interface ICatApp {

    public Context getContext();
    public void onCatFetched(Cat cat);
}
