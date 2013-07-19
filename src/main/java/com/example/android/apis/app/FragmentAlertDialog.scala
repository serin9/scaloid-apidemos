/*
 * Copyright (C) 2010 The Android Open Source Project
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

import com.example.android.apis.R
import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import org.scaloid.common._
/**
 * Demonstrates how to show an AlertDialog that is managed by a Fragment.
 */
object FragmentAlertDialog {
  object MyAlertDialogFragment {
    def newInstance(title: Int): FragmentAlertDialog.MyAlertDialogFragment = {
      val frag = new FragmentAlertDialog.MyAlertDialogFragment
      val args = new Bundle
      args.putInt("title", title)
      frag.setArguments(args)
      return frag
    }
  }
  class MyAlertDialogFragment extends DialogFragment {
    override def onCreateDialog(savedInstanceState: Bundle): Dialog = {
      val title = getArguments.getInt("title")
      return new AlertDialog.Builder(getActivity).setIcon(R.drawable.alert_dialog_icon).setTitle(title).setPositiveButton(R.string.alert_dialog_ok, new DialogInterface.OnClickListener {
        def onClick(dialog: DialogInterface, whichButton: Int) {
          (getActivity.asInstanceOf[FragmentAlertDialog]).doPositiveClick
        }
      }).setNegativeButton(R.string.alert_dialog_cancel, new DialogInterface.OnClickListener {
        def onClick(dialog: DialogInterface, whichButton: Int) {
          (getActivity.asInstanceOf[FragmentAlertDialog]).doNegativeClick
        }
      }).create
    }
  }
}

class FragmentAlertDialog extends SActivity {
  protected override def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.fragment_dialog)
    val tv = findViewById(R.id.text)
    (tv.asInstanceOf[TextView]).setText("Example of displaying an alert dialog with a DialogFragment")
    find[Button](R.id.show).onClick {
        showDialog
      }
  }
  import FragmentAlertDialog._
  private[app] def showDialog {
    val newFragment: DialogFragment = MyAlertDialogFragment.newInstance(R.string.alert_dialog_two_buttons_title)
    newFragment.show(getFragmentManager, "dialog")
  }
  def doPositiveClick {
    Log.i("FragmentAlertDialog", "Positive click!")
  }
  def doNegativeClick {
    Log.i("FragmentAlertDialog", "Negative click!")
  }
}