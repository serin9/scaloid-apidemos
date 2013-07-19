/*
 * Copyright (C) 2007 The Android Open Source Project
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
package com.example.android.apis.app

import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.android.apis.R
import org.scaloid.common._
/**
 * Example of how to use a custom title {@link android.view.Window#FEATURE_CUSTOM_TITLE}.
 * <h3>CustomTitle</h3>

<p>This demonstrates how a custom title can be used.</p>

<h4>Demo</h4>
App/Title/Custom Title

<h4>Source files</h4>
 * <table class="LinkTable">
 * <tr>
 * <td >src/com.example.android.apis/app/CustomTitle.java</td>
 * <td >The Custom Title implementation</td>
 * </tr>
 * <tr>
 * <td >/res/any/layout/custom_title.xml</td>
 * <td >Defines contents of the screen</td>
 * </tr>
 * </table>
 */
class CustomTitle extends SActivity {
  /**
   * Initialization of the Activity after it is first created.  Must at least
   * call {@link android.app.Activity#setContentView(int)} to
   * describe what is to be displayed in the screen.
   */
  protected override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    requestWindowFeature(Window.FEATURE_CUSTOM_TITLE)
    setContentView(R.layout.custom_title)
    getWindow.setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.custom_title_1)
    val leftText = find[TextView](R.id.left_text)
    val rightText = find[TextView](R.id.right_text)
    val leftTextEdit = find[EditText](R.id.left_text_edit)
    val rightTextEdit = find[EditText ](R.id.right_text_edit)
    val leftButton = find[Button](R.id.left_text_button)
    val rightButton = find[Button ](R.id.right_text_button)
    leftButton.onClick {
        leftText.setText(leftTextEdit.getText)
      }
    rightButton.onClick {
        rightText.setText(rightTextEdit.getText)
    }
}
}