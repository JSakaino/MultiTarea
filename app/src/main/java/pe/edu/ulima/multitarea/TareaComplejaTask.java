package pe.edu.ulima.multitarea;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;

/**
 * Created by sodm on 19/09/2016.
 */
public class TareaComplejaTask extends AsyncTask<String, Integer, String>{


    @Override
    protected void onPreExecute() {
        //Se ejecuta en el hilo principal MainThread
        Log.i("Task","Se esta ejecutando el PreExecute");
    }

    @Override
    protected void onPostExecute(String s) {
        //Se ejecuta en el hilo principal MainThread
        Log.i("Task",s);
        //but.setText("Termino");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        //Se ejecuta en el hilo principal MainThread
    }

    @Override
    protected String doInBackground(String... strings) {
        //Se ejecuta en el hilo alterno
        for (String string : strings){
            Log.i("Task",string);
        }
        return "Completado";
    }
}
