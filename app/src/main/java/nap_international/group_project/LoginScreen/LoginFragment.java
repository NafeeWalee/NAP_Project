package nap_international.group_project.LoginScreen;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import nap_international.group_project.HomeScreen.MainScreen;
import nap_international.group_project.R;

import static android.content.Context.MODE_PRIVATE;
import static nap_international.group_project.LoginScreen.RegistrationFragment.DATABASE_NAME;

public class LoginFragment extends Fragment {

    Button Button = null;
    View inflatedView = null;
    EditText username = null;
    EditText password = null;
    TextView textview = null;
    TextView textview2 = null;
    RelativeLayout RL = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.inflatedView = inflater.inflate(R.layout.fragment_login, container, false);
        Button = inflatedView.findViewById(R.id.button);
        username = inflatedView.findViewById(R.id.user);
        password = inflatedView.findViewById(R.id.pass);
        textview = inflatedView.findViewById(R.id.header);
        textview2 = inflatedView.findViewById(R.id.splashtext);
        RL = inflatedView.findViewById(R.id.relative1);

//custom text
        Typeface CustomFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/kaushanRegular.ttf");
        textview.setTypeface(CustomFont);

        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String something1 = username.getText().toString();
                String something2 = password.getText().toString();
                //database
                SQLiteDatabase mDatabase = getActivity().openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
                //select query
                Cursor cursor = mDatabase.rawQuery("select name,pass from users", null);
                //initial state of loop
                cursor.moveToFirst();
                boolean loginstatus = false;
                String NAME = "";
                do {
                    if (something1.equals(cursor.getString(0)) && (something2.equals(cursor.getString(1)))) {
                        loginstatus = true;
                        NAME = cursor.getString(0);
                    } else if (something1.isEmpty() || something2.isEmpty()) {
                        Toast.makeText(getContext(), "Please type user or pass", Toast.LENGTH_LONG).show();
                    }
                } while (cursor.moveToNext()); //loop in db
                if (loginstatus) {
                    Toast.makeText(getContext(), "Welcome " + NAME, Toast.LENGTH_SHORT).show();
                    Intent o = new Intent(getContext(), MainScreen.class);
                    o.putExtra("USER_NAME", NAME);
                    startActivity(o);
                    getActivity().finish();

                   // getFragmentManager().beginTransaction().replace(R.id.frameLayout, new RegistrationFragment()).commit();
                } else {
                    Toast.makeText(getContext(), "Invalid Details", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return inflatedView;
    }
}
