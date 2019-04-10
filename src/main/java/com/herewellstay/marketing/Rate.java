package com.herewellstay.marketing;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;

public class Rate {
    private static final String TAG = Rate.class.getSimpleName();
    private final SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private Context context;
    private Market market;


    public Rate(Context context, Market market) {
        this.context = context;
        this.market = market;
        preferences = context.getSharedPreferences(TAG, 0);
        editor = preferences.edit();
    }

    public void action() {
        dontPromptAgain();
        market.open();
    }

    public void prompt() {

        if (doesntPromptAgain()) {
            return;
        }

        final RateDialog dialog = new RateDialog();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.rate, null);
        RatingBar ratingBar = customView.findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                dontPromptAgain();
                dialog.dismiss();
                action();
            }
        });
        dialog.setContext(context);
        dialog.setCustomView(customView);
        dialog.show();
    }

    public void prompt(long launchesUntilPrompt) {
        long launch_count = preferences.getLong("launch_count", 0) + 1;
        editor.putLong("launch_count", launch_count);
        editor.commit();
        if (launch_count >= launchesUntilPrompt) {
            prompt();
        }
    }

    private boolean doesntPromptAgain() {
        return preferences.getBoolean("dont_show_again", false);
    }

    private void dontPromptAgain() {
        editor.putBoolean("dont_show_again", true);
        editor.commit();
    }

}
