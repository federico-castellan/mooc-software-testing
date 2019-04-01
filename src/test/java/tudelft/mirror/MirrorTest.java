package tudelft.mirror;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tudelft.mirror.Mirror;

public class MirrorTest {
   
    @Test
    public void testMirrod() {
        Mirror rom = new Mirror();
        Assertions.assertEquals("",rom.mirrorEnds(""));
        Assertions.assertEquals("",rom.mirrorEnds("sdf"));
        Assertions.assertEquals("A",rom.mirrorEnds("A"));
        Assertions.assertEquals("AAA",rom.mirrorEnds("AAA"));
        Assertions.assertEquals("aba",rom.mirrorEnds("aba"));
        Assertions.assertEquals("aaaa",rom.mirrorEnds("aaaa"));
        Assertions.assertEquals("abba",rom.mirrorEnds("abba"));
        Assertions.assertEquals("abbba",rom.mirrorEnds("abbba"));
        Assertions.assertEquals("absba",rom.mirrorEnds("absba"));
        Assertions.assertEquals("z",rom.mirrorEnds("zstryz"));
        Assertions.assertEquals("zo",rom.mirrorEnds("zostryoz"));
        Assertions.assertEquals("zor",rom.mirrorEnds("zorstryroz"));

    }
}
