package net.december1900.douby.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.december1900.douby.R;
import net.december1900.douby.adapter.MainAdapter;
import net.december1900.douby.common.base.BaseFragment;
import net.december1900.douby.common.model.Movie;
import net.december1900.douby.net.NetFactory;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by december on 2017/8/22.
 */

public class MyFragment extends BaseFragment {

    public static MyFragment newInstance() {

        Bundle args = new Bundle();

        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private static final String TAG = "MyFragment";


    private RecyclerView mRecyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        loadData();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        return view;

    }

    private void loadData(){
        NetFactory.getRetrofitService().getMovies("20")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Movie>() {
                    @Override
                    public void accept(Movie movie) throws Exception {
                        Log.d(TAG,movie.getSubjects() +" ");
                        setupRecyclerView(movie.getSubjects());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG,"onError : " + throwable.getMessage());
                    }
                });
    }

    private void setupRecyclerView(List<Movie.SubjectsEntity> movies){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        MainAdapter adapter;
        adapter = new MainAdapter(movies);
        mRecyclerView.setAdapter(adapter);
        adapter.setOnTouch(new MainAdapter.OnTouchListener() {
            @Override
            public void OnClick(View view, List<Movie.SubjectsEntity> movie, int position) {
            }
        });

    }

}
