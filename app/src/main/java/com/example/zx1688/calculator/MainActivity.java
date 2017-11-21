package com.example.zx1688.calculator;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import bsh.EvalError;
import bsh.Interpreter;

import java.util.Arrays;


import com.example.zx1688.calculator.R;

import org.w3c.dom.Text;

public class MainActivity extends Activity implements OnClickListener{
    //按钮  
    Button btn_1,btn_2,btn_3,
            btn_4,btn_5,btn_6,
            btn_7,btn_8,btn_9,
            btn_0,btn_add,btn_sub,
            btn_zf,btn_mul,btn_div,
            btn_cl,btn_dot,btn_equal,
            btn_mi,btn_sqrt,btn_sin,btn_cos,btn_unit,btn_ary;
    //用于判断是否需要重新输入  
    boolean restart;
    //屏幕上数字的正负状态  
    int front;
    //操作数与操作符  
    float operator1,operator2;
    int symbol;//
    //"+、—、*、/、x^y、/x、sinx、cosx"-->1、2、3、4、5、6、7、8  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化操作数（默认为0）操作符（默认为+）  
        operator1=0;
        operator2=0;
        restart=true;
        front=0;//默认为正数  
        TextView txt=(TextView)findViewById(R.id.textView);
        txt.setText("0");
        //获取button对象  
        btn_1= (Button)findViewById(R.id.btn1);
        btn_2= (Button)findViewById(R.id.btn2);
        btn_3= (Button)findViewById(R.id.btn3);
        btn_4= (Button)findViewById(R.id.btn4);
        btn_5= (Button)findViewById(R.id.btn5);
        btn_6= (Button)findViewById(R.id.btn6);
        btn_7= (Button)findViewById(R.id.btn7);
        btn_8= (Button)findViewById(R.id.btn8);
        btn_9= (Button)findViewById(R.id.btn9);
        btn_0= (Button)findViewById(R.id.btn0);
        btn_add= (Button)findViewById(R.id.btn_add);
        btn_sub= (Button)findViewById(R.id.btn_sub);
        btn_zf= (Button)findViewById(R.id.btn_zf);
        btn_mul= (Button)findViewById(R.id.btn_mul);
        btn_div= (Button)findViewById(R.id.btn_div);
        btn_cl= (Button)findViewById(R.id.btn_cl);
        btn_dot= (Button)findViewById(R.id.btn_dot);
        btn_equal= (Button)findViewById(R.id.btn_equal);
        btn_mi= (Button)findViewById(R.id.btn_mi);
        btn_sqrt= (Button)findViewById(R.id.btn_sqrt);
        btn_sin= (Button)findViewById(R.id.btn_sin);
        btn_cos= (Button)findViewById(R.id.btn_cos);
        btn_unit=(Button)findViewById(R.id.btn_unit) ;
        btn_ary=(Button)findViewById(R.id.btn_ary);
        //注册点击事件  
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_0.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_zf.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_cl.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_mi.setOnClickListener(this);
        btn_sqrt.setOnClickListener(this);
        btn_sin.setOnClickListener(this);
        btn_cos.setOnClickListener(this);
        btn_unit.setOnClickListener(this);
        btn_ary.setOnClickListener(this);
    }
    @Override
    //点击事件处理  
    public void onClick(View btn) {
        //获取文本框  
        TextView txt=(TextView) findViewById(R.id.textView);
        //文本框内容  
        String text=(String) txt.getText();
        float value=Float.parseFloat(text);                      //       解析一个字符串，并返回一个浮点数
        System.out.println(value);
        switch(btn.getId()){
            //数字
            case R.id.btn1:
                if(restart){
                    txt.setText("1");
                    restart=false;}
                else
                    txt.setText(text+"1");
                break;
            case R.id.btn2:
                if(restart){
                    txt.setText("2");
                    restart=false;}
                else
                    txt.setText(text+"2");
                break;
            case R.id.btn3:
                if(restart){
                    txt.setText("3");
                    restart=false;}
                else
                    txt.setText(text+"3");
                break;
            case R.id.btn4:
                if(restart){
                    txt.setText("4");
                    restart=false;}
                else
                    txt.setText(text+"4");
                break;
            case R.id.btn5:
                if(restart){
                    txt.setText("5");
                    restart=false;}
                else
                    txt.setText(text+"5");
                break;
            case R.id.btn6:
                if(restart){
                    txt.setText("6");
                    restart=false;}
                else
                    txt.setText(text+"6");
                break;
            case R.id.btn7:
                if(restart){
                    txt.setText("7");
                    restart=false;}
                else
                    txt.setText(text+"7");
                break;
            case R.id.btn8:
                if(restart){
                    txt.setText("8");
                    restart=false;}
                else
                    txt.setText(text+"8");
                break;
            case R.id.btn9:
                if(restart){
                    txt.setText("9");
                    restart=false;}
                else
                    txt.setText(text+"9");
                break;
            case R.id.btn0:
                if(restart)
                    txt.setText("00");
                else
                    txt.setText(text+"0");
                break;
            //+  
            case R.id.btn_add:
                symbol=1;
                operator1=value;
                restart=true;
                break;
            //-  
            case R.id.btn_sub:
                symbol=2;
                operator1=value;
                restart=true;
                break;
            //-/+  
            case R.id.btn_zf:
                if(restart){
                    txt.setText("-");
                    front=1;}
                else if(front==0){
                    txt.setText("-"+text);
                    front=1;}
                else if(front==1){
                    txt.setText(text.substring(1));
                    front=0;
                }
                break;
            //*  
            case R.id.btn_mul:
                symbol=3;
                operator1=value;
                restart=true;
                break;
            // /  
            case R.id.btn_div:
                symbol=4;
                operator1=value;
                restart=true;
                break;
            //C  
            case R.id.btn_cl:
                txt.setText("00");
                restart=true;
                break;
            // .  
            case R.id.btn_dot:
                if(restart)
                    txt.setText(".");
                else
                    txt.setText(text+".");
                restart=false;
                break;
            //=  
            case R.id.btn_equal:
                restart=true;
                switch(symbol){
                    case 1:
                        txt.setText(String.valueOf(operator1+value));
                        break;
                    case 2:
                        txt.setText(String.valueOf(operator1-value));
                        break;
                    case 3:
                        txt.setText(String.valueOf(operator1*value));
                        break;
                    case 4:
                        txt.setText(String.valueOf(operator1/value));
                        break;
                    case 5:
                        txt.setText(String.valueOf(Math.pow(operator1, value)));
                        break;
                }
                break;
            //x^y  
            case R.id.btn_mi:
                symbol=5;
                operator1=value;
                restart=true;
                break;
            // /x  
            case R.id.btn_sqrt:
                symbol=6;
                txt.setText(String.valueOf(Math.sqrt(value)));
                restart=true;
                break;
            // sinx  
            case R.id.btn_sin:
                symbol=7;
                txt.setText(String.valueOf(Math.sin(value)));
                restart=true;
                break;
            // cosx  
            case R.id.btn_cos:
                symbol=8;
                txt.setText(String.valueOf(Math.cos(value)));
                restart=true;
                break;
            case R.id.btn_unit:
                symbol=9;
                txt.setText(String.valueOf( Math.round(value/100d)/10d));
                restart=true;
                break;
            case R.id.btn_ary:
                symbol=10;
                txt.setText(String.valueOf(Integer.toBinaryString((int) value)));
                restart=true;
                break;

            default:
                break;
        }

    }

}