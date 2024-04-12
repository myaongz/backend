package com.mya.ong.backend.myaong.health.service;
import java.io.File;

public class GetServerStatus {
    public static String toMB(long size) {
        return String.valueOf((int) (size / (1024 * 1024)));
    }
    public static String[] getStorage() {
        File root = null;
            root = new File("/");
            String[] list = new String[2];
            list[0] = toMB(root.getTotalSpace());
            list[1] = toMB(root.getUsableSpace());
            return list;
    }

    public static String[] getCpuUsage() {

    }
}
