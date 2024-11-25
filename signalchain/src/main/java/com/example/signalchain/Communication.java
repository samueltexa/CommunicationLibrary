package com.example.signalchain;

import android.util.Log;
import org.jetbrains.annotations.NotNull;
import java.util.HashMap;
import java.util.Map;

public class Communication {
    // HashMap to store scanned devices
    private final Map<String, DeviceDetails> devices;

    public Communication() {
        devices = new HashMap<>();
    }

    // Method to receive scanned device information and the edge/message
    public void receiveScannedDevice(String macAddress, int rssi, String scannedDevice, String scanningDevice) {
        DeviceDetails deviceDetails = new DeviceDetails(rssi, scannedDevice, scanningDevice);
        devices.put(macAddress, deviceDetails);
    }

    // Method to retrieve devices in the HashMap
    public Map<String, DeviceDetails> getHashMap() {
        return devices;
    }

    // Inner class to hold device information without macAddress, as it's already the key
    public static class DeviceDetails {
        private final int rssi;
        private final String scanningDevice; // Corrected from badge to scanningDevice
        private final String scannedDevice;  // Added scannedDevice parameter

        public DeviceDetails(int rssi, String scanningDevice, String scannedDevice) {
            this.rssi = rssi;
            this.scanningDevice = scanningDevice;
            this.scannedDevice = scannedDevice;
        }

        public int getRssi() {
            return rssi;
        }

        public String getScanningDevice() {
            return scanningDevice;
        }

        public String getScannedDevice() {
            return scannedDevice;
        }

        @NotNull
        @Override
        public String toString() {
            return "DeviceDetails{" +
                    "rssi=" + rssi +
                    ", edge='" + scanningDevice + " ====> " + scannedDevice + '\'' +
                    '}';
        }

    }

    // Method to get devices by macAddresses
    public DeviceDetails getDeviceDetails(String macAddress) {
        return devices.get(macAddress);
    }

    // For debugging
    public void logAllDevices() {
        Log.d("HashMap", "Saved Data: " + devices);
    }
}
