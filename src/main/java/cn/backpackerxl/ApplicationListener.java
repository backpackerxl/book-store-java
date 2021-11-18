package cn.backpackerxl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;

/*
 * @author: backpackerxl
 * @create: 2021/11/16
 * @filename: ApplicationListener
 **/
public class ApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String banner = " \033[36m____\033[0m                   \033[33m_\033[0m                            \033[33m _\033[0m                          \033[33m _ \033[0m\n" +
                "\033[36m| __ )    \033[0m\033[31m__ _    \033[0m\033[32m___  \033[0m\033[33m| | __  \033[0m\033[34m_ __     \033[0m\033[31m__ _    \033[0m\033[32m___  \033[0m\033[33m| | __   \033[0m\033[35m___   \033[0m\033[36m_ __  \033[0m\033[32m__  __ \033[0m\033[33m| |\033[0m\n" +
                "\033[36m|  _ \\   \033[0m\033[31m/ _` |  \033[0m\033[32m/ __| \033[0m\033[33m| |/ / \033[0m\033[34m| '_ \\   \033[0m\033[31m/ _` |  \033[0m\033[32m/ __| \033[0m\033[33m| |/ /  \033[0m\033[35m/ _ \\ \033[0m\033[36m| '__| \033[0m\033[32m\\ \\/ / \033[0m\033[33m| |\033[0m\n" +
                "\033[36m| |_) | \033[0m\033[31m| (_| | \033[0m\033[32m| (__  \033[0m\033[33m|   <  \033[0m\033[34m| |_) | \033[0m\033[31m| (_| | \033[0m\033[32m| (__  \033[0m\033[33m|   <  \033[0m\033[35m|  __/ \033[0m\033[36m| |     \033[0m\033[32m>  <  \033[0m\033[33m| |\033[0m\n" +
                "\033[36m|____/   \033[0m\033[31m\\__,_|  \033[0m\033[32m\\___| \033[0m\033[33m|_|\\_\\ \033[0m\033[34m| .__/   \033[0m\033[31m\\__,_|  \033[0m\033[32m\\___| \033[0m\033[33m|_|\\_\\  \033[0m\033[35m\\___| \033[0m\033[36m|_|    \033[0m\033[32m/_/\\_\\ \033[0m\033[33m|_|\033[0m\n" +
                "                              \033[0m\033[34m|_|\033[0m                                                   \n";

        System.out.println(banner);
        String address = null;
        try {
            address = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println("\033[42mDONE\033[0m" + "\033[32m ,Compiled successfully\033[0m");
        System.out.println("App running at:");
        System.out.println("[\033[36m" + DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date()) + "\033[0m] \033[42mINFO\033[0m - Local: \033[34mhttp://localhost:3000/bstore\033[0m");
        System.out.println("[\033[36m" + DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date()) + "\033[0m] \033[42mINFO\033[0m - Network: \033[34mhttp://" + address + ":3000/bstore\033[0m");
        System.out.println("[\033[36m" + DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date()) + "\033[0m] \033[42mINFO\033[0m - Note that the development build is not optimized.\n"+"[\033[36m" + DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).format(new Date()) + "\033[0m] \033[42mINFO\033[0m - To create a production build, run \033[36mmvn clean package\033[0m.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
