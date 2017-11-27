package configuration;

import com.jcraft.jsch.JSch;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Tomas on 18.11.2017.
 */
public abstract class JpaConfig {

    static {
        setPortForwarding();
    }

    @Bean
    public abstract LocalEntityManagerFactoryBean entityManagerFactory();

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public abstract DataSource getDataSource();

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
