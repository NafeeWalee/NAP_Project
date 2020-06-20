package nap_international.group_project.HomeScreen;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import nap_international.group_project.R;
import nap_international.group_project.RecyclerScreen.VideoAdapter;
import nap_international.group_project.RecyclerScreen.VideoDataClass;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {


    Context context;
    RecyclerView rv = null;
    VideoAdapter va = null;
    View inflatedView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        this.inflatedView = inflater.inflate(R.layout.fragment_video, container, false);
        rv = inflatedView.findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
//adding data by info object of videoDataClass in RecyclerScreen folder
        final ArrayList<VideoDataClass> info = new ArrayList<>();
        info.add(new VideoDataClass("Twitch.tv", "Website", "Twitch is a live streaming video platform", R.drawable.twitchtv, "https://www.twitch.tv/"));
        info.add(new VideoDataClass("YouTube", "Video sharing company", "American video-sharing website", R.drawable.youtube3, "https://www.youtube.com/"));
        info.add(new VideoDataClass("Vine","Service","Vine was a short-form video hosting service",R.drawable.vine,"https://vine.co/"));
        info.add(new VideoDataClass("Metacafe", "Company", "Metacafe is a video-sharing website", R.drawable.metacafe, "http://www.metacafe.com/"));
        info.add(new VideoDataClass("Vimeo","Website","Vimeo is a video-sharing website",R.drawable.vimeo,"https://vimeo.com/"));
        info.add(new VideoDataClass("Veoh","Media company","Veoh is an Internet television company",R.drawable.veoh,"https://www.veoh.com/"));
        info.add(new VideoDataClass("Vevo","Website","Vevo is an American multinational video hosting service ",R.drawable.vevo,"https://www.vevo.com/"));


        va = new VideoAdapter(getContext(), info);
        rv.setAdapter(va);
//VideoAdapter in RecyclerScreen folder
        return inflatedView;
    }

}
