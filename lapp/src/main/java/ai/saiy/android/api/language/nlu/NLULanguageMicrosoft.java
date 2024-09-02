/*
 * Copyright (c) 2016. Saiy™ Ltd. All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ai.saiy.android.api.language.nlu;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.StringTokenizer;

import ai.saiy.android.api.Defaults;

/**
 * Created by benrandall76@gmail.com on 29/09/2016.
 */

public enum NLULanguageMicrosoft {

    MANDARIN_CHINA_SIMPLIFIED("zh-CN"),
    ENGLISH_US("en-US"),
    FRENCH_FRANCE("fr-FR"),
    ITALIAN("it-IT"),
    SPANISH_SPAIN("es-ES");

    private static final boolean DEBUG = Defaults.DEBUG;
    private static final String CLS_NAME = NLULanguageMicrosoft.class.getSimpleName();

    private final String localeString;

    NLULanguageMicrosoft(final String localeString) {
        this.localeString = localeString;
    }

    public String getLocaleString() {
        return localeString;
    }

    public static NLULanguageMicrosoft[] getLanguages() {
        return NLULanguageMicrosoft.values();
    }

    public static boolean isLanguageAvailable(@NonNull final Locale userLocale) {

        final String localeString = userLocale.toString();

        StringTokenizer tokens;
        Locale locale;

        try {

            if (DEBUG) {
                Log.i(CLS_NAME, "userLocale: " + localeString);
                Log.i(CLS_NAME, "userLocale.getLanguage: " + userLocale.getLanguage());
                Log.i(CLS_NAME, "userLocale.getCountry : " + userLocale.getCountry());
            }

            final Locale formattedLocale = new Locale(userLocale.getLanguage(), userLocale.getCountry());

            for (final NLULanguageMicrosoft language : getLanguages()) {
                if (DEBUG) {
                    Log.i(CLS_NAME, "language: " + language.getLocaleString());
                }

                tokens = new StringTokenizer(language.getLocaleString(), "-");
                locale = new Locale(tokens.nextToken(), tokens.nextToken());

                if (DEBUG) {
                    Log.i(CLS_NAME, "locale: " + locale);
                }

                if (locale.equals(formattedLocale)) {
                    if (DEBUG) {
                        Log.i(CLS_NAME, "Locale full match");
                    }
                    return true;
                }
            }

        } catch (final MissingResourceException e) {
            if (DEBUG) {
                Log.e(CLS_NAME, "isLanguageAvailable: language/country error. checking language only");
                e.printStackTrace();
            }
        }

        try {

            final Locale formattedLocale = new Locale(userLocale.getLanguage());

            for (final NLULanguageMicrosoft language : getLanguages()) {
                if (DEBUG) {
                    Log.i(CLS_NAME, "language: " + language.getLocaleString());
                }

                tokens = new StringTokenizer(language.getLocaleString(), "-");
                locale = new Locale(tokens.nextToken(), tokens.nextToken());

                if (DEBUG) {
                    Log.i(CLS_NAME, "locale: " + locale);
                }

                // Perhaps this should not return true for many cases.
                if (locale.getLanguage().matches(formattedLocale.getLanguage())) {
                    if (DEBUG) {
                        Log.i(CLS_NAME, "Locale Language match");
                    }
                    return true;
                }
            }

        } catch (final MissingResourceException e) {
            if (DEBUG) {
                Log.e(CLS_NAME, "isLanguageAvailable: language error. returning false");
                e.printStackTrace();
            }
        }

        return false;
    }

    public static NLULanguageMicrosoft getLanguage(@NonNull final Locale userLocale) {

        final String localeString = userLocale.toString();
        StringTokenizer tokens;
        Locale locale;


        try {

            if (DEBUG) {
                Log.i(CLS_NAME, "userLocale: " + localeString);
                Log.i(CLS_NAME, "userLocale.getLanguage: " + userLocale.getLanguage());
                Log.i(CLS_NAME, "userLocale.getCountry : " + userLocale.getCountry());
            }

            final Locale formattedLocale = new Locale(userLocale.getLanguage(), userLocale.getCountry());

            for (final NLULanguageMicrosoft language : getLanguages()) {
                if (DEBUG) {
                    Log.i(CLS_NAME, "language: " + language.getLocaleString());
                }

                tokens = new StringTokenizer(language.getLocaleString(), "-");
                locale = new Locale(tokens.nextToken(), tokens.nextToken());

                if (DEBUG) {
                    Log.i(CLS_NAME, "locale: " + locale);
                }

                if (locale.equals(formattedLocale)) {
                    if (DEBUG) {
                        Log.i(CLS_NAME, "Locale full match");
                    }
                    return language;
                }
            }

        } catch (final MissingResourceException e) {
            if (DEBUG) {
                Log.e(CLS_NAME, "getLanguage: language/country error. checking language");
                e.printStackTrace();
            }
        }

        try {

            final Locale formattedLocale = new Locale(userLocale.getLanguage());

            for (final NLULanguageMicrosoft language : getLanguages()) {
                if (DEBUG) {
                    Log.i(CLS_NAME, "language: " + language.getLocaleString());
                }

                tokens = new StringTokenizer(language.getLocaleString(), "-");
                locale = new Locale(tokens.nextToken(), tokens.nextToken());

                if (DEBUG) {
                    Log.i(CLS_NAME, "locale: " + locale);
                }

                // Perhaps this should not return true for many cases.
                if (locale.getLanguage().matches(formattedLocale.getLanguage())) {
                    if (DEBUG) {
                        Log.i(CLS_NAME, "Locale Language match");
                    }
                    return language;
                }
            }

        } catch (final MissingResourceException e) {
            if (DEBUG) {
                Log.e(CLS_NAME, "getLanguage: language error. returning Default English");
                e.printStackTrace();
            }
        }

        return ENGLISH_US;
    }

    public static NLULanguageMicrosoft getNLULanguageMicrosoft(final String name) {
        if (DEBUG) {
            Log.i(CLS_NAME, "getNLULanguageMicrosoft: " + name);
        }

        if (name != null) {

            try {
                return Enum.valueOf(NLULanguageMicrosoft.class, name.trim().toUpperCase());
            } catch (final IllegalArgumentException e) {
                if (DEBUG) {
                    Log.w(CLS_NAME, "getNLULanguageMicrosoft: IllegalArgumentException");
                    e.printStackTrace();
                }
                return NLULanguageMicrosoft.ENGLISH_US;
            }

        } else {
            if (DEBUG) {
                Log.w(CLS_NAME, "getNLULanguageMicrosoft: name null");
            }
            return NLULanguageMicrosoft.ENGLISH_US;
        }
    }


}
