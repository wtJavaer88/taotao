package com.taotao.manage.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PropertieService {

	@Value("${REPOSITORY_PATH}")
	public String REPOSITORY_PATH;
	// public String REPOSITORY_PATH =
	// "D:\\Users\\wnc\\Programs\\sts-bundle\\projects\\taotao\\taotao-manage\\taotao-manage-web\\src\\main\\webapp";
	// public String REPOSITORY_PATH = "E:\\0114\\taotao-upload";
	@Value("${IMAGE_BASE_URL}")
	public String IMAGE_BASE_URL;
	// public String IMAGE_BASE_URL = "http://image.taotao.com";

}
