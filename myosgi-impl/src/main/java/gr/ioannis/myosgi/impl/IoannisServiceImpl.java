package gr.ioannis.myosgi.impl;

import com.eurodyn.qlack2.fuse.mailing.api.MailService;
import com.eurodyn.qlack2.fuse.mailing.api.dto.EmailDTO;
import gr.ioannis.myosgi.api.IoannisService;
import org.ops4j.pax.cdi.api.OsgiService;
import org.ops4j.pax.cdi.api.OsgiServiceProvider;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;
import java.util.Arrays;

@Transactional
@OsgiServiceProvider(classes = { IoannisService.class })
@Singleton
public class IoannisServiceImpl implements IoannisService {

    @OsgiService
    @Inject
    private MailService mailService;

    @Override
    public void execute() {

        EmailDTO emailDTO = new EmailDTO();
        emailDTO.setSubject("QLACK test email");
        emailDTO.setBody("<p>This is the email body.</p>");
        emailDTO.setFrom("ioannis.mousmoutis@eurodyn.com");
        emailDTO.setToContact(Arrays.asList("wapis_user@delos.eurodyn.com"));
        emailDTO.setEmailType(EmailDTO.EMAIL_TYPE.HTML);

        String emailId = mailService.queueEmail(emailDTO);

        mailService.sendOne(emailId);
    }
}
