package se.oscarb.notificationsdemo;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Instansvariabler
    View container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Spara undan vår coordinator layout som allt ligger inuti till senare
        container =     findViewById(R.id.coordinator_layout);

        // Visa en Snackbar med hjälp av vår egen metod!
        showSnackbar("Test 1");
    }

    // En metod för att visa en Snackbar som anropas från en onClick (i XML)
    public void showSnackbar(View view) {
        // Argumentet view är nödvändigt då metoden anropas från onClick i en XML-fil
        // Även om vi inte använder oss av view

        // Visa en Snackbar
        showSnackbar("Default message");
    }

    // En generell metod för att visa en Snackbar
    public void showSnackbar(String message) {
        Snackbar.make(container, message, Snackbar.LENGTH_LONG).show();
    }



    // Metod för att visa en notifiering (notification)
    public void showNotification(View view)  {

        // Vi behöver bygga ihop en Notification först
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        // Bestäm hur den ska se ut (följande tre saker krävs)
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Titel på notification");
        builder.setContentText("Text på notification!");

        int notificationId = 1; // Ett påhittat ID för att hänvisa till samma senare

        // Hämta systemet som visar notifications
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(notificationId, builder.build());
    }
}
