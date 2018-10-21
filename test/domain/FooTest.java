
package domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class FooTest {
    @Test
    public void testFoo() {
        Foo foo = new Foo();
        assertTrue(foo.bar());
    }
}
