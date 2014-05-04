package com.swing.sample;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SampleFrame extends JFrame {

	private static final long serialVersionUID = -4204174095188207929L;
	private ImageTableModel model = null;

	public SampleFrame(String title) throws HeadlessException {
		super(title);
		init();
	}

	private void init() {
		setLayout(new BorderLayout());
		setupImageTable();
		initalizeAndStartImageWorker();
	}

	private void initalizeAndStartImageWorker() {
		List<String> urls = Arrays.asList("http://i.imgur.com/5gpRa43.jpg","https://i.imgur.com/bMCoc4o.jpg","https://i.imgur.com/ZZ0pQxl.jpg");
		ImageWorker worker = new ImageWorker(urls);
		worker.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if(ImageWorker.NEW_IMAGE.equals(evt.getPropertyName())) {
					Object obj = evt.getNewValue();
					SampleFrame.this.model.addImageBean((ImageBean)obj);
				}
			}
		});
		worker.execute();
	}

	private void setupImageTable() {
		this.model  = new ImageTableModel();
		JTable table = new JTable(this.model);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}


}
