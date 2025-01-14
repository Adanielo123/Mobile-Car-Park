package com.example.carpark.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Bitmap;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.carpark.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.pdf417.encoder.BarcodeMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;


public class InvoiceActivity extends AppCompatActivity{

    private ImageView qrImage;
    private Object BarcodeMatrix;
    private String directionFrom;
    private String directionTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        getSupportActionBar().setTitle("Invoice");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();
    }

    private void initView() {
        qrImage = findViewById(R.id.qr_code);

        showQrCode();

        directionFrom = "20.344,34.34";
        directionTo = "20.5666,45.345";
    }

    public void showQrCode(){

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        //final Bitmap bm = null;

        String barcodeNumber = "CDE-uyr-7209";//For testing
        //BarcodeMatrix barcodeNumber;
        try {
           // bm = encod
            BitMatrix bitMatrix = multiFormatWriter.encode(barcodeNumber, BarcodeFormat.QR_CODE, 200, 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);

            qrImage.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }

    public void encodeAsBitmap(){

    }

    public void getDirection(View view){
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr="+directionFrom+"&daddr="+directionTo));
        //Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr=20.344,34.34&daddr=20.5666,45.345"));
        startActivity(intent);
    }

    private void setDirectionFrom(String directionFrom){
        this.directionFrom = directionFrom;
    }

    private void setDirectionTo(String directionTo){
        this.directionTo = directionTo;
    }

    private String getDirectionFrom(){
        return directionFrom;
    }

    private String getDirectionTO(){
        return directionTo;
    }


}
