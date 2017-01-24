/* -*-mode:java; c-basic-offset:2; -*- */
package com.jcraft.jzlib.example;

import com.jcraft.jzlib.JZlib;
import com.jcraft.jzlib.ZInputStream;
import com.jcraft.jzlib.ZOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class test_stream_deflate_inflate {
    public static void main(String[] args) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ZOutputStream zOut = new ZOutputStream(out, JZlib.Z_BEST_COMPRESSION);
            ObjectOutputStream objOut = new ObjectOutputStream(zOut);
            String hello = "Hello World!";
            objOut.writeObject(hello);
            zOut.close();

            ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
            ZInputStream zIn = new ZInputStream(in);
            ObjectInputStream objIn = new ObjectInputStream(zIn);
            System.out.println(objIn.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
