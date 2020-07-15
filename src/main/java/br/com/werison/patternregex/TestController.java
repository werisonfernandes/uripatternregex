package br.com.werison.patternregex;

import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@ResponseBody
	@RequestMapping(value = {}, method = RequestMethod.GET)
    public String get2() {
		System.out.println("OK!!!!");
        return "Dynamic URI parameter fetched using regex";
    }
	
	@RequestMapping(value = "/fetch/{id:[a-z]+}/{name}", method = RequestMethod.GET)
    String getDynamicUriValueRegex(@PathVariable("name") String name) {
        System.out.println("Name is " + name);
        return "Dynamic URI parameter fetched using regex";
    }
	
	@RequestMapping(method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON }, name = "get", headers = { "content-type=application/json",
					"content-type=text/html", "content-type=text/plain" }, path = {"/contexto/{contextoAtual:amil|onehealth|lincx|lincx_dental|next}"}, produces = {
							MediaType.APPLICATION_JSON, MediaType.TEXT_HTML }, value = {"/contexto/{contextoAtual:amil|onehealth|lincx|lincx_dental|next}"})
	public void get() throws Exception {
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON }, name = "insert", headers = { "content-type=application/json",
					"content-type=text/html", "content-type=text/plain" }, path = {"/contexto/{contextoAtual:amil|onehealth|lincx|lincx_dental|next}"}, produces = {
							MediaType.APPLICATION_JSON, MediaType.TEXT_HTML }, value = {"/contexto/{contextoAtual:amil|onehealth|lincx|lincx_dental|next}"})
	public void insert(@RequestBody Map<?,?> usuario, @PathVariable("contextoAtual") String contextoAtual) throws Exception {
		System.out.println(usuario);
		System.out.println("\n");
		System.out.println(contextoAtual);
	}

}
