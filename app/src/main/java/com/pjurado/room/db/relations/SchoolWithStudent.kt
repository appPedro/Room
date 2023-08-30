package com.pjurado.room.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.pjurado.room.db.entities.School
import com.pjurado.room.db.entities.Student

data class SchoolWithStudent (
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<Student>
)