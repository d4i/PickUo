package models;

public class Designation{
	private Integer designationId;
	private String designation;

	public void setDesignationId(Integer designationId){
		this.designationId = designationId;
	}

	public Integer getDesignationId(){
		return designationId;
	}

	public void setDesignation(String designation){
		this.designation = designation;
	}
	public String getDesignation(){
		return designation;
	}
}
