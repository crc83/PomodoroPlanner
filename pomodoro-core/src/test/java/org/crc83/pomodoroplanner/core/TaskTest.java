package org.crc83.pomodoroplanner.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.crc83.pomodoroplanner.core.Task;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by sbelei on 10/4/2017.
 */

public class TaskTest {

    @Test
    @DisplayName("should be serializable to json")
    void testTaskIsSerializable() {
        Task task = new Task("42", "First task", "Lorem ipsum sind", false);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(task);
        System.out.println(task);
        System.out.println(json);
        assertAll("JSon contains important fields", () -> {
            assertNotNull(json);
            assertTrue(json.contains("\"id\": \"42\""));
            assertTrue(json.contains("\"name\": \"First task\""));
            assertTrue(json.contains("\"description\": \"Lorem ipsum sind\""));
            assertTrue(json.contains("\"done\": false"));
        });
    }
}
