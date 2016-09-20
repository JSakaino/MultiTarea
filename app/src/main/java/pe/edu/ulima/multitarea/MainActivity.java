package pe.edu.ulima.multitarea;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but = (Button) findViewById(R.id.but);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Runnable porcionUI = new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Toast!", Toast.LENGTH_SHORT).show();
                    }
                };
                ThreadPoolExecutor poolExecutor =
                        new ThreadPoolExecutor(
                                5,5,60l, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>()
                        );
                final Handler handler = new Handler();
                for (int i=0; i<5; i++){
                    final int cont = i;
                    poolExecutor.execute(new Runnable(){
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Log.i("MainActivity","Cont:" + cont);
                            handler.post(porcionUI);
                        }
                    });
                }
            }

        });
        /*but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Runnable porcionToast = new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Toast!", Toast.LENGTH_SHORT).show();
                    }
                };

                final Handler handler = new Handler();
                Thread hiloSecundario = new Thread(){
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(5000);
                            handler.post(porcionToast);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                hiloSecundario.start();
            }
        });
*/

    }
}
