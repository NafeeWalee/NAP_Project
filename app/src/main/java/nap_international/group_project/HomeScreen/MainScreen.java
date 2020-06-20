package nap_international.group_project.HomeScreen;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import nap_international.group_project.LoginScreen.LoginScreen;
import nap_international.group_project.R;

public class MainScreen extends AppCompatActivity {

    String name;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFrag2 = null;
            switch (item.getItemId()) {
                //frame selection
                case R.id.VideoNav:
                    selectedFrag2 = new VideoFragment();
                    break;
                case R.id.MusicNav:
                    selectedFrag2 = new MusicFragment();
                    break;
            }
            //going to selected frame
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout2, selectedFrag2).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
        name = getIntent().getStringExtra("USER_NAME");

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation2);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //initial frame
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout2, new VideoFragment()).commit();
    }


    public void onBackPressed() {
        final AlertDialog.Builder ab = new AlertDialog.Builder(MainScreen.this);
        ab.setMessage("Do you wish to log out?\n " + name);
        ab.setCancelable(false);
        ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent o = new Intent(MainScreen.this, LoginScreen.class);
                startActivity(o);
                finish();
            }
        });
        ab.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog AD = ab.create();
        AD.show();

    }

}
