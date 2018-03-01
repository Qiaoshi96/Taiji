package example.xueguoxue.taiji;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private TextView html;
   public static   Handler handler= new Handler();

    //图文混排
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
       /* html=findViewById(R.id.html);*/
       final TJview tJview=findViewById(R.id.tj);

        final Handler handler = new Handler() {
            private float degrees = 0;

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                tJview.setRotate(degrees += 2);
                this.sendEmptyMessageDelayed(0, 20);
            }
        };

        handler.sendEmptyMessageDelayed(0, 20);

        /*final String string = "<p><img alt=\"laugh\" height=\"23\" src=\"http://img3.imgtn.bdimg.com/it/u=3140599426,288343775&fm=26&gp=0.jpg\" " +
                "title=\"laugh\" width=\"23\" /> 简单的图文混排" +
                "<img alt=\"cheeky\" height=\"23\" src=\"http://img3.imgtn.bdimg.com/it/u=3140599426,288343775&fm=26&gp=0.jpg\" " +
                "title=\"cheeky\" width=\"23\" />这是展示内容</p>";

        //展示图片
        final Html.ImageGetter imgGetter = new Html.ImageGetter() {
            public Drawable getDrawable(String source) {
                Drawable drawable = null;
                URL url = null;
                try {
                    url = new URL(source);
                    drawable = Drawable.createFromStream(url.openStream(), "img");
                } catch (Exception e) {
                    return null;
                }
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable
                        .getIntrinsicHeight());
                return drawable;
            }
        };

        new Thread(new Runnable() {
            @Override
            public void run() {

                final Spanned spanned = Html.fromHtml(string, imgGetter, null);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,"gascjsdf ceds",Toast.LENGTH_LONG).show();
                        html.setText(spanned);
                    }
                });

            }
        }).start();*/




    }

}
