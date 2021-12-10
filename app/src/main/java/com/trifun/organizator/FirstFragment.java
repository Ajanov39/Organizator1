package com.trifun.organizator;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.trifun.organizator.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }



    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        DisableButton(binding.btnLog);




        binding.btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = binding.etName.getText().toString();
                String mail = binding.etMail.getText().toString();
                if(CheckFields()) {
                    Toast.makeText(getContext(), name + " approve registration at " + mail, Toast.LENGTH_SHORT).show();
                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_FirstFragment_to_SecondFragment);


                } else {
                    Toast.makeText(getContext(), "Please fill * fields" , Toast.LENGTH_SHORT).show();
                }



            }

        });





        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(CheckFields()) {
                    EnableButton(binding.btnLog);
                } else {
                    DisableButton(binding.btnLog);
                }
            }
        };

        binding.etPassword.addTextChangedListener(textWatcher);
        binding.etName.addTextChangedListener(textWatcher);


        binding.btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etName.setHint("Your name ");
                binding.etPassword.setHint("Your 8 digit password");
                binding.etPhone.setHint("Your phone #");
                binding.etMail.setHint("Your e-mail");

            }
        });




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



    Boolean CheckFields() {
        String name = binding.etName.getText().toString();
        String age = binding.etPassword.getText().toString();
        if(age.isEmpty() || name.isEmpty())
            return false;
        else
            return true;
    }

    void DisableButton(Button btn) {
        btn.setAlpha(0.5f);
        btn.setEnabled(false);
    }

    void EnableButton(Button btn) {
        btn.setAlpha(1f);
        btn.setEnabled(true);
    }


}