package example.xueguoxue.taiji;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Scrollviewconfident extends AppCompatActivity {
    private RecyclerView one_re;
    private RecyclerView two_re;
    private ScrollView scroll;
    private ProgressBar progressBar;
    private TextView banner;
    private List<String> one_list = new ArrayList<>();
    private List<String> two_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollviewconfident);
        two_re = findViewById(R.id.two_re);
        one_re = findViewById(R.id.one_re);
        scroll = findViewById(R.id.scroll);
        progressBar=findViewById(R.id.progress);
        banner=findViewById(R.id.banner);
        banner.setFocusable(true);
        banner.setFocusableInTouchMode(true);
        banner.requestFocus();
        for (int i = 0; i <=3; i++) {
            one_list.add("第一个item" + i);
        }

        for (int i = 0; i <= 5; i++) {
            two_list.add("第二个item-------" + i);
        }
        LinearLayoutManager manager = new LinearLayoutManager(this);
        one_re.setNestedScrollingEnabled(false);
        one_re.setLayoutManager(manager);
        one_re.setAdapter(new MyAdapter(one_list, Scrollviewconfident.this));
        LoadeMore();

    }

    private void LoadeMore() {

        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        two_re.setNestedScrollingEnabled(false);
        two_re.setLayoutManager(manager1);
        final MyAdapter myAdapter = new MyAdapter(two_list, Scrollviewconfident.this);
        two_re.setAdapter(myAdapter);

     /*   two_re.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                LinearLayoutManager lm = (LinearLayoutManager) recyclerView.getLayoutManager();
                int totalItemCount = recyclerView.getAdapter().getItemCount();
                int lastVisibleItemPosition = lm.findLastVisibleItemPosition();
                int visibleItemCount = recyclerView.getChildCount();

               *//* if (newState == RecyclerView.SCROLL_STATE_IDLE
                        && lastVisibleItemPosition == totalItemCount - 1
                        && visibleItemCount > 0) {

                    //加载更多
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                          two_list.add("第二个item-------后加");
                            //Toast.makeText(Scrollviewconfident.this, "加载成功！", Toast.LENGTH_SHORT).show();

                        }
                    }, 1000);
                }*//*
            }
        });*/

        scroll.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_UP:
                        //一秒加载更多
                        //当文本的measureheight 等于scroll滚动的长度+scroll的height
                        if (scroll.getChildAt(0).getMeasuredHeight() <= scroll.getScrollY() + scroll.getHeight()) {
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    for (int i = 0; i < 10; i++) {
                                        two_list.add("这个是后加的");
                                    }
                                    myAdapter.notifyDataSetChanged();
                                    Toast.makeText(Scrollviewconfident.this, "加载成功！", Toast.LENGTH_SHORT).show();
                                    progressBar.setVisibility(View.VISIBLE);
                                }
                            }, 1000);
                        }else {
                            //progressBar.setVisibility(View.GONE);
                        }
                        break;

                }

                return false;
            }
        });
    }
}
