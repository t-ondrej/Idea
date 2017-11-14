package utils;

import com.jcraft.jsch.JSch;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

/**
 * Created by Tomas on 8.11.2017.
 */
public final class HibernateUtils {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {
        setPortForwarding();

        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    private static void setPortForwarding() {
        try {
            // SSH connection
            String sshAccount = "michal";
            String sshPassword = "skeldag0";
            String sshHost = "kado.ddns.net";
            int sshPort = 22;

            // Port forwarding
            int localPort = 6844;
            String remoteHost = "localhost";
            int remotePort = 5432;

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");

            JSch jsch = new JSch();
            com.jcraft.jsch.Session jschSession = jsch.getSession(sshAccount, sshHost, sshPort);
            jschSession.setPassword(sshPassword);
            jschSession.setConfig(config);

            System.out.println("Start Connecting " + sshHost + ":" + sshPort);
            jschSession.connect();

            int assinged_port = jschSession.setPortForwardingL(localPort,
                    remoteHost, remotePort);

            System.out.println("localhost:" + assinged_port + " -> " + remoteHost + ":" + remotePort);
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
