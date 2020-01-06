/**
 * This class holds player name and score
 * @author Khanh Tran
 */
public class Player {
    private String playerName;
    private int score = 0;
    
    public Player(String name) {
        playerName = name;
    } 
    public void setName(String name) {
        playerName = name;
    }
    public String getName() {
        return playerName;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return this.score;
    }
    public void addScore(int score) {
        this.score += score;
    }
}
