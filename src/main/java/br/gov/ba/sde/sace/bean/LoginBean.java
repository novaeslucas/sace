package br.gov.ba.sde.sace.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.hibernate.validator.constraints.NotEmpty;

import br.gov.ba.sde.sace.domain.Usuario;
import br.gov.ba.sde.sace.internal.message.SeverityType;
import br.gov.ba.sde.sace.internal.util.Faces;
import br.gov.ba.sde.sace.security.User;
import br.gov.ba.sde.sace.service.UsuarioService;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@NotEmpty
	private String user;
	
	@NotNull
	@NotEmpty
	private String pwd;
	
	@User
	@Produces
	@SessionScoped	
	private Usuario authenticated = new Usuario();
	
	@Inject
	private UsuarioService usuarioService;
	
	public void redirecionar(){
		if(authenticated.isAuthenticated()){
			Faces.redirectView("pretty:home");
		}
	}
	
	public String login(){
		String result = null;
		try{
			UsernamePasswordToken token = new UsernamePasswordToken(user.toLowerCase(), pwd);
            Subject subject =  SecurityUtils.getSubject();
            subject.login(token);
            loadUser(user.toLowerCase());
            result = "pretty:home";
		} catch (Exception e) {
			Faces.addMessage("Usuário ou senha inválidos!", SeverityType.ERROR);
		}
		
		return result;
	}
	
	public String logout(){
		Faces.getSession(true).removeAttribute("usuarioLogado");
		Subject subject =  SecurityUtils.getSubject();
		subject.logout();
		authenticated = new Usuario();
		return "pretty:login";
	}
	
	private void loadUser(String user){
		Usuario usuario = new Usuario();
		usuario.setLogin(user);
		authenticated = usuarioService.buscarPorLogin(usuario);
		authenticated.setAuthenticated(true);
		Faces.getSession(true).setAttribute("usuarioLogado", authenticated);
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Usuario getAuthenticated() {
		return authenticated;
	}

	public String preEsqueciMinhaSenha(){
		return "pretty:esqueci-minha-senha";
	}

}
