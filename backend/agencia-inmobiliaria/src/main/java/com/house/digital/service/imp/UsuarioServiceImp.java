package com.house.digital.service.imp;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.house.digital.dto.UsuarioDto;
import com.house.digital.entity.Usuario;
import com.house.digital.exception.ResourceFoundException;
import com.house.digital.exception.ResourceNotFoundException;
import com.house.digital.mapper.UsuarioMapper;
import com.house.digital.repository.UsuarioRepository;
import com.house.digital.service.UsuarioService;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;


@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Value("${sendgrid.api.key}")
	private String apiKeySendGrid;
	
	@Value("${sendgrind.template.id}")
	private String templateId;
	
	private static final String MESSAGE = "No se encontraron usuarios con el id: ";

	@Override
	public Usuario getByUserName(String userName) {

		return usuarioRepository.findByEmail(userName).orElseThrow(
				() -> new ResourceNotFoundException("No se encontraron usuario con el email: " + userName));
	}

	@Override
	public UsuarioDto crearUsuario(UsuarioDto usuarioDto) {

		Usuario usuario = UsuarioMapper.INSTANCE.usuarioDtoToUsuario(usuarioDto);
		
		if(!usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
			usuario.setPassword(passwordEncoderGenerator(usuarioDto.getPassword()));

			usuarioRepository.save(usuario);
			
			sendTextEmail(usuarioDto);

			return UsuarioMapper.INSTANCE.usuarioToUsuarioDto(usuario);
		} else {
			throw new ResourceFoundException("El correo ingresado " + usuario.getEmail() + " ya se encuentra registrado");
		}

		
	}

	@Override
	public UsuarioDto obtenerUsuarioById(Long id) {

		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MESSAGE + id));

		return UsuarioMapper.INSTANCE.usuarioToUsuarioDto(usuario);
	}

	@Override
	public List<UsuarioDto> obtenerUsuarios() {

		List<Usuario> listUsuario = usuarioRepository.findAll();

		if (!listUsuario.isEmpty()) {
			return UsuarioMapper.INSTANCE.listUsuarioToListUsuarioDto(listUsuario);
		} else {
			throw new ResourceNotFoundException("No hay usuarios registrados");
		}
	}

	@Override
	public UsuarioDto actualizarUsuario(UsuarioDto usuarioDto) {

		if (usuarioRepository.existsById(usuarioDto.getId())) {

			Usuario usuario = UsuarioMapper.INSTANCE.usuarioDtoToUsuario(usuarioDto);
			usuarioRepository.save(usuario);
			return UsuarioMapper.INSTANCE.usuarioToUsuarioDto(usuario);
		} else {
			throw new ResourceNotFoundException("No hay roles registrados");
		}
	}

	@Override
	public void eliminarUsuario(Long id) {

		Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(MESSAGE + id));

		usuarioRepository.delete(usuario);

	}

	private String passwordEncoderGenerator(String password) {

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		return passwordEncoder.encode(password);

	}

	private void sendTextEmail(UsuarioDto usuarioDto){
		
		String nombreUsuario = usuarioDto.getNombre() + " " + usuarioDto.getApellido();

		// The sender email must be the same as the one with which the API key is
		// configured.
		Email from = new Email("wonderbooking04@gmail.com", "WONDER BOOKING"); // Email to send the message
		String subject = "Bienvenido a Wonder Booking"; // Subject to be displayed in the mail
		Email to = new Email(usuarioDto.getEmail(), nombreUsuario); // Email to receive the message
		// Type and message to be sent in the mailing
		Content content = new Content("text/html", "Bienvenido a Wonder Booking " + nombreUsuario);
		Mail mail = new Mail(from, subject, to, content);
		
		// Add template to the mail
		mail.personalization.get(0).addDynamicTemplateData("name", nombreUsuario); // Add data for mail
	    mail.setTemplateId(templateId);

		SendGrid sg = new SendGrid(apiKeySendGrid); // An instance of SendGrid with your respective key
		Request request = new Request(); // An instance of request

		// Consumption of API SendGrid
		try {

			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());

			Response response = sg.api(request);

			// Validate success of the send email
			if (!response.getBody().isEmpty() || response.getStatusCode() != 202) {

				JSONArray jsonArrayErrors = new JSONArray(new JSONObject(response.getBody()).get("errors").toString());
				JSONObject jsonErros = jsonArrayErrors.getJSONObject(0);

				String messageErrors = (jsonErros.get("message").toString()).split("\\.")[0];

				throw new ResourceNotFoundException(messageErrors);

			}

		} catch (IOException ex) {
			throw new ResourceNotFoundException("SendGrid API does not respond");
		}

	}

}
