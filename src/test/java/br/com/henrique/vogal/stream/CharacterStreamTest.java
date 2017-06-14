package br.com.henrique.vogal.stream;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * CharacterStreamTest
 */
public class CharacterStreamTest {

    @Test(expected = RuntimeException.class)
    public void shouldTrhowIllegalArgumetException() {
        Stream s = new CharacterStream("abc");
        for(int i = 0; i < 5; i++) {
            s.getNext();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldTrhowRuntimeException() {
        new CharacterStream(null);
    }

    @Test
    public void shouldProcessStream() {
        Stream s = new CharacterStream("querocafe");
        while (s.hasNext()) {
            s.getNext();
        }
        assertThat(s.hasNext(), is(equalTo(false)));
    }

    @Test
    public void shouldBeFalseNoMoreCharacters() {
        Stream s = new CharacterStream("picolelimao");
        while (s.hasNext()) {
            s.getNext();
        }
        assertThat(s.hasNext(), is(equalTo(false)));
    }

    @Test
    public void shouldBeTrueHasMoreCharacters() {
        Stream s = new CharacterStream("naotemmundial");
        assertThat(s.hasNext(), is(equalTo(true)));
        assertThat(s.hasNext(), is(equalTo(true)));
    }
}