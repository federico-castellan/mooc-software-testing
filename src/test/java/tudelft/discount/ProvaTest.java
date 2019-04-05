package tudelft.discount;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.mockito.Mock;

public class ProvaTest {
    @Mock List mockedList = mock(List.class);
    
    public static void main(String[] args) {
        ProvaTest p = new ProvaTest();
        p.prova();

    }

    public void prova() {
           // using mock object - it does not throw any "unexpected interaction" exception
           mockedList.add("one");
           mockedList.clear();
   
           // selective, explicit, highly readable verification
           verify(mockedList).add("one");
           verify(mockedList).clear();
    }
}