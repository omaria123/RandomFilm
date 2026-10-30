package com.example.randomfilm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvFilm: TextView
    // Список оставшихся фильмов, которые ещё не показывали
    private val remainingFilms = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvFilm = findViewById(R.id.tvFilm)
        initFilmsList()
    }

    // Загрузка/перезагрузка фильмов из строкового массива
    private fun initFilmsList() {
        remainingFilms.clear()
        val filmsArray = resources.getStringArray(R.array.films)
        remainingFilms.addAll(filmsArray)
    }

    // Обработка нажатия на кнопку "Случайный фильм"
    fun onGetFilmClick(view: View) {
        if (remainingFilms.isNotEmpty()) {
            // Выбираем случайный фильм
            val randomFilm = remainingFilms.random()
            tvFilm.text = randomFilm
            // Удаляем из списка
            remainingFilms.remove(randomFilm)
        } else {
            // Если фильмов больше нет
            tvFilm.text = getString(R.string.no_more_films)
        }
    }

    // Обработка нажатия на кнопку "Сброс"
    fun onResetClick(view: View) {
        initFilmsList()
        tvFilm.text = getString(R.string.reset_message)
    }
}