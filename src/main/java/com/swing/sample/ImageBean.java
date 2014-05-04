package com.swing.sample;

import java.awt.Image;
import java.net.URL;

public class ImageBean {
	private URL url;
	private Image image;

	public ImageBean() {
	}
	public ImageBean(URL url, Image image) {
		this.url = url;
		this.image = image;
	}
	public URL getUrl() {
		return this.url;
	}
	public void setUrl(URL url) {
		this.url = url;
	}
	public Image getImage() {
		return this.image;
	}
	public void setImage(Image image) {
		this.image = image;
	}


}
