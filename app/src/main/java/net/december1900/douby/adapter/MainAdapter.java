package net.december1900.douby.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.december1900.douby.R;
import net.december1900.douby.common.model.Movie;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by december on 2017/8/22.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {


    private List<Movie.SubjectsEntity> mMovie;
    private OnClickListener mOnClickListener;

    public interface OnClickListener {
        void OnClick(View view, List<Movie.SubjectsEntity> movies, int position);
    }

    public MainAdapter(List<Movie.SubjectsEntity> movie) {
        this.mMovie = movie;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.setIsRecyclable(false);
        holder.mTvNum.append(position + 1 + "");
        Random random = new Random();
        holder.mTvSeat.setText(random.nextInt(10) + "" + "排" + random.nextInt(20) + "" + "座");
        holder.mTvName.setText(mMovie.get(position).getTitle());
        holder.mTvYear.setText(mMovie.get(position).getYear());
        holder.mTvRating.append(mMovie.get(position).getRating().getAverage() + "");
        holder.mTvActor.append(mMovie.get(position).getCasts().get(0).getName() + "/" + mMovie.get(position).getCasts().get(1).getName());
        holder.mBaseLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnClickListener != null){
                    mOnClickListener.OnClick(v,mMovie,position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMovie.size();
    }

    public void setOnClickListenter(OnClickListener onClickListenter) {
        this.mOnClickListener = onClickListenter;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.base_layout)
        RelativeLayout mBaseLayout;
        @BindView(R.id.tv_num)
        TextView mTvNum;
        @BindView(R.id.tv_seat)
        TextView mTvSeat;
        @BindView(R.id.tv_name)
        TextView mTvName;
        @BindView(R.id.tv_year)
        TextView mTvYear;
        @BindView(R.id.tv_rating)
        TextView mTvRating;
        @BindView(R.id.tv_actor)
        TextView mTvActor;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
