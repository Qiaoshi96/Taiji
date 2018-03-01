package example.xueguoxue.taiji;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;

import android.view.View;


/**
 * Created by xueguoxue on 2018/2/26.
 */

public class TJview extends View {
    private Paint whitePaint;   //白色画笔

    private Paint blackPaing;   //黑色画笔
    //画笔初始化函数
    private void initPaints() {
        //创建白色画笔
        whitePaint = new Paint();
        whitePaint.setAntiAlias(true);//设置无锯齿
        whitePaint.setColor(Color.WHITE);
        //创建黑色画笔
        blackPaing = new Paint();
        blackPaing.setAntiAlias(true);
        blackPaing.setColor(Color.BLACK);
    }
    //用户直接new一个View时会被调用
    public TJview(Context context) {
        super(context);
        initPaints();       //初始化画笔
    }

    //用户在Layout文件中使用这个View时会被调用
    public TJview(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaints();       //初始化画笔
    }
    //设置旋转角度  默认角度
    private float degrees = 0;          //旋转角度
    public void setRotate(float degrees) {
        this.degrees = degrees;
        invalidate();   //重绘界面
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();                          //画布宽度
        int height = canvas.getHeight();                        //画布高度
        Point centerPoint = new Point(width / 2, height / 2);   //画布中心点

        canvas.translate(centerPoint.x, centerPoint.y);         //将画布移动到中心

        canvas.drawColor(Color.GRAY);                           //绘制背景色
        canvas.rotate(degrees);                                 //绘制旋转的角度

        //绘制两个半圆
        int radius = Math.min(width, height) / 2 - 100;             //太极半径
        RectF rect = new RectF(-radius, -radius, radius, radius);   //绘制区域
        canvas.drawArc(rect, 90, 180, true, blackPaing);            //绘制黑色半圆
        canvas.drawArc(rect, -90, 180, true, whitePaint);           //绘制白色半圆

        //绘制两个小圆
        int smallRadius = radius / 2;
        canvas.drawCircle(0, -smallRadius, smallRadius, blackPaing);
        canvas.drawCircle(0, smallRadius, smallRadius, whitePaint);

        //绘制鱼眼 位置和颜色
        canvas.drawCircle(0, -smallRadius, smallRadius / 4, whitePaint);
        canvas.drawCircle(0, smallRadius, smallRadius / 4, blackPaing);
    }
}
