package soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertNotNull;



public class CDPlayerTest {
    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeNull() {
        if(cd==null)
            System.out.println("null");
        assertNotNull(cd);
    }
}