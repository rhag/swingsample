package com.swing.sample;

import java.awt.Image;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.SwingWorker;

public class ImageWorker extends SwingWorker<Void, Void> {
	public static final String NEW_IMAGE = "new image";
	private List<String> urls;

	public ImageWorker(List<String> urls) {
		this.urls = urls;
	}

	@Override
	protected Void doInBackground() throws Exception {
		for(String urlSpec : this.urls) {
			URL url = new URL(urlSpec);
			Image image = ImageIO.read(url);
			ImageBean bean = new ImageBean(url, image);
			firePropertyChange(NEW_IMAGE, null, bean);
		}
		return null;
	}

}
