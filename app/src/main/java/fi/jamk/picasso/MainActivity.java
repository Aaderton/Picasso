package fi.jamk.picasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    int x = 0;
    Button btnDrawableImage, btnUrlImage, btnErrorImage, btnPlaceholderImage, btnResizeImage, btnRotateImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        btnDrawableImage = (Button) findViewById(R.id.btnDrawable);
        btnUrlImage = (Button) findViewById(R.id.btnUrl);
        btnPlaceholderImage = (Button) findViewById(R.id.btnPlaceholder);
        btnErrorImage = (Button) findViewById(R.id.btnError);
        btnResizeImage = (Button) findViewById(R.id.btnResize);
        btnRotateImage = (Button) findViewById(R.id.btnRotate);

        btnDrawableImage.setOnClickListener(this);
        btnPlaceholderImage.setOnClickListener(this);
        btnUrlImage.setOnClickListener(this);
        btnResizeImage.setOnClickListener(this);
        btnErrorImage.setOnClickListener(this);
        btnRotateImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDrawable:
                Picasso.with(this).load(R.drawable.image).into(imageView);
                Toast.makeText(getApplicationContext(), "Show pic from drawable", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnPlaceholder:
                Picasso.with(this).load("http://student.labranet.jamk.fi/~H3183/android/").placeholder(R.mipmap.ic_launcher).into(imageView);
                Toast.makeText(getApplicationContext(), "Show placeholder pic", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnUrl:
                Picasso.with(this).load("http://student.labranet.jamk.fi/~H3183/android/toronto1.jpg").placeholder(R.mipmap.ic_launcher).into(imageView);
                Toast.makeText(getApplicationContext(), "Load pic from url", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnError:
                Picasso.with(this).load("http://student.labranet.jamk.fi/~H3183/android/").placeholder(R.mipmap.ic_launcher).error(R.drawable.error).into(imageView);
                Toast.makeText(getApplicationContext(), "Show error pic", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnResize:
                Picasso.with(this).load(R.drawable.image).resize(1280, 720).into(imageView);
                Toast.makeText(getApplicationContext(), "Resize drawable image", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnRotate:
                if (x == 4)
                    x = 0;
                else {
                    Toast.makeText(getApplicationContext(), "Rotate 90 degrees", Toast.LENGTH_SHORT).show();
                    if (x == 0) {
                        Picasso.with(this).load(R.drawable.image).rotate(90).into(imageView);
                    } else if (x == 1) {
                        Picasso.with(this).load(R.drawable.image).rotate(180).into(imageView);
                    } else if (x == 2) {
                        Picasso.with(this).load(R.drawable.image).rotate(270).into(imageView);
                    } else if (x == 3) {
                        Picasso.with(this).load(R.drawable.image).rotate(0).into(imageView);
                    }
                    x++;
                }
                break;
        }
    }

}

