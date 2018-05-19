package codingblocks.com.billsplit.util;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import info.metadude.android.typedpreferences.BooleanPreference;
import info.metadude.android.typedpreferences.IntPreference;
import info.metadude.android.typedpreferences.StringPreference;

/**
 * Preference utilities.
 *
 * Configuration storage for simple objects, such as text and numbers.
 */
public final class Preferences {

    private static final class Locations {
        public static final String BACKEND = "backend";
    }

    public static final class Keys {
        public static final String USERNAME = "username";
        public static final String NAME = "name";
        public static final String EMAIL = "email";
    }

    private final SharedPreferences serverPreferences;

    @NonNull
    public static Preferences of(@NonNull Context context) {
        return new Preferences(context, Locations.BACKEND);
    }

    private Preferences(Context context, String preferencesLocation) {
        this.serverPreferences = context.getSharedPreferences(preferencesLocation, Context.MODE_PRIVATE);
    }

    @NonNull
    public StringPreference username() {
        return new StringPreference(serverPreferences, Keys.USERNAME);
    }

    @NonNull
    public StringPreference name() {
        return new StringPreference(serverPreferences, Keys.NAME);
    }

    @NonNull
    public StringPreference email() {
        return new StringPreference(serverPreferences, Keys.EMAIL);
    }


}