package grandi.bambino.startapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    public static final String PREFERENCE = "preference";
    public static final String FIRST_RUN = "firstrun";
    SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences(PREFERENCE, MODE_PRIVATE);

    }
    @Override

    protected void onResume() {
        super.onResume();

        if (prefs.getBoolean(FIRST_RUN, true)) {
            // При первом запуске (или если юзер удалял все данные приложения)
            // мы попадаем сюда. Делаем что-то
//и после действия записывам false в переменную FIRST_RUN
//Итого при следующих запусках этот код не вызывается.
            prefs.edit().putBoolean(FIRST_RUN, false).commit();
        }
    }
}
