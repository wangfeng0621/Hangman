
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by feng on 2016/7/2.
 */


public class HangmanTest {
    @Test
    public void show_properties_when_word_is_apple() {
        Hangman hangman = new Hangman("apple");

        assertThat(hangman.str, is("apple"));
        assertThat(hangman.strLength, is(5));
        assertThat(hangman.times, is(6));
        assertThat(hangman.guessedStr, is("iaoue"));
        assertThat(hangman.displayedStr, is("a___e"));

    }

    @Test
    public void show_properties_when_word_is_application() {
        Hangman hangman = new Hangman("application");

        assertThat(hangman.str, is("application"));
        assertThat(hangman.strLength, is(11));
        assertThat(hangman.times, is(12));
        assertThat(hangman.guessedStr, is("iaoue"));
        assertThat(hangman.displayedStr, is("a___i_a_io_"));
    }


    @Test
    public void show_guess_word_when_guess_char_is_p() {
        Hangman hangman = new Hangman("apple");

        hangman.guessAChar('p');

        assertThat(hangman.times, is(5));
        assertThat(hangman.guessedStr, is("iaouep"));
        assertThat(hangman.displayedStr, is("app_e"));
    }

    @Test
    public void show_false_when_times_out_put() {

        Hangman hangman = new Hangman("apple");

        hangman.guessAChar('p');
        hangman.guessAChar('w');
        hangman.guessAChar('r');
        hangman.guessAChar('t');
        hangman.guessAChar('y');
        hangman.guessAChar('s');

        assertThat(hangman.checkTimes(), is(false));
    }

    @Test
    public void show_propertiex_when_guess_the_same_char() {
        Hangman hangman = new Hangman("apple");

        hangman.guessAChar('p');
        hangman.guessAChar('p');

        assertThat(hangman.times, is(5));
        assertThat(hangman.guessedStr, is("iaouep"));
        assertThat(hangman.displayedStr, is("app_e"));
    }

    @Test
    public void show_true_when_guess_right_the_word() {
        Hangman hangman = new Hangman("apple");

        hangman.guessAChar('p');
        hangman.guessAChar('l');

        assertThat(hangman.guessedStr, is("iaouepl"));
        assertThat(hangman.displayedStr, is("apple"));
        assertThat(hangman.chenkAnswer(), is(true));
    }

    @Test
    public void show_false_when_guess_wrong_the_word() {
        Hangman hangman = new Hangman("apple");

        hangman.guessAChar('p');
        hangman.guessAChar('q');
        hangman.guessAChar('w');
        hangman.guessAChar('r');
        hangman.guessAChar('t');
        hangman.guessAChar('y');

        assertThat(hangman.chenkAnswer(), is(false));
    }

    @Test
    public void should_return_false_given_apple_when_guess_r() {
        Hangman hangman = new Hangman("apple");

        hangman.guessAChar('r');

        assertThat(hangman.times, is(5));
        assertThat(hangman.guessedStr, is("iaouer"));
        assertThat(hangman.displayedStr, is("a___e"));
        assertThat(hangman.chenkAnswer(), is(false));
    }

}