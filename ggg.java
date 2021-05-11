package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
class mo implements MouseListener{
    Boolean tf=false,release=false,new1=false;
    Double rr;
    int x,count=0;
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e){
        if((1000-e.getX())*(1000-e.getX())+(350-e.getY())*(350-e.getY())>0 &&(1000-e.getX())*(1000-e.getX())+(350-e.getY())*(350-e.getY())<1600) {
            //System.out.println("f");
            count++;
            if(count==4){
                count=0;
            }
            tf = true;
        }
        else{
            tf = false;
        }
    }
    public void mouseReleased(MouseEvent e) {
        if(tf==true){
            rr=(Math.sqrt((1000-e.getX())*(1000-e.getX())+(350-e.getY())*(350-e.getY())))*2;
            x=1000-((e.getX()-1000)*2);
            if(e.getX()<1000){
                x=899;
            }
            release=true;
            new1=true;
            //System.out.println(rr);
        }
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
class b extends JPanel{
    int cx,cy,x,y,hanX,hanY,Sx,Sy,score;
    double nnn,k,dx1,df,r;
    ArrayList<Double[]> arr=new ArrayList();
    Random ran=new Random();
    Toolkit body;
    Image get;
    b(){
        cx=1000;
        cy=350;//Integer.parseInt(new java.text.DecimalFormat("0").format(0.0142*(x-150)*(x-150)-20));
        x=250;
        hanX=cx;
        hanY=cy;
        //y=Integer.parseInt(new java.text.DecimalFormat("0").format(cy-Math.sqrt(r*r-(x-cx)*(x-cx))));
        nnn=((cx-x)*(cx-x));
        k=(cy-y)/nnn;
        dx1=300-Math.sqrt((cy-y)/k);
        df=cx-dx1;
        Sx= ran.nextInt(750);
        Sy=ran.nextInt(780);
        score=0;
        body=getToolkit();
        get=body.getImage("src/img/mt.PNG");
        //System.out.println(dx1);
    }
    public void paint(Graphics c){
        setSize(1600,800);
        hanY=Integer.parseInt(new java.text.DecimalFormat("0").format(k*(hanX-x)*(hanX-x)+y));
        //y=Integer.parseInt(new java.text.DecimalFormat("0").format(0.0142*(x-150)*(x-150)-20));
        Graphics2D gg=(Graphics2D) c;
        gg.setColor(Color.ORANGE);
        //gg.fillOval(Sx,Sy,40,40);
        gg.setFont(new Font("宋体",Font.BOLD,20));
        gg.drawString("Score:"+score,1200,30);
        c.drawImage(get,Sx-40,Sy-40,100,100,this);
        for (int b=0;b<arr.size();b++){
            //g.fillOval(Integer.parseInt(new java.text.DecimalFormat("0").format(arr.get(b)[2])),Integer.parseInt(new java.text.DecimalFormat("0").format(arr.get(b)[3])),20,20);
            c.drawImage(body.getImage("src/img/bb"+b+".PNG"),Integer.parseInt(new java.text.DecimalFormat("0").format(arr.get(b)[2]))-20,Integer.parseInt(new java.text.DecimalFormat("0").format(arr.get(b)[3]))-20,40,40,this);
            //g.drawImage(body.getImage("6.PNG"),Integer.parseInt(new java.text.DecimalFormat("0").format(arr.get(b)[2])),Integer.parseInt(new java.text.DecimalFormat("0").format(arr.get(b)[3]),20,20,this);
        }
        //g.fillOval(cx,cy,20,20);
        c.drawImage(body.getImage("src/img/pp.JPG"),cx-25,cy-25,50,50,this);

    }
}
public class ggg {
    public static void main(String args[]) {
        JFrame wi = new JFrame("cehshi");
        Random ra=new Random();
        wi.setSize(1600, 600);
        wi.setBounds(100, 100, 1600, 800);
        Boolean run = true;
        b cc = new b();
        cc.setSize(500, 500);
        ArrayList<Double[]> arr=new ArrayList();
        int  count = 0;
        mo lin=new mo();
        cc.addMouseListener(lin);
        wi.add(cc);
        for (int i=0;i<4;i++){
            arr.add(new Double[]{-50.0,-50.0,-50.0,-50.0,-50.0,0.0,0.0,0.0});
        }
        while (run) {
            count++;
            try {
                Thread.sleep(1);//Integer.parseInt(new java.text.DecimalFormat("0").format( 1000/(speed+20))));
            } catch (InterruptedException e) {
                System.out.println("j");
            }
            if (lin.new1==true){
                cc.r=lin.rr;
                cc.x=lin.x;
                System.out.println(cc.x +" "+cc.r);
                if (Double.isNaN(cc.cy-Math.sqrt(cc.r*cc.r-(cc.x-cc.cx)*(cc.x-cc.cx))) ) {
                    cc.arr.get(lin.count)[2] = 1000.0;
                    cc.arr.get(lin.count)[3] = 350.0;
                    cc.arr.get(lin.count)[4] = 1.0;
                    cc.x=1000;
                    System.out.println("f");
                }
                else {
                    cc.y = Integer.parseInt(new java.text.DecimalFormat("0").format(cc.cy - Math.sqrt(cc.r * cc.r - (cc.x - cc.cx) * (cc.x - cc.cx))));
                    cc.nnn = ((cc.cx - cc.x) * (cc.cx - cc.x));
                    cc.dx1 = 1000 - Math.sqrt((cc.cy - cc.y) / cc.k);
                    arr.get(lin.count)[0] = lin.rr;
                    arr.get(lin.count)[5] = (cc.cy - cc.y) / cc.nnn;
                    arr.get(lin.count)[1] = cc.cx - (1000 - Math.sqrt((cc.cy - cc.y) / arr.get(lin.count)[5]));
                    arr.get(lin.count)[2] = 0.0 + cc.cx;
                    arr.get(lin.count)[3] = arr.get(lin.count)[5] * (arr.get(lin.count)[2] - cc.x) * (arr.get(lin.count)[2] - cc.x) + cc.y;
                    arr.get(lin.count)[4] = 0.0;
                    arr.get(lin.count)[6] = lin.x + 0.0;
                    arr.get(lin.count)[7] = cc.cy - Math.sqrt(cc.r * cc.r - (cc.x - cc.cx) * (cc.x - cc.cx));

                }
                cc.arr=arr;
                lin.new1=false;
            }
            if(lin.release==true) {
                for (int a=0;a<4;a++) {
                    if (Double.isNaN((cc.arr.get(a)[0])*1.5 / cc.arr.get(a)[1])) {
                        cc.arr.get(a)[2] = 1000.0;
                        cc.arr.get(a)[3]=350.0;
                        cc.arr.get(a)[4]=1.0;
                        System.out.println("f");
                    }
                    if (count % Math.abs(Integer.parseInt(new java.text.DecimalFormat("0").format(((cc.arr.get(a)[0])*1.5 / cc.arr.get(a)[1])))) == 0) {
                        if (cc.arr.get(a)[3] >= 800) {
                            cc.arr.get(a)[2] = 1000.0;
                            cc.arr.get(a)[3]=350.0;
                            cc.arr.get(a)[4]=1.0;
                        }

                        if (cc.arr.get(a)[4]==0.0) {
                            cc.arr.get(a)[2]--;
                            cc.arr.get(a)[3]=cc.arr.get(a)[5]*(cc.arr.get(a)[2]-cc.arr.get(a)[6])*(cc.arr.get(a)[2]-cc.arr.get(a)[6])+cc.arr.get(a)[7];
                        }
                        wi.add(cc);
                    }
                    if(Math.sqrt((cc.Sx+20-(cc.arr.get(a)[2]+10))*(cc.Sx+20-(cc.arr.get(a)[2]+10))+(cc.Sy+20-(cc.arr.get(a)[3]+10))*(cc.Sy+20-(cc.arr.get(a)[3]+10)))<50 ){
                        cc.Sy= ra.nextInt(740)+40;
                        cc.Sx= ra.nextInt(540)+40;
                        cc.arr.get(a)[4]=1.0;
                        cc.arr.get(a)[2] = 1000.0;
                        cc.arr.get(a)[3]=350.0;
                        cc.score++;
                    }
                    if (cc.score==5){
                        cc.get=cc.body.getImage("src/img/mt2.PNG");
                    }
                    if (cc.score==7){
                        cc.get=cc.body.getImage("src/img/mt3.PNG");
                    }


                }
            }
            wi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            wi.setVisible(true);
        }

    }
}