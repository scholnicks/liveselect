package scholnick.liveselect;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DescribableTest {
    @Test
    void getDescription() {
        Describable d = () -> "pink";
        assertEquals("pink",d.getDescription());
    }
}