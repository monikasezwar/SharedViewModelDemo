package com.example.sharedviewmodeldemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class MessageSenderFragment: Fragment() {
    lateinit var model: SharedViewModel
    lateinit var button : AppCompatButton
    var a = 0;

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        button.setOnClickListener{
            model.sendMessage(a.toString())
            a++
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.sender_fragment,container,false)
        button = view.findViewById(R.id.button)
        return view
    }
}