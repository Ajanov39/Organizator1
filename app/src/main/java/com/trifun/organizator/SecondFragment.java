package com.trifun.organizator;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.trifun.organizator.databinding.FragmentSecondBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SecondFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private FragmentSecondBinding binding;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // za recicler view
        ArrayList<ToDo> todo = new ArrayList<>();

        ToDo todo1 = new ToDo("06.12.2021", "12:20", "sudenje K-br. 35/21" );
        ToDo todo2 = new ToDo("07.12.2021", "10:00", "sudenje K-br. 36/21" );
        ToDo todo3 = new ToDo("08.12.2021", "11:20", "sudenje K-br. 63/21" );
        ToDo todo4 = new ToDo("09.12.2021", "09:20", "sudenje K-br. 39/20" );
        ToDo todo5 = new ToDo("10.12.2021", "12:00", "sudenje K-br. 75/20" );
        ToDo todo6 = new ToDo("06.12.2021", "12:20", "sudenje K-br. 35/21" );
        ToDo todo7 = new ToDo("04.12.2021", "10:00", "sudenje K-br. 6/21" );
        ToDo todo8 = new ToDo("08.12.2021", "11:20", "sudenje K-br. 63/21" );
        ToDo todo9 = new ToDo("03.12.2021", "12:20", "sudenje K-br. 59/20" );
        ToDo todo10 = new ToDo("10.12.2021", "12:00", "sudenje K-br. 75/20" );


        todo.add(todo1);
        todo.add(todo2);
        todo.add(todo3);
        todo.add(todo4);
        todo.add(todo5);
        todo.add(todo6);
        todo.add(todo7);
        todo.add(todo8);
        todo.add(todo9);
        todo.add(todo10);
        todo.add(todo3);
        todo.add(todo1);
        todo.add(todo2);
        todo.add(todo1);
        todo.add(todo1);
        todo.add(todo2);
        todo.add(todo3);
        todo.add(todo4);
        todo.add(todo8);
        todo.add(todo3);
        todo.add(todo1);
        todo.add(todo8);
        todo.add(todo3);
        todo.add(todo4);
        todo.add(todo3);
        todo.add(todo5);
        todo.add(todo2);
        todo.add(todo1);

       ToDoAdapter toDoAdapter = new ToDoAdapter(todo);
       binding.rcToDo.setAdapter(toDoAdapter);




            // da se otvori activity za prakanje mejl
        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this);
                opensendMail();

            }
        });
    }

    private void opensendMail() {

       Intent intent = new Intent(getContext(), SendMail.class);
       startActivity(intent);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }
}