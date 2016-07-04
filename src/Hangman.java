/**
 * Created by feng on 2016/7/2.
 */
public class Hangman {
    private String str;
    private int lenth;
    private String guess_str = "aeiou";
    private int times;

    public Hangman(String str) {
        this.str = str;
        times = str.length() + 1;
    }


    public int getLenth() {
        return  str.length();
    }

    public  String show() {

        return "a___e";
    }

    public int getTime() {
        return times;
    }

    public  String Yuan() {
        return "aeiou";
    }

    public String showWords() {
        char st[] = str.toCharArray();
        String str_buff = "";
        for(int i = 0;i < str.length();i++){
            str_buff += isContains(st[i]) ? Character.valueOf(st[i]) : "_";
        }
        return str_buff;
    }

    private boolean isContains(char c) {
        return guess_str.indexOf(String.valueOf(c)) != -1;
    }

    public String guess(String guess_char) {
        guess_str += guess_char;
        times--;
        return guess_str;
    }

    public String result() {
        System.out.println(showWords());
        return (times > 0 && str.equals(showWords())) ?  "you win !" :  "you lose !";
    }


}
