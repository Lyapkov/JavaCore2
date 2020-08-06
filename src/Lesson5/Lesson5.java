package Lesson5;

class General {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) throws InterruptedException {
        long a = System.currentTimeMillis();
        func1();
        System.out.println("Time: " + (System.currentTimeMillis() - a));

        a = System.currentTimeMillis();
        func2();
        System.out.println("Time: " + (System.currentTimeMillis() - a));
    }

    private static void func1(){
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    private static void func2() throws InterruptedException {
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        MyThread t1 = new MyThread(h);
        MyThread t2 = new MyThread(h);
        Thread mt1 = new Thread(t1);
        Thread mt2 = new Thread(t2);
        mt1.start();
        mt2.start();
        mt1.join();
        mt2.join();
        a1 = t1.getArr();
        a2 = t2.getArr();
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
    }

}
