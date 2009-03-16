/*
 * Copyright (C) 2008,2009  OMRON SOFTWARE Co., Ltd.
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

package jp.co.omronsoft.openwnn.JAJP;

import jp.co.omronsoft.openwnn.*;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
/**
 * User dictionary tool for Japanese IME
 *
 * @author Copyright (C) 2009, OMRON SOFTWARE CO., LTD.  All Rights Reserved.
 */
public class UserDictionaryToolsListJAJP extends UserDictionaryToolsList {
    /**
     * Constructor
     */
    public UserDictionaryToolsListJAJP() {
        mListViewName = "jp.co.omronsoft.openwnn.JAJP.UserDictionaryToolsListJAJP";
        mEditViewName = "jp.co.omronsoft.openwnn.JAJP.UserDictionaryToolsEditJAJP";
        mPackageName  = "jp.co.omronsoft.openwnn";
    }

    /** @see jp.co.omronsoft.openwnn.UserDictionaryToolsList#headerCreate */
    @Override protected void headerCreate() {
      getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,
      R.layout.user_dictionary_tools_list_header_ja);
    }

    /** @see jp.co.omronsoft.openwnn.UserDictionaryToolsList#createUserDictionaryToolsEdit */
    @Override protected UserDictionaryToolsEdit createUserDictionaryToolsEdit(View view1, View view2, int wordCount) {
        return new UserDictionaryToolsEditJAJP(view1, view2, wordCount);
    }

    /** @see jp.co.omronsoft.openwnn.UserDictionaryToolsList#sendEventToIME */
    @Override protected boolean sendEventToIME(OpenWnnEvent ev) {
        try {
            return OpenWnnJAJP.getInstance().onEvent(ev);
        } catch (Exception ex) {
            /* do nothing if an error occurs */
        }
        return false;
    }

}
