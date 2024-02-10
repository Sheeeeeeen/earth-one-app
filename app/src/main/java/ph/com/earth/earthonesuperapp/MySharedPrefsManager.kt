package ph.com.earth.earthonesuperapp

import android.content.Context
import android.content.SharedPreferences

object MySharedPrefsManager {

    fun create(context: Context): SharedPreferences {
        return context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    }
}