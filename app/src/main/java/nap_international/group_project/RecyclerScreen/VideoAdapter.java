package nap_international.group_project.RecyclerScreen;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import nap_international.group_project.R;
import nap_international.group_project.WebView.WebScreen;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.DataViewHolder> {
    private Context context;
    private List<VideoDataClass> dataList;

    public VideoAdapter(Context context, List<VideoDataClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.video_layout, null);
        DataViewHolder holder = new DataViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        final VideoDataClass VDC = dataList.get(position);
        holder.tv1.setText(VDC.getTitle());
        holder.tv2.setText(VDC.getLikes());
        holder.tv3.setText(VDC.getViews());
        holder.iv.setImageDrawable(context.getResources().getDrawable(VDC.getImage()));
        //onclick on linearLayout
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent o = new Intent(context, WebScreen.class);
                o.putExtra("WEB_URL", VDC.getAddress());
                context.startActivity(o);
                //sending web address to WebScreen class in WebView folder
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class DataViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv1;
        private TextView tv2;
        private TextView tv3;
        private LinearLayout ll;

        public DataViewHolder(View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.textView1);
            tv2 = itemView.findViewById(R.id.textView2);
            tv3 = itemView.findViewById(R.id.textView3);
            iv = itemView.findViewById(R.id.imageView1);
            ll = itemView.findViewById(R.id.linearLayout);
        }
    }
}
