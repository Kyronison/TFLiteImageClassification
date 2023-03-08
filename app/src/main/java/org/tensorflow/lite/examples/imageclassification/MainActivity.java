/*
 * Copyright 2022 The TensorFlow Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *             http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tensorflow.lite.examples.imageclassification;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import org.tensorflow.lite.examples.imageclassification.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;

/** Entrypoint for app */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        sampleVoting();
    }
    public void sampleVoting() {
        VotingClassifier votingClassifier = new VotingClassifier(3);
        ArrayList<ArrayList<Double>> numbers = new ArrayList<>();
        ArrayList<Double> prob1 = new ArrayList<>();
        for (int i=0;i<9;i++){
            prob1.add(0e-9);
        }
        prob1.add(1.0);
        numbers.add(prob1);
        numbers.add(prob1);
        numbers.add(prob1);
        System.out.println(Arrays.toString(votingClassifier.summarize(numbers)));
    }
    @Override
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q) {
            // Workaround for Android Q memory leak issue in IRequestFinishCallback$Stub.
            // (https://issuetracker.google.com/issues/139738913)
            finishAfterTransition();
        } else {
            super.onBackPressed();
        }
    }
}