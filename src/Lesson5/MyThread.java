package Lesson5;

public class MyThread implements Runnable {

    private int h;
    private float[] arr;

    MyThread(int h){
        this.h = h;
        arr = new float[h];
    }

    @Override
    public void run() {
        create();
        calculation();
    }

    private void create(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
    }

    private void calculation(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public float[] getArr(){
        return arr;
    }
}
