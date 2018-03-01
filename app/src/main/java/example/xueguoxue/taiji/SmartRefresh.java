package example.xueguoxue.taiji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class SmartRefresh extends AppCompatActivity {
    private RecyclerView recycle;
    private SmartRefreshLayout refresh;
    private ImageView gif_image;
    private List<String> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_refresh);
        recycle=findViewById(R.id.recycle);
        refresh=findViewById(R.id.refresh);
        gif_image=findViewById(R.id.gif_image);
        //加载动态图
        Glide.with(this).load(R.mipmap.smile).into(gif_image);
        getData();
        LinearLayoutManager manager = new LinearLayoutManager(SmartRefresh.this);
        recycle.setLayoutManager(manager);
        final MyAdapter myAdapter = new MyAdapter(list, SmartRefresh.this);
        recycle.setAdapter(myAdapter);
        refresh.autoRefresh();
        //尝试定义样式
        refresh.setRefreshHeader(new ClassicsHeader(this));
        refresh.setRefreshFooter(new BallPulseFooter(this));
        //上拉刷新
        refresh.setDisableContentWhenLoading(true);
        refresh.setEnableFooterTranslationContent(false);
        //下拉加载更多
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                for (int i=0;i<5;i++){
                    list.add("加载更多");
                }
                myAdapter.notifyDataSetChanged();
                refreshlayout.finishLoadmore(2000/*,false*/);//传入false表示加载失败
            }
        });
    }
    private void getData(){
        for (int i=0;i<50;i++){
            list.add("匆匆那些错过的很多很多"+i);
        }
    }
}
