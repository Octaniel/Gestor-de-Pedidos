package com.octa.gestorpedidos.services;

import com.octa.gestorpedidos.controllers.OrderController;
import com.octa.gestorpedidos.models.User;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class SendEmail {

    Logger logger = LoggerFactory.getLogger(SendEmail.class);

    @Value("${mail.email.authentication}")
    private String emailAuthentication;
    @Value("${mail.password.authentication}")
    private String senhaAuthentication;
    @Value("${mail.host.name}")
    private String hostName;

    @Async
    public void sendEmail(User to) {

        try {
            HtmlEmail emailOrdem = new HtmlEmail();
            emailOrdem.setHostName(hostName);

            emailOrdem.setSmtpPort(465);
            emailOrdem.setFrom(emailAuthentication, "Gestor de Pedidos");

            emailOrdem.addTo(to.getEmail());

            emailOrdem.setSubject("Registo de Pedido");

            emailOrdem.setSocketConnectionTimeout(100000);
            emailOrdem.setSocketTimeout(100000);
            emailOrdem.setSSLOnConnect(true);
            emailOrdem.setAuthentication(emailAuthentication, senhaAuthentication);

            String htmlEmail = "<html> <head> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\" /> <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n"
                    + "    <meta content=\"telephone=no\" name=\"format-detection\"></head><body>" +
                    "<br/>" + "Olá " + to.getName() +
                    "," + "<br/>" +
                    "O seu pedido foi registado com sucesso" +
                    "<br/>" +
                    "<br/>" +
                    "Gestor de Pedidos" + "<br/>" +
                    "</body></html>";
            logger.info("Email enviado -> "+htmlEmail);
            emailOrdem.setHtmlMsg(htmlEmail);
            emailOrdem.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}