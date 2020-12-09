package com.continental.travelbuddy.LeonardoNoTocarRadiactivo;

public class Header {

    private String txtId;
    private String txtNombre;
    private String imageView;

    public Header(String txtId, String txtNombre, String imageView) {
        this.txtId = txtId;
        this.txtNombre = txtNombre;
        this.imageView = imageView;
    }

    public String getTxtId() {
        return txtId;
    }

    public void setTxtId(String txtId) {
        this.txtId = txtId;
    }

    public String getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre = txtNombre;
    }

    public String getImageView() {
        return imageView;
    }

    public void setImageView(String imageView) {
        this.imageView = imageView;
    }
}
