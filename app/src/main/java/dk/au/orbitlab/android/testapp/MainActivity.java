package dk.au.orbitlab.android.testapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import dk.au.orbitlab.android.catapi.Cat;
import dk.au.orbitlab.android.catapi.CatFetcher;
import dk.au.orbitlab.android.catapi.CatImageView;
import dk.au.orbitlab.android.catapi.ICatApp;
import dk.au.orbitlab.android.catapi.testapp.R;

public class MainActivity extends AppCompatActivity implements ICatApp {

    CatFetcher catsFetcher;
    CatImageView catImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cat_layout);

        catsFetcher = new CatFetcher(this);
        catImageView = findViewById(R.id.catImageView);
        catImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                catsFetcher.getRandomCat();
            }
        });
        catsFetcher.getRandomCat();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onCatFetched(Cat cat) {
        catImageView.setCat(cat);
    }
}
