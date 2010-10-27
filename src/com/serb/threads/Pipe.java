package com.serb.threads;

import java.util.Queue;

/**
 * User: SBezugliy
 * Date: 11.02.2010
 */
public class Pipe {
    Queue<String> src; // ��������
    Queue<String> dst; // �������


    public Pipe(Queue<String> src, Queue<String> dst) {
        this.src = src;
        this.dst = dst;
    }

    public void forward() { // ���������� ������� �� ��������� � �������
        synchronized (src) { // ��������� �������
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
            }
            ;

            synchronized (dst) { // ��������� �������
                System.out.println("Start Pipe.forward() by " + Thread.currentThread().getName());
                String elem = src.peek();
                if (elem == null) {
                    dst.offer("Something");
                } else {
                    dst.offer(elem); // � ��������� � ������� src
                }

            }
        }
    }

    public void backward() { // ����������� ������� � �������� ����������� �
        // �� �������� � ��������

        synchronized (dst) { // ��������� �������
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
            }
            ;            
            synchronized (src) { //  ��������� �������
                System.out.println("Start Pipe.backward() by " + Thread.currentThread().getName());
                String elem = dst.peek(); // ����� ������� �� ������� dst
                if (elem == null) {
                    src.offer("Something");
                } else {
                    src.offer(elem); // � ��������� � ������� src
                }

            }
        }
    }

}
