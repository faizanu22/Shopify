package com.example.shopify.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.shopify.R
import com.example.shopify.databinding.FragmentLoginBinding
import com.example.shopify.ui.home.HomeMainActivity
import com.example.shopify.utils.PreferenceHelper

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonLogin.setOnClickListener {
            val userEmail = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            if (userEmail == "test@gmail.com" && password == "123") {
                PreferenceHelper.setUserEmail(requireContext(), userEmail)
                startActivity(Intent(requireContext(), HomeMainActivity::class.java))
            } else {
                Toast.makeText(
                    requireContext(),
                    "Enter Valid UserName & Password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.buttonSignUp.setOnClickListener {
            findNavController().navigate(R.id.SignUpFragment)
        }
    }
}