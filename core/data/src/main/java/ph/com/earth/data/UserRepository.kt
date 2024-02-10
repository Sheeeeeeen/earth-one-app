package ph.com.earth.data

import android.content.SharedPreferences
import ph.com.earth.data.sharedPref.delegates

class UserRepository(preferences: SharedPreferences) {
    var turboMode: Boolean by preferences.delegates.boolean(true)
}