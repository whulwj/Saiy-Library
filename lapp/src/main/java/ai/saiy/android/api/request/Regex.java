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

package ai.saiy.android.api.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.Nullable;

import ai.saiy.android.api.Defaults;

/**
 * Enum class that provides Saiy with additional 'context' as to how to
 * detect a given keyphrase.
 * <p>
 * Created by benrandall76@gmail.com on 03/10/2016.
 */
public enum Regex implements Parcelable {

    MATCHES,
    STARTS_WITH,
    ENDS_WITH,
    CONTAINS,
    CUSTOM;

    private static final boolean DEBUG = Defaults.DEBUG;
    private static final String CLS_NAME = Regex.class.getSimpleName();

    public static final Creator<Regex> CREATOR = new Creator<Regex>() {
        @Override
        public Regex createFromParcel(Parcel in) {
            final byte index = in.readByte();
            for (Regex regex : values()) {
                if (index == regex.ordinal()) {
                    return regex;
                }
            }
            return Regex.MATCHES;
        }

        @Override
        public Regex[] newArray(int size) {
            return new Regex[size];
        }
    };

    /**
     * Get the Regex type from its string representation
     *
     * @param regex the String representation
     * @return the associated Regex value or {@link #MATCHES} should an error occur.
     */
    public static Regex getRegex(@Nullable final String regex) {

        if (regex != null) {

            try {
                return Regex.valueOf(regex);
            } catch (final IllegalArgumentException e) {
                if (DEBUG) {
                    Log.w(CLS_NAME, "getRegex IllegalArgumentException:" + e.getMessage());
                }
            }
        }

        return MATCHES;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeByte((byte) ordinal());
    }
}
