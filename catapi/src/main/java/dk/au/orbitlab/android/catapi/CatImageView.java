package dk.au.orbitlab.android.catapi;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import com.bumptech.glide.Glide;

public class CatImageView extends AppCompatImageView {

    private Cat cat;

    public CatImageView(Context context) {
        super(context);
    }

    public CatImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CatImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setCat(Cat cat){
        this.cat = cat;
        Glide.with(this.getContext()).load(cat.getImgUrl()).into(this);
    }
}
