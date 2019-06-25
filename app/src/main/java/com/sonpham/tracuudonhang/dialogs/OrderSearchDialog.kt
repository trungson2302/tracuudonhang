package com.sonpham.tracuudonhang.dialogs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import com.sonpham.tracuudonhang.R
import com.sonpham.tracuudonhang.enums.Company
import kotlinx.android.synthetic.main.dialog_order_seach.*

@Suppress("UNCHECKED_CAST")
class OrderSearchDialog : DialogFragment() {
    private lateinit var callback: (shipmentID: String, company: Company) -> Unit
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        callback = context as (shipmentID: String, company: Company) -> Unit
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_order_seach, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item, arrayListOf<String>().apply {
                Company.values().forEach { company ->
                    add(company.name)
                }
            }
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            dialog_order_company_spinner.adapter = adapter
        }
        dialog_order_cancel_btn.setOnClickListener {
            dismiss()
        }
        dialog_order_ok_btn.setOnClickListener {
            val shipmentID = dialog_order_edt.text.toString()
            if (shipmentID.isNotEmpty()) {
                //TODO change company later
                callback.invoke(shipmentID, Company.Any)
                dismiss()
            }
        }
    }

    companion object {
        val TAG = OrderSearchDialog::class.java.simpleName

        fun newInstance(callback:(String, Company) -> Unit) = OrderSearchDialog().apply {
            this.callback= callback
            arguments = Bundle().apply {
            }
        }
    }
}