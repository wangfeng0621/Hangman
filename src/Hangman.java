/**
 * Created by feng on 2016/7/2.
 */
public class Hangman {

    public int strLength;
    public int times;
    public String guessedStr;
    public String displayedStr;
    public String str;

    public Hangman(String s) {
        str = s;
        strLength = str.length();
        times = strLength + 1;
        guessedStr = "iaoue";
        showTheGuessedStr();
    }

    private void showTheGuessedStr() {
        char st[] = str.toCharArray();
        displayedStr = "";
        for (int i = 0; i < strLength; i++)
            displayedStr += isContain(st[i]) ? st[i] : "_";
    }

    private boolean isContain(char c) {
        return (guessedStr.indexOf(c) == -1) ? false : true;
    }


    public void guessAChar(char c) {
        if (isContain(c))
            return;
        guessedStr += c;
        showTheGuessedStr();
        times--;
    }


    public boolean checkTimes() {
        return times > 0;
    }

    public boolean chenkAnswer() {
        return (checkTimes() && str.equals(displayedStr));
    }

    public void showStatus() {
        System.out.println("剩余次数：" + times);
        System.out.println("现在的猜出的字符所组成的单词：" + displayedStr);
        System.out.println("请继续！！！");
    }


}
