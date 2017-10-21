package net.december1900.douby.ui;

import android.animation.Animator;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import net.december1900.douby.R;
import net.december1900.douby.common.model.Summary;
import net.december1900.douby.net.NetFactory;
import net.december1900.douby.util.NetUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by december on 2017/9/2.
 */

public class DetailActivity extends AppCompatActivity {


    private static final String TAG = "DetailActivity";

    @BindView(R.id.mv_summary)
    TextView mMvSummary;
    @BindView(R.id.mv_image)
    SimpleDraweeView mMvImage;
    @BindView(R.id.mv_name)
    TextView mMvName;


    private View mRevealLayout;

    private int mX;
    private int mY;

    private String movieId;
    private String movieName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        mRevealLayout = findViewById(R.id.reveal_layout);


        mX = getIntent().getIntExtra("x", 0);
        mY = getIntent().getIntExtra("y", 0);

        movieId = getIntent().getStringExtra("movieId");
        movieName = getIntent().getStringExtra("movieName");
        Log.d(TAG, movieId);

        mRevealLayout.post(new Runnable() {
            @Override
            public void run() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Log.d(TAG, mX + " ");
                    Log.d(TAG, mY + " ");
                    Animator animator = createRevealAnimator(false, mX, mY);
                    animator.start();
                }
            }
        });

        mRevealLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Animator animator = createRevealAnimator(true, (int) event.getX(), (int) event.getY());
                    animator.start();
                } else {
                    finish();
                }
                return false;
            }
        });

        loadData();


    }


    private void loadData() {
        if (NetUtil.isConnected()) {
            NetFactory.getRetrofitService().getSummary(movieId)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Summary>() {
                        @Override
                        public void accept(Summary summary) throws Exception {
                            mMvSummary.setText(summary.getSummary());
                            mMvImage.setImageURI(Uri.parse(summary.getImages().getLarge()));
                            mMvName.setText("「 " + movieName + " 」");
                        }
                    });
        }
    }

    private Animator createRevealAnimator(boolean reversed, int x, int y) {
        float hypot = (float) Math.hypot(mRevealLayout.getHeight(), mRevealLayout.getWidth());
        float startRadius = reversed ? hypot : 0;
        float endRadius = reversed ? 0 : hypot;

        Animator animator = ViewAnimationUtils.createCircularReveal(
                mRevealLayout, x, y,
                startRadius,
                endRadius);
        animator.setDuration(400);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        if (reversed)
            animator.addListener(animatorListener);
        return animator;
    }


    private Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            mRevealLayout.setVisibility(View.GONE);
            finish();
        }

        @Override
        public void onAnimationCancel(Animator animation) {
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
        }
    };

    @Override
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Animator animator = createRevealAnimator(true, mX, mY);
            animator.start();
        } else {
            finish();
        }
    }

}
