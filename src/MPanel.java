import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class MPanel extends JPanel implements KeyListener, ActionListener{
	/*
	 * ����ͼƬ
	 */
	ImageIcon title =new ImageIcon("title.png");
	ImageIcon food =new ImageIcon("food.png");
	ImageIcon down =new ImageIcon("down.png");
	ImageIcon up =new ImageIcon("up.png");
	ImageIcon left =new ImageIcon("left.png");
	ImageIcon right =new ImageIcon("right.png");
	ImageIcon body =new ImageIcon("body.png");

	
    /*
     * ���ñ�����
     */
	
    boolean isStarted=false;
    boolean isfailed=false;
    Timer timer=new Timer(200,this);

    Random rand=new Random();
    static snake snake1=new snake("snake1",3,0,"R");
    static snake snake2=new snake("snake2",3,0,"F");
    food food1=new food();
    food food2=new food();


   static List<snake> snakes;

    
    /*
         * ���췽��MPanel
     */
     public MPanel() {
 
    	initSnake();

    
    	 this.setFocusable(true);                               //�ɻ�ȡ����True
    	 this.addKeyListener(this);                             //addKeyListener(this)������������
    	
    	 timer.start();	 
    	 
     }
     
     
     
     /*
      * �ߵļ��ϣ���ʱû�ã�
      */
     public static void initsnake() {
      	snakes = new ArrayList<snake>();
     	snakes.add(snake1);
     	snakes.add(snake2);
     }     
     
     
     /*
      * ����ʳ��
      */
     public void foods(food x) {
		 x.foodx=25+25*rand.nextInt(33);
		 x.foody=75+25*rand.nextInt(23);
     }
     
     
     /*
      * �Ե�ʳ��
      */
 	public void Score(snake s,food x) {
		if( s.snakex[0]==x.foodx&& s.snakey[0]==x.foody) {
			 s.len++;
			 s.Score= s.Score+3;
             foods(x);
		}
 	}
     
 	
 
		/*
		 * �ж�̰ʳ���Ƿ��ص�
		 */
    public void overlep(snake s) {
       
       	 for(int i=1;i< snake1.len;i++) {                           
    			if( snake1.snakex[i]== s.snakex[0]&& snake1.snakey[i]== s.snakey[0]) {
    				isfailed=true;
        }
    			for(int j=1;j<snake2.len;j++) {
    				if(snake2.snakex[i]== s.snakex[0]&& snake2.snakey[i]== s.snakey[0]) {
    				isfailed=true;
    			}
    }
    			}
    }
    
    
	
	/*
	 * ���߶�����
	 */   
 	public void Snakedoing(snake s) {

		for(int i= s.getLen()-1;i>0;i--){
			 s.snakex[i]= s.snakex[i-1];
			 s.snakey[i]= s.snakey[i-1];		
		}
		
		if( s.fx=="R"||s.fx=="F") {
			 s.snakex[0]= s.snakex[0]+25;
		if( s.snakex[0]>850) 
			 s.snakex[0]=25;
		}else if( s.fx=="L"||s.fx=="A") {
			 s.snakex[0]= s.snakex[0]-25;
			if( s.snakex[0]<25) 
				 s.snakex[0]=850;
		}else if( s.fx=="D"||s.fx=="S") {
			 s.snakey[0]= s.snakey[0]+25;
			if( s.snakey[0]>650) 
				 s.snakey[0]=75;
		}else if( s.fx=="U"||s.fx=="W") {
			 s.snakey[0]= s.snakey[0]-25;
			if( s.snakey[0]<75) 
				 s.snakey[0]=650;
		}

			Score(s,food1);
			Score(s,food2);

			 }

 	
 	
		/*
		 * ��ͷ�ķ���
		 */
		public void Drawhead(snake s,ImageIcon r,String b,Graphics g) {
	    	if( s.fx==b) {  
	    		 r.paintIcon(this, g, s.snakex[0],  s.snakey[0]);
		}
		}
 	
		
	 	/*
	 	 * ������
	 	 */
	   public void Drawbody(snake s,Graphics g) {
	       for(int i=0;i< s.len;i++) {                         
	   	  body.paintIcon(this, g, s. snakex[i], s. snakey[i]);
	     }
	   }
	   
	   
	   
	   /*
	    * ��ʳ��
	    */
	   public void Drawfood(food x,Graphics g) {
		   food.paintIcon(this, g, x.foodx, x.foody);
	   }
		
  
	   
	   /*
	    * ���ְ�
	    */ 
	
	   public void DrawString(snake s,Graphics g,int i) {
		  
	    	 g.drawString(s.getName()+"Len:   "+s.len,  i, 35);
	    	 g.drawString(s.getName()+"Score:   "+s.Score, i, 50);
	   
	   }
	   
	   
	   
     /*
           * ��������
           * ����Graphics g
      * (non-Javadoc)
      * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
      */

     public void paintComponent(Graphics g) {
    	 super.paintComponent(g);
    	 this.setBackground(Color.WHITE ); 
    	 title.paintIcon(this, g, 25, 11);
    	 g.fillRect(25, 75, 850, 600);                    //���һ�黭��
    	 g.setColor(Color.white); 
    	 
    	 
        DrawString(snake1,g,750);
        DrawString(snake2,g,600);
        
    	Drawhead(snake1,right,"R",g);
    	Drawhead(snake1,left,"L",g);
    	Drawhead(snake1,down,"D",g);
    	Drawhead(snake1,up,"U",g);
    	Drawhead(snake2,right,"F",g);
    	Drawhead(snake2,left,"A",g);
    	Drawhead(snake2,down,"S",g);
    	Drawhead(snake2,up,"W",g);
    	
    	Drawbody(snake1,g);
    	Drawbody(snake2,g);
    	
    	Drawfood(food1,g);
  
    	
        
          /*
                    * ������Ϸ�Ŀ�ʼ����ͣ
           */
      if(isStarted==false) {
          g.setColor(Color.WHITE);
          g.setFont(new Font("arial",Font.BOLD,40));
          g.drawString("Press  space to Start", 300, 400);
        
      }
      if(isfailed) {
          g.setColor(Color.RED);
          g.setFont(new Font("arial",Font.BOLD,40));
          g.drawString("Failed:Press Space to ReStrat", 300, 400);
        
      }
     }
     
     
     
     /*
           * ��Ϸ��ԭʼ����
      */
   public void initSnake() {
	   snake1. len=3;
	   snake1.snakex[0]=100;
	   snake1.snakey[0]=100;
	   snake1. snakex[1]=75;
	   snake1. snakey[1]=100;
	   snake1.snakex[2]=50;
	   snake1. snakey[2]=100;    
       foods(food1);
       foods(food2);

	   snake1.fx="R";
       snake1.Score=0;
       
	   snake2. len=3;
	   snake2.snakex[0]=750;
	   snake2.snakey[0]=100;
	   snake2. snakex[1]=775;
	   snake2. snakey[1]=100;
	   snake2.snakex[2]=800;
	   snake2. snakey[2]=100;    
	   snake2.fx="A";
       snake2.Score=0;
     }

	public void keyTyped(KeyEvent e) {
		
	}

	
	/*
	 * ���ü��������Ƽ�������
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent e) {

		 int KeyCode=e.getKeyCode();
	
		 if(KeyCode==KeyEvent.VK_SPACE) {                 //�������ж��ļ�����һ������
			 if(isfailed) {
				 isfailed=false;
				
				
				initSnake();                             //Space��Ӧ��Ϸʧ������ԭʼ����
			 }else {
				 isStarted=!isStarted;                   //���������ͣ���ٿ�ʼ��           
			 }
		
			 repaint();
			 
			 
		 }
          
		 
		 /*
		  * ��Ӧ������������Ӧ�Ķ���
		  */
		 switch(KeyCode) {
		 case KeyEvent.VK_LEFT:snake1.fx="L";
		 break;
		 case KeyEvent.VK_RIGHT:snake1.fx="R";
		 break;
		 case KeyEvent.VK_UP:snake1.fx="U";
		 break;
		 case KeyEvent.VK_DOWN:snake1.fx="D";
		 break;

		 case KeyEvent.VK_D: snake2.fx="F";
		 break;
		 case KeyEvent.VK_A: snake2.fx="A";
		 break;
		 case KeyEvent.VK_S: snake2.fx="S";
		 break;
		 case KeyEvent.VK_W: snake2.fx="W";
		 break;
		 }
	}

	


	/*
	  * ������Ӧ����Ӧ���̶���
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		
                  
		if(isStarted&&!isfailed) {                       //����Ϸ������ͣ��ʧ��״̬�����
     	Snakedoing(snake1);
		Snakedoing(snake2);
        overlep(snake1);
        overlep(snake2);

		
		
		    repaint();                                       //ˢ�»���������
	}
			  timer.start();                                 //ʱ��start
}

	public void keyReleased(KeyEvent e) {
		
	}   
	}

