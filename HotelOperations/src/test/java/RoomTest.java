import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RoomTest {
    private Room room;

    @Before
    public void setUp() {
        room = new Room(2, 100.0, false, false);
    }

    @Test
    public void testCheckInSuccessful() {
        room.checkIn();
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void testCheckInFailsIfOccupied() {
        room.checkIn();
        room.checkIn(); // try to check in again
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void testCheckInFailsIfDirty() {
        room.checkIn();
        room.checkout();
        room.checkIn(); // should fail since room is dirty
        assertFalse(room.isAvailable());
    }

    @Test
    public void testCheckout() {
        room.checkIn();
        room.checkout();
        assertFalse(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void testCleanRoomSuccess() {
        room.checkIn();
        room.checkout();
        room.cleanRoom();
        assertFalse(room.isDirty());
    }

    @Test
    public void testCleanRoomFailsIfOccupied() {
        room.checkIn();
        room.cleanRoom(); // should not clean because it's occupied
        assertTrue(room.isDirty());
    }
}
