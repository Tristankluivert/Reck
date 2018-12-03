package ng.com.hybrid.reck;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {
        private Context mContext;
        private List<Upload> mUploads;
public CircleImageView imageView;
        public ImageAdapter(Context context, List<Upload> uploads) {
            mContext = context;
            mUploads = uploads;
        }

        @Override
        public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.postslayout, parent, false);
            return new ImageViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ImageViewHolder holder, int position) {
            Upload uploadCurrent = mUploads.get(position);
            holder.t4.setText(uploadCurrent.getName());
            holder.t2.setText(uploadCurrent.getmService());
            holder.t3.setText(uploadCurrent.getmLocation());
            holder.textViewName1.setText(uploadCurrent.getmPrice());
            Picasso.get().load(String.valueOf(mContext)).into(imageView);
        }

        @Override
        public int getItemCount() {
            return mUploads.size();
        }

        public class ImageViewHolder extends RecyclerView.ViewHolder {
            public TextView textViewName1,t2,t3,t4;
         CircleImageView  imageView;

            public ImageViewHolder(View itemView) {
                super(itemView);

                t4 = itemView.findViewById(R.id.postlabel);
                t2 = itemView.findViewById(R.id.postlocation);
                textViewName1 = itemView.findViewById(R.id.postprice);
                t3 = itemView.findViewById(R.id.postservice);
                imageView = itemView.findViewById(R.id.postimage);
            }
        }
}
