import java.util.Random;

public class food {
    Random rand=new Random();
    int foodx=25+25*rand.nextInt(33);
	int foody=75+25*rand.nextInt(23);
 
	public food(int foodx, int foody) {
		super();
		this.foodx = foodx;
		this.foody = foody;
	}
	public food() {
		super();

	
	}
    
}
