package com.example.propuestonotificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    Button botonNormal;
    Button botonBigText;
    Button botonBigPicture;
    Button botonInbox;
    Button botones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crearCanalesNotificacion();

        botonNormal = (Button) findViewById(R.id.boton_normal);
        botonBigText = (Button) findViewById(R.id.boton_bigText);
        botonBigPicture = (Button) findViewById(R.id.boton_bigPicture);
        botonInbox = (Button) findViewById(R.id.boton_Inbox);
        botones = (Button) findViewById(R.id.boton_Botones);

        botonNormal.setOnClickListener(this);
        botonBigText.setOnClickListener(this);
        botonBigPicture.setOnClickListener(this);
        botonInbox.setOnClickListener(this);
        botones.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.boton_normal:
            {
                NotificationCompat.Builder notificacion;
                notificacion = new NotificationCompat.Builder(getApplicationContext(), "CHANNELMENSAJES_ID");
                notificacion.setContentText("Notificacion normal");
                notificacion.setContentTitle("NOTIFICACION NORMAL");
                notificacion.setSmallIcon(R.mipmap.ic_launcher);
                notificacion.setTicker("Optional Ticker");
                notificacion.setWhen(System.currentTimeMillis());
                notificacion.setAutoCancel(true);

                Uri defaultSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                notificacion.setSound(defaultSound);

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0 , intent,0);
                notificacion.setContentIntent(pendingIntent);

                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                nm.notify(1, notificacion.build());



                break;
            }

            case R.id.boton_bigText:
            {
                NotificationCompat.Builder notificacion;
                notificacion = new NotificationCompat.Builder(getApplicationContext(), "CHANNELMENSAJES_ID");
                notificacion.setContentText("Notificacion Big Text");
                notificacion.setContentTitle("BIG TEXT");
                notificacion.setSmallIcon(R.mipmap.ic_launcher);
                notificacion.setTicker("Optional Ticker");
                notificacion.setWhen(System.currentTimeMillis());
                notificacion.setAutoCancel(true);

                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                NotificationCompat.BigTextStyle n = new NotificationCompat.BigTextStyle(notificacion)
                        .bigText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                                "Vestibulum bibendum dignissim viverra. Phasellus pellentesque felis sodales " +
                                "dapibus rhoncus. Aenean convallis mollis eros, viverra aliquam massa auctor eu. " +
                                "Curabitur pellentesque erat.")
                        .setBigContentTitle("Expande BigText")
                        .setSummaryText("Summary Text");
                nm.notify(2, n.build());

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0 , intent,0);
                notificacion.setContentIntent(pendingIntent);

                Uri uri = Uri.parse("http://www.marca.com");
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intentWeb);
                break;
            }
            case R.id.boton_bigPicture:
            {
                NotificationCompat.Builder notificacion;
                notificacion = new NotificationCompat.Builder(getApplicationContext(), "CHANNELMENSAJES_ID");
                notificacion.setContentText("Notificacion Big Picture");
                notificacion.setContentTitle("BIG PICTURE");
                notificacion.setSmallIcon(R.mipmap.ic_launcher);
                notificacion.setTicker("Optional Ticker");
                notificacion.setWhen(System.currentTimeMillis());
                notificacion.setAutoCancel(true);

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0 , intent,0);
                notificacion.setContentIntent(pendingIntent);

                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                NotificationCompat.BigPictureStyle n2 = new NotificationCompat.BigPictureStyle(notificacion)
                        .bigPicture(((BitmapDrawable)ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_launcher)).getBitmap())
                        .bigLargeIcon(((BitmapDrawable)ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_launcher)).getBitmap())
                        .setBigContentTitle("Expande Big Picture")
                        .setSummaryText("Summary Text");
                nm.notify(3,n2.build());
                break;

            }
            case R.id.boton_Inbox:
            {
                Notification.Builder notificacion;
                notificacion = new Notification.Builder(getApplicationContext(), "CHANNELMENSAJES_ID");
                notificacion.setContentText("Notificacion InBox");
                notificacion.setContentTitle("INBOX");
                notificacion.setSmallIcon(R.mipmap.ic_launcher);
                notificacion.setTicker("Optional Ticker");
                notificacion.setWhen(System.currentTimeMillis());
                notificacion.setAutoCancel(true);

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0 , intent,0);
                notificacion.setContentIntent(pendingIntent);

                String[] lines = {"Mensaje 1", "Mensaje 2", "Mensaje 3", "Mensaje 4"};
                Notification.InboxStyle n3 = new Notification.InboxStyle(notificacion)
                        .setBigContentTitle("Expande Inbox")
                        .setSummaryText("Summary text");
                for (String line : lines)
                {
                    n3.addLine(line);
                }
                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                nm.notify(4,n3.build());
                break;
            }

            case R.id.boton_Botones:
            {
                Notification.Builder notificacion;
                notificacion = new Notification.Builder(getApplicationContext(), "CHANNELMENSAJES_ID");
                notificacion.setContentText("Notificacion con Botones");
                notificacion.setContentTitle("BOTONES");
                notificacion.setSmallIcon(R.mipmap.ic_launcher);
                notificacion.setTicker("Optional Ticker");
                notificacion.setWhen(System.currentTimeMillis());
                notificacion.setAutoCancel(true);

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0 , intent,0);
                notificacion.setContentIntent(pendingIntent);

                Notification.Action action = new Notification.Action.Builder(R.drawable.share,"Delete", pendingIntent).build();
                notificacion.addAction(action);
                notificacion.addAction(R.drawable.share, "Share", pendingIntent);


                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                nm.notify(5,notificacion.build());
                break;
            }
        }
    }

    private NotificationChannel crearCanal(String idCanal, String nombreCanal, String descripcion, int importancia)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel canal = new NotificationChannel(idCanal, nombreCanal, importancia);
            canal.setDescription(descripcion);
            return canal;
        }
        return null;
    }

    private void crearCanalesNotificacion()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            NotificationChannel canal = crearCanal("CanalAvisos", "Avisos", "Avisos importantes", NotificationManager.IMPORTANCE_HIGH);
            canal.setVibrationPattern(new long[]{400,600,100,300,100});

            notificationManager.createNotificationChannel(canal);
            canal = crearCanal("CHANNELMENSAJES_ID", "Mensajes", "Mensajes", NotificationManager.IMPORTANCE_LOW);
            notificationManager.createNotificationChannel(canal);
        }
    }
}
