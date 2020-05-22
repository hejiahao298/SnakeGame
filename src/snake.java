
public class snake{
    int len=3;
    int Score=0;
    int[] snakex =new int[750];
    int[] snakey=new int [750];
    String name;
    String fx;
    
	public snake(String name,int len, int score, String fx) {
		super();
		this.len = len;
		this.Score = score;
		this.fx = fx;
		this.name=name;
	}
	public snake() {
		super();


	}
	
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public int[] getSnakex() {
		return snakex;
	}
	public void setSnakex(int[] snakex) {
		this.snakex = snakex;
	}
	public int[] getSnakey() {
		return snakey;
	}
	public void setSnakey(int[] snakey) {
		this.snakey = snakey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFx() {
		return fx;
	}
	public void setFx(String fx) {
		this.fx = fx;
	}
	public int getLen() {
		return len;
	}
	public void setLen(int len) {
		this.len = len;
	}

	}
    

