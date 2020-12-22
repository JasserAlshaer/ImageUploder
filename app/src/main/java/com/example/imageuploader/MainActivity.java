package com.example.imageuploader;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;
public class MainActivity extends AppCompatActivity {
    // step 1
    CircleImageView profileImage;
    Uri selectedImage;
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ChangeTrainerImage(View view) {
    //via this method we going to pick up an image from the Gallery
        Intent picker=new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(picker,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1 && requestCode==RESULT_OK && data!=null){
            try {
                selectedImage=data.getData();
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),selectedImage);
                profileImage.setImageBitmap(bitmap);
            }catch (Exception exception){

            }
        }else{
            Toast.makeText(this, "Something Wrong !", Toast.LENGTH_SHORT).show();
        }
    }

    public void continueSignupAsTrainer(View view) {
    }
}