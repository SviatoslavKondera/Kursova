package com.example.mylnu.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();

        mText.setValue(
                "Львівський національний університет імені Івана Франка\n" +
                "\n" +
                "Факультет Факультет прикладної математики та інформатики\n" +
                "\n" +
                "Напрям підготовки \"Комп’ютерні науки\"\n" +
                "\n" +
                "Освітньо-кваліфікаційний рівень\n" +
                "\n" +
                "Группа ПМІ-32с\n" +
                "\n" +
                "Форма навчання Денна\n" +

                "Форма оплати навчання Держ.замовлення\n" +

                "Наказ на зарахування 1654 від 01.08.2019\n" +

                "Термін навчання 4 роки\n" +

                "Дата закінчення навчання 30.06.2023");
    }

    public LiveData<String> getText() {
        return mText;
    }
}