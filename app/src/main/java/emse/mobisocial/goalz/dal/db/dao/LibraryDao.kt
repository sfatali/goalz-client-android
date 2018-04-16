package emse.mobisocial.goalz.dal.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import emse.mobisocial.goalz.model.LibraryEntry

/**
 * Created by MobiSocial EMSE Team on 4/4/2018.
 */
@Dao
abstract class LibraryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertLibraryEntryList(entryList: List<LibraryEntry>)
}