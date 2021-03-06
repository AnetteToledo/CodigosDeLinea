
import java.awt.*;

public class AreaGrafica extends Canvas{   

  private String c;

  public AreaGrafica(){
    c="";
  }

  public void graficar(String cad){
    c=cad;
    repaint();
  }

  public void paint(Graphics g){
    int val;
    int ab=20;
    int[] abAcum = new int[5];
    int prev = 0;
    int aux_bip=266;
    int aux_pse=56;
    int aux_rz=200; 
    
    g.setColor(Color.black);
    g.fillRect(23,8,699,380);
    for(int y=0;y<5;y++) 
        abAcum[y]=115;
    for(int i=38;i<380;i+=70){ //lineas horizontales de la grafica
      g.setColor(Color.white);//
      g.drawLine(23,i,722,i);
      g.setColor(Color.white);
      for(int j=114;j<=722;j+=10){//linea punteada horizontal
        g.drawLine(j,i+17,j+1,i+17);
        g.setColor(Color.white);
        g.drawLine(j,i+37,j+9,i+37);
        g.setColor(Color.white);
        g.drawLine(j,i+57,j+1,i+57);
      }
      g.setColor(Color.white);
      g.drawString(" 1",98,i+20);
      g.drawString(" 0",98,i+40);
      g.drawString("-1",98,i+60);
    }
    g.drawString("CÓDIGO",26,73);
    g.drawString("PSEUDO...",25,88);
    g.drawString("CÓDIGO",28,143);
    g.drawString("NRZ",40,158);
    g.drawString("CÓDIGO",32,218);
    g.drawString("B - RZ",40,232);
    g.drawString("CÓDIGO",26,275);
    g.drawString("AMI",41,288);
    g.drawString("CÓDIGO",27,353);
    g.drawString("MANCHESTER",10,368);
    g.drawLine(113,8,113,388);
  // here i go
    
    for(int u=0;u<(c.length()<31?c.length():30);u++){
      g.setColor(Color.white);
      for(int q=14;q<=374;q+=12)
        g.drawLine(abAcum[0]+ab,q,abAcum[0]+ab,q+1);
      g.setColor(Color.yellow);    
      g.drawString(""+c.charAt(u),abAcum[0]+6,28);
      val=(int)(c.charAt(u))-48;
      if(prev!=val){
        //g.drawLine(abAcum[0],76,abAcum[0],76); // pseudoternario
        g.drawLine(abAcum[1],126,abAcum[1],166); //  NRZ
      }
      else
        g.drawLine(abAcum[4],336,abAcum[4],376); // vertical divisora pulso anterior y actual manchester
      if(val==1){
        g.drawLine(abAcum[0],76,(abAcum[0]+=ab),76);//pulso bajo Pseudoternario
        g.drawLine(abAcum[1],126,(abAcum[1]+=ab),126); // pulso alto  NRZ
        g.drawLine(abAcum[2],196,abAcum[2],216); // vertical divisora pulso anterior y actual  RZ
        g.drawLine(abAcum[2],196,(abAcum[2]+=(int)(ab/2)),196); // Medio pulso alto RZ
        g.drawLine(abAcum[2],196,abAcum[2],216); // vertical divisora medio pulso  RZ
        g.drawLine(abAcum[2],216,(abAcum[2]+=(int)(ab/2)),216); // Medio pulso bajo  RZ
        g.drawLine(abAcum[3],aux_bip,abAcum[3],286); // vertical divisora pulso anterior y actual Bipolar
        g.drawLine(abAcum[3],aux_bip,(abAcum[3]+=ab),aux_bip); // medio pulso alto Bipolar
        g.drawLine(abAcum[3],aux_bip,abAcum[3],286); // vertical divisora medio pulso Bipolar
       // g.drawLine(abAcum[3],286,(abAcum[3]+=(int)(ab/2)),286); // medio pulso bajo Bipolar
        aux_bip=(aux_bip==266?306:266); // cambiar valor pulso en alto para Bipolar
        g.drawLine(abAcum[4],336,(abAcum[4]+=(int)(ab/2)),336); // medio pulso alto manchester
        g.drawLine(abAcum[4],336,abAcum[4],376); // vertical divisora medio pulso manchester
        g.drawLine(abAcum[4],376,(abAcum[4]+=(int)(ab/2)),376); // medio pulso bajo manchester
      }
      else{
        g.drawLine(abAcum[0],aux_pse,abAcum[0],76); // vertical divisora pulso anterior y actual pseudoternario
        g.drawLine(abAcum[0],aux_pse,(abAcum[0]+=ab),aux_pse); // medio pulso alto pseudoternario
        g.drawLine(abAcum[0],aux_pse,abAcum[0],76); // vertical divisora medio pulso pseudoternario
       // g.drawLine(abAcum[0],76,(abAcum[0]+=(int)(ab/2)),76); // medio pulso bajo pseudoternario
        aux_pse=(aux_pse==56?96:56); // cambiar valor pulso en alto para pseudoternario*/
        g.drawLine(abAcum[1],166,(abAcum[1]+=ab),166); // pulso bajo  NRZ-
        g.drawLine(abAcum[2],216,abAcum[2],236); // vertical divisora pulso anterior y actual  RZ
       g.drawLine(abAcum[2],236,(abAcum[2]+=(int)(ab/2)),236); // pulso bajo RZ
        g.drawLine(abAcum[2],216,abAcum[2],236); // medio pulso bajo RZ
        g.drawLine(abAcum[2],216,(abAcum[2]+=(int)(ab/2)),216); // vertical divisora medio pulso RZ
        g.drawLine(abAcum[3],286,(abAcum[3]+=ab),286); // pulso bajo Bipolar
        g.drawLine(abAcum[4],376,(abAcum[4]+=(int)(ab/2)),376); // medio pulso bajo manchester
        g.drawLine(abAcum[4],336,abAcum[4],376); // vertical divisora medio pulso manchester
        g.drawLine(abAcum[4],336,(abAcum[4]+=(int)(ab/2)),336); // medio pulso alto manchester
      }
      prev=val;
    }
  }
}