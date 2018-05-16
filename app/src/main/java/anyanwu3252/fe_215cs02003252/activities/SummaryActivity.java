package anyanwu3252.fe_215cs02003252.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

import anyanwu3252.fe_215cs02003252.R;
import anyanwu3252.fe_215cs02003252.helper.Tools;
import anyanwu3252.fe_215cs02003252.helper.ViewAnimation;
import anyanwu3252.fe_215cs02003252.pref.OrderInfo;

public class SummaryActivity extends AppCompatActivity {

    private View lyt_expand_items, lyt_expand_description;
    private NestedScrollView nested_scroll_view;

    private OrderInfo orderInfo;

    private TextView total, stay, misc;

    Float totalCharge;

    String name;

    private AppCompatButton send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        orderInfo = new OrderInfo(this);
        send = findViewById(R.id.btnSend);

        name = orderInfo.getUserName();

        total = findViewById(R.id.totalCharge);

        total.setText(String.valueOf(orderInfo.getTotalCharge()));

        totalCharge = orderInfo.getTotalCharge();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // sends an email

                Intent intent = new Intent(android.content.Intent.ACTION_SENDTO);
                intent.setType("text/plain");
                intent.setData(Uri.parse("mailto:" + name + "@mail.com"));
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "HOSPITAL BILL");
                String bodyMessage = "Please here is your receipt: \n Total Charge: " +
                        totalCharge +
                        " GHS";
                intent.putExtra(android.content.Intent.EXTRA_TEXT, bodyMessage);
                startActivity(intent);
            }
        });
    }

    private void toggleSection(View bt, final View lyt) {
        boolean show = toggleArrow(bt);
        if (show) {
            ViewAnimation.expand(lyt, new ViewAnimation.AnimListener() {
                @Override
                public void onFinish() {
                    Tools.nestedScrollTo(nested_scroll_view, lyt);
                }
            });
        } else {
            ViewAnimation.collapse(lyt);
        }
    }

    public boolean toggleArrow(View view) {
        if (view.getRotation() == 0) {
            view.animate().setDuration(200).rotation(180);
            return true;
        } else {
            view.animate().setDuration(200).rotation(0);
            return false;
        }
    }
}
