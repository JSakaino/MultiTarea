package pe.edu.ulima.multitarea;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by sodm on 19/09/2016.
 */
public class TareaComplejaTask extends AsyncTask<String, Integer, String>{


    @Override
    protected void onPreExecute() {
        //Se ejecuta en el hilo principal MainThread
        
    }

    @Override
    protected void onPostExecute(String s) {
        //Se ejecuta en el hilo principal MainThread
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        //Se ejecuta en el hilo principal MainThread
    }

    @Override
    protected String doInBackground(String... strings) {
        //Se ejecuta en el hilo alterno
        return null;
    }
}
