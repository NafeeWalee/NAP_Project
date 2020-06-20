package nap_international.group_project.MusicScreen;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import nap_international.group_project.R;

public class CustomAdapter extends ArrayAdapter<Info> {

    private MediaPlayer mp;
    private boolean flag = true;

    public CustomAdapter(Context context, int resource, ArrayList<Info> objects) {
        super(context, resource, objects);
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater LF = LayoutInflater.from(getContext());
        View customView = LF.inflate(R.layout.fragment_music_layout, parent, false);

        TextView TV1 = customView.findViewById(R.id.adaptertext1);
        final ImageView IV = customView.findViewById(R.id.adapterimage);
        final ImageView IV2 = customView.findViewById(R.id.adapterimage2);
        RelativeLayout RL = customView.findViewById(R.id.relative);

        final String name = getItem(position).getTitle();
        final int pic = getItem(position).getButton();
        final int pic2 = getItem(position).getButton2();

        TV1.setText(name);
        IV.setImageResource(pic);
        IV2.setImageResource(pic2);

        //play
        IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    mp = MediaPlayer.create(getContext(), getItem(position).getSong());
                    flag = false;
                }
                if (mp.isPlaying()) {
                    mp.pause();
                    IV.setImageResource(R.drawable.play);
                } else {
                    mp.start();
                    IV.setImageResource(R.drawable.pause);
                    Toast.makeText(getContext(), name, Toast.LENGTH_SHORT).show();
                }
            }
        });
        //stop
        IV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    mp.stop();
                    mp.release();
                    flag = true;
                }
                IV.setImageResource(R.drawable.play);
            }
        });

        return customView;
    }
}

