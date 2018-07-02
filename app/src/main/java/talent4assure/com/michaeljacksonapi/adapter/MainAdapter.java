package talent4assure.com.michaeljacksonapi.adapter;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.List;

import talent4assure.com.michaeljacksonapi.R;
import talent4assure.com.michaeljacksonapi.model.DataList;

/**
 * Created by adity on 4/18/2018.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    public List<DataList> dataLists;
    public Button play, pause, stop;
    public MediaPlayer mediaPlayer;
    Context context;

    public MainAdapter(Context context, List<DataList> dataLists) {
        this.context = context;
        this.dataLists = dataLists;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cardview_mj, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {

        holder.artist.setText(dataLists.get(position).getArtist());
        holder.songName.setText(dataLists.get(position).getNameOfSong());
        holder.album.setText(dataLists.get(position).getAlbum());

        //for image method
        applyProfilePicture(holder, dataLists, position);

        //for song method
        playmusic(holder, dataLists, position);
    }

    //for song
    private void playmusic(MainViewHolder holder, List<DataList> dataList, int position) {

        final MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(dataList.get(position).getSong());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
        } catch (IOException e) {
            e.printStackTrace();
        }
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }

        });
        pause.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
            }
        });
        stop.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
            }
        });
    }

    //for image
    private void applyProfilePicture(MainViewHolder holder, List<DataList> dataList, final int position) {
        if (!TextUtils.isEmpty(dataList.get(position).getImage())) {
            Glide.with(context).load(dataList.get(position).getImage())
                    .thumbnail(0.5f)
                    .into(holder.imageView);

        } else {
            holder.imageView.setImageResource(R.drawable.mj);

        }
    }

    @Override
    public int getItemCount() {
        return dataLists.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        TextView artist, songName, album;
        ImageView imageView;

        public MainViewHolder(View itemView) {
            super(itemView);

            artist = itemView.findViewById(R.id.tv_artist);
            songName = itemView.findViewById(R.id.tv_song);
            album = itemView.findViewById(R.id.tv_album);
            imageView = itemView.findViewById(R.id.image_mic);
            play = itemView.findViewById(R.id.play);
            pause = itemView.findViewById(R.id.pause);
            stop = itemView.findViewById(R.id.stop);
        }
    }
}
