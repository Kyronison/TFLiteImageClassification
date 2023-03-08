package org.tensorflow.lite.examples.imageclassification;

import java.util.ArrayList;
import java.util.Arrays;

public class VotingClassifier {
    int n;
    public double[] summarize(ArrayList<ArrayList<Double>> array){
        int count = array.size();
        int value = array.get(count-1).size();
        double[] result = new double [value];
        for (int i = 0;i<value;i++){
            for (int j=0;j<count;j++){
                result[i] = result[i] + array.get(j).get(i);
            }
        }
        return result;
    }
    VotingClassifier(int n) {
        this.n = n;
    }

}
