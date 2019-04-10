package com.herewellstay.marketing;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class Share {
    private Context context;

    public Share(Context context) {
        this.context = context;
    }

    public void action() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Check this out! " + "http://play.google.com/store/apps/details?id=" + context.getPackageName();
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Awesome Android App!");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        Intent.createChooser(sharingIntent, "Share via");
        context.startActivity(sharingIntent);
    }


    public void prompt() {

        final ShareDialog dialog = new ShareDialog();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.share, null);

        Button button = customView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                action();
            }
        });
        dialog.setContext(context);
        dialog.setCustomView(customView);
        dialog.show();
    }


}
