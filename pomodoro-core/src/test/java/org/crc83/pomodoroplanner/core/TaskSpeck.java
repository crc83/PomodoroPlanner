package org.crc83.pomodoroplanner.core;

import org.crc83.pomodoroplanner.junit.Api;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sbelei on 10/4/2017.
 */

@Api
public class TaskSpeck {

    @Test
    @DisplayName("should be serializable to json")
    void testTaskIsSerializable() {
        Task task = new Task(42, "First task", "Lorem ipsum sind", 0, 0, "");
        String json = task.toJson();
        assertAll("JSon contains important fields", () -> {
            assertNotNull(json);
            assertTrue(json.contains("\"id\": 42"));
            assertTrue(json.contains("\"name\": \"First task\""));
            assertTrue(json.contains("\"description\": \"Lorem ipsum sind\""));
        });
    }
}
