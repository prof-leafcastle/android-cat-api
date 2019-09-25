package dk.au.orbitlab.android.catapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cat {

    private String name;
    private String imgUrl;

    public Cat(String name, String imgUrl) {
        this.name = name;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public class CatResponse {

        @SerializedName("file")
        @Expose
        private String file;

        public Cat getCat(){
            return new Cat("Carsten", file);
        }
    }
}
