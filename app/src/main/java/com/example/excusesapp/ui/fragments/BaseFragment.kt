package com.example.excusesapp.ui.fragments

import android.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.excusesapp.ui.viewmodel.ExcusesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment : Fragment() {
    protected  val excusesViewModel by lazy{
        ViewModelProvider(requireActivity())[ExcusesViewModel::class.java]
    }

    protected fun showError(message: String, action: () -> Unit) {
        AlertDialog.Builder(requireContext())
            .setTitle("Error")
            .setMessage(message)
            .setNegativeButton("DISMISS") { dialog, _ ->
                dialog.dismiss()
            }
            .setPositiveButton("RETRY",) { _, _ ->
                action.invoke()
            }

    }
}