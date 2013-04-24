package com.example.androidhive;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class CreditsActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credits);

        // New block to print the body text in the Credits page
        TextView textView = (TextView) findViewById(R.id.creditsBodyView);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String text = "EZ-Go is an application that helps users to find cheapest transportation among several transportation modes. "
                + "The users are able to choose from airplane, rented car, bus and train. <br/><br/>"
                + "A very special thanks to Mr. Keehwan Park, who has lent us a helping hand in solving technical problems.<br/><br/>"
                + "Sincerely,<br/><br/>"
                + "					Harry Tran<br/>					Kishen Sivalingam<br/>					Yiyang Pan<br/>					Wei Haow Tan<br/>					Jun Xiang Tee<br/><br>"
                + "Reach us at tan85@purdue.edu for inquiries.";
        textView.setText(Html.fromHtml(text));
        // End of body text block
    }
    
}
