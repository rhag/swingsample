package com.swing.sample;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

public class ImageTableModel extends DefaultTableModel {

	private static final long serialVersionUID = -3421671011581649589L;

	public ImageTableModel() {
		setColumnIdentifiers(new String[]{"URL","Image"});
	}

	public void addImageBean(ImageBean imageBean) {
		addRow(new Object[]{imageBean.getUrl(), getScaledImageIcon(imageBean.getImage())});
	}

	private ImageIcon getScaledImageIcon(Image image) {
		return new ImageIcon(image.getScaledInstance(50, 20, Image.SCALE_SMOOTH));
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return String.class;
		case 1:
			return ImageIcon.class;
		}
		return super.getColumnClass(columnIndex);
	}


}
