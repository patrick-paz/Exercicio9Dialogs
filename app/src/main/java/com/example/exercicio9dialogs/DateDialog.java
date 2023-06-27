package com.example.exercicio9dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Calendar;

public class DateDialog extends AppCompatDialogFragment implements DatePickerDialog.OnDateSetListener {

    private OnDateSetListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar agora = Calendar.getInstance();
        int ano = agora.get(Calendar.YEAR);
        int mes = agora.get(Calendar.MONTH);
        int dia = agora.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, ano, mes, dia);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (!(context instanceof OnDateSetListener)) {
            throw new IllegalArgumentException("Activity must implement DateDialog.OnDateSetListener");
        }

        this.listener = (OnDateSetListener) context;
    }

    @Override
    public void onDateSet(DatePicker view, int ano, int mes, int diaDoMes) {
        listener.onDateSet(ano, mes, diaDoMes);
    }

    public interface OnDateSetListener{
        void onDateSet(int ano, int mes, int dia);
    }
}
