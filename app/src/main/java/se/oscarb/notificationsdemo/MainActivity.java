package se.oscarb.notificationsdemo;

import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
