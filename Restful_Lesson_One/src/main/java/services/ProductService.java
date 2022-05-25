package services;


import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import emplement.ProductImp;
import entity.Product;

@Path("/san-pham")
public class ProductService {
	ProductImp db;
	public ProductService() {
		db=new ProductImp();
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public String getProducts()
	{
		List<Product> products=db.getAll();
		//chuyen san chuoi json
		Gson gson=new Gson();
		String datajson=gson.toJson(products);
		return datajson;
	}
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/tim-kiem/{name}")
	public String search(@PathParam("name") String name)
//	@Path("/tim-kiem")
//	public String search(@QueryParam("name") String name)
	{
		List<Product> products=db.search(name);
		//chuyen san chuoi json
		Gson gson=new Gson();
		String datajson=gson.toJson(products);
		return datajson;
	}
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/{id}")
	public String search(@PathParam("id") int id)
	{
		Product p=db.getById(id);
		//chuyen san chuoi json
		Gson gson=new Gson();
		String datajson=gson.toJson(p);
		return datajson;
	}
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String data)
	{
		Gson gson=new Gson();
		Product p=gson.fromJson(data, Product.class);
		boolean b=db.insert(p);
		if(b)
			return "{msg:'Them moi'}";
		else
			return "{msg:'Them moi that bai'}";
	}
	@Produces(MediaType.APPLICATION_JSON)
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public String update(String data)
	{
		Gson gson=new Gson();
		Product p=gson.fromJson(data, Product.class);
		boolean b=db.update(p);
		if(b)
			return "{msg:'sua thanh cong'}";
		else
			return "{msg:'Sua that bai'}";
	}
	@Produces(MediaType.APPLICATION_JSON)
	@DELETE
	@Consumes(MediaType.TEXT_PLAIN)
	@Path("/{id}")
	public String delete(@PathParam("id") int id)
	{
		
		boolean b=db.delete(id);
		if(b)
			return "{msg:'Xoa thanh cong'}";
		else
			return "{msg:'Xoa that bai'}";
	}
}
