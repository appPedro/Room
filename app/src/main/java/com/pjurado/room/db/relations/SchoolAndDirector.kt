package com.pjurado.room.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.pjurado.room.db.entities.Director
import com.pjurado.room.db.entities.School

data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)
