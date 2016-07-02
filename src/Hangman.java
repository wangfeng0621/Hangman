/**
 * Created by feng on 2016/7/2.
 */
public class Hangman {
    private String str;
    private int lenth;

    public Hangman(String str) {
        this.str = str;
    }


    public int getLenth() {
        lenth = str.length();
        return lenth;
    }
}
