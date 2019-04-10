package com.herewellstay.marketing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class About {
    private Context context;

    public About(Context context) {
        this.context = context;
    }

    public void show() {
        final AboutDialog dialog = new AboutDialog();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.about, null);

        Button button = customView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setContext(context);
        dialog.setCustomView(customView);
        dialog.show();

    }
}
