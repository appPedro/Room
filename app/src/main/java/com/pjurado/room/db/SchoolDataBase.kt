package com.pjurado.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pjurado.room.db.entities.Director
import com.pjurado.room.db.entities.School
import com.pjurado.room.db.entities.Student
import com.pjurado.room.db.entities.Subject
import com.pjurado.room.db.relations.StudentSubjectCrossRef

@Database(
    entities = [
        Director::class,
        School::class,
        Student::class,
        Subject::class,
        StudentSubjectCrossRef::class
               ],
    version = 1
)
abstract class SchoolDataBase: RoomDatabase() {
    abstract val schoolDao: SchoolDao

    companion object {
        @Volatile
        private var INSTANCE: SchoolDataBase? = null

        fun getInstance(context: Context): SchoolDataBase? {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                        context.applicationContext,
                        SchoolDataBase::class.java,
                        "school_database"
                    ).build().also {
                        INSTANCE = it
                    }
            }
        }
    }

}