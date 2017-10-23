package net.december1900.douby.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.december1900.douby.R;
import net.december1900.douby.common.model.Comment;
import net.december1900.douby.net.NetFactory;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by december on 21/10/2017.
 */

public class CommentActivity extends AppCompatActivity {

    private static final String TAG = "CommentActivity";

    @BindView(R.id.base_layout)
    RelativeLayout mBaseLayout;
    @BindView(R.id.frame_layout)
    FrameLayout mFrameLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.num_count)
    TextView mNumCount;
    @BindView(R.id.mv_comment)
    TextView mMvComment;

    private String id;
    private int count;

    public static void start(Context context, String id, int count) {
        Intent starter = new Intent(context, CommentActivity.class);
        starter.putExtra("movieId", id);
        starter.putExtra("movieComment", count);
        context.startActivity(starter);
    }


    //    private String[] comments = new String[]{"超棒", "推荐", "还不错", "什么鬼"};
    private int[] percents = new int[4];
    private String text = "超棒";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        id = getIntent().getStringExtra("movieId");
        count = getIntent().getIntExtra("movieCount", 159723);

        loadComment();


    }


    private void loadComment() {
        NetFactory.getRetrofitService().getComment(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Comment>() {
                    @Override
                    public void accept(Comment comment) throws Exception {
                        percents[0] = Integer.parseInt(new DecimalFormat("0").format(comment.rate4));
                        percents[1] = Integer.parseInt(new DecimalFormat("0").format(comment.rate3));
                        percents[2] = Integer.parseInt(new DecimalFormat("0").format(comment.rate2));
                        percents[3] = Integer.parseInt(new DecimalFormat("0").format(comment.rate1));

                        int sum = 0;
                        for (int i = 0; i < 4; i++) {
                            sum += percents[i];
                            if (sum != 101) {
                                percents[3] += 101 - sum;
                            }
                        }

                        CircleView view = new CircleView(getApplicationContext());
                        view.setPercents(percents);
                        view.setText(text);
                        mFrameLayout.addView(view);

                        mNumCount.setText("评价人数：" + count);
                        mMvComment.setText(comment.comment);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, throwable.getMessage() + "");
                    }
                });
    }


}