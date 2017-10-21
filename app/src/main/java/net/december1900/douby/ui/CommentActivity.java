package net.december1900.douby.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import net.december1900.douby.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by december on 21/10/2017.
 */

public class CommentActivity extends AppCompatActivity {


    @BindView(R.id.base_layout)
    RelativeLayout mBaseLayout;
    @BindView(R.id.frame_layout)
    FrameLayout mFrameLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    public static void start(Context context) {
        Intent starter = new Intent(context, CommentActivity.class);
        context.startActivity(starter);
    }


    private String[] comments = new String[]{"超棒", "推荐", "还不错", "什么鬼"};
    private int[] percents = new int[]{10, 25, 18, 48};
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

//        MyChatView view = new MyChatView(getApplicationContext());
//        view.setStrPercent(percents);
//        mBaseLayout.addView(view);

    CircleView view = new CircleView(getApplicationContext());
        view.setPercents(percents);
        view.setText(text);
        mFrameLayout.addView(view);
//        CircleView circle = new CircleView(getApplicationContext());
//
//        circle.setText(text);
//        circle.setColors(colors);
//        circle.setPercents(percents);
//        circle.setComments(comments);
}


}
