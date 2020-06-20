package nap_international.group_project.HomeScreen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import nap_international.group_project.MusicScreen.CustomAdapter;
import nap_international.group_project.MusicScreen.Info;
import nap_international.group_project.R;

public class MusicFragment extends Fragment {
    View inflatedView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.inflatedView = inflater.inflate(R.layout.fragment_music, container, false);

        final ArrayList<Info> charInfo = new ArrayList<>();
        //adding data by charinfo object of Info class in MusicScreen folder
        charInfo.add(new Info(R.drawable.play, R.drawable.stop, "Philter Back To Yesterday", R.raw.philterbacktoyesterday));
        charInfo.add(new Info(R.drawable.play, R.drawable.stop, "Written in the stars", R.raw.writteninthestarslyrics));
        charInfo.add(new Info(R.drawable.play, R.drawable.stop, "Hero", R.raw.jj));
        charInfo.add(new Info(R.drawable.play, R.drawable.stop, "Devil May Cry", R.raw.dmc));
        charInfo.add(new Info(R.drawable.play, R.drawable.stop, "The Rising Fighting Spirit",R.raw.therising));
        charInfo.add(new Info(R.drawable.play, R.drawable.stop, "Carnival Of Rust", R.raw.carnivalofrust));
        charInfo.add(new Info(R.drawable.play, R.drawable.stop, "Decadence", R.raw.decadence));
        charInfo.add(new Info(R.drawable.play, R.drawable.stop, "Breaking the habit", R.raw.breakingthehabit));
        charInfo.add(new Info(R.drawable.play, R.drawable.stop, "The Dunk Squad", R.raw.thedunksquad));
        charInfo.add(new Info(R.drawable.play, R.drawable.stop, "The Spin Squad", R.raw.thespinsquad));

        ListView listView = inflatedView.findViewById(R.id.LV);
        CustomAdapter newadapter = new CustomAdapter(getContext(), R.layout.fragment_music_layout, charInfo);
        listView.setAdapter(newadapter);
        //adapter in MusicScreen folder
        return inflatedView;
    }

}
