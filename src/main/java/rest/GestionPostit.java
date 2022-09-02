package rest;

import java.time.LocalDate;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import bll.PostItBLL;
import bo.PostIt;

@Path("/postits")
public class GestionPostit {
	private PostItBLL bll;
	
	public GestionPostit() {
		bll = new PostItBLL();
	}

	@GET
	public List<PostIt> getAll() {
		return bll.selectAll();
	}
	
	/*
	 * En cas d'erreur "entity body cannot be empty"
	 * Verifier l'import de @PathParam -> import javax.ws.rs.PathParam
	 */
	@GET @Path("/{cle : \\d+}")
	public PostIt selectById(@PathParam("cle") int id) {
		return bll.selectById(id);
	}
	
	@POST
	public PostIt addPostIt(
			@FormParam("titre") String title,
			@FormParam("contenu") String content) {
		PostIt postit = new PostIt();
		postit.setTitre(title);
		postit.setContenu(content);
		postit.setDateCrea(LocalDate.now());
		try {
			bll.insert(postit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return postit;
	}
	
	@PUT @Path("/{cle : \\d+}")
	public PostIt updatePostIt(
			@PathParam("cle") int id,
			@FormParam("titre") String title,
			@FormParam("contenu") String content
			) {
		PostIt postit = bll.selectById(id);
		postit.setTitre(title);
		postit.setContenu(content);
		postit.setDateModif(LocalDate.now());
		try {
			bll.update(postit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return postit;
	}
	
	@DELETE @Path("/{cle : \\d+}")
	public PostIt deletePostIt(@PathParam("cle") int id) {
		PostIt postit = bll.selectById(id);
		bll.delete(id);
		return postit;
	}
}
