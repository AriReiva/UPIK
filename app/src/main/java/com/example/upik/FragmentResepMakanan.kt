package com.example.upik

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class FragmentResepMakanan : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_resep_makanan, container, false)

        // Mengakses ImageView menggunakan view dari fragment
        view.findViewById<ImageView>(R.id.PERKEDEL).setOnClickListener {
            val intent = Intent(requireActivity(), ResepPerkedel::class.java)
            startActivity(intent)
        }
        view.findViewById<ImageView>(R.id.saladbowl).setOnClickListener {
            val intent = Intent(requireActivity(), Activity_salad_bowl::class.java)
            startActivity(intent)
        }
        view.findViewById<ImageView>(R.id.capcay).setOnClickListener {
            val intent = Intent(requireActivity(),ActivityResepCapcay::class.java)
            startActivity(intent)
        }
        view.findViewById<ImageView>(R.id.SANDWICH).setOnClickListener {
            val intent = Intent(requireActivity(), ResepRotiGandum::class.java)
            startActivity(intent)
        }

        return view
    }


}