package com.example.carpooling;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class DetailActivity extends AppCompatActivity implements PaymentResultListener {

    TextView detailName, detailGender, detailSrc, detailDest, detailTime, detailNoPass, detailFare;
    ImageView detailImage;
    Button payRazorpay;
    String driverName, driverFare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailImage = findViewById(R.id.detailImage);
        detailName = findViewById(R.id.detailName);
        detailGender = findViewById(R.id.detailGender);
        detailSrc = findViewById(R.id.detailSrc);
        detailDest = findViewById(R.id.detailDest);
        detailTime = findViewById(R.id.detailTime);
        detailNoPass = findViewById(R.id.detailNoPass);
        detailFare = findViewById(R.id.detailFare);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailName.setText(bundle.getString("Name"));
            driverName = bundle.getString("Name");
            detailGender.setText(bundle.getString("Gender"));
            detailSrc.setText(bundle.getString("Source"));
            detailDest.setText(bundle.getString("Destination"));
            detailTime.setText(bundle.getString("Time"));
            detailNoPass.setText(bundle.getString("NoPassenger"));
            detailFare.setText(bundle.getString("FarePP"));
            driverFare = bundle.getString("FarePP");
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);
        }

        payRazorpay = findViewById(R.id.payBtnRazorpay);
        Checkout.preload(getApplicationContext());
        payRazorpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPayment();
            }
        });

    }

    private void startPayment(){

            /**
             * Instantiate Checkout
             */
            Checkout checkout = new Checkout();
            checkout.setKeyID("rzp_test_sxyxVRKZ0SPG8m");
            /**
             * Set your logo here
             */
            checkout.setImage(R.drawable.entry_splash);

            /**
             * Reference to current activity
             */
            final Activity activity = this;

            /**
             * Pass your payment options to the Razorpay Checkout as a JSONObject
             */
            try {
                JSONObject options = new JSONObject();

                options.put("name", driverName);
                options.put("description", "Reference No. #123456");
                options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg");
                //options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
                options.put("theme.color", "#3399cc");
                options.put("currency", "INR");
                options.put("amount", Integer.parseInt(driverFare)*100);//pass amount in currency subunits
                options.put("prefill.email", "gaurav.kumar@example.com");
                options.put("prefill.contact","9988776655");
                JSONObject retryObj = new JSONObject();
                retryObj.put("enabled", true);
                retryObj.put("max_count", 4);
                options.put("retry", retryObj);

                checkout.open(activity, options);

            } catch(Exception e) {
                Toast.makeText(getApplicationContext(), "Error in starting Razorpay Checkout", Toast.LENGTH_SHORT).show();
            }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(getApplicationContext(), "Thank you for eliminating CO2 and saving time!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(getApplicationContext(), "Error! Payment couldn't be processed", Toast.LENGTH_SHORT).show();
    }
}