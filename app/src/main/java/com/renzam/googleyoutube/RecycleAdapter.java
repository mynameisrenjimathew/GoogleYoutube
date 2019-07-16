package com.renzam.googleyoutube;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.List;

import static com.renzam.googleyoutube.R.layout.viedio_list;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    @NonNull
    List<Modelvideo> myViedioList;
    Context context;

    public RecycleAdapter(@NonNull List<Modelvideo> myViedioList, Context context) {
        this.myViedioList = myViedioList;
        this.context = context;
    }

    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(viewGroup.getContext()).inflate(viedio_list,viewGroup,false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {




        final YouTubePlayer.OnInitializedListener mOninitializedlistener;




        mOninitializedlistener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                youTubePlayer.loadVideo(myViedioList.get(i).getViedioId());


            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                Log.i("initialize ","failed");


            }
        };


        final String ApiKey ="AIzaSyCvXMI47ZOaiKGIbpyaNUi6X6qqegZ0pjI";




        viewHolder.youTubePlayerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewHolder.youTubePlayerView.initialize(ApiKey,mOninitializedlistener);

                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myViedioList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        YouTubePlayerView youTubePlayerView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            youTubePlayerView =(YouTubePlayerView) itemView.findViewById(R.id.youtubePlayerView);
        }
    }
}
