package hkcc.ccn3165.intents;

import android.content.Intent;
import android.net.Uri;
import android.provider.Contacts;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonPage2 = (Button) findViewById(R.id.ButtonPage2);
        buttonPage2.setOnClickListener(buttonPage2Listner);
        Button buttonMarket = (Button) findViewById(R.id.ButtonMarket);
        Button buttonUrl = (Button) findViewById(R.id.ButtonUrl);
        Button buttonEmail = (Button) findViewById(R.id.ButtonEmail);
        Button buttonGMap = (Button) findViewById(R.id.ButtonGMap);
        Button buttonTel = (Button) findViewById(R.id.ButtonTel);
        Button buttonCamera = (Button) findViewById(R.id.ButtonCamera);
        Button buttonImage = (Button) findViewById(R.id.ButtonImage);
        Button buttonPeople = (Button) findViewById(R.id.ButtonPeople);

        buttonMarket.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                Uri uri = Uri.parse("market://search?q=AR");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }
        });

        /* Tutorial 4: Intents
        Button button = (Button) findViewById(R.id.ButtonUrl);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://www.hkcc-polyu.edu.hk/"));
                startActivity(i);
            }
        }); */

        buttonUrl.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                Uri uri = Uri.parse("http://moodle.cpce-polyu.edu.hk");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
            }
        });
        buttonEmail.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                Uri uri = Uri.parse("mailto:ccvschan@hkcc-polyu.edu.hk");
                Intent i = new Intent(Intent.ACTION_SENDTO, uri);
                startActivity(i);
            }
        });
        buttonGMap.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                Uri uri = Uri.parse("geo:22.303342,114.184828");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
            }
        });
        buttonTel.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:37460123");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
            }
        });
        buttonCamera.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(i);
            }
        });
        buttonImage.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.addCategory(Intent.CATEGORY_OPENABLE);
                i.setType("image/*");
                startActivityForResult(i, 0);
            }
        });
        buttonPeople.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Contacts.People.CONTENT_URI);
                startActivity(i);
            }
        });
    }

    private Button.OnClickListener buttonPage2Listner = new Button.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, Second.class);
            startActivity(intent);
        }
    };
}
