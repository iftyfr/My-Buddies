package com.example.ifty.buddies;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class BuddysDetailsActivity extends AppCompatActivity {

    private static final int CALL_PHONE_PERMISSION_CODE = 1;
    private static final int SEND_SMS_PERMISSION_CODE = 2;
    CircleImageView profile_image;
    TextView nameTv;
    TextView mobileNoTv;
    TextView emailTv;
    TextView bloodGroupTv;
    TextView addressTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddys_details);

        profile_image = findViewById(R.id.profile_image);
        nameTv = findViewById(R.id.nameTv);
        mobileNoTv = findViewById(R.id.mobileNoTv);
        emailTv = findViewById(R.id.emailTv);
        bloodGroupTv = findViewById(R.id.bloodGroupTv);
        addressTv = findViewById(R.id.addressTv);

        int image = getIntent().getIntExtra("image", 0);
        String name = getIntent().getStringExtra("name");
        String mobileNo = getIntent().getStringExtra("mobileNo");
        String email = getIntent().getStringExtra("email");
        String bloodGroup = getIntent().getStringExtra("bloodGroup");
        String address = getIntent().getStringExtra("address");

        profile_image.setImageResource(image);
        nameTv.setText(name);
        mobileNoTv.setText(mobileNo);
        emailTv.setText(email);
        bloodGroupTv.setText(bloodGroup);
        addressTv.setText(address);
    }

    public void callPhone(View view) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + mobileNoTv.getText().toString()));
            startActivity(callIntent);
        }
        else {
            requestCallphonePermission();
        }

    }

    private void requestCallphonePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)){
            new AlertDialog.Builder(this)
                    .setTitle("Permission Needed")
                    .setMessage("To make a call this permission is needed.")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(BuddysDetailsActivity.this,new String[] {Manifest.permission.CALL_PHONE},CALL_PHONE_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        }
        else {
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.CALL_PHONE},CALL_PHONE_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case CALL_PHONE_PERMISSION_CODE:
            if (grantResults.length>0 && grantResults[0] ==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Perission Denied", Toast.LENGTH_SHORT).show();
            }

            case SEND_SMS_PERMISSION_CODE:if (grantResults.length>0 && grantResults[0] ==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Perission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void sendSMS(View view) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
            Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + mobileNoTv.getText().toString()));
            startActivity(smsIntent);
        }
        else {
            requestSendSMSPermission();
        }

    }

    private void requestSendSMSPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SEND_SMS)) {
            new AlertDialog.Builder(this)
                    .setTitle("Permission Needed")
                    .setMessage("To send a SMS this permission is needed.")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(BuddysDetailsActivity.this, new String[]{Manifest.permission.SEND_SMS}, SEND_SMS_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        }

        else {
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.SEND_SMS},SEND_SMS_PERMISSION_CODE);
        }
    }

    public void sendEmail(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailTv.getText().toString()});
        emailIntent.setType("message/rfc822");
        try {
            startActivity(Intent.createChooser(emailIntent, "Choose an email client: (ex: Gmail app)"));

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_LONG).show();
        }
    }
}

