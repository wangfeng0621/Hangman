import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by feng on 2016/7/2.
 */
public class HangmanTest {
    @Test
    public void Should_get_all_when_the_word_is_apple(){
        Hangman hangman = new Hangman("apple");


        assertThat(hangman.getLenth(),is(5));
        assertThat(hangman.getTime(),is(6));
        assertThat(hangman.Yuan(),is("aeiou"));
        assertThat(hangman.showWords(),is("a___e"));
    }
    @Test
    public void Should_get_all_when_the_word_is_orange(){
        Hangman hangman = new Hangman("orange");


        assertThat(hangman.getLenth(),is(6));
        assertThat(hangman.getTime(),is(7));
        assertThat(hangman.Yuan(),is("aeiou"));
        assertThat(hangman.showWords(),is("o_a__e"));
    }

    @Test
    public void should_true_when_guess_words_is_r(){
        Hangman hangman = new Hangman("orange");


        assertThat(hangman.getLenth(),is(6));
        assertThat(hangman.getTime(),is(7));
        assertThat(hangman.guess("r"),is("aeiour"));
        assertThat(hangman.Yuan(),is("aeiou"));
        assertThat(hangman.showWords(),is("ora__e"));
    }

    @Test
    public void should_flase_when_guess_words_is_h(){
        Hangman hangman = new Hangman("orange");


        assertThat(hangman.getLenth(),is(6));
        assertThat(hangman.getTime(),is(7));
        assertThat(hangman.guess("h"),is("aeiouh"));
        assertThat(hangman.Yuan(),is("aeiou"));
        assertThat(hangman.showWords(),is("o_a__e"));
    }


    @Test
    public void should_times_cut_1_when_guess_a_char(){
        Hangman hangman = new Hangman("orange");

        assertThat(hangman.getTime(),is(7));
        assertThat(hangman.guess("h"),is("aeiouh"));
        assertThat(hangman.getTime(),is(6));
        assertThat(hangman.Yuan(),is("aeiou"));
        assertThat(hangman.showWords(),is("o_a__e"));
    }

    @Test
    public void should_false_when_times_use_up(){
        Hangman hangman = new Hangman("orange");

        for(int i = 0;i < 7;i++){
            hangman.guess("h");
        }
        assertThat(hangman.result(),is("you lose !"));

    }

    @Test
    public void should_true_when_guess_the_word(){
        Hangman hangman = new Hangman("orange");

        hangman.guess("r");
        hangman.guess("n");
        hangman.guess("g");
        assertThat(hangman.getTime(),is(4));
        assertThat(hangman.showWords(),is("orange"));
        assertThat(hangman.result(),is("you win !"));
    }


}