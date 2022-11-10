package com.example.textutils;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import com.squareup.picasso.Picasso;

public class ImageActivity extends AppCompatActivity {
    Button previewBtn;
    TextInputEditText editUrlTxt;
    ImageButton rotateLeftImgBtn;
    ImageButton rotateRightImgBtn;
    Button flipHBtn;
    Button flipVBtn;
    Button hideBtn;
    Button showBtn;
    String sample = "https://img.etimg.com/thumb/msid-58559398,width-650,resizemode-4,imgsize-223989/baahubali-2-sets-a-new-benchmark-becomes-first-indian-film-to-cross-rs-1000-crore-mark.jpg";
    ImageView imageView;
    int angle = 0;
    int scaleX = 1;
    int scaleY = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        getSupportActionBar().setTitle("Image Utils");



        editUrlTxt = findViewById(R.id.edit_url_txt);
        imageView = findViewById(R.id.view_img);
        previewBtn = findViewById(R.id.preview_btn);
        rotateLeftImgBtn = findViewById(R.id.rotate_left_img_btn);
        rotateRightImgBtn = findViewById(R.id.rotate_right_img_btn);
        flipHBtn = findViewById(R.id.flip_h_btn);
        flipVBtn = findViewById(R.id.flip_v_btn);
        hideBtn = findViewById(R.id.hide_btn);
        showBtn = findViewById(R.id.show_btn);
        editUrlTxt.setText(sample);
        handlePreviewClick();
        handleLeftClick();
        handleRightClick();
        handleFlipHClick();
        handleFlipVClick();
        handleHideClick();
        handleShowClick();
    }

    private void handleShowClick() {
       showBtn.setOnClickListener(view -> {
           getSupportActionBar().show();
       });
    }

    private void handleHideClick() {
       hideBtn.setOnClickListener(view -> {
           getSupportActionBar().hide();
       });
    }

    private void handleFlipHClick() {
        flipHBtn.setOnClickListener(view -> {
            scaleX *= -1;
            imageView.setScaleX(scaleX);
        });
    }

    private void handleFlipVClick() {
        flipVBtn.setOnClickListener(view -> {
            scaleY *= -1;
            imageView.setScaleY(scaleY);
        });
    }

    private void handleLeftClick() {
        rotateLeftImgBtn.setOnClickListener(view -> {
            angle = angle + (-90 * scaleY * scaleX);
            String imageUrl = editUrlTxt.getText().toString();
            Picasso.get().load(imageUrl).rotate(angle).into(imageView);
        });
    }

    private void handleRightClick() {
        rotateRightImgBtn.setOnClickListener(view -> {
            angle = angle + (90 * scaleY * scaleX);
            String imageUrl = editUrlTxt.getText().toString();
            Picasso.get().load(imageUrl).rotate(angle).into(imageView);
        });
    }

    private void handlePreviewClick() {
        previewBtn.setOnClickListener(view -> {
            String imageUrl = editUrlTxt.getText().toString();
            angle = 0;
            scaleX = 1;
            scaleY = 1;
            imageView.setScaleX(scaleX);
            imageView.setScaleY(scaleY);
            Picasso.get().load(imageUrl).into(imageView);
        });
    }
}