package com.herewellstay.marketing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class Review {
    private Context context;
    private Market market;

    public Review(Context context, Market market) {
        this.context = context;
        this.market = market;
    }

    public void prompt() {

        final ReviewDialog dialog = new ReviewDialog();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.review, null);

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

    public void action() {
        market.open();
    }
}
