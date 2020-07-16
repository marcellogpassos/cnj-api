package br.com.marcellogpassos.cnjapi.sendgrid;

import br.com.marcellogpassos.cnjapi.sgt.interessado.Interessado;
import br.com.marcellogpassos.cnjapi.sgt.versions.Version;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Log4j2
@Service
public class SendgridEmailSender {

    private final String from;
    private final String subject;
    private final String text;
    private final SendGrid sg;

    public SendgridEmailSender(@Value("${spring.sendgrid.from}") String from,
                               @Value("${notificacao.subject}") String subject,
                               @Value("${notificacao.text}") String text,
                               SendGrid sg) {
        this.from = from;
        this.subject = subject;
        this.text = text;
        this.sg = sg;
    }

    public void notificar(Interessado informed, Version novaVersao) {
        try {
            final var mail = this.getMail(informed, novaVersao);
            final var sendgridRequest = this.getRequest(mail);
            final var response = this.sg.api(sendgridRequest);
            this.handleResponse(response);
        } catch (Exception ex) {
            log.error(">>> Falha ao tentar enviar o e-mail. Causa: " + ex.getMessage(), ex);
        }
    }

    private Mail getMail(Interessado informed, Version novaVersao) {
        final var content = String.format(this.text, informed.getNome(), novaVersao.getDataVersao().toString());
        return new Mail(
                new Email(this.from),
                this.subject,
                new Email(informed.getEmail()),
                new Content("text/plain", content));
    }

    private Request getRequest(Mail mail) throws IOException {
        final var sendgridRequest = new Request();
        sendgridRequest.setMethod(Method.POST);
        sendgridRequest.setEndpoint("mail/send");
        sendgridRequest.setBody(mail.build());
        return sendgridRequest;
    }

    private void handleResponse(Response response) {
        log.info(">>> response.statusCode: " + response.getStatusCode());
        log.info(">>> response.body: " + response.getBody());
        log.info(">>> response.headers: " + response.getHeaders());
    }
}
