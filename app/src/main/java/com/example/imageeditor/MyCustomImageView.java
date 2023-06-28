package com.example.imageeditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MyCustomImageView extends ImageView {
        private float width;
        private float height;
        private float xPosition;
        private float yPosition;
        private float angle;
//        private FillBehavior fillBehavior;
        private float opacity;
        private float blur;
        private boolean greyscale;
        private boolean sepia;
        private float hueRotation;
        private float brightness;

        private Bitmap originalBitmap;
        private Bitmap scaledBitmap;
        private Paint paint;

    public MyCustomImageView(Context context) {
            super(context);
            init();
        }

    public MyCustomImageView(Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
            init();
        }

        private void init() {
            // Load the original bitmap from the resources
            originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bb);

            // Initialize the paint object
            paint = new Paint();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            // Set the position and rotation of the image
//            canvas.translate(xPosition, yPosition);
//            canvas.rotate(angle, width / 2, height / 2);
//
//            // Scale the bitmap based on the fill behavior and image dimensions
//            if (fillBehavior == FillBehavior.FILL) {
//                canvas.drawBitmap(originalBitmap, null, getBounds(), paint);
//            } else if (fillBehavior == FillBehavior.FIT) {
//                canvas.drawBitmap(scaledBitmap, null, getBounds(), paint);
//            } else if (fillBehavior == FillBehavior.STRETCH) {
//                canvas.drawBitmap(originalBitmap, null, getBounds(), paint);
//            }
//
//            // Apply effects
            applyOpacity();
            applyBlur();
            applyGreyscale();
            applySepia();
            applyHueRotation();
            applyBrightness();
        }

        private void applyOpacity() {
            if (opacity < 1.0f) {
                paint.setAlpha((int) (opacity * 255));
            }
        }

        private void applyBlur() {
            if (blur > 0.0f) {
                // Apply blur effect
                // Example: you can use RenderScript or third-party libraries like Glide or Picasso for blur effect
            }
        }

        private void applyGreyscale() {
            if (greyscale) {
                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.setSaturation(0);
                paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            }
        }

        private void applySepia() {
            if (sepia) {
                // Apply sepia effect
                // Example: you can use ColorMatrix to apply sepia effect
            }
        }

        private void applyHueRotation() {
            if (hueRotation != 0.0f) {
                // Apply hue rotation effect
                // Example: you can use ColorMatrix to apply hue rotation effect
            }
        }

        private void applyBrightness() {
            if (brightness != 0.0f) {
                // Apply brightness effect
                // Example: you can use ColorMatrix to apply brightness effect
            }
        }

        private RectF getBounds() {
            float left = -width / 2;
            float top = -height / 2;
            float right = width / 2;
            float bottom = height / 2;
            return new RectF(left, top, right, bottom);
        }

        // Implement getter and setter methods for the properties

        public void setWidth(float width) {
            this.width = width;
            scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, (int) width, (int) height, true);
            invalidate();
        }

        public void setHeight(float height) {
            this.height = height;
            scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, (int) width, (int) height, true);
            invalidate();
        }

        public void setXPosition(float xPosition) {
            this.xPosition = xPosition;
            invalidate();
        }

        public void setYPosition(float yPosition) {
            this.yPosition = yPosition;
            invalidate();
        }

        public void setAngle(float angle) {
            this.angle = angle;
            invalidate();
        }

//        public void setFillBehavior(FillBehavior fillBehavior) {
//            this.fillBehavior = fillBehavior;
//            invalidate();
//        }

        public void setOpacity(float opacity) {
            this.opacity = opacity;
            invalidate();
        }

        public void setBlur(float blur) {
            this.blur = blur;
            invalidate();
        }

        public void setGreyscale(boolean greyscale) {
            this.greyscale = greyscale;
            invalidate();
        }

        public void setSepia(boolean sepia) {
            this.sepia = sepia;
            invalidate();
        }

        public void setHueRotation(float hueRotation) {
            this.hueRotation = hueRotation;
            invalidate();
        }

        public void setBrightness(float brightness) {
            this.brightness = brightness;
            invalidate();
        }
    }
