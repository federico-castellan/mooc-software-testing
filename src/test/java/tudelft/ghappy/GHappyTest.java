package tudelft.ghappy;
import org.junit.jupiter.api.*;

public class GHappyTest {
    
    
    private GHappy gh;


    @BeforeEach
    public void init() {
      gh = new GHappy();
    }

    @Test
    public void testConerCase() {
        Assertions.assertTrue(gh.gHappy(""));
    }

    
    @Test
    public void testOneLonely() {
        Assertions.assertFalse(gh.gHappy("g"));
        Assertions.assertFalse(gh.gHappy("gar"));
        Assertions.assertFalse(gh.gHappy("tyg"));
        Assertions.assertFalse(gh.gHappy("abmnagnmns"));
    }

    @Test
    public void testManyLonely() {
        Assertions.assertFalse(gh.gHappy("ghg"));
        Assertions.assertFalse(gh.gHappy("ghmgoijg"));
        Assertions.assertFalse(gh.gHappy("abbgjkgklmb"));
    }

    @Test
    public void testSomehappy() {
        Assertions.assertTrue(gh.gHappy("ggmmmmm"));
        Assertions.assertTrue(gh.gHappy("hhgghh"));
        Assertions.assertTrue(gh.gHappy("hhhhgg"));
        Assertions.assertFalse(gh.gHappy("ggmmgmmmgg"));
        Assertions.assertFalse(gh.gHappy("ggmmmmmg"));
    }

    
    @Test
    public void testAllHappy() {
        Assertions.assertTrue(gh.gHappy("hhggmmmnzggoopgg"));
        Assertions.assertTrue(gh.gHappy("gggg"));
        Assertions.assertTrue(gh.gHappy("gg"));
    }
}
