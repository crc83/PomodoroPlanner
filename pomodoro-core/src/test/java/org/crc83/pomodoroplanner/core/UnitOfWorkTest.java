package org.crc83.pomodoroplanner.core

import org.crc83.pomodoroplanner.junit.Api;
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

@Api
public class UnitOfWorkTest {

    @Test
    @DisplayName("should be serializable to json")
    void testUoWIsSerializable() {
        UnitOfWork uow = new UnitOfWork(UUID.randomUUID(), "I did something", 1, 3, 7, "X'XX'OOO" );

        System.out.println(uow.toJson());
    }
}