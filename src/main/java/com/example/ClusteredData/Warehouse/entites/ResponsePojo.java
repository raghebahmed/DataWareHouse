package com.example.ClusteredData.Warehouse.entites;

public class ResponsePojo {
	
	private String status;
	
	private String description;
	
	private Object response;
	
	

	public ResponsePojo(String status, String description, Object response) {
		super();
		this.status = status;
		this.description = description;
		this.response = response;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

}
