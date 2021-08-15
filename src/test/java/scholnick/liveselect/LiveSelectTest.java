package scholnick.liveselect;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LiveSelectTest {
    @Test
    void testToString() {
        assertNotNull(new LiveSelect<String>(List.of("pink")).toString());
    }
}