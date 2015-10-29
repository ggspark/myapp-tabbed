package apps.buddy.myapptabbed.parse;


import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseInstallation;

import apps.buddy.myapptabbed.R;


public class Application extends android.app.Application {

    public Application() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize the Parse SDK.
        Parse.enableLocalDatastore(this);
        //TODO: Change Parse API
        Parse.initialize(this, "", "");
        ParseInstallation.getCurrentInstallation().saveInBackground();

        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.color.primary)
                .showImageForEmptyUri(R.color.colorAccent)
                .showImageOnFail(R.color.blue_editable)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();

        // Create global configuration and initialize ImageLoader with this config
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).
                threadPoolSize(5)
                .defaultDisplayImageOptions(options)
                .build();
        ImageLoader.getInstance().init(config);

    }
}