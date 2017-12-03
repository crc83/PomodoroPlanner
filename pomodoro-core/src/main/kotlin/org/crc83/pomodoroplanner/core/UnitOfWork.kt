package org.crc83.pomodoroplanner.core

import java.util.*

data class UnitOfWork (
        val id: UUID,
        val description: String,
        val taskId: Long,
        val originallyPlanned: Int,
        val planned: Int,
        val log: String) : JsonObject()