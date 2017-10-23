package net.december1900.douby.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.facebook.drawee.view.SimpleDraweeView;

import net.december1900.douby.R;
import net.december1900.douby.adapter.MainAdapter;
import net.december1900.douby.common.model.Movie;
import net.december1900.douby.net.NetFactory;
import net.december1900.douby.util.NetUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.bg_appbar)
    SimpleDraweeView mBgAppbar;
    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    private MainAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

//        Toolb = (Toolbar) findViewById(R.id.toolbar);


        initView();
    }

    private void initView() {
        setSupportActionBar(mToolbar);
        mCollapsingToolbarLayout.setTitle("A little bit more.");
        mBgAppbar.setImageURI(Uri.parse("res://drawable-xxhdpi/" + R.drawable.bg_appbar));
        loadData();
    }


    private void loadData() {
        if (NetUtil.isConnected()) {
            NetFactory.getRetrofitService().getMovies("20")
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Movie>() {
                        @Override
                        public void accept(Movie movie) throws Exception {
                            Log.d(TAG, movie.getSubjects() + " ");
                            for (int i = 0; i < movie.getSubjects().size(); i++) {
                                Log.d(TAG,movie.getSubjects().get(i).getId());

                            }
                            setupRecyclerView(movie.getSubjects());
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            Log.d(TAG, "onError : " + throwable.getMessage());
                        }
                    });

        }
    }

    private void setupRecyclerView(List<Movie.SubjectsEntity> movies) {
        mAdapter = new MainAdapter(movies);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnClickListenter(new MainAdapter.OnClickListener() {
            @Override
            public void OnClick(View view, List<Movie.SubjectsEntity> movies, int position) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("x", (int) view.getX());
                intent.putExtra("y", (int) view.getY());
                intent.putExtra("movieId", movies.get(position).getId());
                intent.putExtra("movieName", movies.get(position).getTitle());

                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
