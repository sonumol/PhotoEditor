package com.example.imageeditor;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class CanvasFragment extends Fragment {
    private FrameLayout editorContainer;
    private ImageView imageView;
    private View canvasView;
    private Bitmap bitmap;
    private Canvas canvas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_canvas, container, false);

        editorContainer = rootView.findViewById(R.id.editorContainer);
        imageView = rootView.findViewById(R.id.imageView);
        canvasView = rootView.findViewById(R.id.canvasView);

        return rootView;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Load the image into the ImageView
        imageView.setImageResource(R.drawable.aa);

        // Create a bitmap with the same dimensions as the image
        bitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);

        // Create a canvas using the bitmap
        canvas = new Canvas(bitmap);
        canvasView.setBackground(new BitmapDrawable(getResources(), bitmap));

        // Perform image editing operations on the canvas

        // Example: Draw a rectangle on the canvas
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawRect(100, 100, 300, 300, paint);
    }
}