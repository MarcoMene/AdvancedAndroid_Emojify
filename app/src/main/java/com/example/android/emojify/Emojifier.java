package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by marcomeneghelli on 9/10/17.
 */

public class Emojifier {

    public static final String LOG_TAG = Emojifier.class.getSimpleName();

    public static void detectFaces(Context context, Bitmap bitmap) {

        // detect faces + log number of
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                .build();

        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        SparseArray<Face> faces = detector.detect(frame);

        int nFaces = faces.size();

        Log.i(LOG_TAG, nFaces + " faces detected in this pic.");
        Toast.makeText(context, nFaces + " faces detected in this pic.", Toast.LENGTH_SHORT).show();

        // if no faces --> Toast
        if (nFaces < 1) {
            Toast.makeText(context, "No faces detected in this pic.", Toast.LENGTH_SHORT).show();
        }

        detector.release();  // NB you should release the resource once used


    }
}
