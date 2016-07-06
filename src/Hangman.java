import java.util.Scanner;

/**
 * Created by feng on 2016/7/2.
 */
public class Hangman {

    public int str_length;
    public int times;
    public String guess_str;
    public String show_str;
    public String str;

    public Hangman(String s) {
        str = s;
        str_length = str.length();
        times = str_length + 1;
        guess_str = "iaoue";
        show_the_guessed_str();
    }

    private void show_the_guessed_str() {
        char st[] = str.toCharArray();
        show_str = "";
        for(int i = 0;i < str_length;i++)
           show_str += isContain(st[i]) ?  st[i]:"_";
    }

    private boolean isContain(char c) {
        return (guess_str.indexOf(c) == -1) ? false:true;
    }


    public void guess_a_char(char c) {
        if(isContain(c))
            return;
        guess_str += c;
        show_the_guessed_str();
        times--;
    }


    public boolean check_times() {
        return times > 0;
    }

    public boolean chenk_answer() {
        return (check_times() && str.equals(show_str));
    }

    public void show_status() {
        System.out.println("剩余次数："+times);
        System.out.println("现在的猜出的字符所组成的单词："+show_str);
        System.out.println("请继续！！！");
    }



}
