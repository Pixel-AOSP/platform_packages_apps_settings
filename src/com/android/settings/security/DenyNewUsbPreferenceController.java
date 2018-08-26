/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.security;

import android.content.Context;
import android.provider.Settings;
import android.os.SystemProperties;

import com.android.settings.core.TogglePreferenceController;
import com.android.settings.overlay.FeatureFactory;
import com.android.settings.R;

public class DenyNewUsbPreferenceController extends TogglePreferenceController {
 
    private static final String KEY_DENY_NEW_USB = "deny_new_usb";
    private static final String DENY_NEW_USB_PERSIST_PROP = "persist.security.deny_new_usb";

    public DenyNewUsbPreferenceController(Context context) {
        super(context, KEY_DENY_NEW_USB);
    }

    @Override
    public boolean isChecked() {
        return SystemProperties.getInt(DENY_NEW_USB_PERSIST_PROP, 0) != 0;
    }

    @Override
    public boolean setChecked(boolean isChecked) {
        SystemProperties.set(DENY_NEW_USB_PERSIST_PROP, isChecked ? "1" : "0");
        return true;
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }
    
}

