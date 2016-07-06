
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by feng on 2016/7/2.
 */
public class HangmanTest {
    @Test
    public void show_shuxin_when_word_is_apple(){
        Hangman hangman = new Hangman("apple");

        assertThat(hangman.str,is("apple"));
        assertThat(hangman.str_length,is(5));
        assertThat(hangman.times,is(6));
        assertThat(hangman.guess_str,is("iaoue"));
        assertThat(hangman.show_str,is("a___e"));

    }

    @Test
    public void show_shuxin_when_word_is_application(){
        Hangman hangman = new Hangman("application");

        assertThat(hangman.str,is("application"));
        assertThat(hangman.str_length,is(11));
        assertThat(hangman.times,is(12));
        assertThat(hangman.guess_str,is("iaoue"));
        assertThat(hangman.show_str,is("a___i_a_io_"));
    }


    @Test
    public void  show_guess_word_when_guess_char_is_p(){
        Hangman hangman = new Hangman("apple");

        hangman.guess_a_char('p');
        assertThat(hangman.times,is(5));
        assertThat(hangman.guess_str,is("iaouep"));
        assertThat(hangman.show_str,is("app_e"));
    }

    @Test
    public void show_false_when_times_out_put(){
        Hangman hangman = new Hangman("apple");

        hangman.guess_a_char('p');
        hangman.guess_a_char('w');
        hangman.guess_a_char('r');
        hangman.guess_a_char('t');
        hangman.guess_a_char('y');
        hangman.guess_a_char('s');
        assertThat(hangman.check_times(),is(false));
    }

    @Test
    public void show_shuxin_when_guess_the_same_char(){
        Hangman hangman = new Hangman("apple");

        hangman.guess_a_char('p');
        hangman.guess_a_char('p');
        assertThat(hangman.times,is(5));
        assertThat(hangman.guess_str,is("iaouep"));
        assertThat(hangman.show_str,is("app_e"));
    }

    @Test
    public void show_true_when_guess_right_the_word(){
        Hangman hangman = new Hangman("apple");

        hangman.guess_a_char('p');
        hangman.guess_a_char('l');
        assertThat(hangman.guess_str,is("iaouepl"));
        assertThat(hangman.show_str,is("apple"));
        assertThat(hangman.chenk_answer(),is(true));
    }

    @Test
    public void show_false_when_guess_wrong_the_word(){
        Hangman hangman = new Hangman("apple");

        hangman.guess_a_char('p');
        hangman.guess_a_char('q');
        hangman.guess_a_char('w');
        hangman.guess_a_char('r');
        hangman.guess_a_char('t');
        hangman.guess_a_char('y');
        assertThat(hangman.chenk_answer(),is(false));
    }

    @Test
    public void show_status_when_guess_a_char(){
        Hangman hangman = new Hangman("apple");

        hangman.guess_a_char('p');
        hangman.show_status();
    }

    @Test
    public void show_answeer_when_guess_right_the_word(){
        Hangman hangman = new Hangman("apple");

        hangman.guess_a_char('p');
        hangman.show_status();
        hangman.guess_a_char('l');
        hangman.show_status();

        if(hangman.chenk_answer())
            System.out.println("YOU WIN !!! GAME OVER");
        else
            System.out.println("YOU LOSE !!! GAME OVER");
    }

    @Test
    public void show_answer_when_guess_wrong_the_word(){
        Hangman hangman = new Hangman("apple");

        hangman.guess_a_char('p');
        hangman.show_status();
        hangman.guess_a_char('q');
        hangman.show_status();
        hangman.guess_a_char('w');
        hangman.show_status();
        hangman.guess_a_char('r');
        hangman.show_status();
        hangman.guess_a_char('t');
        hangman.show_status();
        hangman.guess_a_char('y');
        hangman.show_status();

        if(hangman.chenk_answer())
            System.out.println("YOU WIN !!! GAME OVER");
        else
            System.out.println("YOU LOSE !!! GAME OVER");
    }

}