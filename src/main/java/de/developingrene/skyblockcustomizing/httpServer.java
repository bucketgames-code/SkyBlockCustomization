package de.developingrene.skyblockcustomizing;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class httpServer {
    private static HttpServer server;
    private static FileConfiguration conf;
    protected static void CC(){
        File file = new File(SkyBlockCustomizing.getPlugin().getDataFolder(), "web.yml");
        conf = YamlConfiguration.loadConfiguration(file);
        if (!conf.contains("host.port")){
            conf.set("host.port", Bukkit.getServer().getPort()+1);
        }
        try {
            conf.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception{
        start(args);
    }
    public static void start(String[] args) throws Exception {
        server = HttpServer.create(new InetSocketAddress(conf.getInt("host.port")), 0);
        server.createContext("/test" , new testHandler());
        server.setExecutor(null);
        server.start();
    }
    public static void stop(){
        server.stop(0);
    }
    static class testHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String[] ver = Bukkit.getServer().getBukkitVersion().split("-");
            String json = "{\n";
            json += "\"Online\": \"true\",\n";
            json += "\"Name\": \""+ Bukkit.getServer().getName() +"\",\n";
            json += "\"Version\": \""+ver[0]+"\",\n";
            json += "\"OnlinePlayers\": \""+Bukkit.getOnlinePlayers().size()+"\",\n";
            json += "\"MaxPlayers\": \""+Bukkit.getMaxPlayers()+"\"\n";
            json += "}";
            exchange.sendResponseHeaders(200, json.length());
            OutputStream os = exchange.getResponseBody();
            os.write(json.getBytes());
            os.close();
        }
    }
}
