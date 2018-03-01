package example.xueguoxue.taiji;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by xueguoxue on 2018/2/27.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> list;
    private Context context;

    public MyAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        MyviewHolder holder = new MyviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       MyviewHolder my= (MyviewHolder) holder;
       my.item.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list!=null?list.size():0;
    }
        // 为什么我记不住
    static class MyviewHolder extends RecyclerView.ViewHolder{
            TextView item;
            public MyviewHolder(View itemView) {
                super(itemView);
                item=itemView.findViewById(R.id.one_item);
            }
        }

}
