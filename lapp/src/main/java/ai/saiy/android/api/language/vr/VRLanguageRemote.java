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

package ai.saiy.android.api.language.vr;

import androidx.annotation.NonNull;

import java.util.Locale;

/**
 * Created by benrandall76@gmail.com on 29/06/2016.
 */

public class VRLanguageRemote {

    private final Locale locale;

    public VRLanguageRemote(@NonNull final Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return this.locale;
    }
}
