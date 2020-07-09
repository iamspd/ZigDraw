package com.example.zigdraw;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    // widgets
    private ImageView mCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * a method which draws the line on the canvas on a
     * button click
     * @param view invokes the view class of the system, by which
     *             the method should be accessed via layout widget button
     */
    public void onDrawLine(View view) {
        Bitmap bitmap = Bitmap.createBitmap(
                500, // Width
                250, // Height
                Bitmap.Config.ARGB_8888 // Config
        );

        // Initialize a new Canvas instance
        Canvas canvas = new Canvas(bitmap);

        // Initialize a new Paint instance to draw the line
        Paint paint = new Paint();
        // Line color
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        // Line width in pixels
        paint.setStrokeWidth(8);
        paint.setAntiAlias(true);

        String[] array = getResources().getStringArray(R.array.memoryCycle);

        // variables

        // starting point of the line on the canvas at X and Y axis
        int x = 0;
        int y = 90;
        int endX, endY;
        for (int i = 0; i < array.length; i++) {
            endX = x + 100;
            endY = Integer.parseInt(array[i]);

            // draws the line on the canvas
            canvas.drawLine(x, y, endX, endY, paint);
            x = endX;
            y = endY;
        }

        mCanvas = findViewById(R.id.ivCanvas);
        // Display the newly created bitmap on app interface
        mCanvas.setImageBitmap(bitmap);
    }
}