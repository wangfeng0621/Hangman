import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by feng on 2016/7/2.
 */
public class HangmanTest {
    @Test
    public void Should_get_long_when_get_a_word(){
        String str = "apple";
        Hangman hangman = new Hangman(str);
        int len = str.length();

        assertThat(hangman.getLenth(),is(len));
    }


    @Test
    public void Should_get_6_when_inout_apples(){
        Hangman hangman = new Hangman("apples");
        assertThat(hangman.getLenth(),is(6));

    }

}