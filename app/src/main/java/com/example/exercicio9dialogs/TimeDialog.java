package com.example.exercicio9dialogs;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Calendar;

public class TimeDialog extends AppCompatDialogFragment implements TimePickerDialog.OnTimeSetListener {

    private OnTimeSetListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar agora = Calendar.getInstance();
        int hora = agora.get(Calendar.HOUR_OF_DAY);
        int minuto = agora.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hora, minuto, true);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (!(context instanceof OnTimeSetListener)) {
            throw new IllegalArgumentException("Activity must implement TimeDialog.OnTimeSetListener");
        }

        this.listener = (OnTimeSetListener) context;
    }

    @Override
    public void onTimeSet(TimePicker view, int horaDoDia, int minuto) {
        listener.onTimeSet(horaDoDia, minuto);
    }

    public interface OnTimeSetListener{
        void onTimeSet(int hora, int minuto);
    }

}