/**
 * 
 */
package com.ties4560.task3;

import java.util.HashMap;
import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import beans.Order;
import beans.OrderRow;

/**
 * @author Janita, Jere, Rami, Jaro
 * @version 25.9.2018
 *
 */
@Path("orders")
@Singleton
public class OrdersResource {
	
	private HashMap<Integer, Order> orderMap = new HashMap<Integer, Order>();
	
	/**
	 * @param id orderId
	 * @return order by given id
	 */
	@GET
	@Path("/{orderId}")
	public Response getOrder(@PathParam("orderId") int id) {		
		Order order = orderMap.get(id);
		if (order == null ) {
			throw new DataNotFoundException("Order with id "+id+" was not found. Please check the id or add an order with such id to the database.");
		}
		
		return Response.status(Status.OK).entity(order).build();
	}
	
	/**
	 * @param order order to create
	 * @return response
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createOrder(Order order, @Context UriInfo uriInfo) {
		int id = order.getOrderId();
		
		if (orderMap.containsKey(id))
			throw new ItemException("Order with id "+id+" already exists.");
		
		orderMap.put(id, order);
		
		String uri = uriInfo.getBaseUriBuilder()
			.path(OrdersResource.class)
			.path(Long.toString(id))
			.build()
			.toString();
		
		order.addLink(uri, "self");
		return Response.status(Status.CREATED).entity(order).build();
	}
	
	/**
	 * @param id order's id
	 * @param order created order
	 * @return updated order
	 */
	@PUT
	@Path("/{orderId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateOrder(@PathParam("orderId") int id, List<OrderRow> orderRows) {
		Order order = orderMap.get(id);
		if (order == null)
			throw new DataNotFoundException("Order with id "+id+" was not found. Cannot update the order.");
		
		order.setRows(orderRows);
		return Response.status(Status.OK).entity(order).build();
	}
	
	/**
	 * Deletes an order.
	 * @param id orderId
	 * @return deleted order, or 404 if an order with the given id is not found
	 */
	@DELETE
	@Path("/{orderId}")
	public Response deleteOrder(@PathParam("orderId") int id) {
		Order order = orderMap.remove(id);
		if (order == null)
			throw new DataNotFoundException("Order with id "+id+" was not found. Cannot delete the order.");
		
		return Response.status(Status.CREATED).entity(order).build();
	}

}
