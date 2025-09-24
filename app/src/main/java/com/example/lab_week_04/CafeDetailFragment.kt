package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView // Import TextView

// private const val TAB_CONTENT = "TAB_CONTENT" // Unused, can be removed
private const val ARG_TITLE = "ARG_TITLE"
private const val ARG_DESC = "ARG_DESC"

// TODO: Remove ARG_PARAM1 and ARG_PARAM2 if not used
// private const val ARG_PARAM1 = "param1"
// private const val ARG_PARAM2 = "param2"

class CafeDetailFragment : Fragment() {
    // private var param1: String? = null // Remove if not used
    // private var param2: String? = null // Remove if not used
    private var title: String? = null
    private var desc: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            // param1 = it.getString(ARG_PARAM1) // Remove if ARG_PARAM1 is removed
            // param2 = it.getString(ARG_PARAM2) // Remove if ARG_PARAM2 is removed
            // It's safer to check if the keys exist before trying to get Int and then String
            if (it.containsKey(ARG_TITLE)) {
                title = getString(it.getInt(ARG_TITLE))
            }
            if (it.containsKey(ARG_DESC)) {
                desc = getString(it.getInt(ARG_DESC))
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cafe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.cafe_title)?.text = title
        view.findViewById<TextView>(R.id.cafe_desc)?.text = desc
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param titleRes Resource ID for the title string.
         * @param descRes Resource ID for the description string.
         * @return A new instance of fragment CafeDetailFragment.
         */
        @JvmStatic
        fun newInstance(titleRes: Int, descRes: Int) =
            CafeDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_TITLE, titleRes)
                    putInt(ARG_DESC, descRes)
                }
            }
    }
}
