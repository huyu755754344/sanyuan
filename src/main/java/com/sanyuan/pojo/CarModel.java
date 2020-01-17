package com.sanyuan.pojo;

public class CarModel {

	private String modelId;
	private String modelName;
	public String getModelId() {
		return modelId;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	@Override
	public String toString() {
		return "CarModel [modelId=" + modelId + ", modelName=" + modelName + "]";
	}
	

	
}
