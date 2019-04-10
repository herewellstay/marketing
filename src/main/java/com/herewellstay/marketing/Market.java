package com.herewellstay.marketing;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class Market {
    private Context context;

    public Market(Context context) {
        this.context = context;
    }

    public void open() {
        try {
            context.startActivity(app());
        } catch (ActivityNotFoundException e) {
            context.startActivity(website());
        }
    }


    private Intent app() {
        Uri uri = Uri.parse("open://details?id=" + context.getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        // To count with Play open backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        return goToMarket;
    }

    private Intent website() {

        return new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://play.google.com/store/apps/details?id=" + context.getPackageName()));
    }


}
