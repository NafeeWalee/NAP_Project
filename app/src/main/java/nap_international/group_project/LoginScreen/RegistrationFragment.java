package nap_international.group_project.LoginScreen;


import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import nap_international.group_project.R;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment implements View.OnClickListener {

    View inflatedView = null;
    Button Button = null;
    EditText username = null;
    EditText password = null;
    TextView textview = null;

    public static final String DATABASE_NAME = "DATABASE_NAME";
    SQLiteDatabase mDatabase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.inflatedView = inflater.inflate(R.layout.fragment_registration, container, false);
        Button = inflatedView.findViewById(R.id.button);
        username = inflatedView.findViewById(R.id.user);
        password = inflatedView.findViewById(R.id.pass);
        textview = inflatedView.findViewById(R.id.header);
//custom text
        Typeface CustomFont = Typeface.createFromAsset(getActivity().getAssets(), "fonts/kaushanRegular.ttf");
        textview.setTypeface(CustomFont);
        Button.setOnClickListener(this);
        mDatabase = getActivity().openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);
        //SQLiteDatabase mDatabase = getActivity().openOrCreateDatabase("DATABASE_NAME",android.content.Context.MODE_PRIVATE ,null);
        createUserTable();

        return inflatedView;
    }

    //button click
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                addUser();
                break;
        }
    }

    //table creation in db
    private void createUserTable() {
        mDatabase.execSQL(
                "CREATE TABLE IF NOT EXISTS users(\n" +

                        "name varchar(200) NOT NULL,\n" +
                        "pass varchar(200) NOT NULL\n" +
                        ");"
        );
    }

    //insert query
    private void addUser() {
        String name = username.getText().toString();
        String pass = password.getText().toString();

        if (inputsAreCorrect(name, pass)) {
            String insertSQL = "INSERT INTO users \n" +
                    "(name,pass)\n" +
                    "VALUES \n" +
                    "(?,?);";

            mDatabase.execSQL(insertSQL, new String[]{name, pass});

            Toast.makeText(getContext(), "Registered!", Toast.LENGTH_SHORT).show();
        }
    }

    //ET field check
    private boolean inputsAreCorrect(String name, String pass) {
        if (name.isEmpty()) {
            username.setError("Please enter a name");
            username.requestFocus();
            return false;
        }
        if (pass.isEmpty()) {
            password.setError("Please enter your password");
            password.requestFocus();
            return false;
        }
        return true;
    }
}
